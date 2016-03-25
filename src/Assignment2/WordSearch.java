package Assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WordSearch {

	public String[][] array;
	public String[] letters = {"S","Y","E","I","H","B","V","R","F","G","C","M","N","W","Z","A","U","T","D","K","X","L","J","O","Q","P"};
	public String[] wordsArray = {"WORDSEARCH", "HORIZONTAL", "WIKIPEDIA", "SLEUTH", "BACKWARD", "VERTICAL", "DIAGONAL", "RANDOM", "FIND", "WEEK"};
	public ArrayList<String> usedWords = new ArrayList<String>();
	private ArrayList<String> words = new ArrayList<String>(Arrays.asList(wordsArray));
	int num = 0;
	int sizeX , sizeY;
	
	Random rand = new Random();
	
	
	public WordSearch(){
		
		array = new String[10][10];
		
		for(int i = 0; i < array.length; i++){
			for(int k = 0; k < array[i].length; k++){
				array[i][k] = "-";
			}
		}
		
		/*
		  
		 //* code to actually make a wordSearch when the WordSearch class is Initialized 
		 //* Randomly picks a coordinate in array, and randomly picks from addWordH, addWordV, and addWordD to make the wordsearch
		
				while(words.size() > 0){
					//System.out.println(words.size());
					
					int count = 0;
					int randN = rand.nextInt(3);
					//System.out.println(count);
					int i = rand.nextInt(10);
					int k = rand.nextInt(10);
					
					if(randN == 0){
						if(addWordH(i, k, words.get(count))){
							words.remove(count);
							
						}
					}else if(randN == 1){
						if(addWordV(i,k, words.get(count))){
							words.remove(count);
							
						}
					}else if(randN == 2){
						if(addWordD(i, k, words.get(count))){
		 					words.remove(count);
							
						}
					
					}
				
				}
		
	
		
		
		//fillIn();
		*/
	}
	
	public WordSearch(int rows, int cols){
		sizeY = rows;
		sizeX = cols;
		array = new String[rows][cols];
		
		
		for(int i = 0; i < array.length; i++){
			for(int k = 0; k < array[i].length; k++){
				array[i][k] = "-";
			}
		}
		
		/*
		 //* code to actually make a wordSearch when the WordSearch class is Initialized 
		 //* Randomly picks a coordinate in array, and randomly picks from addWordH, addWordV, and addWordD to make the wordsearch
		 
		while(words.size() > 0){
			
			
			int count = 0;
			int randN = rand.nextInt(3);
			
			int i = rand.nextInt(sizeY);
			int k = rand.nextInt(sizeX);
			
			if(randN == 0){
				if(addWordH(i, k, words.get(count))){
					
					words.remove(count);
					//count--;
				}
			}else if(randN == 1){
				if(addWordV(i,k, words.get(count))){
					
					words.remove(count);
					//count--;
				}
			}else if(randN == 2){
				if(addWordD(i, k, words.get(count))){
					
					words.remove(count);
					//count--;
				}
			
			}
		
		}
		
		
		
		fillIn();
		 
		 */
	}
	
	
	//****************Methods*****************
	
	public boolean addWordH(int row, int col, String word){//Method to add words horizontally into array
		if(!word.matches("[A-Z]*")){//if all character in "word" are uppercase Alphabetic
			return false;
		}	
		if(usedWords.contains(word)){//if arraylist of usedwords contains the incoming word, if it does return false
			return false;
		}

		for(int i = 0; i < word.length(); i++){//Iterates over all characters in the "word"
			if(row < 0 || row > array.length || col < 0 || col > array[row].length ){//checks if row and col are outside the array, if they are, return false
				return false;
			}
			if(col + i > array[row].length-1){//checks if the next col is inside the array, if it isn't, return false
				return false;
			}
			if(array[row][col + i] != "-"){//checks if the next col has been occupied by anything out than "-", if so, return false
				return false;
			}
					
		}
		//if the method hasn't returned false at this point, the word can fit inside the wordsearch
				
		for(int i = 1; i <= word.length(); i++){//Iterates over all characters in word and puts them into the array
			array[row][col + i -1] = word.substring(i-1, i);
		}	
		
		usedWords.add(word);
		
		return true;// and return true to say that it has fit into the array
		
			
			
	}
	
	public boolean addWordV(int row, int col, String word){
		if(!word.matches("[A-Z]*")){//if word has a character other than uppercase letter, returns false
			return false;
		}
			
		if(usedWords.contains(word)){//checks if "word" has been used yet, if yes, return false
			return false;
		}
				
		for(int i = 0; i < word.length(); i++){//iterates over all characters in word
			if(row < 0 || row > array.length || col < 0 || col > array[row].length ){//if row and cols are in the array, if not, return false
				return false;
			}
			if(row + i > array.length-1){//if the next row is outside the array, if yes, return false
				return false;
			}
			if(array[row + i][col] != "-"){//checks if the next row is occupied by anything other than "-", if yes, return false
				return false;
			}
		}
		//if the method hasn't returned false at this point, the word can fit inside the wordsearch		
		
		for(int i = 1; i <= word.length(); i++){//adds the word to the array
			array[row + i -1][col] = word.substring(i-1, i);
		}
		
		usedWords.add(word);//add word to usedWords
			
		return true;
		
			
		
	}
	
	public boolean addWordD(int row, int col, String word){
		if(!word.matches("[A-Z]*")){//if word contain anything other than uppercase alphabetic letters
			return false;
		}	
		
		if(usedWords.contains(word)){//if word has already been used
			return false;
		}
		
		for(int i = 0; i < word.length(); i++){//iterates over all characters in word
			if(row < 0 || row > array.length || col < 0 || col > array[row].length ){//if col and row are outside the array
				return false;
			}
			if(row + i > array.length-1 || col + i > array[row].length-1){//if the next row and col are outside the array
				return false;
			}
			if(array[row + i][col + i] != "-"){//if the next row and col are already used
				return false;
			}
			
		}
			//word can be used 
		for(int i = 1; i <= word.length(); i++){//puts word into array
			array[row + i -1][col + i - 1] = word.substring(i-1, i);
		}
			
		usedWords.add(word);//add word to usedword list
			
		return true;
		
		
	}
	
	public void fillIn(){//method to fill in rest of spots
		for(int i = 0; i < array.length; i++){
			for(int k = 0; k < array[i].length; k++){
				if(array[i][k] == "-"){//if location (i, k) has a "-", (not being used)
					array[i][k] = letters[rand.nextInt(letters.length)];//replace  "-" with a random character from letters array
				}
			}
		}
	}
	
	
	//************Methods for testing***************** 
	public String gridToString(){
		String gridStr = "";
		
		for(int i = 0; i < array.length; i++){
			for(int k = 0; k < array[i].length; k++){
				if(k == array[i].length - 1){
					gridStr += (array[i][k] + "\n");
				}
				else{
					gridStr += (array[i][k] + " ");
				}
			}
		}
		
		return gridStr;		
	}
	
	//return String of words
	public String wordsToString(){
		String wordStr = "";
		
		for(String str : usedWords){
			wordStr += str + "\n";
		}
		
		return wordStr;
	}
}
