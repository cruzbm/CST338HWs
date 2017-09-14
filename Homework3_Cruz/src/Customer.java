
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