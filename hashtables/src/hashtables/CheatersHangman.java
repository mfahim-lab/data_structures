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
     //contains all words in dict.
    List <String> allWords = new ArrayList<String>();
    
    
    //important to access in any methods
    CheatersHangman(int wordLength, int totalGuesses){
        this.wordLength = wordLength;
        this.totalGuesses = totalGuesses;
    }


	public static boolean gameisRunning(int totalGuesses) {
		//check to see if there are guesses left 
		if(totalGuesses>0){
			return true;
		}
		
		return false;
	}
	//(List<String> wordList, Set<Character> guessLetters) //rosen's parameter suggestion
	public static Map<String, List<String>> getWordFamilies(String guessedLetters, HashSet <String> wordMaster,char x){
		//given a word list, you will modify and replace it
		
		Iterator <String> wordIterator = wordMaster.iterator();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		
		
		for(String item : wordMaster) {
				
			item = wordIterator.next();
			String family = item;
			
			for(int j = 0; j < family.length(); j++){
                if(family.charAt(j) != x){
                    family = family.replace(family.charAt(j),'-');
                }
            }
			
		    if(!map.containsKey(family)){
                List <String> valueList = new ArrayList <String>();
                map.put(family,valueList); //predefined functions
                map.get(family).add(item);
            }
            else{
                map.get(family).add(item);
            }
      
		}
	
	    return map;
	}
	
	public static HashSet <String> getBestFamily(Map<String, List<String>> wordFamilies, char x) {
		
	    List <String> largestFamily = new ArrayList<String>();
        String largestFamilyKey=null;
        for(String key:wordFamilies.keySet()){
            int size = wordFamilies.get(key).size();
            if (size > largestFamily.size()){
                largestFamily =  wordFamilies.get(key);
                largestFamilyKey = key;
            }
        }

        for(int i=0; i<largestFamilyKey.length(); i++){
            if(largestFamilyKey.charAt(i) != '-'){
                break;
            }
            if(i == largestFamilyKey.length() - 1){
                //totalGuesses--;
            	
                //wrongGuesses.add(x);
            }
        }

        for(int i=0; i<largestFamilyKey.length(); i++){
            if(largestFamilyKey.charAt(i)!= '-'){
              //  currentString.setCharAt(i, largestFamilyKey.charAt(i));
                //letterCount++;
            }
        }

       
        HashSet <String> set = new HashSet<String>(largestFamily);
        return set;
		
        
        
	}
	
    private static HashSet <String> importWords(){
    	HashSet <String> wordMaster = new HashSet<String>(); //important
    	
        String fileName = "words.txt";
        try {
            Scanner s = new Scanner(new File(fileName));
            while(s.hasNextLine()){
                String word = s.nextLine();
                wordMaster.add(word); //add the entire dictionary to my wordMaster hashset
            }
            s.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        return wordMaster;
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
		HashSet <String> wordMaster = importWords(); //important
	
		String guessedLetters = new String(); //output this to console!!!!
		//split the dictionary.txt into a wordList
		//if you can read all the words and split them into dictionaries u good
		//iterate through a word and get a new string out of it 
		
		//go through word master to find something
		
	    Iterator <String> wordIterator = wordMaster.iterator();
		while (wordIterator.hasNext()){
			String nextItem = wordIterator.next();
			 if(nextItem.length() != wordLength){
	                wordIterator.remove();
			 }
		};
		
		String wrongGuesses = new String();
		String hangmanBoard = new String();
		
		for(int i = 0; i < wordLength; i++){
			hangmanBoard += '-';
		} 
		
		while(gameisRunning(game.totalGuesses)) {
			
			System.out.println(hangmanBoard + " Guesses Left: " + game.totalGuesses + "  " + wrongGuesses);
	    		char inputLetter = s.next().charAt(0);
			if(guessedLetters.indexOf(inputLetter) != -1) {
				System.out.println("You already guessed that, please enter another letter or a guess will be charged.");
				inputLetter = s.next().charAt(0);
				guessedLetters += inputLetter;
			} else {
                for(int i = 0; i < wordLength;i++){
                    if(hangmanBoard.charAt(i) == inputLetter){ //check current board
                    	System.out.println("You already guessed that, please enter another letter or a guess will be charged.");
        				inputLetter = s.next().charAt(0);
        				guessedLetters += inputLetter;
                    }
                }
                
                guessedLetters += inputLetter;
                
            }
			
			
			
			Map<String, List<String>> wordFamilies = getWordFamilies(guessedLetters, wordMaster,inputLetter);
			HashSet<String> bestFamily = getBestFamily(wordFamilies, inputLetter); 
						
			System.out.println("");
			
			
			//next update the game
			totalGuesses -= 1;
			
			
		}
			//replace the wordlist
			
			
		    wordIterator = wordMaster.iterator();
	        if(totalGuesses == 0){
	        	System.out.println(hangmanBoard + " Guesses Left: " + totalGuesses + "  " + wrongGuesses);
	            System.out.println("That is all folks. Try again next time.");
	            System.out.println(wordIterator.next() + " was the correct answer.");
	        }
	        else{
	        	System.out.println(hangmanBoard + " Guesses Left: " + totalGuesses + "  " + wrongGuesses);
	            System.out.println("Congratulations! You're one smart cookie.");
	        }

	        s.close();
	    
		
		
		
	}
			


}
