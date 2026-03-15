import java.time.LocalDateTime;


public class Transaction {

private TransactionType type;
private double amount;
private LocalDateTime date;
private String fromAccount;
private String toAccount;

public Transaction(TransactionType type,double amount,
    String fromAccount,String toAccount){
  
        this.type=type;
        this.amount=amount;
        this.date = LocalDateTime.now();
        this.fromAccount=fromAccount;
        this.toAccount=toAccount;

    }
    public TransactionType getType(){
        return type;
    }
    public double getAmount(){
        return amount;
    }
    public LocalDateTime getDate(){
        return date;
    }
    public String getFromAccount(){
        return fromAccount;
    }
    public String getToAccount(){
        return toAccount;
    }


}
