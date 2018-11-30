package ui;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
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

public class SudoNum1Controller {
	//Attributes
	Sudoku s;
	ArrayList<String> coordinates;
	
	@FXML 
	Button launch;
	
	@FXML 
	Button try_sudo = this.createDisabledButton();
	
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
	
	public void setChoiceBoxes()
	{
		ObservableList<Character> availableChoices = FXCollections.observableArrayList('1','2','3','4','5','6','7','8','9'); 
		c1.setItems(availableChoices);		
		c2.setItems(availableChoices);		
		c3.setItems(availableChoices);		
		c4.setItems(availableChoices);		
		c5.setItems(availableChoices);		
		c6.setItems(availableChoices);		
		c7.setItems(availableChoices);		
		c8.setItems(availableChoices);		
		c9.setItems(availableChoices);		
		c10.setItems(availableChoices);		
		c11.setItems(availableChoices);		
		c12.setItems(availableChoices);		
		c13.setItems(availableChoices);		
		c14.setItems(availableChoices);		
		c15.setItems(availableChoices);		
		c16.setItems(availableChoices);		
		c17.setItems(availableChoices);		
		c18.setItems(availableChoices);		
		c19.setItems(availableChoices);	
		c20.setItems(availableChoices);		
		c21.setItems(availableChoices);		
		c22.setItems(availableChoices);		
		c23.setItems(availableChoices);	
		c24.setItems(availableChoices);	
		c25.setItems(availableChoices);	
		c26.setItems(availableChoices);	
		c27.setItems(availableChoices);	
		c28.setItems(availableChoices);	
		c29.setItems(availableChoices);	
		c30.setItems(availableChoices);	
		c31.setItems(availableChoices);	
		c32.setItems(availableChoices);	
		c33.setItems(availableChoices);	
		c34.setItems(availableChoices);	
		c35.setItems(availableChoices);	
		c36.setItems(availableChoices);	
		c37.setItems(availableChoices);	
		c38.setItems(availableChoices);	
		c39.setItems(availableChoices);	
		c40.setItems(availableChoices);	
		c41.setItems(availableChoices);	
		c42.setItems(availableChoices);	
		c43.setItems(availableChoices);
		c44.setItems(availableChoices);
	}
	
	public void errAlert()
	{
		Alert al = new Alert(Alert.AlertType.WARNING);
		al.setTitle("Problème Soduku");
		al.setHeaderText("Un oubli ?");
		al.setContentText("Il faut remplir entièrement la grille avant de pouvoir tester !");
		al.showAndWait();
	}
	
	public void start(ActionEvent event)
	{
		try {
			this.status.setText("");
			this.chances.setText("");
			this.s = new Sudoku("Annexes/Grilles/Sudoku1.txt");
			this.setChoiceBoxes();
			coordinates = new ArrayList<>(Arrays.asList("01","03","04","07","08",
														"11","12","14","15","17",
														"22","24","25","27","28",
														"30","32","35","36","38",
														"40","43","44","45","48",
														"50","52","56","58",
														"60","61","63","64","66",
														"71","73","74","76","77",
														"80","81","84","85","87"));
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
					ChoiceBox<Character> choiceBox = (ChoiceBox<Character>) f.get(this);
					ChoiceBox<Character> temp = choiceBox;
					if(temp.getValue() != null)
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
						this.errAlert();
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
