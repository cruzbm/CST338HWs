
/* 
 * Title: Lab2_Cruz.java
 * Abstract: This program is a brute force decryption system.
 * It will read in a ciphertext and test all possible keys for a caesar cipher.
 * Author: Brandon Cruz
 * ID: 8309
 * Date: 9/12/2017
 */

import java.util.Scanner;

public class Lab2_Cruz {
	
	public static String decrypt(String ct, int k) {
		String pt = "";
		ct = ct.toLowerCase();
		char []cipher = ct.toCharArray();
		for (int i = 0; i < cipher.length; i++) {
			int newLet = (int)cipher[i];
			if ((newLet - k) < 97) {
				newLet = (122 - (newLet - 96)); //WRAP AROUND NOT WORKING PROPERLY
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
	
	public static void main(String[] args) {
		System.out.print("Enter ciphertext --> ");
		Scanner keyboard = new Scanner(System.in);
		String ct = keyboard.nextLine();
		for (int i = 0; i <= 26; i++) {
			System.out.println("----------------------------");
			System.out.println("Key: " + i);
			System.out.println("Ciphertext: " + ct);
			decrypt(ct, i);
			System.out.println("----------------------------");
		}
	}
}
