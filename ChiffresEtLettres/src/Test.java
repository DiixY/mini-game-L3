import java.io.IOException;
import java.util.Scanner;

import games.WordSearchPuzzle;


public class Test {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WordSearchPuzzle wsp = new WordSearchPuzzle("Annexes/Mots_meles/Noel.txt");
		System.out.println(wsp.WordSelection());
		
	}

}
