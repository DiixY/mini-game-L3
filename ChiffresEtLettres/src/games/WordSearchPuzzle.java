package games;
import java.util.NavigableSet;

import Interfaces.ITFWordManagement;

public class WordSearchPuzzle implements ITFWordManagement {
	//attributs:
	NavigableSet<String> mots;
	int choixGrille;
	//constructeurs:
	//methodes:
	
	//methodes de l'intterface
	@Override
	public String takeWord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkWord(String WordInDictionnary, String WordToTest) {
		// TODO Auto-generated method stub
		if(WordInDictionnary == WordToTest) 
			return true;
		else 
			return false;
	}

	@Override
	public boolean checkLetter(String word, char LetterToTest) {
		// TODO Auto-generated method stub
		if( (word.indexOf(LetterToTest)) >= 0)
			return true;
		else
			return false;
	}
	
	

}
