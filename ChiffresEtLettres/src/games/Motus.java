package games;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class Motus extends ABSWordManagement {


/*  Motus : 
- 6 essais
- Mot choisi al�atoirement (la taille du mot doit �tre donn�e au joueur)
- Proposition = Mots 
- Indication lettres pr�sentes dans le Mot
- Indication lettres pr�sentes au bon endroit */

	
	@Override
	public void BidonPower() {
		// TODO Auto-generated method stub

	}
	
	//Attributs
	private int cuTry;			//Nombre d'essais utilis�s
	private String word;		//Mot choisi par checkletter
	private String playWord;	//Mot jou�e par le joueur
	private Boolean end;		//Partie termin�e ? (True = Oui ; False = Non)
	private char[] ghostWo;	//Variable qui va se vider avec les lettres trouv�es par le joueur et se re-remplir � la fin de la boucle
	private char[] ghostCo;	//Variable qui va garder les lettres trouv�es ET au bon emplacement
	private char[] ghostEm;	//Variable qui va garder les lettres trouv�es MAIS au mauvais emplacement
	
	//Constructeurs
	public Motus (int cuTry, String word, String playWord, char[] ghostWo, char[] ghostCo, char[] ghostEm) {
		this.cuTry = cuTry;
		this.word = word;
		this.playWord = playWord;
		this.end = false;
		this.ghostWo = ghostWo;
		this.ghostCo = ghostCo;
		this.ghostEm = ghostEm;
	}
	
	public Motus () {
		this.cuTry = 0;
		this.end = false;
		
		this.word = takeWord();
		while(this.word.length() < 6 || this.word.length() > 8)
		{
			this.word = takeWord();
		}
		
		this.ghostCo = hideWord(word);
		this.ghostCo[0] = this.word.charAt(0);
		this.ghostCo[3] = this.word.charAt(3);
		
		this.ghostEm = hideWord(word);
	}
	
	//M�thodes


	public Boolean getEnd() {
		return end;
	}

	public void setEnd(Boolean end) {
		this.end = end;
	}

	public char[] hideWord(String word) {
		char[] hWord = new char[word.length()];
		for(int i=0 ; i<word.length() ; i++)
			hWord[i] = '.';
		return hWord;
	}		
	
	public char[] hideGhost(String word) {
		char[] gWord = new char[word.length()];
		for(int i = 0;i < word.length();i++) {		
			gWord[i] = word.charAt(i);
		}
		return gWord;
	}
	
	public char[] videGhost(char[] ghost) {
		for(int i=0;i<word.length(); i++) {
			ghost[i] = '.';
		}
		return ghost;
	}
	
	public boolean isWordValid(String s) {

            return s.matches("^[a-zA-Z]*$");
    }

	public String[] remplirGhost(String ghost[], String word) {
		for(int i = 0; i<word.length();i++) {
			ghost[i]=Character.toString(word.charAt(i));
		}
		return ghost;
	}
	
	//D�but programme Motus
	public void motus_game(String strplayed){

		//D�but de la boucle
		if(cuTry < 7)

			ghostWo = hideGhost(word);
			playWord = strplayed.toUpperCase();
			this.ghostEm = videGhost(ghostEm);
		
		//Mot correct ?
		if(playWord.length()==word.length()) {
			if(checkWord(word,playWord) == true) {
				//Le mot jou� est correct
				cuTry++;
				end = true;
			}
			//V�rification lettres
			else {
				cuTry++;
				//Lettre au bon endroit ?
				for(int i = 0 ; i<word.length() ; i++) {

					if(Character.compare(ghostWo[i],playWord.charAt(i)) == 0) {
						ghostCo[i] = playWord.charAt(i);
						ghostWo[i] = '0';
					}
					else if (Character.compare(ghostWo[i],playWord.charAt(i)) != 0 && checkLetter(this.word,playWord.charAt(i)))
					{
						ghostEm[i] = playWord.charAt(i);
					}
					
				}
				
				System.out.println(Arrays.toString(this.ghostEm));
				System.out.println(this.word);
			}
		}
		else {
			cuTry++;
		}

		if(checkWord(word, String.valueOf(playWord)) == true) {
			end = true;
		}		
	}

	public int getCuTry() {
		return cuTry;
	}

	public void setCuTry(int cuTry) {
		this.cuTry = cuTry;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public char[] getGhostWo() {
		return ghostWo;
	}

	public void setGhostWo(char[] ghostWo) {
		this.ghostWo = ghostWo;
	}

	public char[] getGhostCo() {
		return ghostCo;
	}

	public void setGhostCo(char[] ghostCo) {
		this.ghostCo = ghostCo;
	}

	public char[] getGhostEm() {
		return ghostEm;
	}

	public void setGhostEm(char[] ghostEm) {
		this.ghostEm = ghostEm;
	}
}

