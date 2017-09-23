/* 
 * Title: Hangman.java
 * Abstract: This class allows a user to end a file name,
 * then play hangman from a random work selected by the program
 * from a user selected file.
 * Author: Brandon Cruz
 * ID: 8309
 * Date: 9/19/2017
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Hangman {
		
	public static boolean makeGuess(ArrayList<Character> letters, char guess) {
		if (letters.contains(guess)) {
			return true;
		}
		return false;
	}
	
	public static char giveHint(ArrayList<Character>letters, ArrayList<Character>guessed) {
		int hintIndex;
		boolean flag = false;
		while(!flag) {
			hintIndex = (int)(Math.random()*(letters.size()));
			if (!guessed.contains(letters.get(hintIndex))) {
				flag = true;
				return letters.get(hintIndex);
			}
		}	
		System.out.println("Failed hint");
		return '0';
	}
	
	public static void main(String[] args) {
		System.out.println("----------Hangman----------");
		System.out.print("Input filename: ");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		ArrayList<String>stringHolder = new ArrayList<String>();
		int rand = 0;
		int incorrectGuesses = 4; 
		
		//OPEN FILE
		try {
			Scanner fileIn = new Scanner(new FileInputStream(input));
			while(fileIn.hasNextLine()) {
				String tempStr = fileIn.nextLine();
				stringHolder.add(tempStr);
			}
			

			//SELECT INDIVIDUAL WORD AT INDEX OF RAND
			rand = (int)(Math.random()*(stringHolder.size()));
			
			//CONVERT STRING TO BROKEN UP ARRAYLIST OF CHARS
			String holder = stringHolder.get(rand); //ArrayList to string
			char []charHolder = holder.toCharArray(); //String to Char array
			ArrayList<Character>hangman = new ArrayList<Character>(); //Create new char array
			ArrayList<Character>guessedLetters = new ArrayList<Character>(); //Create ArrayList to hold guesses
			ArrayList<Character>blankSpaces = new ArrayList<Character>();
			
			for (int i = 0; i < holder.length(); i++) {
				hangman.add(charHolder[i]); //Add all indexes of char array to ArrayList<Characters>
				blankSpaces.add('_');
			}

			
			
			//PRINT SPACES AND COUNT GUESSES
			while(incorrectGuesses != 0) {
				try {
					//PRINT INITIAL SPACES
					System.out.print("The word is: ");
					for (int i = 0; i < hangman.size(); i++) {
						System.out.print(blankSpaces.get(i) + " ");
					}
					
					System.out.println("You have " + incorrectGuesses + " left.");
					System.out.print("Enter either 1 for guessing or 2 for hint: ");
					keyboard = new Scanner(System.in);
					int option = keyboard.nextInt();
					
					//Call methods from here
					if (option == 1) { //GUESS
						System.out.print("Enter your guess: ");
						keyboard = new Scanner(System.in); //User inputs guess
						char keyIn = Character.toUpperCase(keyboard.next().charAt(0)); //Convert string to char and assign to var keyIn
						if (!makeGuess(hangman, keyIn)) {
							incorrectGuesses--;
						}
						else {
							for (int i = 0; i < hangman.size(); i++) {
								if (hangman.get(i) == keyIn) {
									for (int j = 0; j < hangman.size(); j++) {
										if (hangman.get(i) == keyIn) {
											blankSpaces.set(i, keyIn);
										}
									}
								}
							}
						}
					}
					else if (option == 2) { //HINT
						incorrectGuesses--; //Decrement as penalty for using hint
						System.out.print("OK! ");
						char hint = giveHint(hangman, blankSpaces); //Hint runs validation for not already guessed char in function itself
						System.out.println("Your hint is: " + hint);
						for (int i = 0; i < blankSpaces.size(); i++) {
							if (hangman.get(i) == hint) {
								blankSpaces.set(i, hint);
							}
						}
						
					}
					
					//IF NO MORE BLANKSPACES EXIST IN BLANKSPACES ARRAYLIST --> WORD IS COMPLETED
					if (!blankSpaces.contains('_')){
						System.out.print("The complete word is: ");
						for (int i = 0; i < hangman.size(); i++) {
							System.out.print(blankSpaces.get(i) + " ");
						}
						System.out.println("\nCongrats, you got it!");
						return;
					}
			}
			catch(InputMismatchException i) {
					System.out.println("Invalid input, letters only.");
			}
				
		}
			
			//IF INCORRECTGUESSES REACHES 0
			if (incorrectGuesses == 0) {
				
				System.out.println("You failed. The word was " + hangman);
			}
		}
		catch (InputMismatchException | FileNotFoundException e) {
			System.out.println("Invalid. End of Session.");
		}
		
		
	}
}
