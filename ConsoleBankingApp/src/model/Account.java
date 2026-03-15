
import java.util.List;

import java.util.List;
public class Account {

private List<Transaction> transactions;

private String accountId;
private String firstName;
private String lastName;
private double balance;

public Account(String accountId,String firstName,String lastName
    ){

this.accountId=accountId;
this.firstName=firstName;
this.lastName=lastName;
this.balance=0;
this.transactions=new ArrayList<>();

}

public String getAccountId(){
    return accountId;    
}
public String getFirstName(){
    return firstName;    
}
public String getLastName(){
    return lastName;    
}
public double getBalance(){
    return balance;    
}
public List<Transaction> getTransactions(){
    return transactions;
}

public void deposit(double amount){
   if (amount>0){
      balance+=amount;}else
      {
        System.out.println("The amount is invalid");
      }
}
public void withdraw(double amount){
  if(amount>0){
  if (balance>=amount){
      balance-=amount;
  }else {System.out.print("Error");}
  }else{System.out.print("The amount is invalid");}
}
public void addTransaction(Transaction transaction){
       transactions.add(transaction);
}


}
