
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
import java.util.HashMap;
import java.lang.StringIndexOutOfBoundsException;
//----------------

public class Histogram {
	

	//Faster println call
	public static void println(String line) {
		System.out.println(line);
	}
	
	//Delete repeats in string for use in counting occurrences
	public static String deleteRepeats(String str) {
		int [] count = new int[256];
		
		for (int i = 0 ; i < str.length(); i++) {
			char c = str.charAt(i);
			count[c]++;
		}
		
		StringBuilder strBld = new StringBuilder(count.length);
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				strBld.append((char)i)
;			}
		}
		return strBld.toString();
	}
	
	
	//Build HashMap to hold all letters and default 0 instances of values.
	public static void buildHashMap(HashMap<Character, Integer> tr) {
		tr.put('a', 0);
		tr.put('b', 0);
		tr.put('c', 0);
		tr.put('d', 0);
		tr.put('e', 0);
		tr.put('f', 0);
		tr.put('g', 0);
		tr.put('h', 0);
		tr.put('i', 0);
		tr.put('j', 0);
		tr.put('k', 0);
	}
	
	
	//----------------------
	public static void main(String[] args) {
		//Initialize variables
		Scanner keyboard;
		String keyIn;
		Scanner fileIn;
		String fileString = "";
		char [] letters;
		int [] count = new int[256];
		String cutString;
		HashMap<Character,Integer> tracker = new HashMap<Character, Integer>();
		
		
		System.out.print("Input filename: ");
		keyboard = new Scanner(System.in);
		keyIn = new String(keyboard.nextLine());
		
		//Attempt to open file
		try {
			
			//Note: file must exist outside of src
			fileIn = new Scanner(new FileInputStream(keyIn));
			
			//Fill string with text in file by each line of data in text file
			while(fileIn.hasNextLine()) {
				String tempStr = fileIn.nextLine();
				fileString = fileString + tempStr;
			}
			
//			Testing String concatenation
//			println(fileString); //Successful test
//			--------------------------
			
			
//			Set frame above occurrence marker
			println("Char    Occurrence");
			
			//Convert string to char array and sort
			letters = fileString.toCharArray();
			for(int i = 0; i < letters.length-1; i++) {
				for (int j = i+1; j < letters.length; j++) {
					if ((int)letters[i] > (int)letters[j]) {
						char temp = letters[j];
						letters[j] = letters[i];
						letters[i] = temp;
					}
				}
			}
			
			
			cutString = deleteRepeats(fileString);
			
			//Fill count array according to letter appearance
			for (int i = 0; i < cutString.length(); i++) {
				for (int j = 0; j < letters.length;j ++) {
					if (cutString.charAt(i) == letters[j]) {
						count[i]++;
						//tracker.put(letters[j], tracker.get(letters[j]) + 1);
					}
				}
			}
			
			//Print Char and Occurrence data
			for (int i = 0; i < cutString.length(); i++) {
				System.out.println(cutString.charAt(i) + "       " + count[i]);
			}
			
		}
		catch (FileNotFoundException e) {
			println("File not found.");
			System.exit(0);
		}
		
		
		println("");
		println("============== Vertical Bar Graph ===============");
		println("");
		//println("Success");
		
	}

}
