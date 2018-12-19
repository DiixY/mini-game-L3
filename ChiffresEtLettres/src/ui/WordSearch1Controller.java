package ui;

import java.util.Arrays;

import games.WordSearchPuzzle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class WordSearch1Controller extends ChangeSceneButtons {
	
	
	private Button[] buttons; // Tableau de Button pour recupere les 2 clics nécessaires a la selection du mot (Debut du mot et fin du mot)
	@FXML
	private Button launch;//Attribut FXML qui manipule le bouton Lancer
	@FXML
	private Label status; //Attribut FXML qui manipule le message lorsque l'on gagne
	@FXML
	private GridPane grid; //Attribut FXML qui manipule la grille des boutons
	@FXML
	private Label words; //Attribut FXML qui manipule la liste des mots a trouver
	
	private Background tempbackground = null; //Attribut pour sauvegarder la couleur de fond d'une case (si le mot selectionné n'est pas bon)
	
	WordSearchPuzzle g;
	
	//Initialisation de tout les attibuts dont on a besoin lors de la partie ( Messages , boutons , etc..)
	public void start(ActionEvent event) throws Exception
	{
		cleanGrid();
		this.launch.setDisable(true);
		this.buttons = new Button[2];
		//this.status.setText("");
		this.grid.getParent().requestFocus();
		this.g = new WordSearchPuzzle("Annexes/Mots_meles/Fruits.txt");
		setButtonsEnable(false);
		String str = Arrays.toString(this.g.getGrille().getAutorise()).substring(1, Arrays.toString(this.g.getGrille().getAutorise()).length()-1);
		this.words.setText(str);
		this.words.setFont(new Font("Arvin", 14));
		this.status.setText("");
		
		
	}
	
	//Fonction qui va recuperer l'interaction avec l'utilisateur et va jouer le mot choisit par celui-ci
	public void test(ActionEvent event)
	{
		
		if(this.buttons[0] == null)
		{
			this.buttons[0] = (Button)event.getSource();//recupere le premier bouton cliqué lors de l'event
			StackPane b1 = (StackPane)this.buttons[0].getParent();
			if(b1.getBackground() != null) this.tempbackground = b1.getBackground();
			b1.setBackground(new Background(new BackgroundFill(Paint.valueOf("rgba(255, 102, 102,0.5)"), null, null)));
		}
		else if (this.buttons[1] == null)
		{
			this.buttons[1] = (Button)event.getSource(); //recupere le deuxieme bouton cliqué lors de l'event
			StackPane b1 = (StackPane)this.buttons[0].getParent();
			StackPane b2 = (StackPane)this.buttons[1].getParent(); //recupere le parent du bouton cliqué lors de l'event pour pouvoir chercher les coordonnés du bouton dans la grille et manipuler la couleur de fond
			



			//Initialisation des coordonnées du mot selectionné par l'utilisateur
			this.g.setColonneDebutMot(GridPane.getColumnIndex(b1));
			this.g.setLigneDebutMot(GridPane.getRowIndex(b1));
			this.g.setColonneFinMot(GridPane.getColumnIndex(b2));
			this.g.setLigneFinMot(GridPane.getRowIndex(b2));


			if(this.g.jouer()) // Test si le mot est correct et fait parti de la liste des mots à trouver
			{
				System.out.println(this.g.getNbMots());
				if(GridPane.getColumnIndex(b1) == GridPane.getColumnIndex(b2)) //cas où la selection du joueur est en colonne
				{
					if(GridPane.getRowIndex(b1) < GridPane.getRowIndex(b2)) //cas où le mot se lit de gauche a droite
					{
						for(int i = GridPane.getRowIndex(b1);i<=GridPane.getRowIndex(b2);i++)
						{
							getNodeByRowColumnIndex(i,GridPane.getColumnIndex(b1)).setBackground(new Background(new BackgroundFill(Paint.valueOf("rgba(153, 255, 51,0.5)"), null, null)));
						}
					}
					else //cas où le mot se lit de droite a gauche
					{
						for(int i = GridPane.getRowIndex(b2) ; i<=GridPane.getRowIndex(b1);i++)
						{
							getNodeByRowColumnIndex(i,GridPane.getColumnIndex(b1)).setBackground(new Background(new BackgroundFill(Paint.valueOf("rgba(153, 255, 51,0.5)"), null, null)));
						}
					}
				}
				else //cas où la selection du joueur est en ligne
				{
					if(GridPane.getColumnIndex(b1) < GridPane.getColumnIndex(b2))//cas où le mot se lit de haut en bas
					{
						for(int i = GridPane.getColumnIndex(b1) ; i<=GridPane.getColumnIndex(b2);i++)
						{
							getNodeByRowColumnIndex(GridPane.getRowIndex(b1),i).setBackground(new Background(new BackgroundFill(Paint.valueOf("rgba(153, 255, 51,0.5)"), null, null)));
						}
					}
					else //cas où le mot se lit de bas en haut
					{
						for(int i = GridPane.getColumnIndex(b2) ; i<=GridPane.getColumnIndex(b1);i++)
						{
							getNodeByRowColumnIndex(GridPane.getRowIndex(b1),i).setBackground(new Background(new BackgroundFill(Paint.valueOf("rgba(153, 255, 51,0.5)"), null, null)));
						}
					}
				}
			}
			else // Sinon on remet les coordonnées du mot a 0 pour la prochaine interaction avec l'utilisateur
			{
				b1.setBackground(this.tempbackground);
				this.g.setColonneDebutMot(0);
				this.g.setLigneDebutMot(0);
				this.g.setColonneFinMot(0);
				this.g.setLigneFinMot(0);
			}

			//Reinitialisation du tableau de boutons a null pour recuperer la prochaine saisie
			
			this.buttons[0] = null;
			this.buttons[1] = null;
			String str = Arrays.toString(this.g.getGrille().getAutorise()).substring(1, Arrays.toString(this.g.getGrille().getAutorise()).length()-1);
			this.words.setText(str);

			if(this.g.getNbMots() == 0 ) // Test si l'utilisateur a trouvé tout les mots ,si oui on affiche le message gagné et on active/désactive les boutons nécessaire au bon fonctionnement d'une nouvel partie
			{
				this.launch.setDisable(false);
				this.status.setText("Gagné !");
				this.status.setTextFill(Color.ORANGE);
				setButtonsEnable(false);
			}

		}
	}			


	
	/*
	 * Fonction qui retourne une Node specifique d'un GridPane grace a ses coordonnées (Fonction trouvé sur une discussion Stack OverFlow : 
	 * https://stackoverflow.com/questions/20825935/javafx-get-node-by-row-and-column
	 * Tout crédit revient à son créateur */
	public StackPane getNodeByRowColumnIndex (final int row, final int column) {
	    StackPane result = null;
	    ObservableList<Node> childrens = this.grid.getChildren();

	    for (Node node : childrens) {
	        if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
	            StackPane temp = (StackPane)node;
	            result = temp;
	            break;
	        }
	    }

	    return result;
	}
	
	//Fonction qui remet la couleur de fond de toute la grille en blanc (Utilisé lorsque l'on relance une partie)
	public void cleanGrid(){

		ObservableList<Node> childrens = this.grid.getChildren();

		for (Node node : childrens) {
			{

				StackPane temp = (StackPane)node;
				temp.setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), null, null)));

			}
		}
	}
	
	
	
	
	//Change l'état des boutons de la grille (Activé : etat = false , Désactivé : etat = true)
	public void setButtonsEnable(boolean etat)
	{
		
		ObservableList<Node> childrens = this.grid.getChildren();

		for(Node temp:childrens)
		{
			StackPane temp2 = (StackPane)temp;
			temp2.getChildren().get(0).setDisable(etat);	
		}		
		
	}
}
