package games;

import java.io.File;
import java.io.IOException;

public class Sudoku {
	
	private GrilleSudoku grille;
	
	
	public Sudoku(String fpath) throws IOException
	{
		File f = new File(fpath);
		this.grille = new GrilleSudoku(fpath);
	}


	/**
	 * @return the grille
	 */
	public GrilleSudoku getGrille() {
		return grille;
	}


	/**
	 * @param grille the grille to set
	 */
	public void setGrille(GrilleSudoku grille) {
		this.grille = grille;
	}
	
	/*public boolean verifLine()
	{
		for(int i=0;i<9;i++)
		{
			if()
		}
	}*/

	
	
}
