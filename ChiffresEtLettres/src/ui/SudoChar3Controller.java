package ui;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import games.Sudoku;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class SudoChar3Controller extends ChangeSceneButtons{
	//Attributes
	Sudoku s;
	ArrayList<String> coordinates;
	
	@FXML 
	Button launch;
	
	@FXML 
	Button try_sudo;
	
	@FXML
	private Label chances;
	
	@FXML
	private Label status;
	
	@FXML
	ChoiceBox<Character> c1;
	@FXML
	ChoiceBox<Character> c2;
	@FXML
	ChoiceBox<Character> c3;
	@FXML
	ChoiceBox<Character> c4;
	@FXML
	ChoiceBox<Character> c5;
	@FXML
	ChoiceBox<Character> c6;
	@FXML
	ChoiceBox<Character> c7;
	@FXML
	ChoiceBox<Character> c8;
	@FXML
	ChoiceBox<Character> c9;
	@FXML
	ChoiceBox<Character> c10;
	@FXML
	ChoiceBox<Character> c11;
	@FXML
	ChoiceBox<Character> c12;
	@FXML
	ChoiceBox<Character> c13;
	@FXML
	ChoiceBox<Character> c14;
	@FXML
	ChoiceBox<Character> c15;
	@FXML
	ChoiceBox<Character> c16;
	@FXML
	ChoiceBox<Character> c17;
	@FXML
	ChoiceBox<Character> c18;
	@FXML
	ChoiceBox<Character> c19;
	@FXML
	ChoiceBox<Character> c20;
	@FXML
	ChoiceBox<Character> c21;
	@FXML
	ChoiceBox<Character> c22;
	@FXML
	ChoiceBox<Character> c23;
	@FXML
	ChoiceBox<Character> c24;
	@FXML
	ChoiceBox<Character> c25;
	@FXML
	ChoiceBox<Character> c26;
	@FXML
	ChoiceBox<Character> c27;
	@FXML
	ChoiceBox<Character> c28;
	@FXML
	ChoiceBox<Character> c29;
	@FXML
	ChoiceBox<Character> c30;
	@FXML
	ChoiceBox<Character> c31;
	@FXML
	ChoiceBox<Character> c32;
	@FXML
	ChoiceBox<Character> c33;
	@FXML
	ChoiceBox<Character> c34;
	@FXML
	ChoiceBox<Character> c35;
	@FXML
	ChoiceBox<Character> c36;
	@FXML
	ChoiceBox<Character> c37;
	@FXML
	ChoiceBox<Character> c38;
	@FXML
	ChoiceBox<Character> c39;
	@FXML
	ChoiceBox<Character> c40;
	@FXML
	ChoiceBox<Character> c41;
	@FXML
	ChoiceBox<Character> c42;
	@FXML
	ChoiceBox<Character> c43;
	@FXML
	ChoiceBox<Character> c44;
	
	
	public Button createDisabledButton()
	{
		Button temp = new Button();
		
		temp.setDisable(true);;
		
		return temp;
	}
	
	//Fonction qui initialise tout les menu deroulants avec les caractères autorisés pour la grille 
	public void setChoiceBoxes() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		
		List<Character> tempList = new ArrayList<Character>();
		
		tempList.add(' ');
		for(char c:this.s.getGrille().getAutorise())
		{
			tempList.add(c);
		}
		ObservableList<Character> availableChoices = FXCollections.observableArrayList(tempList); 
		 
	
		for(int i = 1;i<=44;i++)
		{
			Field f = this.getClass().getDeclaredField("c"+i);
			f.setAccessible(true);
			ChoiceBox<Character> choiceBox = (ChoiceBox<Character>) f.get(this);
			ChoiceBox<Character> temp = choiceBox;
			
			temp.setItems(availableChoices);
		}
	}
	
	
	public boolean errAlert() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		for(int i = 1;i<=44;i++)
		{
			Field f = this.getClass().getDeclaredField("c"+i);
			f.setAccessible(true);
			ChoiceBox<Character> choiceBox = (ChoiceBox<Character>) f.get(this);
			ChoiceBox<Character> temp = choiceBox;

			if(temp.getValue() == null || Character.compare(temp.getValue(),' ')==0)
			{
				Alert al = new Alert(Alert.AlertType.WARNING);
				al.setTitle("Problème Soduku");
				al.setHeaderText("Un oubli ?");
				al.setContentText("Il faut remplir entièrement la grille avant de pouvoir tester !");
				al.showAndWait();
				return false;
			}
		}
		return true;
	}
	
	public void start(ActionEvent event) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		try {
			this.status.setText("");
			this.chances.setText("");

			this.s = new Sudoku("Annexes/Grilles/SudokuChar3.txt");
			this.setChoiceBoxes();
			coordinates = new ArrayList<>(Arrays.asList("00","02","05","08",
					"10","13","14","15","16","17",
					"20","21","26","27","28",
					"31","32","33","35","36","37",
					"40","42","45","46","48",
					"50","51","54","55","57",
					"60","62","66","68",
					"70","71","73","76","78",
					"82","83","85","88"));
			this.launch.setDisable(true);
			this.try_sudo.setDisable(false);
			this.chances.setText("Chances Restantes : "+s.getChance());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void verif(ActionEvent event) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		if(s.getChance()>0)
		{
			outofloop:
			for(int i = 1;i<=44;i++)
			{
					Field f = this.getClass().getDeclaredField("c"+i);
					f.setAccessible(true);
					ChoiceBox<Character> choiceBox =(ChoiceBox<Character>) f.get(this);
					ChoiceBox<Character> temp = choiceBox;
					
					if(this.errAlert())
					{
						if(!s.playCoup(this.coordinates.get(i-1).charAt(0)-'0', this.coordinates.get(i-1).charAt(1)-'0', temp.getValue()))
						{
							s.setChance(s.getChance()-1);
							this.chances.setText("Chances Restantes : "+s.getChance());
							break outofloop;
						}
					}
					else
					{
						break outofloop;
					}			
			}

			if(s.verifAllPlayed())
			{
				status.setText("Gagné !");
				status.setTextFill(Color.ORANGE);
				try_sudo.setDisable(true);
				launch.setDisable(false);
			}
		}
		else 
		{
			status.setText("Perdu !");
			status.setTextFill(Color.RED);
			try_sudo.setDisable(true);
			launch.setDisable(false);
		}
	}
}
