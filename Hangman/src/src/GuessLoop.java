package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GuessLoop {

	

	
	public static void guessLoop(String secretWord, String[] secretWordObscured)
	{
		boolean isStillGuessing = true; 
		boolean isGuessValid = false;
		int incorrectGuessCounter = 0;
		
		while(isStillGuessing)
		{
			isStillGuessing = guess(secretWord, secretWordObscured, incorrectGuessCounter);
			
		}
		
	}
	public static boolean guess(String secretWord, String[] secretWordObscured, int igc)
	{
	Scanner letterScn = new Scanner(System.in);
	ArrayList<Character> alphabet = GuessLoop.fillAlphabet();
	HashSet<String>guessedLetters = new HashSet<String>();
	
	boolean isGameDone = false;
	
	
		System.out.println("\nEnter a one-character guess. ");
		String guess = letterScn.nextLine();

		if(guess.length() > 1)
			{
				//invalid guess
				System.out.println("Invalid guess. Try again!");
				return isGameDone;
			}
		else
			{
				
				//correct guess
				if(secretWord.contains(guess))
						{
					secretWordObscured[Hangman.findCharacter(guess, secretWord)] = guess;
						System.out.println("Your guess was correct!");
						}
				else
				{
					//if incorrect
					displayStickman(igc, guess);
				}
				
			}
		
		Hangman.printSWO(secretWordObscured);
		
		return isGameDone;
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
	
	public static void displayStickman(int incorrectGuessCounter, String guess)
	{
		
		String[] stickman = {"o", "/", "|", "\\", "/", "\\"}; 
		
		System.out.println("Your guess \"" + guess + "\" was incorrect. You have guessed incorrectly " + (incorrectGuessCounter + 1) + " times.");
		System.out.print("			" + stickman[incorrectGuessCounter] + "\n\n\n");
		incorrectGuessCounter++; 
	}
	
	public static void wordGuess()
	{
		
		
		ArrayList<Character> alphabet = GuessLoop.fillAlphabet();
		int rand = (int)(Math.random() * 999);
		
		String secretWord = Hangman.wl.get(rand);
				
		String[] secretWordObscured = new String[secretWord.length()];
		
		for(int i = 0; i < secretWord.length(); i++)
		{
			secretWordObscured[i] =" _ ";
		}
		
		System.out.println("Your word has " + secretWord.length() + " letters.");
		
		Hangman.printSWO(secretWordObscured);
		
		System.out.println("\nYour list of unguessed letters is: ");
		
		for(int i = 0; i < alphabet.size(); i++)
		{
			System.out.print(alphabet.get(i) + " ");
		}
		guessLoop(secretWord, secretWordObscured);
	}
}
