package games;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GrilleSudoku extends Grille {
	
	private char autorise[];
	
	public GrilleSudoku(String fpath) throws IOException
	{
		super(10,9,fpath);
		/*Ligne pour lire des fichiers dans un .jar
		InputStream flux=getClass().getResourceAsStream("/"+fpath);
		InputStreamReader lecture=new InputStreamReader(flux);*/
		
		File f = new File(fpath);
		FileReader lecture = new FileReader(f);
		BufferedReader br = new BufferedReader(lecture);
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
