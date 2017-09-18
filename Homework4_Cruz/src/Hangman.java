/* 
 * Title: Hangman.java
 * Abstract: This class allows a user to end a file name,
 * then play hangman from a random work selected by the program
 * from the file.
 * Author: Brandon Cruz
 * ID: 8309
 * Date: 9/17/2017
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Hangman {
	public static void main(String[] args) {
		System.out.println("----------Hangman----------");
		System.out.print("Input filename: ");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		
		//Open file
		try {
			Scanner fileIn = new Scanner(new FileInputStream(input));
			
		}
		catch (InputMismatchException | FileNotFoundException e) {
			
		}
	}
}
