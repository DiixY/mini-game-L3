package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	
	private Stage primaryStage;

	//Classe qui creer la premiere fenetre de l'application
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		this.primaryStage = primaryStage;
		Font.loadFont("Res/Arvin.ttf", 12);
		Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		this.primaryStage.setTitle("miniGames");
		
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.DECORATED);
		Scene scene = new Scene(root);
		primaryStage.getIcons().add(new Image("http://image.noelshack.com/fichiers/2018/50/1/1544464567-icone.png"));
		
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
	}
	
		

	public static void main(String[] args) {
		launch(args);
	}
}
