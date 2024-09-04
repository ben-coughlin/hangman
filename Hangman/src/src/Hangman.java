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
		Scanner letterScn = new Scanner(System.in);
		
		System.out.println("Enter a one-character guess. ");
		String guess = letterScn.nextLine();
		
		
		
		
		int rand = (int)(Math.random() * 999);
		
		boolean isGuessing = true;
		
		if(guess.length() > 1)
			{
				System.out.println("Invalid guess. Try again!");
				wordGuess();
			}
		else
			{
				String secretWord = wl.get(rand);
				
				System.out.println("your list of unguessed letters is: ");
				
				for(String a : alphabet)
					{
						if(guess.equals(a))
							{
								
							}
						System.out.print(a);
					}
				//while(isGuessing)
					//{
						
						for(int i = 0; i < secretWord.length(); i++)
							{
								System.out.print(" _ ");
							}
						
						
					//}
			}
	}
	public static ArrayList<String> fillAlphabet()
	{
		ArrayList<String> alphabet = new ArrayList<String>(); 
		
		
		//{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		alphabet.add("a");
		alphabet.add("b");
		alphabet.add("c");
		alphabet.add("d");
		alphabet.add("e");
		alphabet.add("f");
		alphabet.add("g");
		alphabet.add("h");
		alphabet.add("i");
		alphabet.add("j");
		alphabet.add("k");
		
		
		return alphabet;
	}
	
}
