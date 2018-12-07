package games;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.SortedSet;
import java.util.TreeSet;

public final class PlayerGestion {
	//Attribut:

	private SortedSet<Player> playerList;//liste des joueurs
	private String fpath;//chemin du fichier de sauvegarde des joueurs

	//Constructeurs:

	public PlayerGestion(SortedSet<Player> list) {
		this.fpath = "Annexes/Players.txt";
		this.playerList = list;		
	}

	public PlayerGestion() {
		this.fpath = "Annexes/Players.txt";
		this.playerList = null;
	}

	//Methodes:
	public void addPlayer(String pseudo) {//ajoute un joueur a la liste

	
	}

	public void removePlayer(Player p) throws ErrOperation {//supprime un joueur de la liste

	}

	public void savePlayers() {//sauvegarde les joueurs dans un fichier


	}

	public void loadPlayers() {//charge les joueurs dans un fichier

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
	
}
