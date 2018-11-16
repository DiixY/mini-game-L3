package games;

import java.io.File;

public class Sudoku {
	
	private Grille grille;
	
	
	public Sudoku(String fpath)
	{
		File f = new File(fpath);
		this.grille = new Grille(10,9,f);
	}

}
