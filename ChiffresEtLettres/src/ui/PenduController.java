package ui;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;
import games.Pendu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;


public class PenduController extends ChangeSceneButtons implements Initializable {
	
	private Pendu g = null;
	
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
		if(this.getPlayer()==null)
		{
			this.namefield.setVisible(true);
			this.validate.setVisible(true);
		}
		else
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

			g = new Pendu();


			word.setText(String.valueOf(g.getProgW()));
			chances.setText(this.player.getPseudo()+" - Chance(s) restante(s) : "+ g.getCuTry());
		}	
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
		if(g != null)
		{

			((Button) (event.getSource())).setDisable(true);
			g.pendu_game(c);

			if(g.getCuTry()>0) 
			{

				word.setTextAlignment(TextAlignment.CENTER);
				word.setText(String.valueOf(g.getProgW()));
				if(g.checkWord(g.getWord(),String.valueOf(g.getProgW())))
				{
					status.setText("Gagné !");
					this.player.setScorePen(g.getCuTry()*g.getWord().length()+this.player.getScorePen());
					chances.setText(this.player.getPseudo()+" : + "+g.getCuTry()*g.getWord().length()+" points");
					status.setTextFill(Color.ORANGE);
					start.setDisable(false);
					disButton();
					
					this.pg.savePlayers();
				}
				else
				{
					chances.setText(this.player.getPseudo()+" - Chance(s) restante(s) : "+ g.getCuTry());
				}
			}
			else 
			{
				status.setText("Perdu !");
				word.setText(g.getWord());
				chances.setText(this.player.getPseudo()+" - 0 points ");
				status.setTextFill(Color.RED);
				start.setDisable(false);
				disButton();
			}

		}
		else
		{
			this.errAlert(c);
		}
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
