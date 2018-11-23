package games;
import java.io.File;
import java.util.NavigableSet;


public class WordSearchPuzzle extends ABSWordManagement {
	//attributs:
	private int debutMot [] = {0,0};//coordonnees x y de la 1ere lettre du mot choisit
	private int finMot [] = {0,0};//coordonnees x y de la derniere lettre du mot choisit
	private Grille grille;
	private String fpath;//chemin du fichier choisit
	
	//constructeurs:
    public WordSearchPuzzle(String fpath) {
		// TODO Auto-generated constructor stub
    	this.fpath = fpath;
    	File f=new File(this.fpath);
    	
    	if (this.fpath == "Annexes/Mots_meles/Fruits.txt")
    		grille = new Grille(11,10,f);
    	else if(this.fpath == "Annexes/Mots_meles/Legumes")
    		grille = new Grille(14,13,f);
    	else if(this.fpath == "Annexes/Mots_meles/Noel")
    		grille = new Grille(15,13,f);
    	else
    		System.out.println("pas de grille a cette adresse");
    	
    	
    	
    	
	}
	//methodes:

	@Override
	public void BidonPower() {
		// TODO Auto-generated method stub
		
	}
	
	


}
