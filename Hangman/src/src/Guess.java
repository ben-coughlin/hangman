package src;

import java.util.HashSet;
import java.util.Scanner;

public class Guess {
	
	
	public static void init()
	{
		HashSet<String>guessedLetters = new HashSet<String>();
		
		int rand = (int)(Math.random() * 999);
		String secretWord = Hangman.wl.get(rand);
		String[] secretWordObscured = new String[secretWord.length()];
			
	}
	public static void guessLoop()
	{
		String guess = guessLetter();
		
		checkGuess(guess);
		
	}
	public static String guessLetter()
	{
		Scanner guessScn = new Scanner(System.in);
		System.out.println("Enter a one-letter guess.");
		String guess = guessScn.nextLine();
		
		return guess;
	}
	public static void checkGuess(String guess)
	{
		
	}
	public static void updateLetters()
	{
		
	}
	public static void updateAlphabet()
	{
		
	}
	public static boolean isGameOver()
	{

	}


}
