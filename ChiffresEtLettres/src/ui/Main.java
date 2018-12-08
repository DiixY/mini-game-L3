package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		this.primaryStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		this.primaryStage.setTitle("miniGames");
		
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.DECORATED);
		Scene scene = new Scene(root);
		
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
	}
	
		

	public static void main(String[] args) {
		launch(args);
	}
}
