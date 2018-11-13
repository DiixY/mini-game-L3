package ui;

import java.net.URL;
import java.util.Arrays;
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
	void startGame(ActionEvent event)
	{
		start.setDisable(true);
		A.setDisable(false);
		B.setDisable(false);
		C.setDisable(false);
		D.setDisable(false);
		E.setDisable(false);
		F.setDisable(false);
		G.setDisable(false);
		H.setDisable(false);
		I.setDisable(false);
		J.setDisable(false);
		K.setDisable(false);
		L.setDisable(false);
		M.setDisable(false);
		N.setDisable(false);
		O.setDisable(false);
		P.setDisable(false);
		Q.setDisable(false);
		R.setDisable(false);
		S.setDisable(false);
		T.setDisable(false);
		U.setDisable(false);
		V.setDisable(false);
		W.setDisable(false);
		X.setDisable(false);
		Y.setDisable(false);
		Z.setDisable(false);
		
		status.setText("");
		chances.setText("");
		p = new Pendu();
		word.setText(String.valueOf(p.getProgW()));
		chances.setText("Chance(s) restante(s) : "+ p.getCuTry());
		
	}
	
	
	public void playCar(char c)
	{
		if(p.pendu_game(c))
		{
			word.setTextAlignment(TextAlignment.CENTER);
			word.setText(String.valueOf(p.getProgW()));
			if(p.getEnd()==true)
			{
				status.setText("Gagné !");
				status.setTextFill(Color.ORANGE);
				start.setDisable(false);
			}
			else if(p.getEnd() == false && p.getCuTry()<1)
			{
				status.setText("Perdu !");
				status.setTextFill(Color.RED);
				start.setDisable(false);
			}
		}
		else
		{
			chances.setText("Chance(s) restante(s) : "+ p.getCuTry());
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
	
	
	
	
	@FXML
	public void playCarA(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('A');
		}
		else
		{
			this.playCar('A');
			A.setDisable(true);
		}	
	}
	
	@FXML
	public void playCarB(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('B');
		}
		else
		{
			this.playCar('B');
			B.setDisable(true);
		}	
	}
	
	@FXML
	void playCarC(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('C');
		}
		else
		{
			this.playCar('C');
			C.setDisable(true);
		}	
	}
	
	@FXML
	void playCarD(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('D');
		}
		else
		{
			this.playCar('D');
			D.setDisable(true);
		}	
	}
	
	@FXML
	void playCarE(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('E');
		}
		else
		{
			this.playCar('E');
			E.setDisable(true);
		}
	}
	
	@FXML
	void playCarF(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('F');
		}
		else
		{
			this.playCar('F');
			F.setDisable(true);
		}
	}
	
	@FXML
	void playCarG(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('G');
		}
		else
		{
			this.playCar('G');
			G.setDisable(true);
		}
	}
	
	@FXML
	void playCarH(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('H');
		}
		else
		{
			this.playCar('H');
			H.setDisable(true);
		}
	}
	
	@FXML
	void playCarI(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('I');
		}
		else
		{
			this.playCar('I');
			I.setDisable(true);
		}
	}
	
	@FXML
	void playCarJ(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('J');
		}
		else
		{
			this.playCar('J');
			J.setDisable(true);
		}
	}
	
	@FXML
	void playCarK(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('K');
		}
		else
		{
			this.playCar('K');
			K.setDisable(true);
		}
	}
	
	@FXML
	void playCarL(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('L');
		}
		else
		{
			this.playCar('L');
			L.setDisable(true);
		}	
	}
	
	@FXML
	void playCarM(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('M');
		}
		else
		{
			this.playCar('M');
			M.setDisable(true);
		}
	}
	
	@FXML
	void playCarO(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('O');
		}
		else
		{
			this.playCar('O');
			O.setDisable(true);
		}	
	}
	
	@FXML
	void playCarP(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('P');
		}
		else
		{
			this.playCar('P');
			P.setDisable(true);
		}
	}
	
	@FXML
	void playCarQ(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('Q');
		}
		else
		{
			this.playCar('Q');
			Q.setDisable(true);
		}
	}
	
	@FXML
	void playCarR(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('R');
		}
		else
		{
			this.playCar('R');
			R.setDisable(true);
		}
	}
	
	@FXML
	void playCarS(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('S');
		}
		else
		{
			this.playCar('S');
			S.setDisable(true);
		}
	}
	
	@FXML
	void playCarT(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('T');
		}
		else
		{
			this.playCar('T');
			T.setDisable(true);
		}
	}
	
	@FXML
	void playCarU(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('U');
		}
		else
		{
			this.playCar('U');
			U.setDisable(true);
		}
	}
	
	@FXML
	void playCarV(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('V');
		}
		else
		{
			this.playCar('V');
			V.setDisable(true);
		}
	}
	
	@FXML
	void playCarW(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('W');
		}
		else
		{
			this.playCar('W');
			W.setDisable(true);
		}
	}
	
	@FXML
	void playCarX(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('X');
		}
		else
		{
			this.playCar('X');
			X.setDisable(true);
		}
	}
	
	@FXML
	void playCarY(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('Y');
		}
		else
		{
			this.playCar('Y');
			Y.setDisable(true);
		}
	}
	
	@FXML
	void playCarN(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('N');
		}
		else
		{
			this.playCar('N');
			N.setDisable(true);
		}
	}
	
	@FXML
	void playCarZ(ActionEvent event)
	{
		if(p == null)
		{
			this.errAlert('Z');
		}
		else
		{
			this.playCar('Z');
			Z.setDisable(true);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
