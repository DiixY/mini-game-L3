package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangeSceneButtons {

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
	
	@FXML
	public void goSudo1(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("SudokuNum1.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	public void goPlayView(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("PlayView.fxml"));
		Scene scene = new Scene(root);
		Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
		mainwindow.setScene(scene);	
	}
	
}
