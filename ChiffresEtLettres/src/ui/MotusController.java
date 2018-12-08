package ui;


import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import games.Motus;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public final class MotusController extends ChangeSceneButtons implements Initializable{
	
	//creation des objet pour la grille et la zone de texte a manipuler dans l'interface graphique
	@FXML
	private GridPane grid;
	@FXML
	private TextField word;
	@FXML
	private Button launch;
	@FXML
	private Button check;
	@FXML
	private Label status;
	
	//Objet du jeu motus
	private Motus m;
	
	//Formes représentants si une lettre est bonne et est à la bonne place ou pas.
	Circle circle;
	Rectangle r;
	
	
	public void start(ActionEvent event)
	{
		//Si la grille a déjà été utilisé alors on supprime tout son contenu
		if(this.grid.getChildren() != null)
		{
			this.grid.getChildren().removeAll(this.grid.getChildren());
			this.grid.getRowConstraints().removeAll(this.grid.getRowConstraints());
			this.grid.getColumnConstraints().removeAll(this.grid.getColumnConstraints());
		}
		
		try {
			this.m = new Motus();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.word.setDisable(false);
		this.launch.setDisable(true);
		this.check.setDisable(false);
		this.status.setText("");
		this.word.setPromptText("Entrez un mot ! ("+this.m.getWord().length()+"caractères)");
		
		
		//Permet d'enlever le focus sur la zone de texte et de montrer le prompt text
		this.word.getParent().requestFocus();
		
		BorderStroke bs = new BorderStroke(Paint.valueOf("grey"),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderStroke.THIN);
		this.grid.setBorder(new Border(bs));
		this.grid.setBackground(new Background(new BackgroundFill(Paint.valueOf("rgba(64, 64, 64,0.5)"), null, null)));
		
		for(int i = 0;i<m.getWord().length();i++)
		{
			ColumnConstraints c = new ColumnConstraints();
			c.setPercentWidth(100);
			this.grid.getColumnConstraints().add(c);
		}
		
		for(int i = 0;i<7;i++)
		{
			RowConstraints r = new RowConstraints();
			r.setPercentHeight(100);
			this.grid.getRowConstraints().add(r);
		}

		
		
		for (int i = 0; i< this.m.getWord().length();i++)
			this.grid.add(this.wrongChar(this.m.getGhostCo()[i]), i, 0);
		
	}
	
	
	public void play(ActionEvent event)
	{
		
		if(this.m.getCuTry()<6)
		{
			if(this.word.getText().equals("") || this.word.getText().length() != this.m.getWord().length() || !this.m.isWordValid(this.word.getText()))
			{
				this.errAlert();
			}
			else
			{
				String playWord = this.word.getText().toUpperCase();
				this.m.motus_game(this.word.getText());

				for(int i = 0 ; i < playWord.length() ; i++)
				{
					if(Character.compare(playWord.charAt(i),this.m.getGhostCo()[i]) == 0)
					{
						this.grid.getChildren().remove(getNodeByRowColumnIndex(this.m.getCuTry(),i));
						this.grid.add(this.goodPlaceChar(playWord.charAt(i)), i, this.m.getCuTry()-1);
					}
					else if (Character.compare(playWord.charAt(i),this.m.getGhostEm()[i]) == 0)
					{
						this.grid.getChildren().remove(getNodeByRowColumnIndex(this.m.getCuTry(),i));
						this.grid.add(this.wrongPlaceChar(playWord.charAt(i)), i, this.m.getCuTry()-1);
					}
					else 
					{
						this.grid.getChildren().remove(getNodeByRowColumnIndex(this.m.getCuTry()-1,i));
						this.grid.add(this.wrongChar(playWord.charAt(i)), i, this.m.getCuTry()-1);
					}
				}
				
				
				if(this.m.getEnd())
				{
					for(int i = 0 ; i < this.m.getWord().length() ; i++)
					{
						this.grid.add(this.goodPlaceChar(this.m.getWord().charAt(i)), i, this.m.getCuTry()-1);
					}
					this.status.setText("Gagné");
					this.check.setDisable(true);
					this.launch.setDisable(false);

				}
				else
				{
					for(int i = 0 ; i < this.m.getWord().length() ; i++)
					{

						this.grid.add(this.wrongChar(this.m.getGhostCo()[i]), i, this.m.getCuTry());
					}
				}
				this.word.clear();
			}
			
			
		}
		else
		{
			this.status.setText("Perdu !");
			this.status.setTextFill(Paint.valueOf("crimson"));
			
			for(int i = 0 ; i < this.m.getWord().length() ; i++)
			{
					this.grid.add(this.goodPlaceChar(this.m.getWord().charAt(i)), i, this.m.getCuTry());
			}
			this.word.clear();
		}
	}
	
	
	public Node getNodeByRowColumnIndex (final int row, final int column) {
	    Node result = null;
	    ObservableList<Node> childrens = this.grid.getChildren();

	    for (Node node : childrens) {
	        if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
	            result = node;
	            break;
	        }
	    }

	    return result;
	}
	//Fonction qui créer la fenetre de warning
	public void errAlert()
	{
		Alert al = new Alert(Alert.AlertType.WARNING);
		al.setTitle("Problème Motus");
		al.setHeaderText("Problème de mot");
		al.setContentText("Il faut essayer un mot de "+this.m.getWord().length()+" caractères pour pouvoir jouer !");
		al.showAndWait();
	}
	
	//Fonction qui creer la cellule contenant la lettre et un rectangle rouge signalant que la lettre est bonne et est bien placé
	public StackPane goodPlaceChar(char c)
	{
		Label text = new Label();
		StackPane s = new StackPane();

		s.setBorder( new Border(new BorderStroke(Paint.valueOf("grey"),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderStroke.THIN)));
		this.r = new Rectangle(30,30, Paint.valueOf("crimson"));
		text.setText(Character.toString(c));
		text.setFont(new Font("Arial",16));
		text.setTextFill(Paint.valueOf("white"));
		
		s.getChildren().addAll(this.r,text);
		return s;
	}
	
	//Fonction qui creer la cellule contenant la lettre et un cercle jaune signalant que la lettre est bonne mais n'est pas bien placé
	public StackPane wrongPlaceChar(char c)
	{
		Label text = new Label();
		StackPane s = new StackPane();
		
		s.setBorder( new Border(new BorderStroke(Paint.valueOf("grey"),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderStroke.THIN)));
		
		this.circle = new Circle(15,Paint.valueOf("rgb(230, 230, 0)"));
		text.setText(Character.toString(c));
		text.setFont(new Font("Arial",16));
		text.setTextFill(Paint.valueOf("white"));
		
		s.getChildren().addAll(this.circle,text);
		return s;
	}
	
	
	//Fonction qui creer la cellule contenant la lettre  signalant que la lettre n'est pas dans le mot à trouver
	public StackPane wrongChar(char c)
	{
		Label text = new Label();
		StackPane s = new StackPane();
		
		s.setBorder( new Border(new BorderStroke(Paint.valueOf("grey"),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderStroke.THIN)));
		text.setText(Character.toString(c));
		text.setFont(new Font("Arial",16));
		text.setTextFill(Paint.valueOf("white"));
		
		s.getChildren().addAll(text);
		return s;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
