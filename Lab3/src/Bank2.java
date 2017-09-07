
import java.util.Scanner;
import java.util.InputMismatchException;

public class Bank2 {
	
	private Account2 []accounts = new Account2[3];
	private String bankName;
	private int numOfAccounts = 0;
	
	public Bank2(){
	}
	
	public void setBankName(String name) {
		this.bankName = name;
	}
	
	public boolean openAccount() {
		Scanner keyboard = new Scanner(System.in);
		if (this.numOfAccounts < 3) {
			String name;
			int accountNum;
			int accountType;
			double accountBal;
			
			try { //Read in name
				name = keyboard.next();
			}
			catch(InputMismatchException ie) {
				System.out.println("Invalid format");
				return false;
			}

			keyboard = new Scanner(System.in);
			try { //Read in account number;
				accountNum = keyboard.nextInt();
			}
			catch(InputMismatchException ie) {
				System.out.println("Invalid format");
				return false;
			}
			
			keyboard = new Scanner(System.in);
			try { //Read in account type;
				accountType = keyboard.nextInt();
			}
			catch(InputMismatchException ie) {
				System.out.println("Invalid format");
				return false;
			}
			
			keyboard = new Scanner(System.in);
			try { //Read in account balance;
				accountBal = keyboard.nextDouble();
			}
			catch(InputMismatchException ie) {
				System.out.println("Invalid format");
				return false;
			}
			
			if (numOfAccounts != 0) {
				for (int i = 0; i < numOfAccounts; i++) {
					if (accounts[i] != null) {
						if (accounts[i].getNum() == accountNum) {
							return false;
						}
					}
				}
				for (int i = 0; i < numOfAccounts; i++) {
					if (this.accounts[i] == null) {
						this.accounts[i] = new Account2(name, accountNum, accountType, accountBal);
						this.numOfAccounts++;
						System.out.println("Created.");
						return true;
					}
				}
			}
			else {
				this.accounts[0] = new Account2(name, accountNum, accountType, accountBal);
				this.numOfAccounts++;
				System.out.println("Created");
				return true;
			}
		}
		System.out.println("Bank full");
		return false;
	}
	
	public boolean closeAccount(int number) {
		
		
		return false;
	}
	
	public void printAllAccounts() {
		if (this.numOfAccounts == 0) {
			System.out.println("No accounts exist");
			return;
		}
		else {
			for (int i = 0; i < this.numOfAccounts; i++) {
				if (this.accounts[i] == null) {
					continue;
				}
				else {
					System.out.println(this.accounts[i].getName());
					System.out.println(this.accounts[i].getNum());
					System.out.println(this.accounts[i].getType());
					System.out.println(this.accounts[i].getBal());
				}
			}
		}
	}
}
