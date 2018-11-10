package ui;

import java.net.URL;
import java.util.ResourceBundle;
import games.Pendu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PenduController implements Initializable {
	
	private Pendu p;
	@FXML
	private Button play;
	@FXML
	private Label chances;
	@FXML
	private Label word;
	
	@FXML
	void startGame(ActionEvent event)
	{
		p = new Pendu();
		
		chances.setText("Chance restante : "+ p.getCuTry());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
