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
	private String[] progW;		//Progression du joueur (lettres trouvées etc)
	
	//Constructeurs
	public Pendu (int cuTry, int score, String word, char playCara, Boolean end, String[] progW) {
		this.cuTry = cuTry;
		this.word = word;
		this.playCara = playCara;
		this.end = false;
		this.progW = progW;
	}
	
	public Pendu () {
		this.cuTry = 0;
		this.word = word;
		this.playCara = playCara;
		this.end = false;
		this.progW = progW;
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

	public String[] hideWord(String word) {
		String[] hWord = new String[word.length()];
		return hWord;
	}
		
	public boolean checkWord(String WordInDictionnary, String WordToTest) {
		if(WordInDictionnary == WordToTest) 
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
	
	public void aff(String[] progW) {
		for (int i = 1;i<progW.length;i++) {
			if (progW[i] == null)
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
		while(end == false && cuTry < 11) {
			System.out.println("Essai numéro : " +(cuTry+1));
			carac = sc.nextLine();
			playCara = carac.charAt(0);
			System.out.println(playCara);
			
			if (checkLetter(word,playCara) == true) { //La lettre est dans le mot
					System.out.println("Test1");
					for(int i = 0;i<word.length();i++) {
						if(word.charAt(i) == playCara) {
							progW[i] = Character.toString(playCara);
						}
					}
				}
				else {	//La lettre n'est pas dans le mot
					System.out.println("Test2");
					cuTry++;
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
}
