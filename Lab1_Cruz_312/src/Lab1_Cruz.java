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
	
	public static String encrypt(String pt, int k) {
		String ct = ""; //product
		pt = pt.toLowerCase();
		char []plain = pt.toCharArray();
		for (int i = 0; i < plain.length; i++) {
			int newLet = (int)plain[i];
			if ((newLet + k) > 122) {
				int hold = 122 - newLet + 97 ;
				newLet = hold; //wraparound INCOMPLETE does not wrap beyond 'a'
			}
			else {
				newLet += k;
			}
			plain[i] = (char)newLet;
		}
		for (int i = 0; i < plain.length; i++) {
			ct += plain[i];
		}
		System.out.println("Output Ciphertext: " + ct);
		return ct;
	} // close encrypt
	
	public static String decrypt(String ct, int k) {
		String pt = "";
		ct = ct.toLowerCase();
		char []cipher = ct.toCharArray();
		for (int i = 0; i < cipher.length; i++) {
			int newLet = (int)cipher[i];
			if ((newLet - k) < 97) {
				newLet = (123 - (newLet - 96)); //WRAP AROUND NOT WORKING PROPERLY
			}
			else {
				newLet -= k; // 
			}
			cipher[i] = (char)newLet;
		}
		for (int i = 0; i < cipher.length; i++) {
			pt += cipher[i];
		}
		System.out.println("Output Plaintext: " + pt);
		return pt;
	} // close decrypt
	
	
	public static void main(String []args) {
		
		System.out.println("Choose an option: ");
		System.out.print("1. Encrypt, 2. Decrypt --> ");
		Scanner keyboard = new Scanner(System.in);
		int opt = keyboard.nextInt();
		
		
		if (opt == 1) {
			System.out.print("Input plaintext: ");
			keyboard = new Scanner(System.in);
			String pt = keyboard.nextLine();
			System.out.print("Enter a key: ");
			keyboard = new Scanner(System.in);
			int key = keyboard.nextInt();
			encrypt(pt, key);
		}
		if (opt == 2) {
			System.out.println("Input ciphertext: ");
			keyboard = new Scanner(System.in);
			String ct = keyboard.nextLine();
			System.out.print("Enter the key: ");
			keyboard = new Scanner(System.in);
			int key = keyboard.nextInt();
			decrypt(ct, key);
		}
	} // close main
} // close class
