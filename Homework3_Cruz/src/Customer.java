/* 
 * Title: Customer.java
 * Abstract: This class is the Customer Class built in conjuction with
 * Bank.java and Account.java for a functioning bank account.
 * Customer.java contains all methods meant to enable methods from Bank.java.
 * Author: Brandon Cruz
 * ID: 8309
 * Date: 9/14/2017
 */


public class Customer {
	private String name;
	private int ssn;
	private String address;
	
	public Customer() {} //Default Constructor
	

	//---------------------------------
	//OVERLOADED CONSTRUCTOR(String, int, String)
	//---------------------------------
	public Customer(String cName, int cSSN, String cAddress) {
		this.name = cName;
		this.ssn = cSSN;
		this.address = cAddress;
	}
	

	//---------------------------------
	//SSN GETTER
	//---------------------------------
	public int getSSN() {
		return ssn;
	}
	
	//---------------------------------
	//ADDRESS GETTER
	//---------------------------------
	public String getAddress() {
		return address;
	}
	
	//---------------------------------
	//NAME GETTER
	//---------------------------------
	public String getName() {
		return name;
	}
	
	//---------------------------------
	//ADDRESS SETTER
	//---------------------------------
	public void setNewAddr(String addr) {
		this.address = addr;
	}
	
	//---------------------------------
	//PRINT CUSTOMER
	//---------------------------------
	public void printCustomer() {
		System.out.println("\t" + name + ": " + ssn + ", " + address);
	}

	//---------------------------------
	//OVERLOADED PRINT CUSTOMER(SSN)
	//---------------------------------
	public void printCustomer(int ssn) {
		System.out.println(name + ": " + ssn);
	}
}
