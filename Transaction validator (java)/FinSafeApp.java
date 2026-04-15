import java.util.*;

// Custom Exception
class InSufficientFundsException extends Exception {
    public InSufficientFundsException(String message) {
        super(message);
    }
}

// Account Class
class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<Double> transactions;

    public Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        addTransaction(amount);
        System.out.println("Deposited: " + amount);
    }

    // Withdraw Method
    public void processTransaction(double amount) throws InSufficientFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        if (amount > balance) {
            throw new InSufficientFundsException("Insufficient balance!");
        }

        balance -= amount;
        addTransaction(-amount);
        System.out.println("Withdrawn: " + amount);
    }

    // Maintain last 5 transactions
    private void addTransaction(double amount) {
        if (transactions.size() == 5) {
            transactions.remove(0);
        }
        transactions.add(amount);
    }

    // Print Mini Statement
    public void printMiniStatement() {
        System.out.println("\nLast 5 Transactions:");
        for (double t : transactions) {
            System.out.println(t);
        }
    }

    // Show Balance
    public void showBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

// Main Class
public class FinSafeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account("Harini", 1000);

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Mini Statement");
            System.out.println("4. Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount: ");
                        double dep = sc.nextDouble();
                        acc.deposit(dep);
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        double wd = sc.nextDouble();
                        acc.processTransaction(wd);
                        break;

                    case 3:
                        acc.printMiniStatement();
                        break;

                    case 4:
                        acc.showBalance();
                        break;

                    case 5:
                        System.out.println("Thank you!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InSufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Input: " + e.getMessage());
            }
        }
    }
}
