
import java.util.Scanner;


public class Bank {
	private String name;
	private Account []accounts;
	private Customer []customers;
	
	public Bank() {
		//Default constructor
	}
	

	//---------------------------------
	//OVERLOADED CONSTRUCTOR(STRING)
	//---------------------------------
	public Bank(String bankName) {
		this.name = bankName;
		this.accounts = new Account[5]; //max 5 accounts, one per customer max
		this.customers = new Customer[5]; //max 5 customers per bank, each customer has no more than 1 account
	}
	
	//---------------------------------
	//ADD CUSTOMER
	//---------------------------------
	public boolean addCustomer(String cName, String cAdd, int cSSN) {
		//Conditions for false -- 1. Customer with SSN already exists
		//                     -- 2. Number of Customers is max
		
		//Check for repeated SSN
		for (int i = 0; i < 5; i++) {
			if (customers[i] == null) {
				continue;
			}
			if (customers[i].getSSN() == cSSN) {
				System.out.println("**Customer with SSN already exists**");;
				return false; //SSN is already present
			}
		}
		for (int i = 0; i < 5; i++) {
			if (customers[i] == null) {
				customers[i] = new Customer(cName, cSSN, cAdd);
				System.out.println("Customer Added --");
				System.out.println("\t Name: " + cName + ", SSN: " + cSSN + ", Address: " + cAdd);
				return true;
			}
		}
		System.out.println("**Number of Customers in Bank " + name + " has reached capacity**");
		return false; //Will reach if all accounts are filled.
	}
	

	//---------------------------------
	//OPEN ACCOUNT
	//---------------------------------
	public boolean openAccount(int ssn, int accNum, int accType, double balance) {
		//Conditions for false -- 1. Account Number already exists
		//                     -- 2. 5 accounts already exist
		for (int i = 0; i < 5; i++) {
			if (accounts[i] == null) {
				continue;
			}
			if (accounts[i].getAccNUM() == accNum) {
				System.out.println("**Account Number " + accNum + " already exists**");
				return false;
			}
		}
		for (int i = 0; i < 5; i++) {
			if (accounts[i] == null) {
				accounts[i] = new Account(ssn, accNum, accType, balance);
				System.out.println("Account Created --");
				System.out.println("\t SSN: " + ssn + ", Account Number: " + accNum + 
						", Account Type: "+ accType + ", Account Balance: " + balance);
				return true;
			}
		}
		
		return false;
	}
	

	//---------------------------------
	//CLOSE ACCOUNT
	//---------------------------------
	public boolean closeAccount(int accNum) {
		//Conditions for false -- 1. Account Number does not exist
		for (int i = 0; i < 5; i++) {
			if (accounts[i] == null) {
				continue;
			}
			if (accounts[i].getAccNUM() == accNum) {
				accounts[i] = null;
				return true;
			}
		}
		return false;
	}
	

	//---------------------------------
	//ACCOUNT INFO
	//---------------------------------
	public boolean accountInfo(int accNum) {
		//Conditions for false -- 1. Account Number does not exist
		for (int i = 0; i < 5; i++) {
			if (accounts[i] == null) {
				continue;
			}
			if (accounts[i].getAccNUM() == accNum) {
				System.out.println("Account Info:");
				System.out.println("\tAccount Number: " + accNum);
				System.out.println("\t" + accounts[i].getType());
				System.out.printf("\tBalance: $%5.2f \n", accounts[i].getBalance());
				
				System.out.println("Customer Info:");
				for (int j = 0; j < 5; j++) {
					if (customers[j] == null) {
						continue;
					}
					if (customers[j].getSSN() == accounts[i].getSSN()) {
						System.out.println("\t" + customers[i].getName());
						System.out.println("\t" + customers[i].getAddress());
						System.out.println("\tSSN:" + customers[i].getSSN());
					}
				}
			}
		}
		return false;
	}
	

	//---------------------------------
	//UPDATE BALANCE
	//---------------------------------
	public boolean updateBalance(int accNum, double newAmount) {
		for (int i = 0; i < 5; i++) {
			if (accounts[i] == null) {
				continue;
			}
			if (accounts[i].getAccNUM() == accNum) {
				accounts[i].setNewBal(newAmount);
				return true;
			}
		}
		return false;
	}
	

	//---------------------------------
	//UPDATE ADDRESS
	//---------------------------------
	public boolean updateAddress(int SSN, String addr) {
		for (int i = 0; i < 5; i++) {
			if (customers[i] == null) {
				continue;
			}
			if (customers[i].getSSN() == SSN) {
				customers[i].setNewAddr(addr);
				return true;
			}
		}
		return false;
	}
	

	//---------------------------------
	//BANK INFO
	//---------------------------------
	public void bankInfo() {
		System.out.println("Bank Name: " + name);
		
		//Customer Info
		//Count number of customers, then print each customer
		int numCust = 0;
		for (int i = 0; i < 5; i++) {
			if (customers[i] != null) {
				numCust++;
			}
		}
		System.out.println("Number of Customers: " + numCust);
		//Print individual customers
		for (int i = 0; i < 5; i++) {
			if (customers[i] != null) {
				customers[i].printCustomer();
			}
		}
		
		//Account Info
		int numAcct = 0;
		for (int i = 0; i < 5; i++) {
			if (accounts[i] != null) {
				numAcct++;
			}
		}
		System.out.println("Number of Accounts: " + numAcct);;
		//Print individual accounts
		for (int i = 0; i < 5; i++) {
			if (accounts[i] != null) {
				accounts[i].printAccount();
				for (int j = 0; j < 5; j++) {
					if (customers[i] != null) {
						if (customers[i].getSSN() == accounts[i].getSSN()) {
							customers[i].printCustomer(customers[i].getSSN());
							break;
						}
					}
				}
			}
		}
		
		//Obtain Bank Balance
		double totBalance = 0;
		for (int i = 0; i < 5; i++) {
			if (accounts[i] != null) {
				totBalance += accounts[i].getBalance();
			}
		}
		System.out.printf("Bank Total Balance: $%5.2f", totBalance);
	}
	
	
}
