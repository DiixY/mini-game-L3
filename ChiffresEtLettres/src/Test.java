import java.io.File;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			File f = new File("Annexes/Grilles/Sudoku1.txt");
			Grille g = new Grille(10,9,f);
			System.out.println(Arrays.deepToString(g.getGrille()));
	}

}
