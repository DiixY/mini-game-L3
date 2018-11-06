import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class Grille {

	private char grille[][];
	private char autorise[];
	private int x,y;

	public Grille(int x,int y,File f) {
		this.x = x;
		this.y = y;
		
		try {
			
			this.autorise = new char[y];
			this.grille = new char[x-1][y];
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String temp = br.readLine();
			for(int i=0;i<y;i++)
			autorise[i] = temp.charAt(i);
			
			for(int i=1;i<x;i++)
			{	
				temp = br.readLine();
				for(int j=0;j<y;j++)
				{
					//System.out.println(temp);
					this.grille[i-1][j] = temp.charAt(j);
				}	
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println ("Le fichier n'a pas �t� trouv�");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println ("Erreur lors de la lecture : " + e.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Grille [grille=" + Arrays.toString(grille) + ", toString()=" + super.toString() + "]";
	}

	/**
	 * @return the grille
	 */
	public char[][] getGrille() {
		return grille;
	}

	/**
	 * @return the autorise
	 */
	public char[] getAutorise() {
		return autorise;
	}

	/**
	 * @param grille the grille to set
	 */
	public void setGrille(char[][] grille) {
		this.grille = grille;
	}

	/**
	 * @param autorise the autorise to set
	 */
	public void setAutorise(char[] autorise) {
		this.autorise = autorise;
	}
	
}
