package games;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		GrilleMelee g = new GrilleMelee("Annexes/Grilles/Mots_meles/Fruits.txt",11,10);
		
		
		System.out.println(Arrays.deepToString(g.getGrille()));
		System.out.println(Arrays.toString(g.getAutorise()));

	}

}
