import java.util.Scanner;

public class Account {

    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //for group project, Account Type would extend this

    public Account(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    void deposit( int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = amount;
        }
    }

   void getPreviousTransaction() {

        if(previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0){
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred.");
        }

    }
    void calculateInterest(int years){
        double interestRate=0;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate));
        System.out.println("After " + years + "years, your balance will be: " + newBalance);
    }
    public void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println(" A. Check your balance");
        System.out.println(" B. Make a deposit");
        System.out.println(" C. Make a withdrawal");
        System.out.println(" D. View previous transactions");
        System.out.println(" E. Calculate Interest");
        System.out.println(" F. Exit");

        do{
            System.out.println();
            System.out.println("Enter an option");
            char Option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(Option1);
            System.out.println();

            //check the cases match the stated methods above
            switch (option){
                case 'A':
                    //check balance
                    System.out.println("====================");
                    System.out.println("Balance = £" + balance);
                    System.out.println("====================");
                    System.out.println();
                break;
                case 'B':
                    //make a deposit
                    System.out.println("Enter an amount to deposit");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    System.out.println();
                    break;
                case 'C':
                    //make a withdrawal
                    System.out.println("Enter an amount to withdraw");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println();
                    break;
                case 'D':
                    //view previous transactions
                    System.out.println("====================");
                    getPreviousTransaction();
                    System.out.println("====================");
                    System.out.println();
                    break;
                case 'E':
                    //calculate interest
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    System.out.println();
                    break;
                case 'F':
                    //exit the program
                    System.out.println("=====================================");
                    break;
                default:
                    System.out.println("Error: invalid operation. Please enter A, B, C, D, E or F");

            }
        } while (option !='F');
        System.out.println("Thank you for banking with us. ");

    }
}
