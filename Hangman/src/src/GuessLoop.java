package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GuessLoop {

	static int incorrectGuessCounter = 0;
	

	
	public static void guessLoop()
	{
		boolean isStillGuessing = true; 
		boolean isGuessValid = false;
		
		
		while(isStillGuessing)
		{
			isStillGuessing = guess(incorrectGuessCounter);
			
		}
		
	}
	public static boolean guess(int igc)
	{
	
	//variables :)
	Scanner letterScn = new Scanner(System.in);
	ArrayList<Character> alphabet = Hangman.fillAlphabet();
	HashSet<String>guessedLetters = new HashSet<String>();
	boolean isGameDone = false;
	int rand = (int)(Math.random() * 999);
	String secretWord = Hangman.wl.get(rand);
	String[] secretWordObscured = new String[secretWord.length()];
	
	//prints the unguessed word
	for(int i = 0; i < secretWord.length(); i++)
	{
		secretWordObscured[i] =" _ ";
	}
	
	System.out.println("Your word has " + secretWord.length() + " letters.");
	
	Hangman.printSWO(secretWordObscured);
	
	//letter dictionary
	System.out.println("\nYour list of unguessed letters is: ");
	
	for(int i = 0; i < alphabet.size(); i++)
	{
		System.out.print(alphabet.get(i) + " ");
	}
	
	
	
		System.out.println("\nEnter a one-character guess. ");
		String guess = letterScn.nextLine();
		
		
		//guess validity & actions
		if(guess.length() > 1)
			{
				//invalid guess
				System.out.println("Invalid guess. Try again!");
				isGameDone = false;
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
		
		//end of turn 
		Hangman.printSWO(secretWordObscured);
		
		if(isGameOver(secretWordObscured, secretWord) == 1 || isGameOver(secretWordObscured, secretWord) == 2)
		{
			isGameDone = true;
		}
		
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
	
	
	public static void displayStickman(int incorrectGuessCounter, String guess)
	{
		
		String[] stickman = {"o", "/", "|", "\\", "/", "\\"}; 
		
		System.out.println("Your guess \"" + guess + "\" was incorrect. You have guessed incorrectly " + (incorrectGuessCounter + 1) + " times.");
		System.out.print("			" + stickman[incorrectGuessCounter] + "\n\n\n");
		incorrectGuessCounter++; 
	}
	public static boolean isWordGuessed(String[] swo, String sw)
	{
		
		boolean isWordGuessed = false;
		
		int secretWordLength = sw.length();
		
		
		for(int i = 0; i < swo.length; i++)
		{
			if(!swo[i].equals(" _ "))
			{
				secretWordLength--;
			}
			
		}
		
		if(secretWordLength == 0)
		{
			
			isWordGuessed = true;
		}
		else
		{
			isWordGuessed = false;
		}
		
		
		return isWordGuessed;
	}
	public static boolean isGameLost(int igc)
	{
		
		//stickman has six limbs
		
		boolean isGameLost = false;
		
		if(igc == 6)
		{
			isGameLost = true;
		}
	
		
		return isGameLost;
	}
	
	public static int isGameOver(String[] swo, String sw)
	{
		
		//0 = game is still going, 1 = game was lost, 2 = game was won
		
		int gameOverIndex = 0;
		
		if(isGameLost(incorrectGuessCounter) == true)
		{
			gameOverIndex = 1;
		}
		else if(isWordGuessed(swo, sw) == true)
		{
			gameOverIndex = 2;
		}
		
		return gameOverIndex;
	}
	
	

}
