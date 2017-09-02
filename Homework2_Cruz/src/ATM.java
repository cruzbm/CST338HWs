/* 
 * Title: ATM.java
 * Abstract: This class is the ATM object used when
 * accessing user data and money information for ATMs on
 * campus at CSUMB.
 * Author: Brandon Cruz
 * ID: 8309
 * Date: 9/1/2017
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class ATM {
	
	//Object variables
	private String bankName;
	private String atmLocation;
	private int atmSerial;
	private double atmBalance;
	private int countWithdrawals[] = {0,0};
	private int countDeposits[] = {0,0};
	private int countTransfers[] = {0,0};
	private String []userNames = {"Alice", "Tom", "Monica", "Michael", "John", "Jane", "Robert", "Owen", "Chris", "Rebecca"};
	private int []userPins = {1234, 2000, 3000, 7777, 8000, 2222, 2323, 4455, 8787, 8080};
	private double []userBalances = {5000.00, 200.00, 50.00, 0.00, 500.00, 500.00, 200.00, 50.00, 10.00, 555.55};
	
	public ATM() {
		//default constructor
	}
	
	public ATM(String bank) {
		this.bankName = bank;
		this.atmBalance = 100.00;
		this.atmLocation = "UNKNOWN";
		this.atmSerial = 0;
	}
	
	public ATM(int serial, String bank, String location) {
		this.atmSerial = serial;
		this.bankName = bank;
		this.atmLocation = location;
		this.atmBalance = 100.00;
	}
	
	public void setATM(int serial, String location) {
		this.atmSerial = serial;
		this.atmLocation = location;
	}
	
	public String toString() { //overload System.out.println(ATM) to print ATM
		System.out.println("Serial Number: " + atmSerial);
		System.out.println("Bank Name: " + bankName);
		System.out.println("Location: " + atmLocation);
		System.out.printf("Balance: $%6.2f", atmBalance);
		
		return "";
//		String lineOne;
//			lineOne = "Serial Number: " + atmSerial;
//		String lineTwo = "Bank Name: " + bankName;
//		String lineThree = "Location: " + atmLocation;
//		String lineFour = "Balance: " + atmBalance;
//		String stringTotal = lineOne + "\n" +
//							lineTwo + "\n" +
//							lineThree + "\n" +
//							lineFour + "\n";
//		return stringTotal;
	}
	
	public void addFund(double amnt) {
		atmBalance += amnt;
	}
	
	public void displayMenu() {
		System.out.println("1. Withdrawal");
		System.out.println("2. Deposit");
		System.out.println("3. Transfer");
	}
	
	public void withdrawal(String name, int pin, double wdBalance) {
		for (int i = 0; i < 10; i++) {
			if (name == userNames[i] && pin == userPins[i]) {
				if ((userBalances[i]-wdBalance)>0 && (this.atmBalance - wdBalance)>0) {
				userBalances[i] -= wdBalance;
				System.out.println("Success - withdrawal: " + userNames[i] + " new balance: " + userBalances[i]);
				this.atmBalance -= wdBalance;
				this.countWithdrawals[0] += 1; 
				return;
				}
				else {
					System.out.println("Fail - withdrawal");
					this.countWithdrawals[1] += 1;
					return;
				}
			}
		}
		this.countWithdrawals[1] += 1;
		System.out.println("Fail - withdrawal");
	}
	
	public void status() {
		System.out.println(this);
		int numTransactions = 0;
		int numDep = 0;
		int numWith = 0;
		int numTransf = 0;
		for (int i = 0; i < 2; i++) {
			numDep += countDeposits[i];
			numWith += countWithdrawals[i];
			numTransf += countTransfers[i];
			numTransactions += this.countDeposits[i] + this.countWithdrawals[i] + this.countTransfers[i];
		}
		System.out.println(numTransactions + " Transactions so far:");
		System.out.println("\t Withdrawals: " + numWith + " (" + this.countWithdrawals[0] + " success, " + this.countWithdrawals[1] + " fail)");
		System.out.println("\t Deposits: " + numDep + " (" + this.countDeposits[0] + " success, " + this.countDeposits[1] + " fail)");
		System.out.println("\t Transfers: " + numTransf + " (" + this.countTransfers[0] + " success, " + this.countTransfers[1] + " fails)");
	}
	
	public void deposit(String name, int pin, double amnt) {
		for (int i = 0 ; i < 10; i++) {
			if (name == userNames[i] && pin == userPins[i]) {
				this.countDeposits[0] += 1;
				this.atmBalance += amnt;
				userBalances[i] += amnt;
				System.out.printf("Success - deposit: " + userNames[i] + " new balance : $6.2f", userBalances[i]);
				return;
			}
		}
		System.out.println("Fail - deposit");
		this.countDeposits[1] += 1;
		return;
	}
	
	public void transfer(String name1, int pin1, double trnsferAmnt, String name2, int pin2) {
		for (int i = 0 ; i < 10; i++) {
			if (name1 == userNames[i] && pin1 == userPins[i]) {
				if (userBalances[i] > trnsferAmnt) {
					for (int j = 0; j < 10; j++) {
						if (name2 == userNames[j] && pin2 == userPins[j]) {
							this.countTransfers[1] += 1;
							userBalances[i] -= trnsferAmnt;
							userBalances[j] += trnsferAmnt;
							System.out.printf("Success - transfer: " + userNames[i] + " balance: $%6.2f, ", userBalances[i]);
							System.out.printf(userNames[j] + " balance: $%6.2f", userBalances[j]);
							return;
						}
					}
				}
			}
		}
		this.countTransfers[1] += 1;
		System.out.println("Fail - transfer");
	}
}
