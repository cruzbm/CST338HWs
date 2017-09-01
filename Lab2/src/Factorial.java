/*
* Title: Factorial.java
* Abstract: Prints out the value of a factorial given and integer,
* while also handling input exceptions.
* Author: Brandon Cruz
* ID: 6809
* Date: 09/1/2017
*/

import java.util.Scanner;
import java.util.InputMismatchException;


public class Factorial {
	public static void main(String []args) {
		System.out.print("Enter a number: ");
		Scanner keyboard = new Scanner(System.in);
		try {
			int num = keyboard.nextInt();
			System.out.println(""); //line break
			System.out.print(num + "! --> ");
			for (int i = num; i > 0; i--) {
				int fact = num;
				System.out.print(i);
				if (i > 1) {
					num *= i-1;
					System.out.print(" * ");
				}
				else {
					System.out.print(" --> " + num);
				}
			}
			
		}
		catch(InputMismatchException i) {
			System.out.println("Not a correct format");
			main(args);
		}
	}
	
}
