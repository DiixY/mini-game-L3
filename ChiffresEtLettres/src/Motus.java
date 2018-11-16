import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import Interfaces.ITFWordManagement;

/*  Motus : 
- 6 essais
- Mot choisi al�atoirement (la taille du mot doit �tre donn�e au joueur)
- Proposition = Mots 
- Indication lettres pr�sentes dans le Mot
- Indication lettres pr�sentes au bon endroit */

public class Motus implements ITFWordManagement { 
	
	//Attributs
	private int cuTry;			//Nombre d'essais utilis�s
	private String word;		//Mot choisi par checkletter
	private String playWord;	//Mot jou�e par le joueur
	private Boolean end;		//Partie termin�e ? (True = Oui ; False = Non)
	private String[] progW;		//Progression du joueur (lettres trouv�es etc)
	private String[] ghostCo;	//Variable qui va garder les lettres trouv�es ET au bon emplacement
	private String[] ghostEm;	//Variable qui va garder les lettres trouv�es MAIS au mauvais emplacement
	
	//Constructeurs
	public Motus (int cuTry, int score, String word, String playWord, Boolean end, String[] progW, String[] ghostCo, String[] ghostEm) {
		this.cuTry = cuTry;
		this.word = word;
		this.playWord = playWord;
		this.end = false;
		this.progW = progW;
		this.ghostCo = ghostCo;
		this.ghostEm = ghostEm;
	}
	
	public Motus () {
		this.cuTry = 0;
		this.word = word;
		this.playWord = playWord;
		this.end = false;
		this.progW = progW;
		this.ghostCo = ghostCo;
		this.ghostEm = ghostEm;
	}
	
	//M�thodes

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
		for (int i = 0;i<progW.length;i++) {
			if (progW[i] == null)
				System.out.print("_ ");
			else
				System.out.print(progW[i]);
		}
		System.out.println("");
	}
	
	public String[] hideGhost(String word) {
		String[] gWord = new String[word.length()];
		for(int i = 0;i>word.length();i++) {		
			gWord[i] = Character.toString(word.charAt(i));
		}
		return gWord;
	}
	
	public String[] videGhost(String word, String[] ghost) {
		for(int i=0;i<word.length(); i++) {
			ghost[i] = null;
		}
		return ghost;
	}
	
	public Motus motus_game(){
		Motus p1 = new Motus();
		//word = takeWord();	
		word = "test";
		//progW = hideWord(word);
		ghostCo = hideWord(word);
		ghostEm = hideWord(word);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("D�but de la partie : mot de "+word.length()+" caract�res.");
		while(end == false && cuTry < 6) {
			System.out.println("Essai num�ro : " +(cuTry+1));
			playWord = sc.nextLine();
			
			if(checkWord(word,playWord) == true) { //Le mot jou� est correct
				end = true;
			}
			else {
				cuTry++;
				for(int i = 0;i<word.length();i++) {
					if(word.charAt(i) == playWord.charAt(i)) {
						ghostCo[i] = Character.toString(playWord.charAt(i));
					}
					else {
						if(checkLetter(word,playWord.charAt(i)) == true) {
							for(int j=0;j<word.length();j++) {
								if(word.charAt(j)==playWord.charAt(j)) {
									ghostEm[i] = Character.toString(playWord.charAt(i));
								}
							}
						}
					}
				}
			}
			System.out.println("Lettres correctes :");
			aff(ghostCo);
			
			System.out.println("Lettres au mauvais endroit :");
			aff(ghostEm);
			
			System.out.println("");
			
			
			ghostCo = videGhost(word,ghostCo);
			ghostEm = videGhost(word,ghostEm);

		
			if(checkWord(word, String.valueOf(playWord)) == true) {
				end = true;
				System.out.println("Vous avez gagn� !");
			}
				
		}
		sc.close();
		System.out.println("Fin de la partie !");
		
		return p1;
	}
}

