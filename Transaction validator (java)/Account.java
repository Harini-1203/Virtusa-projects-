import java.util.ArrayList;
import java.util.Random;


public class Account {
    private double balance;
    private String name;
    private int password;
    private int accountNumber;
    private ArrayList<Transaction> transactions;

    public Account(String name, int password, int accountNumber) {
        this.balance = 0;
        this.name = name;
        this.password = password;
        this.accountNumber = accountNumber;
        transactions=new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public Transaction makeTransaction(double amount,double prev,String type){
        if (transactions.size() == 5) {
            transactions.remove(0); // remove oldest
        }
        int min=100000,max=999999;
        Random r=new Random();
        int number = r.nextInt(max - min + 1) + min;
        return new Transaction(amount,prev,type,number);

    }
    public void processTransaction(double amount) throws InSufficientFundsException {
        if(amount<0){
            throw new IllegalArgumentException("amount is negative cannot procees");
        }if (amount>balance) {
            throw new InSufficientFundsException("insufficient balance");
        }
        double prev=balance;
        balance-=amount;
        System.out.println("amount withdrawn succesfully\nyour current balance is: "+balance);
        transactions.add(makeTransaction(amount,prev,"withdrawal"));

    }
    public void deposit(double amount){
        if(amount<0){
            throw new IllegalArgumentException("amount is negative cannot procees");
        }
        double prev=balance;
        balance+=amount;
        transactions.add(makeTransaction(amount,prev,"deposit"));
        System.out.println("amount added succesfully\nyour current balance is: "+balance);

    }
    public void printMiniStatement(){
        for (Transaction t:transactions){
            System.out.println(t);
        }
    }
    public void showBalance(){
        System.out.println("your balance is: "+balance);
    }



}
