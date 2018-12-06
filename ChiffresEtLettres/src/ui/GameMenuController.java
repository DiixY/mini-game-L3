package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GameMenuController implements Initializable{
	
	@FXML
	Image btnImage;
	
	@FXML
	public void goPendu(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("PenduView.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goHome(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("MainView.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goSudoNum(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("SudokuNumMenuView.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goMotus(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("MotusView.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	

}
