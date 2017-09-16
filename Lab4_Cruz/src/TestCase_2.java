/*
 * Title: TestCase_2.java
 * Purpose: Verify if Bank2 can close account that is already closed.
 *  
 * Input: First account: AAAA, 1111, 1, 1000.50
 *        Second account: BBBB, 2222, 1, 1000.50
 *        First closed account: 1111
 *        Second closed account: 2222
 *
 * Expected Result: The program should print false on second
 * iteration of closeAccount();
 *
 * Test Result: The program passed the test case.
 *
 * Author: XXXX
 * ID: XXXX
 * Date: MM/DD/YY
 */

	public class TestCase_2 {
	
	    public static void main(String[] args) 
	    {
	        Bank2 testBank = new Bank2();
	        testBank.setBankName("CSUMB");
	        
	        System.out.println (testBank.openAccount());
	        System.out.println (testBank.openAccount());
	        System.out.println (testBank.closeAccount(1111));
	        System.out.println (testBank.closeAccount(1111));
	        
	        
	        
	    }
	}
