package ui;

import java.io.IOException;

import games.WordSearchPuzzle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class WordSearchController {
	
	Button[] buttons;
	@FXML
	Button launch;
	@FXML
	Label status;
	@FXML
	GridPane grid;
	
	WordSearchPuzzle g;
	
	public void start(ActionEvent event) throws Exception
	{
		this.launch.setDisable(true);
		this.buttons = new Button[2];
		this.status.setText("");
		
		this.g= new WordSearchPuzzle("Annexes/Mots_meles/Fruit.txt");
	}
	
	public void test(ActionEvent event)
	{
		if(this.buttons[0] == null)
		{
			this.buttons[0] = (Button)event.getSource();
		}
		else if (this.buttons[1] == null)
		{
			this.buttons[1] = (Button)event.getSource();
			
			
			
		}
	}

}
