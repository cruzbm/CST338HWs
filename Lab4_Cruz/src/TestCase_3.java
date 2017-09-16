/*
 * Title: TestCase_0.java
 * Purpose: Verify if Bank2 can handles more three accounts, deleting 1 account, then opening a new one.
 * Input: First account: AAAA, 1111, 1, 1000.50
 *        Second account: BBBB, 2222, 1, 1000.50
 *        Third account: CCCC, 3333, 2, 1000.50
 *        Fourth account: DDDD, 4444, 2, 1000.50
 *
 * Expected Result: The program should return true for all.
 *
 * Test Result: The program passed the test case.
 *
 * Author: Brandon Cruz
 * ID: 8309
 * Date: MM/DD/YY
 */

	public class TestCase_3 {
	
	    public static void main(String[] args) 
	    {
	        Bank2 testBank = new Bank2();
	        testBank.setBankName("CSUMB");
	        
	        System.out.println (testBank.openAccount());
	        System.out.println (testBank.openAccount());
	        System.out.println (testBank.openAccount());
	        System.out.println(testBank.closeAccount(1111));
	        System.out.println (testBank.openAccount());
	        
	    }
	}
