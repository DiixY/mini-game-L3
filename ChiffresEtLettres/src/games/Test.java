package games;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Test {

	public static void deletePlayer(PlayerGestion pg,Scanner sc) {
		if(pg.getPlayerList() != null) {
			if(!pg.getPlayerList().isEmpty()){
				System.out.println("Liste des joeurs disponibles pour la suppression: ");
				for(Player b:pg.getPlayerList()){
					System.out.print("||");
					System.out.print(b.getPseudo()+"||");
				}
		  
				System.out.println("\n Saisir le nom du jeu à supprimer:");
				String name =sc.nextLine();
				for(Player b:pg.getPlayerList()){  
					if(b.getPseudo().equals(name)) {
						try {
							pg.removePlayer(b);
						} catch (ErrOperation e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			else
				System.out.println("#Erreur: La liste de jeu est vide. \n");
	  		}
	  		else
	  			System.out.println("#Erreur: La liste de jeu est null");
	}

	public static void createPlayer(PlayerGestion pg,Scanner sc) {
		System.out.println("saisir le pseudo du joueur:");
		pg.addPlayer(sc.nextLine());
	}
	
	public static void affichePlayer(PlayerGestion pg) {
		//affichage joueurs
		for(Player b:pg.getPlayerList()){  
			if(pg.getPlayerList() != null) {
				System.out.println("id: "+b.getId()+"\n pseudo: "+ b.getPseudo());
			}  
		}
	}
	
	public static void chargePlayer(PlayerGestion pg) {
		File File = new File(pg.getFpath());
		  FileInputStream FileStream;
		  if(File.exists()) {
			  try {

				  FileStream = new FileInputStream(File);
				  ObjectInputStream ObjectStream = new ObjectInputStream(FileStream);
				  Player p;
				  for (int i = 0; i < 3; i++) {

				  p = (Player) ObjectStream.readObject();
				  pg.addPlayer(p.getPseudo(),p.getScoreG(),p.getScoreSud(),p.getScoreSudAZ(),p.getScoreMotMel(),p.getScorePen(),p.getScoreMotus(),p.getNbPartG(),p.getNbPartSud(),p.getNbPartSudAZ(),p.getNbPartMotMel(),p.getNbPartPen(), p.getNbPartMotus(),p.getId());
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayerGestion pg = new PlayerGestion();
		Scanner sc = new Scanner(System.in);
		/*
		Test.createPlayer(pg, sc);
		Test.createPlayer(pg, sc);
		Test.createPlayer(pg, sc);
		Test.affichePlayer(pg);
		pg.savePlayers(pg);
		*/
		
		
		Test.chargePlayer(pg);
		Test.affichePlayer(pg);
		
	}
}
