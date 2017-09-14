

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
	//PRINT ACCOUNT
	//---------------------------------
	public void printAccount() {
		System.out.printf("\t" + accNum + ": $%5.2f" + " - " , accBalance);
		
	}
}
