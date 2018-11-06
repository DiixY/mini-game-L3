package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class MainUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        
    	primaryStage.setTitle("Hello World");
        Group root = new Group();
        root.setId("grad");
        Scene scene = new Scene(root,Color.LIGHTGREEN);
        scene.getStylesheets().add("Res/buttons.css");
        
        Button playb = new Button();
        Button helpb = new Button();
        
   
        playb.setLayoutX(100);
        playb.setLayoutY(80);
        playb.setText("Jouer !");
        playb.setId("dark-blue");
        playb.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });
        root.getChildren().add(playb);     
        
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MiniGames");
        primaryStage.show();
  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Application.launch(args);
	}

}
