
/*
* Title: Histogram.java
* Abstract: Displays the number of distinct characters in
* a user defined file.
* Author: Brandon Cruz
* ID: 6809
* Date: 08/25/2017
*/

//File imports----
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//----------------

public class Histogram {

	//Faster println call
	public static void println(String line) {
		System.out.println(line);
	}
	
	//Processor Methods-----
	public static int counter(String str, String seeker) {
		return 0;
	}
	
	public static void printFrame() {
		
	}
	
	public static void main(String[] args) {
		//Initialize variables
		Scanner keyboard;
		String keyIn;
		Scanner fileIn = null;
		
		System.out.print("Input filename: ");
		keyboard = new Scanner(System.in);
		keyIn = new String(keyboard.nextLine());
		
		//Attempt to open file
		try {
			//Note: file must exist outside of src
			fileIn = new Scanner(new FileInputStream(keyIn));
		}
		catch (FileNotFoundException e) {
			println("File not found.");
			System.exit(0);
		}
		
		//println("Success");
		
	}

}
