package hangman_final;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SinglePlayer extends GameMgr{
	
	public SinglePlayer() throws IOException {
		super();
	}
	
	public String getWord() {
		/*
		 * This method randomly picks out a word from the dictionary. 
		 *  */
		Random rand = new Random();
		int randword = Math.abs(rand.nextInt()) % dict.size();
		return dict.get(randword);
	}

	public void initDict() throws IOException {
		try {
			File dictionary = new File("dictionary.txt");
			fileReader = new FileReader(dictionary);
			bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while(line != null) {
				dict.add(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			fileReader.close();
			
		} catch(IOException e) {
			System.out.println("Couldn't get initialization done.");
		}
		
	}

}
