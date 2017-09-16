/**
 * Title: Account2.java
 * Abstract: This program creates an Account2 class that keeps account holder's name,
 *           account number, type, and balance.
 * Author: XXXX
 * ID: XXXX
 * Date: MM/DD/YY
 */

public class Account2 
{
    private String name;
    private int number;
    private int type;
    private double balance;
     
    public Account2()
    {
        this.name = "UNKNOWN";
        this.number = 0;
        this.type = 0;
        this.balance = 0;
    }
    
    
    public Account2(String name, int number, int type, double balance)
    {
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
    }
    
    
    public void setAccount(String name, int number, int type, double balance)
    {
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
    }          
    
    
    public boolean deposit(double fund)
    {
        if (fund < 0.0) 
        {
            System.out.println("Error: no negative amount to deposit.");
            return false;
        }
        else
        {
            balance += fund;
            return true;
        }
    }

    
    public boolean withdrawal(double fund)
    {
        if (fund > balance) 
        {
            System.out.println("Error: insufficient balance to withdraw.");
            return false;
        }
        else 
        {
            balance -= fund;
            return true;
        }
    }
    

    public int getAccountNumber()
    {
        return (this.number);
    }
    

    public void printAccount()
    {
        System.out.println("Account holder's name: " + name +
                           "\nAccount number: " + number +
                           "\nAccount type: " + type +
                           "\nBalance: " + balance);
    }
}