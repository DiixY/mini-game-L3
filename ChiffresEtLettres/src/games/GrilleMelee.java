package games;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GrilleMelee extends Grille {
	
	private String autorise[];
	
	public GrilleMelee(String fpath,int x,int y) throws IOException
	{
		super(x,y,fpath);
		
		
		InputStream flux=getClass().getResourceAsStream("/"+fpath);
		InputStreamReader lecture=new InputStreamReader(flux);
		BufferedReader br = new BufferedReader(lecture);
		String temp = br.readLine();
		
		this.autorise = temp.split("-",0);
		br.close();
	}

	/**
	 * @return the autorise
	 */
	public String[] getAutorise() {
		return autorise;
	}

	/**
	 * @param autorise the autorise to set
	 */
	public void setAutorise(String[] autorise) {
		this.autorise = autorise;
	}
	
	
	

}
