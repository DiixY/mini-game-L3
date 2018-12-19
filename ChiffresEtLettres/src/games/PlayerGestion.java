package games;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;


public final class PlayerGestion {
	//Attribut:

	private ArrayList<Player> playerList;//liste des joueurs
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
		//variable pour savoir si le nom existe deja sur le serveur
		Boolean compare=false;
		if(this.getPlayerList() != null) {
			for(Player b: this.getPlayerList()){ 
				if(pseudo.equals(b.getPseudo()))
					compare=true;
			}  
		}
		if(compare == false) {
			if(this.playerList == null)
				this.playerList = new ArrayList<Player>();
			if(pseudo != null) {
				this.playerList.add(new Player(pseudo));
				System.out.println("Creation du joueur terminé.\n");
			}
		}
		else
			System.out.println("#Erreur: Le nom de ce joueur existe deja dans le serveur.\n");
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

	public void savePlayers() {//sauvegarde les joueurs dans un fichier
		File f = new File(this.fpath);
		if (f.exists()) 
			f.delete();

		if(this.getPlayerList().isEmpty() == false) {

			try {
				FileOutputStream outFileStream = new FileOutputStream(f);
				ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);


				outObjectStream.writeObject(this.getPlayerList());
				outObjectStream.close();
				outFileStream.close();
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
			System.out.println("#Erreur: La liste ne possede pas de joeurs");

	}

	public void loadPlayers() {//charge les joueurs d'un fichier
		File File = new File(fpath);
		FileInputStream FileStream;

		if(File.exists()) {
			try {
				FileStream = new FileInputStream(File);
				ObjectInputStream ObjectStream = new ObjectInputStream(FileStream);
				ArrayList<Player> p= new ArrayList<Player>((ArrayList<Player>)ObjectStream.readObject());
				//ArrayList<Player> p = (ArrayList<Player>) ObjectStream.readObject();
				this.setPlayerList(p);
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

	public void generalRanking(ArrayList<Player> list) {//calcul le score general d'un joueur et tri la liste 
		for(Player p : list) {
			p.setScoreG(p.getScoreMotMel() + p.getScoreMotus() + p.getScorePen() + p.getScoreSud() + p.getScoreSudAZ());
		}
		Collections.sort(this.getPlayerList(), Collections.reverseOrder());
		Collections.reverse(this.getPlayerList());
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public String getFpath() {
		return fpath;
	}

	public Player choosePlayer(String pseudo) {
		if(this.getPlayerList() != null) {
			if(!this.getPlayerList().isEmpty()){
				System.out.println("Liste des joueurs disponibles: ");
				for(Player b:this.getPlayerList()){
					System.out.print("||");
					System.out.print(b.getPseudo()+"||");
				}

				for(Player b:this.getPlayerList()){  
					if(b.getPseudo().equals(pseudo)) {
						return b;
					}
				}
			}
			else
				System.out.println("#Erreur: La liste de jeu est vide. \n");
		}
		else
			System.out.println("#Erreur: La liste de jeu est null");
		return null;

	}

	public void afficheJoueur() {
		for(Player p: this.getPlayerList()) {
			System.out.println("pseudo : " + p.getPseudo() +" score general:" + p.getScoreG());
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "";
		this.generalRanking(getPlayerList());	
		if(this.playerList.size()>10)
		{
			for(int i = 0;i<10;i++)
			{
				Player p = (Player)this.playerList.get(i);
				s = s + p.getPseudo()+"\t" +"- Générale : "+p.getScoreG()+" P : "+p.getScorePen()+" MM : "+p.getScoreMotMel()+" M : "+p.getScoreMotus()+" SC : "+p.getScoreSud()+" SL : "+p.getScoreSudAZ()+"\n";
			}
		}
		else
		{
			for(int i = 0;i<this.playerList.size();i++)
			{
				Player p = (Player)this.playerList.get(i);
				s = s + p.getPseudo()+"\t" +"- Générale : "+p.getScoreG()+" P : "+p.getScorePen()+" MM : "+p.getScoreMotMel()+" M : "+p.getScoreMotus()+" SC : "+p.getScoreSud()+" SL : "+p.getScoreSudAZ()+"\n";
			}
		}
			
		return s;
	}

	

}
