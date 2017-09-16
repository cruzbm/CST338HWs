/**
 * Title: Bank2.java
 * Abstract: This program creates a Bank2 class that holds only three accounts.
 *           The class should implement openAccount (), closeAccount (),
 *           printAllAccounts(), etc.

 * Author: XXXX
 * ID: XXXX
 * Date: MM/DD/YY
 */

import java.util.Scanner;

public class Bank2 
{
    private Account2[] accounts = new Account2[3];
    private String bankName;
    private int numOfAccounts;
    
    // Default constructor
    public Bank2()
    {
        bankName = "UNKNOWN";
        numOfAccounts = 0;
    }
    
    
    public String toString()
    {
        return("Bank name: " + bankName + "\nNumber of accounts: " + numOfAccounts);
    }
    
    
    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }
    

    // Open an account based on the user's input.
    public boolean openAccount()
    {
        if (numOfAccounts == 3)
        {
            System.out.println("Sorry, the bank has already too many accounts." +
                              "\nPlease try again later.\n");
            return false;
        }
        
        // Find an empty slot in the accounts array.
        boolean nullAccount = false;
        int accountIndex = 0;
        for (int i = 0; i < 3; i++)
        {
            if (accounts[i] == null)
            {
                accountIndex = i;
                nullAccount = true;
                break;
            }
        }
        
        if (nullAccount == false)
        {
            return false;
        }
        
        Scanner keyboard = new Scanner(System.in);
        String accountName;
        int accountNum;
        int accountType;
        double balance;
        
        System.out.print("Enter the account owner's name: ");
        accountName = keyboard.next();
        
        System.out.print("Enter an account number: ");
        accountNum = keyboard.nextInt();
        
        // Check if the account number is used or not.
        for (int i = 0; i < 3; i++)
        {
            if (accounts[i] != null)
            {            
                if (accountNum == accounts[i].getAccountNumber())
                {
                    System.out.println("Account number is already used.");
                    return false;
                }
            }
        }
        
        System.out.print("Enter an account type: ");
        accountType = keyboard.nextInt();

        System.out.print("Enter an initial balance: ");
        balance = keyboard.nextDouble();
        
        // Open an account with the given data from the user.
        accounts[accountIndex] = new Account2(accountName, accountNum, accountType, balance);
        numOfAccounts++;
        System.out.println("Account open success!\n");
        return true;
    }

    
    public boolean closeAccount(int num)
    {
        for (int i = 0; i < 3; i++)
        {
            if (accounts[i] != null)
            {           
                if (num == accounts[i].getAccountNumber())
                {
                    accounts[i] = null;
                    numOfAccounts--;
                    return true;
                }
            }
        }
        
        System.out.println("No such account exists to close!");
        return false;
    }

    
    //Prints out all the accounts' information
    public void printAllAccounts()
    {
        for (int i = 0; i < 3; i++)
        {
            if (accounts[i] != null)
            {     
                accounts[i].printAccount();
                System.out.println();
            }
        }
    }
}