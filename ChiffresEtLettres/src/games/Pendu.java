package games;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import Interfaces.ITFWordManagement;
/*  Pendu : 11 étapes
 1 - Sol
 2 - Poteau
 3 - Barre horizontale
 4 - Barre de soutien
 5 - Fil
 6 - Tête
 7 - Corps
 8 - Bras gauche
 9 - Bras droit
10 - Jambe gauche
11 - Jambe droite + perdu */

public class Pendu implements ITFWordManagement { 
	
	//Attributs
	private int cuTry;			//Nombre d'essais utilisés
	private String word;		//Mot choisi par checkletter
	private char playCara;		//Lettre jouée par le joueur
	private Boolean end;		//Partie terminée ? (True = Oui ; False = Non)
	private char[] progW;		//Progression du joueur (lettres trouvées etc)
	
	//Constructeurs
	public Pendu (int cuTry, int score, String word, char playCara, Boolean end, char[] progW) {
		this.cuTry = cuTry;
		this.word = word;
		this.playCara = playCara;
		this.end = false;
		this.progW = progW;
	}
	
	public Pendu () {
		this.cuTry = 11;
		this.word = takeWord();
		this.playCara = ' ';
		this.end = false;
		this.progW = hideWord(this.word);
	}
	
	//Méthodes

	public String takeWord() {
		Random r = new Random();
		int valeurMin = 1;//premiere ligne du fichier
		int valeurMax = 27236;//derniere ligne +1 du fichier
		int ligne= valeurMin + r.nextInt(valeurMax - valeurMin);//nombre aleatoire entre [1;27236[
		int compt=0;
		String word="";
		
		File f = new File("Annexes","Dictionary.txt");
		if(f.exists()) {
			try{
				InputStream flux=new FileInputStream(f); 
				InputStreamReader lecture=new InputStreamReader(flux);
				BufferedReader buff=new BufferedReader(lecture);
				while (compt<(ligne-1)){
					compt++;
					buff.readLine();
				}
				word = buff.readLine();
				buff.close(); 
				}		
				catch (Exception e){
				System.out.println(e.toString());
				}

		} 
		else{
			System.out.println("Fichier introuvable");
		}

		 return word;
	}

	public char[] hideWord(String word) {
		char[] hWord = new char[word.length()];
		return hWord;
	}
		
	public boolean checkWord(String WordInDictionnary, String WordToTest) {
		if(WordInDictionnary.equals(WordToTest)) 
			return true; 
		else 
			return false;
	}
	
	public boolean checkLetter(String word, char LetterToTest) {
		if( (word.indexOf(LetterToTest)) >= 0)
			return true;
		else
			return false;			
	}
	
	public void aff(char[] progW) {
		for (int i = 0;i<progW.length;i++) {
			if (progW[i] == ' ')
				System.out.print("_");
			else
				System.out.print(progW[i]);
		}
		System.out.println("");
	}
	
	public boolean pendu_game(char c)
	{
			
		if (checkLetter(word,c) == true) 
		{ //La lettre est dans le mot
			
			for(int i = 0;i<word.length();i++) 
			{
				if(this.word.charAt(i) == c) 
				{
					this.progW[i] = c;
				}
				else if(this.word.charAt(i) != progW[i]) progW[i] = '_';
			}
			
			end = checkWord(word,String.valueOf(progW));
				
			return true;
		}
		else 
		{	//La lettre n'est pas dans le mot
			cuTry = cuTry-1;
			if(cuTry==0) end=false;
			return false;
		}
	}



	/**
	 * @return the cuTry
	 */
	public int getCuTry() {
		return cuTry;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param cuTry the cuTry to set
	 */
	public void setCuTry(int cuTry) {
		this.cuTry = cuTry;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the end
	 */
	public Boolean getEnd() {
		return end;
	}

	/**
	 * @return the playCara
	 */
	public char getPlayCara() {
		return playCara;
	}

	/**
	 * @return the progW
	 */
	public char[] getProgW() {
		return progW;
	}
	
}
