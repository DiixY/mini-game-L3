package games;

import java.io.IOException;
import java.util.Scanner;


//on considere que la 1ere case du tableau est 1-1
public final class WordSearchPuzzle extends ABSWordManagement {
	//attributs:
	private int xdebutMot ;//coordonnees x de la 1ere lettre du mot choisit
	private int ydebutMot;//coordonnees y de la 1ere lettre du mot choisit
	private int xfinMot ;//coordonnees x de la derniere lettre du mot choisit
	private int yfinMot ;//coordonnees y de la derniere lettre du mot choisit
	private GrilleMelee grille;
	private String fpath;//chemin du fichier choisit
	private String word;
	
	//constructeurs:
    public WordSearchPuzzle(String fpath) throws IOException {
		// TODO Auto-generated constructor stub
    	this.fpath = fpath;
    	
    	if (this.fpath.equals("Annexes/Mots_meles/Fruits.txt")) {
    		this.grille = new GrilleMelee(this.fpath,11,10);
    	}
    		
    	else if(this.fpath.equals("Annexes/Mots_meles/Legumes.txt")) {
    		this.grille = new GrilleMelee(this.fpath,14,13);
    	}
    		
    	else if(this.fpath.equals("Annexes/Mots_meles/Noel.txt") ) {
    		this.grille = new GrilleMelee(this.fpath,15,13);
    	}
    		
    	else
    		System.out.println("pas de grille a cette adresse");	
 
    	this.xdebutMot = 0;
    	this.ydebutMot = 0;
    	
    	this.xfinMot = 0;
    	this.yfinMot = 0;
    	
    	this.word="";
	}
    
	//methodes:

	@Override
	public void BidonPower() {
		// TODO Auto-generated method stub
		
	}

	public int getXdebutMot() {
		return xdebutMot;
	}

	public void setXdebutMot(int xdebutMot) {
		this.xdebutMot = xdebutMot;
	}

	public int getYdebutMot() {
		return ydebutMot;
	}

	public void setYdebutMot(int ydebutMot) {
		this.ydebutMot = ydebutMot;
	}

	public int getXfinMot() {
		return xfinMot;
	}

	public void setXfinMot(int xfinMot) {
		this.xfinMot = xfinMot;
	}

	public int getYfinMot() {
		return yfinMot;
	}

	public void setYfinMot(int yfinMot) {
		this.yfinMot = yfinMot;
	}

	public String getFpath() {
		return fpath;
	}

	public GrilleMelee getGrille() {
		return grille;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void changeDebutMot(Scanner sc) {//permet de changer les coordonnées du debut du mot
		int temp;
		System.out.println("saisir le x de la lettre du debut du mot");
		temp=sc.nextInt();
		this.setXdebutMot(temp-1);
		sc.nextLine();
		System.out.println("saisir le y de la lettre du debut du mot");
		temp=sc.nextInt();
		this.setYdebutMot(temp-1);
		sc.nextLine();
	}
	
	public void changeFinMot(Scanner sc) {//permet de changer les coordonnées de la fin du mot
		int temp;
		System.out.println("saisir le x de la lettre de fin du mot");
		temp=sc.nextInt();
		this.setXfinMot(temp-1);
		sc.nextLine();
		System.out.println("saisir le y de la lettre de fin du mot");
		temp=sc.nextInt();
		this.setYfinMot(temp-1);
		sc.nextLine();
	}
	
	public void WordSelection(){//permet de selectionner un mots de la grille
		Scanner sc= new Scanner(System.in);
		this.changeDebutMot(sc);
		this.changeFinMot(sc);
		
		//probleme avec les cas(a refaire sur eclipse) la feuille
		if(this.getXdebutMot() == this.getXfinMot()) {//cas 1:mots est a la verticale
			
			if(this.getYdebutMot() <= this.getYfinMot()) {//cas 1.1:le mot est de haut en bas
				
				for(int compt = 0; compt < (this.getYfinMot() - this.getYdebutMot() + 1) ; compt++){
					System.out.println(this.grille.getGrille()[(this.getXdebutMot() + compt)] [this.getYdebutMot()] );
				}
			}
			else {//cas 1.2:le mot est de bas en haut
				for(int compt = 0; compt < (this.getYdebutMot()-this.getYfinMot() + 1) ; compt++){
					System.out.println(this.grille.getGrille()[(this.getXdebutMot())] [this.getYdebutMot()- compt] );
				}
			}
			 
		}
		else if(this.getYdebutMot() == this.getYfinMot()) {//cas 2:le mot est a l'horizontale
			
			if(this.getXdebutMot() < this.getXfinMot()) {//cas 2.1:le mot est de gauche a droite

			}
			else {//cas 2.2:le mot est de droite a gauche

			}
		}
		else {//cas 3:on reset la selection
			System.out.println("Erreur,le mot ne peut pas etre en diagonale");
			this.setXdebutMot(0);
			this.setYdebutMot(0);
			
			this.setXfinMot(0);
			this.setYfinMot(0);
		}
		sc.close();
	}
}
