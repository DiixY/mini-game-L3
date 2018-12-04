package ui;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;
import games.Pendu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class PenduController implements Initializable {
	
	private Pendu p = null;
	
	@FXML
	Button A;
	@FXML
	Button B;
	@FXML
	Button C;
	@FXML
	Button D;
	@FXML
	Button E;
	@FXML
	Button F;
	@FXML
	Button G;
	@FXML
	Button H;
	@FXML
	Button I;
	@FXML
	Button J;
	@FXML
	Button K;
	@FXML
	Button L;
	@FXML
	Button M;
	@FXML
	Button N;
	@FXML
	Button O;
	@FXML
	Button P;
	@FXML
	Button Q;
	@FXML
	Button R;
	@FXML
	Button S;
	@FXML
	Button T;
	@FXML
	Button U;
	@FXML
	Button V;
	@FXML
	Button W;
	@FXML
	Button X;
	@FXML
	Button Y;
	@FXML
	Button Z;
	@FXML
	Button start;
	
	@FXML
	private Label chances;
	@FXML
	private Label word;
	@FXML
	private Label character;
	@FXML
	private Label status; 
	
	
	
	@FXML
	void startGame(ActionEvent event) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		for(int i = 0;i<=25;i++)
		{
			char c = (char)(65+i);
				Field f = this.getClass().getDeclaredField(Character.toString(c));
				f.setAccessible(true);
				Button temp_button = (Button)f.get(this);
				temp_button.setDisable(false);
		}
		start.setDisable(true);
		
		status.setText("");
		chances.setText("");
		p = new Pendu();
		
		word.setText(String.valueOf(p.getProgW()));
		chances.setText("Chance(s) restante(s) : "+ p.getCuTry());
		
	}
	
	public void disButton() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
	
		for(int i = 0;i<=25;i++)
		{
			char c = (char)(65+i);
				Field f = this.getClass().getDeclaredField(Character.toString(c));
				f.setAccessible(true);
				Button temp_button = (Button)f.get(this);
				temp_button.setDisable(true);
		}
	}
	
	public void playCar(ActionEvent event) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		char c = ((Button) (event.getSource())).getText().charAt(0);
		if(p != null)
		{

			((Button) (event.getSource())).setDisable(true);
			p.pendu_game(c);

			if(p.getCuTry()>0) 
			{

				word.setTextAlignment(TextAlignment.CENTER);
				word.setText(String.valueOf(p.getProgW()));
				if(p.checkWord(p.getWord(),String.valueOf(p.getProgW())))
				{
					status.setText("Gagné !");
					status.setTextFill(Color.ORANGE);
					start.setDisable(false);
					disButton();
				}
			}
			else 
			{
				status.setText("Perdu !");
				word.setText(p.getWord());
				status.setTextFill(Color.RED);
				start.setDisable(false);
				disButton();
			}

			chances.setText("Chance(s) restante(s) : "+ p.getCuTry());
		}
		else
		{
			this.errAlert(c);
		}
	}

	@FXML
	public void goGames(ActionEvent event) throws IOException
	{	
			Parent playParent = FXMLLoader.load(getClass().getResource("PlayView.fxml"));
			Scene scene = new Scene(playParent);
			Stage playwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			
			playwindow.setScene(scene);	
	}
	
	public void errAlert(char c)
	{
		Alert al = new Alert(Alert.AlertType.WARNING);
		al.setTitle("Problème Pendu");
		al.setHeaderText("Impossible de jouer la lettre "+c);
		al.setContentText("Il faut d'abord cliquer sur Lancer pour pouvoir jouer ;-)");
		al.showAndWait();
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
}
