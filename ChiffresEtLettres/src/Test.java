import java.io.IOException;
import java.util.Scanner;

import games.WordSearchPuzzle;


public class Test {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WordSearchPuzzle wsp = new WordSearchPuzzle("Annexes/Mots_meles/Noel.txt");
		wsp.WordSelection();
		System.out.println("x1:"+wsp.getXdebutMot()+" y1:"+wsp.getYdebutMot()+" |x2:"+wsp.getXfinMot()+" y2:"+wsp.getYfinMot());
		
	}

}
