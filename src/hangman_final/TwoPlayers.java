package hangman_final;

import java.io.IOException;
import java.util.Scanner;

public class TwoPlayers extends GameMgr {
	public static int noPlayers = 2;

	public TwoPlayers() throws IOException {
		super();
	}

	@Override
	public void initDict() throws IOException {
	}

	@Override
	public String getWord() {
		System.out.println("Please enter a word for your friend to guess.");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}

}
