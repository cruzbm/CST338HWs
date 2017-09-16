/*
 * Title: TestCase_0.java
 * Purpose: Verify Bank2 can handle 2 accounts with the same account number.
 * 
 * Input: First account: AAAA, 1111, 1, 1000.50
 *        Second account: BBBB, 2222, 1, 1000.50
 *        Third account: CCCC, 1111, 2, 1000.50
 *
 * Expected Result: The program should return false on 3rd account opening due
 * to failure of repeated account numbers.
 *
 * Test Result: The program passed the test case.
 *
 * Author: Brandon Cruz
 * ID: 8309
 * Date: 09/14/94
 */

	public class TestCase_1 {
	
	    public static void main(String[] args) 
	    {
	        Bank2 testBank = new Bank2();
	        testBank.setBankName("CSUMB");
	        
	        System.out.println (testBank.openAccount());
	        System.out.println (testBank.openAccount());
	        System.out.println (testBank.openAccount());
	        
	    }
	}

