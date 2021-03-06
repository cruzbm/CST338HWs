/* 
 * Title: Account.java
 * Abstract: This class is the Account Class built in conjuction with
 * Customer.java and Bank.java for a functioning bank account.
 * Account.java contains all account methods necessary for properly running
 * functions in Bank.java
 * Author: Brandon Cruz
 * ID: 8309
 * Date: 9/14/2017
 */

public class Account {
	private int accNum;
	private int accType; //1: checking, 2: savings
	private int assocSSN; //Associated SSN to a user
	private double accBalance;
	
	public Account() {} //Default constructor
	

	//---------------------------------
	//OVERLOADED CONSTRUCTOR(int, int, int)
	//---------------------------------
	public Account(int ssn, int num, int type, double balance) {
		this.assocSSN = ssn;
		this.accNum = num;
		this.accType = type;
		this.accBalance = balance;
	}
	

	//---------------------------------
	//ACCOUNT NUMBER GETTER
	//---------------------------------
	public int getAccNUM() {
		return accNum;
	}
	
	//---------------------------------
	//ASSOCIATED SSN GETTER
	//---------------------------------
	public int getSSN() {
		return assocSSN;
	}
	
	//---------------------------------
	//ACCOUNT BALANCE GETTER
	//---------------------------------
	public double getBalance() {
		return accBalance;
	}
	
	//---------------------------------
	//ACCOUNT TYPE GETTER
	//---------------------------------
	public String getType() {
		if (accType == 1) {
			return "Checking Account";
		}
		else if (accType == 2) {
			return "Savings Account";
		}
		else
			return "Account Type Invalid";
	}
	
	//---------------------------------
	//ACCOUNT BALANCE GETTER
	//---------------------------------
	public void setNewBal(double newBal) {
		this.accBalance = newBal;
	}
	
	//---------------------------------
	//PRINT ACCOUNT
	//---------------------------------
	public void printAccount() {
		System.out.printf("\t" + accNum + ": $%5.2f" + " - " , accBalance);
		
	}
}
