package ui;

import java.io.IOException;

import games.Player;
import games.PlayerGestion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.layout.*;


//Classe qui regroupe toutes les fonctions pour les boutons dans l'interface graphique (redirection entre fenetre)
//Et les variables/fonctions de manipulation pour avoir un joueur (present dans tout les jeux)
public class ChangeSceneButtons {
	
	protected PlayerGestion pg;
	protected Player player;
	protected String nickname;
	@FXML protected Button validate;
	@FXML protected TextField namefield;
	
	
	public ChangeSceneButtons() {
		super();
		this.pg = null;
		this.nickname = null;
		this.setPlayer(null);
	}
	
	//Permet de recuperer le nom du joueur en testant si il existe dans la liste des joueurs ou non , si non on l'ajoute puis ensuite on recupere son pseudo
		public void initPlayer(ActionEvent event)
		{
			this.pg = new PlayerGestion();
			this.pg.loadPlayers();
			if(this.pg.choosePlayer(this.namefield.getText()) == null)
			{
				this.pg.addPlayer(this.namefield.getText());
				this.pg.savePlayers();
			}
			this.player = this.pg.choosePlayer(this.namefield.getText());
			this.nickname = this.namefield.getText();
			this.namefield.setVisible(false);
			this.validate.setVisible(false);
		}

	@FXML
	public void goPendu(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/PenduView.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goHome(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/MainView.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goSudoNum(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/SudokuNumMenuView.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goSudoChar(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/SudokuCharMenuView.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goMotus(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/MotusView.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goSudo1(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/SudokuNum1.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goChar1(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/SudokuChar1.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goSudo2(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/SudokuNum2.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goChar2(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/SudokuChar2.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goSudo3(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/SudokuNum3.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goChar3(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/SudokuChar3.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	
	public void goPlayView(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("layout/PlayView.fxml"));
		Scene scene = new Scene(root);
		Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
		mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goWordSearch1(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/WordSearch1.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goWordSearch2(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/WordSearch2.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goWordSearch3(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/WordSearch3.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goWordSearchMenu(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/WordSearchMenu.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	
	@FXML
	public void goClassement(ActionEvent event) throws IOException
	{	
			Parent mainParent = FXMLLoader.load(getClass().getResource("layout/Classement.fxml"));
			Scene scene = new Scene(mainParent);
			Stage mainwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			mainwindow.setScene(scene);	
	}
	

	public PlayerGestion getPg() {
		return pg;
	}

	public void setPg(PlayerGestion pg) {
		this.pg = pg;
	}

	public String getP() {
		return nickname;
	}

	public void setP(String p) {
		this.nickname = p;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
