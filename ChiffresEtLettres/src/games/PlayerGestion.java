package games;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.SortedSet;
import java.util.TreeSet;

public final class PlayerGestion {
	//Attribut:

	private SortedSet<Player> playerList;//liste des joueurs
	private String fpath;//chemin du fichier de sauvegarde des joueurs

	//Constructeurs:

	public PlayerGestion() {
		this.fpath = "Annexes/Players.txt";
		this.playerList = null;
	}

	//Methodes:

	//ajout d'un joueur (de la BDD et liste des joueurs)
	public void addPlayer(String pseudo) {//ajoute un joueur a la liste
		//variable pour savoir si le nom existe deja sur le serveur
		if(this.playerList == null)
			this.playerList = new TreeSet<Player>();
		if(pseudo != null) {

					this.playerList.add(new Player(pseudo));
					System.out.println("Creation du joueur terminé.\n");
				
			}

}


//pour le chargement uniquement:
public void addPlayer(String pseudo,int scoreG, int scoreSud, int scoreSudAZ, int scoreMotMel, int scorePen, int scoreMotus,int nbPartG, int nbPartSud, int nbPartSudAZ, int nbPartMotMel, int nbPartPen, int nbPartMotus,int id) {
	if(this.playerList == null)
		this.playerList = new TreeSet<Player>();
	if(pseudo != null) {
		this.playerList.add(new Player(pseudo,scoreG,scoreSud,scoreSudAZ,scoreMotMel,scorePen,scoreMotus,nbPartG,nbPartSud,nbPartSudAZ,nbPartMotMel,nbPartPen,nbPartMotus,id));
	}
}

public void removePlayer(Player p) throws ErrOperation {//supprime un joueur de la liste
	if(this.playerList.isEmpty() == true) {
		this.playerList = null;
		System.out.println("la liste de joueur est vide");
	}
	else if(this.playerList.isEmpty() == false)
		this.playerList.remove(p);
	System.out.println("joueur suprimme");
}

public void savePlayers(PlayerGestion pg) {//sauvegarde les joueurs dans un fichier
	File f = new File(this.fpath);
	if (f.exists()) 
		f.delete();

	if(pg.getPlayerList().isEmpty() == false) {

		try {
			FileOutputStream outFileStream = new FileOutputStream(f);
			ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);

			for(Player b : pg.getPlayerList()){
				outObjectStream.writeObject(b);
			}
			outObjectStream.close();
			System.out.println("Votre liste de joueurs est sauvegardées");
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}  
	}

	else 
		System.out.println("#Erreur: La liste ne possede pas de jeux");

}

public void loadPlayers(PlayerGestion pg) {//charge les joueurs d'un fichier
	File File = new File(fpath);
	FileInputStream FileStream;
	if(File.exists()) {
		try {
			Player p;
			FileStream = new FileInputStream(File);
			ObjectInputStream ObjectStream = new ObjectInputStream(FileStream);
			for (int i = 0; i < 3; i++) {

				p = (Player) ObjectStream.readObject();
				pg.addPlayer(p.getPseudo(),p.getScoreG(),p.getScoreSud(),p.getScoreSudAZ(),p.getScoreMotMel(),p.getScorePen(),p.getScoreMotus(),p.getNbPartG(),p.getNbPartSud(),p.getNbPartSudAZ(),p.getNbPartMotMel(),p.getNbPartPen(),p.getNbPartMotus(),p.getId());
			}
			ObjectStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}			   
	}
	else
		System.out.println("#Erreur:: Le fichier de sauvegarde n'existe pas. \n");
}

public void generalRanking(TreeSet<Player> list) {//calcul le score general d'un joueur et tri la liste 
	for(Player p : list) {
		p.setScoreG(p.getScoreMotMel() + p.getScoreMotus() + p.getScorePen() + p.getScoreSud() + p.getScoreSudAZ());
	}
}

public void sudokuAZRanking(TreeSet<Player> list) {//trie la liste des joueurs en fonction de leurs score sudoku Lettre

}

public void sudoku19Ranking(TreeSet<Player> list) {//trie la liste des joueurs en fonction de leurs score sudoku Nombre

}

public void penduRanking(TreeSet<Player> list) {//trie la liste des joueurs en fonction de leurs score Pendu

}

public void motusRanking(TreeSet<Player> list) {//trie la liste des joueurs en fonction de leurs score Motus

}

public void wordSearchPuzzleRanking() {//trie la liste des joueurs en fonction de leurs score Mots-Meles

}

public SortedSet<Player> getPlayerList() {
	return playerList;
}

public void setPlayerList(SortedSet<Player> playerList) {
	this.playerList = playerList;
}

public String getFpath() {
	return fpath;
}



}
