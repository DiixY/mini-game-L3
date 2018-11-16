package games;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GrilleMelee extends Grille {
	
	private String autorise[];
	
	public GrilleMelee(String fpath,int x,int y) throws IOException
	{
		super(x,y,fpath);
		
		File f = new File(fpath);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String temp = br.readLine();
		
		this.autorise = temp.split("-",0);
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
