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
	String hangmanboard = new String("");
	List<String> allWords = new ArrayList<String>();
	HashSet<String> wordMaster = new HashSet<String>();
	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	StringBuilder currentString = new StringBuilder("");
	ArrayList<Character> wrongGuesses = new ArrayList<Character>();
	String guessedLetters = new String(""); //add all letters guessed here 
	
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

	private boolean gameIsRunning() {
		
		if(this.totalGuesses > 0) {
			return true;
		}
		
		return false;
		
	}
	
	public Map<String, List<String>> getWordFamilies(char x){
		//given a word list, you will modify and replace it
		
		 Iterator <String> wordIterator = wordMaster.iterator();
		 HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		 
		for(int i = 0; i < hangmanboard.length(); i++) {
		if(hangmanboard.charAt(i) != '-') {
			//something else is here make new word families with both cases 
	
			
			
			
			
			
		} //end if 
	}//end for
		
		 for(String word: wordMaster){ //for every word of same length in the list
	            //////  this figures out what word family the word would be a part of
	            word = wordIterator.next();
	            String family = word;
	            
	            for(int i = 0;i<family.length();i++){
	                if(family.charAt(i) != x){
	                    family = family.replace(family.charAt(i),'-');
	                }
	            }
	            //////

	            if(!map.containsKey(family)){
	                List <String> list = new ArrayList <String>();
	                map.put(family,list);
	                map.get(family).add(word);
	            }
	            else{
	                map.get(family).add(word);
	            }
	        }
		
		
		
		
		return map;
	}
	
	public void getBestFamily(Map<String, List<String>> wordFamilies, char x) {
		
	   
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in); 

		// Game starts HERE
		System.out.println("Welcome to Hangman, please choose the length of the word.");
		int wordLength = s.nextInt();
		while (wordLength <= 1 || wordLength >= 30) {
			System.out.println("Please choose another length, words can be from two letters to twenty-nine.");
			wordLength = s.nextInt();
		}

		System.out.println("Please choose the number of wrong guesses until the game is over. (Set Difficulty)");
		int totalGuesses = s.nextInt();

		Hangman newGame = new Hangman(wordLength, totalGuesses); 
		newGame.importWords(); //initiate wordMaster
		
		 Iterator <String> wordIterator = newGame.wordMaster.iterator();
			while (wordIterator.hasNext()){
				String nextItem = wordIterator.next();
				 if(nextItem.length() != wordLength){ //first step is to filter all words not right length
		                wordIterator.remove();
				 }
			};
			
			//print out the blank hang-man board
			for(int i = 0; i < wordLength; i++){
				newGame.hangmanboard += '-';   
			} 
			
			//start the run-game loop
			while(newGame.gameIsRunning() && newGame.hangmanboard.contains("-")) {
					newGame.totalGuesses--;
				System.out.println(newGame.hangmanboard + " Guesses Left: " + newGame.totalGuesses + "  " + newGame.guessedLetters);
				System.out.println(newGame.wordMaster.size());
				
		    		char inputLetter = s.next().charAt(0);		    		
				if(newGame.guessedLetters.indexOf(inputLetter) != -1) {
					System.out.println("You already guessed that, please enter another letter or a guess will be charged.");
					inputLetter = s.next().charAt(0);
					newGame.guessedLetters += inputLetter;
				} else {
	                for(int i = 0; i < wordLength;i++){
	                    if(newGame.hangmanboard.charAt(i) == inputLetter){ //check current board
	                    	System.out.println("You already guessed that, please enter another letter or a guess will be charged.");
	        				inputLetter = s.next().charAt(0);
	        				newGame.guessedLetters += inputLetter;
	                    }
	                }
	                
	                newGame.guessedLetters += inputLetter;
	                
	            }
				
				
				
				Map<String, List<String>> wordFamilies = newGame.getWordFamilies(inputLetter);
				newGame.getBestFamily(wordFamilies, inputLetter); 
							
				System.out.println("");
					
				//next update the game
			
				
			}
				//replace the word list
				
				
			    wordIterator = newGame.wordMaster.iterator();
		        if(newGame.totalGuesses == 0){
		        	System.out.println(newGame.hangmanboard + " Guesses Left: " + newGame.totalGuesses + "  " + newGame.guessedLetters);
		            System.out.println("That is all folks. Try again next time.");
		            System.out.println(wordIterator.next() + " was the correct answer.");
		        }
		        else{
		        	System.out.println(newGame.hangmanboard + " Guesses Left: " + newGame.totalGuesses + "  " + newGame.guessedLetters);
		            System.out.println("Congratulations! You're one smart cookie.");
		        }
		
		
		
		s.close();
	}

}
