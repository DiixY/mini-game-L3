package ui;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController {
	
	@FXML
	public void goGames(ActionEvent event) throws IOException
	{	
			Parent playParent = FXMLLoader.load(getClass().getResource("PlayView.fxml"));
			Scene scene = new Scene(playParent);
			Stage playwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			
			playwindow.setScene(scene);	
	}

}
