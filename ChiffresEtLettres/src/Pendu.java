import Interfaces.ITFWordManagement;
import java.util.Scanner;

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

	@Override
	public String takeWord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkWord(String WordInDictionnary, String WordToTest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkLetter(String word, String LetterToTest) {
		// TODO Auto-generated method stub
		return false;
	}
	
/*
	//Attributs
	private int nbTry;			//Nombre d'essais total
	private int cuTry;			//Nombre d'essais utilisés
	private String word;		//Mot choisi par checkletter
	private String playWorC;	//Mot ou Lettre jouée par le joueur
	private Boolean end;		//Partie terminée ? (True = Oui ; False = Non)
	private char[] progW;		//Progression du joueur (lettres trouvées etc)

	//Constructeurs
	public Pendu (int nbTry, int cuTry, int score, String word, String playWorC, Boolean end, char[] progW) {
		this.nbTry = nbTry;
		this.cuTry = cuTry;
		this.word = word;
		this.playWorC = playWorC;
		this.end = false;
		this.progW = progW;
	}

	public Pendu (String word) {
		this.nbTry = 11;
		this.cuTry = 0;
		this.word = word;
		this.playWorC = playWorC;
		this.end = false;
		this.progW = progW;
	}

	//Méthodes

	/*
	public String wordPendu() {
		//word = takeWord();	//Provient de WordManagement
		word = "DavidLafargePokemon"; //test
	}
	

	public char[] hideWord(String word) {
		char[] hWord = new char[word.length()];
		return hWord;
	}

	public Boolean verifMot(char[] progW, String word) {
		String tmp = new String(progW);
		if (checkWord(word,tmp)==true)
			return true;
		else
			return false;
	}

	public char[] majMot(char[] progW, String word, String playWorC) {
		String[] word2 = new String[];
		for (int i = 0; i>word.length(); i++) {
			if(word[i]==playWorC) {

			}
		}
	}

	public int pendu_game(){
		//word = takeWord();	//Provient de WordManagement
		word = "DavidLafargePokemon"; //test
		Scanner sc = new Scanner(System.in);
		progW = hideWord(word);


		while(end == false || cuTry != nbTry) {
			playWorC = sc.nextLine();

			if (playWorC.length()==1) {

				if (checkLetter(word,playWorC)==true) {
					//Afficher toutes les occurences de la lettre correcte dans le mot
					majMot(progW, word, playWorC); 	//Mise à jour de progW si une lettre a été trouvée
				}
				else {
					//cuTry++
				}

			}
			else {
				if (checkWord(word,playWorC)==true) {
					//Afficher le mot + fin de la partie
				}
				else {
					//cuTry++
				}
			}

			end = verifMot(progW, word); //Vérification entre progW et word

		}



		}*/

}
