/* 
 * Title: Lab1_Cruz.java
 * Abstract: This class is a Caesar Cipher machine
 * that is able to decrypt or encrypt user input.
 * Author: Brandon Cruz
 * ID: 8309
 * Date: 9/6/2017
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab1_Cruz {
	
	
	public static void main(String []args) {
		System.out.print("Enter a string: ");
		Scanner keyboard = new Scanner(System.in);
		String inputString = keyboard.nextLine();
		
		System.out.println("");
			
		System.out.print("Enter a key: ");
		keyboard = new Scanner(System.in);
		try {
			int key = keyboard.nextInt();
		}
		catch (InputMismatchException i) {
			System.out.println("Invalid input type.");
			return;
		}
	} // close main
} // close class
