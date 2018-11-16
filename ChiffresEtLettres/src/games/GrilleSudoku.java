package games;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GrilleSudoku extends Grille {
	
	private char autorise[];
	
	public GrilleSudoku(String fpath) throws IOException
	{
		super(10,9,fpath);
		File f = new File(fpath);
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String temp = br.readLine();
		
		this.autorise = temp.toCharArray();
	}

	/**
	 * @return the autorise
	 */
	public char[] getAutorise() {
		return autorise;
	}

	/**
	 * @param autorise the autorise to set
	 */
	public void setAutorise(char[] autorise) {
		this.autorise = autorise;
	}
	
	

}
