package src;

import java.io.File;
import java.util.*;
import java.io.IOException;

public class Hangman
	{
		public static ArrayList<String>wl = new ArrayList<String>();
		
		public static void main(String[] args) throws IOException
			{
				fillDict();
				startGame();
				GuessLoop.guessLoop();
			}

	public static void startGame()
	{
		System.out.println("\r\n\\u001b[1;34m"
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
				+ " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'   \r\n\\u001b[0m"
				+ "");
		
		System.out.println("Welcome! Hangman is a game where you get a certain amount of guesses to find a word. You will enter one letter at a time, if the letter is correct it will go to the correct spot on the word.\n"
				+ "If the letter is incorrect, it will be put aside and the hangman will gain a limb. If the hangman is completed without guessing the word, you lose! Good luck :)");
	}
	//general utility methods  = = = = = = = = = = = = = = = = = = = =
	
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
		//System.out.println(charIndex); - debugging purposes
		return charIndex;
	}
	
	public static void printSWO(String[] secretWordObscured)
	{
		for(int i = 0; i < secretWordObscured.length; i++)
		{
			System.out.print(secretWordObscured[i]);
		}
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
	
	public static void fillDict() throws IOException
	{
		
		
		Scanner fileScn = new Scanner(new File("wordlist.txt"));
		
		while(fileScn.hasNext())
			{
				wl.add(fileScn.nextLine());
			}
	

}
	
	
	
	
}
