package ui;

import games.PlayerGestion;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClassementController extends ChangeSceneButtons {
	
	@FXML private Label rank;
	
	public void getRanking()
	{
		this.rank = new Label();
		
		this.pg = new PlayerGestion();
		this.pg.loadPlayers();
		this.pg.generalRanking(this.pg.getPlayerList());
		this.rank.setText(this.pg.getPlayerList().toString());
	}

}
