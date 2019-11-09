package hashtables;
//Mark Fahim


//inclass help Tuesday Nov. 8, 2019
import java.util.Scanner;


public class CheatersHangman {

	//thursday will have hash quizzes, watch maps and sets
	
	public static boolean gameisRunning() {
		//check to see if there are guesses left 
		return false;
	}
	
	
	public Map<String, List<String>> getWordFamilies(List<String> wordList, Set<Character> guessedLetters){
		//given a word list, you will modify and replace it
		
		return null;
		
	}
	
	public static String getBestFamily(Map<String, List<String>> wordFamilies) {
		
		return null;
	}
	
	public static void main(String[] args) {
		// Run the Game Here
		//read instructions in pdf of order to ask for length and etc... Important!!
		
		
		
		Scanner s = new Scanner(System.in); //for user's input
		String guessedLetters = new String();
		//split the dictionary.txt into a wordList
		Map<Integer, List<String>> wordList;
		//if you can read all the words and split them into dictionaries u good
		//iterate through a word and get a new string out of it 
	
		while(gameisRunning()) {
			char input = s.next().charAt(0);
			char guess = input;
			//add guess to guessed_letters here 
			Map<String, List<String>> wordFamilies = getWordFamilies(wordList, guessedLetters);
			String bestFamily = getBestFamily(); 
			//next update the game
			//replace the wordlist
			
			
		}
		
		
	}

}
