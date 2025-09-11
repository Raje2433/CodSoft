<<<<<<< HEAD
import java.util.*;
public class AtmInterfaceTask3{
    public static void main(String[] args){
        System.out.println("-----------------------------------");
        System.out.println("           ATM Machine ");
        System.out.println("-----------------------------------");
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        Scanner scan = new Scanner(System.in);
        int choice=0;
        do{
        System.out.print("Options : \n (1) WithDraw  (2) Deposit  (3) Check the Balance (4) Exit");
        System.out.println();
        System.out.print("Enter the Choice : ");
        try {
            choice = scan.nextInt();  
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
            scan.nextLine(); 
            continue;        
        }

        double amount;
        switch(choice){
            case 1:
                {
                System.out.print("Enter the Amount to withdraw : ");
                try {
                    amount = scan.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scan.nextLine(); 
                    continue;        
                }
                atm.withDraw(amount);
                };break;
            case 2:
                 {
                System.out.print("Enter the Amount to Deposit : ");
                try {
                    amount = scan.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scan.nextLine(); 
                    continue;        
                }
                atm.deposit(amount);
                };break;
            case 3:atm.checkBalance();break;
            case 4:System.out.println("Thank You for using the ATM machine");;break;
            default:System.out.println("Invalid Choice. ");break;
        }
        }while(choice!=4);
        scan.close();
    }
}
class ATM{
    private BankAccount account;  

    ATM(BankAccount account) {
        this.account = account;  
    }
    void withDraw(double amount){
        account.withDraw(amount);
    }
    void deposit(double amount){
        account.deposit(amount);
    }
    void checkBalance(){
        account.checkBalance();
    }
}
class BankAccount{
    double accountBalance;
    BankAccount(double accountBalance){
        this.accountBalance = accountBalance;
    }
    //helper method to withdraw the amount
    void withDraw(double amount){
        if((accountBalance-amount)<500 || accountBalance<amount){
            System.out.println("Insufficient Balance");
        }
        else{
            accountBalance -= amount;
            System.out.println("Amount Withdrawn Successfully");
            checkBalance();
        }
    }
    //helper method to deposit the amount
    void deposit(double amount){
        if(amount<0){
            System.out.println("Invalid Amount");
        }
        else{
            accountBalance += amount;
            System.out.println("Amount Deposited Successfully");
            checkBalance();
        }
    }
    //helper method to check the account balance
    void checkBalance(){
        System.out.println("Available Balance : Rs." + accountBalance);
    }
=======
import java.util.*;
public class AtmInterfaceTask3{
    public static void main(String[] args){
        System.out.println("-----------------------------------");
        System.out.println("           ATM Machine ");
        System.out.println("-----------------------------------");
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        Scanner scan = new Scanner(System.in);
        int choice=0;
        do{
        System.out.print("Options : \n (1) WithDraw  (2) Deposit  (3) Check the Balance (4) Exit");
        System.out.println();
        System.out.print("Enter the Choice : ");
        try {
            choice = scan.nextInt();  
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
            scan.nextLine(); 
            continue;        
        }

        double amount;
        switch(choice){
            case 1:
                {
                System.out.print("Enter the Amount to withdraw : ");
                try {
                    amount = scan.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scan.nextLine(); 
                    continue;        
                }
                atm.withDraw(amount);
                };break;
            case 2:
                 {
                System.out.print("Enter the Amount to Deposit : ");
                try {
                    amount = scan.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scan.nextLine(); 
                    continue;        
                }
                atm.deposit(amount);
                };break;
            case 3:atm.checkBalance();break;
            case 4:System.out.println("Thank You for using the ATM machine");;break;
            default:System.out.println("Invalid Choice. ");break;
        }
        }while(choice!=4);
    }
}
class ATM{
    private BankAccount account;  

    ATM(BankAccount account) {
        this.account = account;  
    }
    void withDraw(double amount){
        account.withDraw(amount);
    }
    void deposit(double amount){
        account.deposit(amount);
    }
    void checkBalance(){
        account.checkBalance();
    }
}
class BankAccount{
    double accountBalance;
    BankAccount(double accountBalance){
        this.accountBalance = accountBalance;
    }
    //helper method to withdraw the amount
    void withDraw(double amount){
        if((accountBalance-amount)<500 || accountBalance<amount){
            System.out.println("Insufficient Balance");
        }
        else{
            accountBalance -= amount;
            System.out.println("Amount Withdrawn Successfully");
            checkBalance();
        }
    }
    //helper method to deposit the amount
    void deposit(double amount){
        if(amount<0){
            System.out.println("Invalid Amount");
        }
        else{
            accountBalance += amount;
            System.out.println("Amount Deposited Successfully");
            checkBalance();
        }
    }
    //helper method to check the account balance
    void checkBalance(){
        System.out.println("Available Balance : Rs." + accountBalance);
    }
>>>>>>> fbbb92ed5dec4100d99b4a610831fc58046fbb4e
}