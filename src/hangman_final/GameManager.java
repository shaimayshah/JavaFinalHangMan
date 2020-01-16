package hangman_final;
import java.io.IOException;
import java.util.Scanner;
import hangman_final.SinglePlayer;
import hangman_final.TwoPlayers; 

public class GameManager {

	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hey, welcome to this game. Would you like to play by yourself (press 1)"
				+ "or with a friend (press 2)?");
		System.out.println();
		Character noOfPlayers = scanner.next().charAt(0);
		boolean playing = true;
		if(noOfPlayers == '1') {
			while (playing) {
				SinglePlayer game = new SinglePlayer();
				do {
					System.out.println(game.dyingBoi());
					System.out.println();
					System.out.println("Current guessed letters: " + game.getGuessedList());
					System.out.println();
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
						System.out.println();
						
					} else {
						System.out.println("Unfortunately, character not in word.");
						System.out.println();
					}
				} 
				while (!game.gameOver()); 
				System.out.println("Do you want to play another game?");
				Character response = scanner.next().toLowerCase().charAt(0);
				System.out.println();
				playing = (response == 'y');
			}
		}
		else if(noOfPlayers == '2') {
			while (playing) {
				TwoPlayers game = new TwoPlayers();
				//game.getWord();
				for(int i = 0; i < 400; i++) {
					System.out.println(" ");
				}
				do {
					System.out.println(game.dyingBoi());
					System.out.println();
					System.out.println("Current guessed letters: " + game.getGuessedList());
					System.out.println();
					System.out.println(game.getGuessedLetters());
					
					// Get guess 
					char guess = (scanner.next().toLowerCase().charAt(0));
					// Check if guessed before 
					while (game.isGuessed(guess)) {
						System.out.println("Try again, already guessed");
						guess = (scanner.next().toLowerCase().charAt(0));
						System.out.println();
					}
					
					// Check if char is in word
					if (game.playGuess(guess)) {
						System.out.println("Good guess. Character in word.");
						System.out.println();
						
					} else {
						System.out.println("Unfortunately, character not in word.");
						System.out.println();
					}
				} 
				while (!game.gameOver());
				System.out.println("Do you want to play another game?");
				Character response = scanner.next().toLowerCase().charAt(0);
				System.out.println();
				playing = (response == 'y');
			}
		}

	}

}
