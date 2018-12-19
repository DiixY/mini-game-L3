package games;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public abstract class ABSWordManagement {
	public abstract void BidonPower();//methode abstraite qui sert uniquement a pouvoir faire la classe abstraite
	
	public String takeWord(int ligne) throws FileNotFoundException {
		int compt=0;
		String word="";


		try{

			File f = new File("Annexes/Dictionary.txt");
			FileReader lecture = new FileReader(f);
			
			/*Ligne pour lire des fichiers dans un .jar*/
			/*InputStream flux= getClass().getResourceAsStream("/Annexes/Dictionary.txt");
			InputStreamReader lecture=new InputStreamReader(flux);*/
			
			BufferedReader buff=new BufferedReader(lecture);
			while (compt<(ligne-1)){
				compt++;
				buff.readLine();
			}
			word = buff.readLine();
			buff.close(); 
			//flux.close();
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}



		return word;
	}
	
	public String takeWord() {
		Random r = new Random();
		int valeurMin = 1;//premiere ligne du fichier
		int valeurMax = 369086;//derniere ligne +1 du fichier
		int ligne= valeurMin + r.nextInt(valeurMax - valeurMin);//nombre aleatoire entre [1;27236[
		int compt=0;
		String word="";
		
		

		try{
			File f = new File("Annexes/Dictionary.txt");
			FileReader lecture = new FileReader(f);
			
			/*Ligne pour lire des fichiers dans un .jar*/
			/*InputStream flux= getClass().getResourceAsStream("/Annexes/Dictionary.txt");
			InputStreamReader lecture=new InputStreamReader(flux);*/
			
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

		 
		

		 return word;
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
	
	
}
