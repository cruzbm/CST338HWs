/*
 * Title: TestCase_5.java
 * Purpose: Verify if Bank2 toString method will print correctly after multiple closeAccount operations. 
 * Input: First account: AAAA, 1111, 1, 1000.50
 *
 * Expected Result: The program should print an empty bank then,
 * return true for the openAccount and
 * first close account method. Then 2 falses will be printed and the
 * toString method will print an empty bank again.
 *
 * Test Result: The program passed the test case.
 *
 * Author: XXXX
 * ID: XXXX
 * Date: MM/DD/YY
 */

	public class TestCase_5 {
	
	    public static void main(String[] args) 
	    {
	        Bank2 testBank = new Bank2();
	        testBank.setBankName("CSUMB");
	        
	        System.out.println(testBank.toString());
	        System.out.println(testBank.openAccount());
	        System.out.println(testBank.closeAccount(1111));
	        System.out.println(testBank.closeAccount(1111));
	        System.out.println(testBank.closeAccount(1111));
	       
	        System.out.println(testBank.toString());
	        
	        
	    }
	}
