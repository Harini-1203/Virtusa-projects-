import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your name: ");
        String n=sc.nextLine();
        System.out.println("Enter your Password(in numbers): ");
        int pass=sc.nextInt();
        System.out.println("Account no: ");
        int a=sc.nextInt();
        Account acc=new Account(n,pass,a);
        while(true){
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Mini Statement\n4. Balance\n5. Exit");
            System.out.print("enter your choice: ");
            int c=sc.nextInt();
            try {
                switch (c) {
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