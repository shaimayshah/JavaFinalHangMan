package hangman_final;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class GameMgr {
	// Defining a few variables and constants. 
	public int maxTries = 6; 
	String word; 
	public StringBuilder guessedLetters; 
	public ArrayList<Character> guessedList = new ArrayList<>();
	public int currentTry = 0;
	ArrayList<String> dict = new ArrayList<>(); 
	public static FileReader fileReader;
	public static BufferedReader bufferedReader;
	
	
	public GameMgr() throws IOException {
		// A few variables 
		// This variable stores the word to be guessed. 
		initDict();
		word = getWord();
		guessedLetters = initCurrentGuess();
		
	}
	
	public abstract void initDict() throws IOException;

	//public abstract void initDict() throws IOException;
	// For single player game, this would get a word from the dictionary. For a 
	// dual player game, it would get a word from the other player. 
	public abstract String getWord();
	
	public StringBuilder initCurrentGuess() {
		StringBuilder initGuess = new StringBuilder();
		for (int i = 0; i < word.length() * 2; i++) 
		{
			if(i % 2 == 0)
			{
				initGuess.append("_");
			}
			else {
				initGuess.append(" ");
			}
		}
		return initGuess;
	}
	
	// Outputs the number of incorrect guesses. 
	
	public String dyingBoi() {
		switch(currentTry) {
		case 0: return "Zero wrong";
		case 1: return "One wrong";
		case 2: return "Two wrong";
		case 3: return "Three wrong";
		case 4: return "Four wrong";
		case 5: return "Five wrong";
		case 6: return "Six wrong"; 
		default: return "Six wrong, game over.";
		}
	}
	
	// Gets the guessed letters. 
	public String getGuessedLetters() {
		return guessedLetters.toString();
	}
	
	// Checks to see if the letter is in the word.
	public boolean playGuess(char guess) {
		boolean inWord = false;
		guessedList.add(guess);
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess) {
				guessedLetters.setCharAt(i * 2, guess);
				inWord = true; 
			}
		}
		if(!inWord) {
			currentTry++;
		}
		return inWord; 
	}
	
	// Checks to see if game is over. 
	public boolean gameOver() {
		if (gameWon()) {
			System.out.println(" ");
			System.out.println("Congratulations, you have won!");
			return true; 
		}
		else if(gameLost()) {
			System.out.println("Sorry, you have lost. You have used up your 6 tries.");
			System.out.println("The word was " + word);
			return true; 
		}
		return false;
	}

	// Checks to see if game has been lost by the guesser. 
	private boolean gameLost() {
		return currentTry > maxTries; 
	}

	// Checks to see if game has been won by the guesser. 
	private boolean gameWon() {
		String finalguess = getCurrentGuessWithoutSpaces();
		return finalguess.equals(word);
	}

	
	// Gets the current guessed letters. 
	private String getCurrentGuessWithoutSpaces() {
		String guess = getGuessedLetters();
		return guess.replace(" ", "");
	}
	
	
	// Checks if the character has been guessed before. 
	public boolean isGuessed(char guess) {
		return guessedList.contains(guess);
	}
	
	
}
