/*
 * Title: TestCase_5.java
 * Purpose: Verify if two accounts containing identical information in 2 different banks do not
 * interfere.
 * 
 * Input: AAAA, 1111, 1, 10.00
 * 		  AAAA, 1111, 1, 10.00
 *
 * Expected Result: The program should print 2 Account open successes.
 *
 * Test Result: The program passed the test case.
 *
 * Author: XXXX
 * ID: XXXX
 * Date: MM/DD/YY
 */

	public class TestCase_6 {
	
	    public static void main(String[] args) 
	    {
	        Bank2 testBank = new Bank2();
	        testBank.setBankName("CSUMB");
	        
	        Bank2 testBank2 = new Bank2();
	        testBank2.setBankName("MPC");
	        
	        System.out.println(testBank.openAccount());
	        System.out.println(testBank2.openAccount());
	        
	        
	    }
	}
