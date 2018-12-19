package games;

import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayerGestion pg =new PlayerGestion();
		Scanner sc = new Scanner(System.in);
		/*pg.addPlayer("chevalier_bastien_78");
		pg.addPlayer("minecraftDiixY");
		pg.addPlayer("xxxDarkNailllil666xxx");
		//Player p=pg.choosePlayer();
		//pg.getPlayerList().get(0).setScoreMotMel(45);
		//pg.generalRanking(pg.getPlayerList());
		pg.afficheJoueur();
		pg.savePlayers();*/
		pg.loadPlayers();
		pg.afficheJoueur();
		sc.close();

	}

}
