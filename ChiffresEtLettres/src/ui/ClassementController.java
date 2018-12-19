package ui;

import games.PlayerGestion;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClassementController extends ChangeSceneButtons {
	
	@FXML 
	private Label rank;
	
	public void getRanking()
	{
		
		this.pg = new PlayerGestion();
		this.pg.loadPlayers();
		this.rank.setText(this.pg.toString());
	}

}
