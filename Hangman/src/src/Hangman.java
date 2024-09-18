package src;

import java.io.File;
import java.util.*;
import java.io.IOException;
import java.util.Scanner;

public class Hangman
	{
		static ArrayList<String>wl = new ArrayList<String>();
		
		public static void main(String[] args) throws IOException
			{
				fillDict();
				startGame();
				wordGuess();
			}
	public static void fillDict() throws IOException
		{
			
			
			Scanner fileScn = new Scanner(new File("wordlist.txt"));
			
			while(fileScn.hasNext())
				{
					wl.add(fileScn.nextLine());
				}
		
//hello
	}
	public static void startGame()
	{
		System.out.println("\r\n"
				+ " .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.  .-----------------.  \r\n"
				+ "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |  \r\n"
				+ "| |  ____  ____  | || |      __      | || | ____  _____  | || |    ______    | || | ____    ____ | || |      __      | || | ____  _____  | |  \r\n"
				+ "| | |_   ||   _| | || |     /  \\     | || ||_   \\|_   _| | || |  .' ___  |   | || ||_   \\  /   _|| || |     /  \\     | || ||_   \\|_   _| | |  \r\n"
				+ "| |   | |__| |   | || |    / /\\ \\    | || |  |   \\ | |   | || | / .'   \\_|   | || |  |   \\/   |  | || |    / /\\ \\    | || |  |   \\ | |   | |  \r\n"
				+ "| |   |  __  |   | || |   / ____ \\   | || |  | |\\ \\| |   | || | | |    ____  | || |  | |\\  /| |  | || |   / ____ \\   | || |  | |\\ \\| |   | |  \r\n"
				+ "| |  _| |  | |_  | || | _/ /    \\ \\_ | || | _| |_\\   |_  | || | \\ `.___]  _| | || | _| |_\\/_| |_ | || | _/ /    \\ \\_ | || | _| |_\\   |_  | |  \r\n"
				+ "| | |____||____| | || ||____|  |____|| || ||_____|\\____| | || |  `._____.'   | || ||_____||_____|| || ||____|  |____|| || ||_____|\\____| | |  \r\n"
				+ "| |              | || |              | || |              | || |              | || |              | || |              | || |              | |  \r\n"
				+ "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |  \r\n"
				+ " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'   \r\n"
				+ "");
		
		System.out.println("Welcome! Hangman is a game where you get a certain amount of guesses to find a word. You will enter one letter at a time, if the letter is correct it will go to the correct spot on the word.\n"
				+ "If the letter is incorrect, it will be put aside and the hangman will gain a limb. If the hangman is completed without guessing the word, you lose! Good luck :)");
	}
	public static void wordGuess()
	{
		
		
		ArrayList<Character> alphabet = fillAlphabet();
		int rand = (int)(Math.random() * 999);
		
		String secretWord = wl.get(rand);
				
		String[] secretWordObscured = new String[secretWord.length()];
		
		for(int i = 0; i < secretWord.length(); i++)
		{
			secretWordObscured[i] =" _ ";
		}
		
		System.out.println("Your word has " + secretWord.length() + " letters.");
		
		printSWO(secretWordObscured);
		
		System.out.println("\nYour list of unguessed letters is: ");
		
		for(int i = 0; i < alphabet.size(); i++)
		{
			System.out.print(alphabet.get(i) + " ");
		}
		guessLoop(secretWord, secretWordObscured);
	}
	public static void guessLoop(String secretWord, String[] secretWordObscured)
		{
		Scanner letterScn = new Scanner(System.in);
		ArrayList<Character> alphabet = fillAlphabet();
		int incorrectGuessCounter = 0;
		
			System.out.println("\nEnter a one-character guess. ");
			String guess = letterScn.nextLine();

			if(guess.length() > 1)
				{
					System.out.println("Invalid guess. Try again!");
					return;
				}
			else
				{
					//alphabet.remove(guess);
				
					System.out.println(findCharacter(guess, secretWord));
					if(secretWord.contains(guess))
							{
						secretWordObscured[findCharacter(guess, secretWord)] = guess;

							}
					else
					{
						
						displayStickman(incorrectGuessCounter, guess);
					}
					
				}
			
			printSWO(secretWordObscured);
			//a
			
		}
		
	
	public static ArrayList<Character> fillAlphabet()
	{
		ArrayList<Character> alphabet = new ArrayList<Character>(); 
		
		char c;
		
		for(c = 'a'; c <= 'z'; ++c)
		{
		      alphabet.add(c);
		   }
	
		
		return alphabet;
	}
	public static int findCharacter(String guess, String secretWord)
	{
		int charIndex = 0;
		String[] swArray = secretWord.split(""); 
		
		for(int i = 0; i < secretWord.length(); i++)
		{
			if(swArray[i].equals(guess))
			{
				charIndex = i;
			}
		}
		System.out.println(charIndex);
		return charIndex;
	}
	public static void printSWO(String[] secretWordObscured)
	{
		for(int i = 0; i < secretWordObscured.length; i++)
		{
			System.out.print(secretWordObscured[i]);
		}
	}
	public static void displayStickman(int incorrectGuessCounter, String guess)
	{
		
		String[] stickman = {"o", "/", "|", "\\", "/", "\\"}; 
		
		System.out.println("Your guess \"" + guess + "\" was incorrect. You have guessed incorrectly " + (incorrectGuessCounter + 1) + " times.");
		System.out.print("			" + stickman[incorrectGuessCounter] + "\n\n\n");
		incorrectGuessCounter++; 
	}
	public static boolean isLetterGuessed(HashSet<String>guessedLetters, String guess)
	{
		boolean isLetterGuessed = false;
		
		guessedLetters.add(guess);
		
		if(guessedLetters.contains(guess))
		{
			isLetterGuessed = true;
		}
		
		return isLetterGuessed;
	}
	
}
