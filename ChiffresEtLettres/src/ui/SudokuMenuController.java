package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SudokuMenuController {
	
	@FXML
	public void goSudo1(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("SudokuNum1.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	public void goGames(ActionEvent event) throws IOException
	{	
			Parent playParent = FXMLLoader.load(getClass().getResource("PlayView.fxml"));
			Scene scene = new Scene(playParent);
			Stage playwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			
			playwindow.setScene(scene);	
	}

}
