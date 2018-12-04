package games;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class Grille {

	private char grille[][];
	private int x,y;

	public Grille(int x,int y,String fpath) {
		this.x = x;
		this.y = y;
		
		try {
			File f = new File(fpath);
	
			this.grille = new char[x-1][y];
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String temp = br.readLine();
			
			for(int i=1;i<this.x;i++)
			{	
				temp = br.readLine();
				this.grille[i-1] = temp.toCharArray();
			}
			
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println ("Le fichier n'a pas été trouvé");
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
	 * @param grille the grille to set
	 */
	public void setGrille(char[][] grille) {
		this.grille = grille;
	}



	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
}
