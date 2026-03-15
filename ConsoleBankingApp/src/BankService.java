import java.util.HashMap;
import java.util.Map;

public class BankService {

    private Map<String, Account> accounts;
    private int accountCounter;

    public BankService() {
        this.accounts = new HashMap<>();
        this.accountCounter = 1;
    }

    public Account createAccount(String firstName, String lastName) {
        String accountId = "ACC" + accountCounter;
        Account account = new Account(accountId, firstName, lastName);
        accounts.put(accountId, account);
        accountCounter++;
        return account;
    }

    public boolean deposit(String accountId, double amount) {
        Account account = accounts.get(accountId);

        if (account == null) {
            System.out.println("Account not found.");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }

        account.deposit(amount);

        Transaction transaction = new Transaction(
                TransactionType.DEPOSIT,
                amount,
                accountId,
                accountId
        );

        account.addTransaction(transaction);
        return true;
    }

    public boolean withdraw(String accountId, double amount) {
        Account account = accounts.get(accountId);

        if (account == null) {
            System.out.println("Account not found.");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }

        if (account.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            return false;
        }

        account.withdraw(amount);

        Transaction transaction = new Transaction(
                TransactionType.WITHDRAW,
                amount,
                accountId,
                accountId
        );

        account.addTransaction(transaction);
        return true;
    }

    public boolean transfer(String fromAccountId, String toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null) {
            System.out.println("One or both accounts were not found.");
            return false;
        }

        if (fromAccountId.equals(toAccountId)) {
            System.out.println("You cannot transfer money to the same account.");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }

        if (fromAccount.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            return false;
        }

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        Transaction fromTransaction = new Transaction(
                TransactionType.TRANSFER_OUT,
                amount,
                fromAccountId,
                toAccountId
        );

        Transaction toTransaction = new Transaction(
                TransactionType.TRANSFER_IN,
                amount,
                fromAccountId,
                toAccountId
        );

        fromAccount.addTransaction(fromTransaction);
        toAccount.addTransaction(toTransaction);

        return true;
    }

    public void showTransactions(String accountId) {
        Account account = accounts.get(accountId);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        if (account.getTransactions().isEmpty()) {
            System.out.println("There are no transactions.");
            return;
        }

        for (Transaction transaction : account.getTransactions()) {
            System.out.println(transaction);
        }
    }
}