import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int compt=0;
		String word="";
		int ligne=256129;
		
		File f = new File("Annexes","Dictionary.txt");
		if(f.exists()) {
			try{
				InputStream flux=new FileInputStream(f); 
				InputStreamReader lecture=new InputStreamReader(flux);
				BufferedReader buff=new BufferedReader(lecture);
				while (compt<(ligne-1)){
					compt++;
					buff.readLine();
				}
				word = buff.readLine();
				buff.close(); 
				}		
				catch (Exception e){
				System.out.println(e.toString());
				}

		} 
		else{
			System.out.println("Fichier introuvable");
		}

		 System.out.println(word);
		
	}

}
