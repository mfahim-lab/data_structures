package hashtables;
//Mark Fahim

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class CheatersHangman {

	//initialize globally 
    int wordLength;
    int totalGuesses;
    int letterCount;
    HashSet <String> wordMaster = new HashSet<String>(); //contains all words in dict.
    List <String> allWords = new ArrayList<String>();
    
    
    //important to access in any methods
    CheatersHangman(int wordLength, int totalGuesses){
        this.wordLength = wordLength;
        this.totalGuesses = totalGuesses;
    }

	
	
	
	
	public static boolean gameisRunning() {
		//check to see if there are guesses left 
		
		
		
		return false;
	}
	//(List<String> wordList, Set<Character> guessLetters) //rosens paramater suggestion
	public Map<String, List<String>> getWordFamilies(String guessedLetters){
		//given a word list, you will modify and replace it
		int numOfGuessesInString = guessedLetters.length();
		for(int i = 0; i < numOfGuessesInString; i++) {
			char currentChar = guessedLetters.charAt(i);
		} //might have to merge but later 
		
		for(String item : wordMaster) {
				
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		return null;
		
	}
	
	public static String getBestFamily(Map<String, List<String>> wordFamilies) {
		
		return null;
	}
	
    private void importWords(){
    	
        String fileName = "words.txt";
        try {
            Scanner s = new Scanner(new File(fileName));
            while(s.hasNextLine()){
                String word = s.nextLine();
                List<String> wordMaster = new List<String>();
                
                wordMaster.add(word); //add the entire dictionary to my wordMaster hashset
            }
            s.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }

	
	public static void main(String[] args) {
		// Run the Game Here
		//read instructions in pdf of order to ask for length and etc... Important!!
	
		Scanner s = new Scanner(System.in); //main input scanner
		
		
		// Game starts HERE
		System.out.println("Welcome to Hangman, please choose the length of the word.");
		int wordLength = s.nextInt();
		while(wordLength <= 1 || wordLength >= 30) {
			System.out.println("Please choose a valid word length.");
			 wordLength = s.nextInt();
		}
		
		System.out.println("Please choose the number of wrong guesses until the game is over.");
		int totalGuesses = s.nextInt();
		
		//initialize a new object (game) and initialize the wordMaster
		CheatersHangman game = new CheatersHangman(wordLength, totalGuesses); 
		game.importWords();
		
		
		
	
		String guessedLetters = new String(); //output this to console!!!!
		//split the dictionary.txt into a wordList
		Map<Integer, List<String>> wordList;
		//if you can read all the words and split them into dictionaries u good
		//iterate through a word and get a new string out of it 
		
		//go through word master to find something
		
	    Iterator <String> wordIterator = game.wordMaster.iterator();
		for(String nextItem : game.wordMaster){
			 if(nextItem.length() != wordLength){
	                wordIterator.remove();
			 }
		};
		

	
		while(gameisRunning()) {
			char inputLetter = s.next().charAt(0);
			if(guessedLetters.indexOf(inputLetter) == -1) {
				System.out.println("You already guessed that, please enter another letter or a guess will be charged.");
				inputLetter = s.next().charAt(0);
				guessedLetters += inputLetter;
			} else {
				guessedLetters += inputLetter;;
			}
			
			Map<String, List<String>> wordFamilies = getWordFamilies(guessedLetters);
			String bestFamily = getBestFamily(); 
			//next update the game
			//replace the wordlist
			
			
		}
		
		
	}

}
