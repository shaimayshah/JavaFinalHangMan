package hangman_final;

import java.io.IOException;
import java.util.Scanner;

import hangman_final.SinglePlayer;

public class hangman_final {
	public static void main(String args[]) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Start?");
		boolean playing = true; 
		while (playing) {
			SinglePlayer game = new SinglePlayer();
			do {
				System.out.println(game.dyingBoi());
				System.out.println(game.getGuessedLetters());
				
				// Get guess 
				char guess = (scanner.next().toLowerCase().charAt(0));
				// Check if guessed before 
				while (game.isGuessed(guess)) {
					System.out.println("Try again, already guessed");
					guess = (scanner.next().toLowerCase().charAt(0));
				}
				
				// Check if char is in word
				if (game.playGuess(guess)) {
					System.out.println("Good guess. Character in word.");
					
				} else {
					System.out.println("Unfortunately, character not in word.");
				}
			} 
			while (!game.gameOver()); 
			System.out.println("Do you want to play another game?");
			Character response = scanner.next().toLowerCase().charAt(0);
			playing = (response == 'y');
		}
	}
}
