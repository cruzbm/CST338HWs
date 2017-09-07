/**
 * Title: Bank2Demo.java
 * Abstract: This is a sample program to test the Account 2 and Bank2 classes.
 *           The program opens two accounts and closes one account.
 * Author: Dr. Byun
 * ID: XXXX
 * Date: MM/DD/YY
 */

public class Bank2Demo {

    public static void main(String[] args) 
    {
        Bank2 testBank = new Bank2();
        testBank.setBankName("CSUMB");
        
        // Create an account with the name (= "Alice"), account number (= 1000),
        // account type (= 1), and balance (= 500.25).
        testBank.openAccount();
        
        // Create an account with the name (= "Bob"), account number (= 2000),
        // account type (= 1), and balance (= 0).
        testBank.openAccount();

        System.out.println("test");
        
        // Display the current account(s) information on the screen.
        testBank.printAllAccounts();
        
        // Close the account with the number 1000.
        testBank.closeAccount(1000);
        
        // Close the account with the number 3000.
        // The method should return false because there's no account with 3000.
        //testBank.closeAccount(3000);

        // Display the current account(s) information on the screen.
        //testBank.printAllAccounts();        
    }

}