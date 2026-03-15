import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService();

        while (true) {
            System.out.println("=== BANKING APP ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Show Transactions");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();

                    Account newAccount = bankService.createAccount(firstName, lastName);
                    System.out.println("Account created successfully.");
                    System.out.println("Account ID: " + newAccount.getAccountId());
                    break;

                case "2":
                    System.out.print("Enter account ID: ");
                    String depositAccountId = scanner.nextLine();

                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();

                    boolean depositSuccess = bankService.deposit(depositAccountId, depositAmount);

                    if (depositSuccess) {
                        System.out.println("Deposit completed successfully.");
                    } else {
                        System.out.println("Deposit failed.");
                    }
                    break;

                case "3":
                    System.out.print("Enter account ID: ");
                    String withdrawAccountId = scanner.nextLine();

                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();

                    boolean withdrawSuccess = bankService.withdraw(withdrawAccountId, withdrawAmount);

                    if (withdrawSuccess) {
                        System.out.println("Withdrawal completed successfully.");
                    } else {
                        System.out.println("Withdrawal failed.");
                    }
                    break;

                case "4":
                    System.out.print("Enter sender account ID: ");
                    String fromAccountId = scanner.nextLine();

                    System.out.print("Enter receiver account ID: ");
                    String toAccountId = scanner.nextLine();

                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine();

                    boolean transferSuccess = bankService.transfer(fromAccountId, toAccountId, transferAmount);

                    if (transferSuccess) {
                        System.out.println("Transfer completed successfully.");
                    } else {
                        System.out.println("Transfer failed.");
                    }
                    break;

                case "5":
                    System.out.print("Enter account ID: ");
                    String transactionAccountId = scanner.nextLine();

                    bankService.showTransactions(transactionAccountId);
                    break;

                case "0":
                    scanner.close();
                    System.out.println("Exiting Banking App...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
        }
    }
}