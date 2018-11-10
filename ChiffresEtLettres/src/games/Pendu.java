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
		this.word = "";
		this.playCara = ' ';
		this.end = false;
		this.progW = new char[0];
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
	
	public Pendu pendu_game(){
		Pendu p1 = new Pendu();
		word = takeWord();	
		progW = hideWord(word);
		Scanner sc = new Scanner(System.in);
		
		String carac;
		System.out.println("Début de la partie : mot de "+word.length()+" caractères.");
		while(!end && cuTry >= 1) {
			System.out.println("Nombre d'essai restant : " +cuTry);
			carac = sc.nextLine();
			playCara = Character.toUpperCase(carac.charAt(0));
			System.out.println(word);
			System.out.println(playCara);
			
			if (checkLetter(word,playCara) == true) { //La lettre est dans le mot
					System.out.println("Test1");
					for(int i = 0;i<word.length();i++) {
						if(word.charAt(i) == playCara) {
							progW[i] = playCara;
						}
					}
				}
				else {	//La lettre n'est pas dans le mot
					System.out.println("Test2");
					cuTry--;
				}
			aff(progW);
			if(checkWord(word, String.valueOf(progW)) == true) {
				end = true;
				System.out.println("Vous avez gagné !");
			}
				
		}
		sc.close();
		System.out.println("Fin de la partie !");
		
		return p1;
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
	
}
