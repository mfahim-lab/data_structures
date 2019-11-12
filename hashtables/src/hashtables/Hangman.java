package hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Hangman {

	int wordLength;
	int totalGuesses;
	int letterCount;
	// contains all words in dict.
	List<String> allWords = new ArrayList<String>();
	HashSet<String> wordMaster = new HashSet<String>();
	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	StringBuilder currentString = new StringBuilder("");
	ArrayList<Character> wrongGuesses = new ArrayList<Character>();

	// important to access in any methods
	Hangman(int wordLength, int totalGuesses) {
		this.wordLength = wordLength;
		this.totalGuesses = totalGuesses;
	}

	private HashSet<String> importWords() {

		String fileName = "words.txt";
		try {
			Scanner s = new Scanner(new File(fileName));
			while (s.hasNextLine()) {
				String word = s.nextLine();
				wordMaster.add(word); // add the entire dictionary to my wordMaster hashset
			}
			s.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return wordMaster;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in); 

		// Game starts HERE
		System.out.println("Welcome to Hangman, please choose the length of the word.");
		int wordLength = s.nextInt();
		while (wordLength <= 1 || wordLength >= 30) {
			System.out.println("Please choose a valid word length.");
			wordLength = s.nextInt();
		}

		System.out.println("Please choose the number of wrong guesses until the game is over.");
		int totalGuesses = s.nextInt();

		Hangman newGame = new Hangman(wordLength, totalGuesses);
		newGame.importWords(); //initiate wordMaster
		
		StringBuilder guessedLetters = new StringBuilder(); //add all letters guessed here 
		
		
		
		
		
		
		
		
		s.close();
	}

}
