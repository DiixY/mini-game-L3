package games;

import java.util.concurrent.ThreadLocalRandom;

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

public class Pendu extends ABSWordManagement { 
	
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
		
		this.word = takeWord();
		this.cuTry = ThreadLocalRandom.current().nextInt(this.word.length()/2, this.word.length() + 1);
		this.playCara = ' ';
		this.end = false;
		this.progW = hideWord(this.word);
	}
	
	//Méthodes

	

	public char[] hideWord(String word) {
		char[] hWord = new char[word.length()];
		for(int i=0;i<word.length();i++)
		{
			hWord[i]='_';
		}
		return hWord;
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
	
	public void pendu_game(char c)
	{
			
		if (checkLetter(word,c)) 
		{ //La lettre est dans le mot
			
			for(int i = 0;i<word.length();i++) 
			{
				if(this.word.charAt(i) == c) 
				{
					this.progW[i] = c;
				}
				else if(this.word.charAt(i) != progW[i]) progW[i] = '_';
			}
		}
		else 
		{	//La lettre n'est pas dans le mot
			cuTry = cuTry-1;
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

	@Override
	public void BidonPower() {
		// TODO Auto-generated method stub
		
	}

	
	
}
