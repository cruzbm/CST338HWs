/*
 * Title: TestCase_4.java
 * Purpose: Verify if Bank2 can verify toString method and printAllAccounts.
 * Input: First account: AAAA, 1111, 1, 1000.50
 *        Second account: BBBB, 2222, 1, 1000.50
 *        Third account: CCCC, 3333, 2, 1000.50
 *        Fourth account: DDDD, 4444, 2, 1000.50
 *
 * Expected Result: The program should return true for 
 *        all methods called, and print 3 -> 2 -> 3 for number of accounts.
 *        Then the program will print all accounts DDDD, BBBB, and CCCC after final true statement
 *        from opening Fourth account.
 *
 * Test Result: The program passed the test case.
 *
 * Author: Brandon Cruz, Donald Dong
 * ID: 6809, 7300
 * Date: 9/14/17
 */

	public class TestCase_4 {
	
	    public static void main(String[] args) 
	    {
	        Bank2 testBank = new Bank2();
	        testBank.setBankName("CSUMB");
	        
	        System.out.println(testBank.toString());
	        System.out.println (testBank.openAccount());
	        System.out.println (testBank.openAccount());
	        System.out.println (testBank.openAccount());
	        System.out.println (testBank.toString());
	        System.out.println (testBank.closeAccount(1111));
	        System.out.println(testBank.toString());
	        System.out.println (testBank.openAccount());
	        System.out.println(testBank.toString());
	        testBank.printAllAccounts();
	        
	    }
	}
