package hashtables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.*;

public class Hangman2 {
    int numLetters;
    int guessesLeft;
    int letterCount;

    HashSet <String> set = new HashSet<String>();
    HashMap<String,List<String>> map = new HashMap<String,List<String>>();
    StringBuilder currentString = new StringBuilder("");
    ArrayList <Character> wrongGuesses = new ArrayList<Character>();


    Hangman2(int numLetters, int numGuesses){
        this.numLetters = numLetters;
        this.guessesLeft = numGuesses;
    }


    public void importDictionary(){
        String fileName = "words.txt";
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()){
                String word = scanner.nextLine();
                set.add(word);

            }
            scanner.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }


    public boolean isOver(){
        if(guessesLeft == 0)
            return true;
        else if(letterCount == numLetters)
            return true;
        else
            return false;
    }

    public HashMap <String,List<String>> makeFamilies(char x){
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        Iterator <String> setIterator = set.iterator();
        for(String word:set){
            //////  this figures out what word family the word would be a part of
            word = setIterator.next();
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

    public HashSet <String> chooseFamily(HashMap <String,List<String>> map, char x){

        List <String> largestFamily = new ArrayList<String>();
        String largestFamilyKey=null;
        for(String key:map.keySet()){
            int size = map.get(key).size();
            if (size > largestFamily.size()){
                largestFamily =  map.get(key);
                largestFamilyKey = key;
            }
        }

        for(int i=0; i<largestFamilyKey.length(); i++){
            if(largestFamilyKey.charAt(i) != '-'){
                break;
            }
            if(i == largestFamilyKey.length() - 1){
                guessesLeft--;
                wrongGuesses.add(x);
            }
        }

        for(int i=0; i<largestFamilyKey.length(); i++){
            if(largestFamilyKey.charAt(i)!= '-'){
                currentString.setCharAt(i, largestFamilyKey.charAt(i));
                letterCount++;
            }
        }


        HashSet <String> set = new HashSet<String>(largestFamily);
        return set;
    }

    public void printGameStatus(){
        System.out.println(currentString+" Guesses Left: "+guessesLeft+"  "+wrongGuesses);
    }


    public static void main(String args[]){

        Scanner reader = new Scanner(System.in);

        System.out.print("Number of letter:  ");
        int numLetters = reader.nextInt();
        while(numLetters > 29 || numLetters < 2){
            System.out.println("Please pick a different sized word.");
            System.out.print("Number of letter:  ");
            numLetters = reader.nextInt();
        }

        System.out.print("Number of guess:  ");
        int numGuesses = reader.nextInt();
        while(numGuesses <= 0){
            System.out.println("You need more than 0 guesses.");
            System.out.print("Number of letter:  ");
            numGuesses = reader.nextInt();
        }

        Hangman2 game = new Hangman2(numLetters,numGuesses);

        for(int i=0;i<numLetters;i++){
            game.currentString = game.currentString.append("-");
        }

        game.importDictionary();


        Iterator <String> setIterator = game.set.iterator();
        while(setIterator.hasNext()){
            String word = setIterator.next();
            if(word.length() != numLetters){
                setIterator.remove();
            }
        }




        while(!game.isOver()){
            game.printGameStatus();
            System.out.print("Next guess: ");
            char guess = reader.next().charAt(0);
            if(game.wrongGuesses.contains(guess)){
                System.out.println("You already guessed that letter");
                continue;
            }
            else{
                for(int i = 0; i < game.currentString.length();i++){
                    if(game.currentString.charAt(i) == guess){
                        System.out.println("You already guessed that letter\n");
                        break;
                    }
                }
            }
            game.map = game.makeFamilies(guess);
            game.set = game.chooseFamily(game.map,guess);
            System.out.println("");

        }

        setIterator = game.set.iterator();
        if(game.guessesLeft == 0){
            game.printGameStatus();
            System.out.println("Sorry, you lose.");
            System.out.print(setIterator.next()+ " was the correct answer.");
        }
        else{
            game.printGameStatus();
            System.out.println("Congratulations!");
        }

        reader.close();
    }
}