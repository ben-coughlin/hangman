package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GuessLoop {

	public static boolean guessLoop(String secretWord, String[] secretWordObscured, int incorrectGuessCounter)
	{
		boolean isStillGuessing = true; 
		Scanner letterScn = new Scanner(System.in);
		HashSet<String>guessedLetters = new HashSet<String>();
		
		while(isStillGuessing)
		{
			
			
			System.out.println("\nEnter a one-character guess. ");
			String guess = letterScn.nextLine();

			if(guess.length() > 1 || isLetterGuessed(guessedLetters, guess))
				{
					System.out.println("Invalid guess. Try again!");
					break;
				}
			else
				{
					//alphabet.remove(guess);
				
					//System.out.println(findCharacter(guess, secretWord)); debugging
					if(secretWord.contains(guess))
							{
						secretWordObscured[Hangman.findCharacter(guess, secretWord)] = guess;
							break;
							}
					else
					{
						
						GuessLoop.displayStickman(incorrectGuessCounter, guess);
					}
					
				}
			
			Hangman.printSWO(secretWordObscured);
			
			for(int i = 0; i < secretWordObscured.length; i++)
			{
				
				//if(!secretWordObscured[i].equals(" _ ")
						//{
					
						//}
			}
			
		}
		
		
		return isStillGuessing;
		
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
}
