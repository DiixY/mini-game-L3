package games;


import java.io.IOException;
import java.util.ArrayList;


public class Sudoku {

	private GrilleSudoku grille;
	private int chance;
	


	public Sudoku(String fpath) throws IOException
	{
		
		this.grille = new GrilleSudoku(fpath);
		this.chance = 15;
	}


	public boolean verifAllPlayed()
	{
		for(int i = 0;i<9;i++)
		{
			for(int j = 0;j<9;j++)
			{
				if(Character.compare(this.grille.getGrille()[i][j],'0') == 0)
					return false;
			}
		}

		return true;
	}

	public boolean verifLine()
	{
		int count;

		for(char temp:this.grille.getAutorise()) 
		{
			for(int i=0;i<9;i++)
			{
				count = 0;
				for(int j=0;j<9;j++)
				{
					char test = this.grille.getGrille()[i][j];
					if(Character.compare(test,temp) == 0 && count<2)
					{
						count++;
					}
					else if(count > 1) return false;
				}
			}
		}	
		return true;
	}


	public boolean verifRow()
	{
		int count;

		for(char temp:this.grille.getAutorise()) 
		{
			for(int i=0;i<9;i++)
			{
				count = 0;
				for(int j=0;j<9;j++)
				{
					char test = this.grille.getGrille()[j][i];
					if(Character.compare(test,temp) == 0 && count<2)
					{
						count++;
					}
					else if(count > 1) return false;
				}
			}
		}	
		return true;
	}


	//Verification Region :
	public char[] createRegionArray(int l, int r)
	{
		char[] res = new char[9];
		int count = 0;

		for(int i = l; i<l+3;i++)
		{
			for(int j = r; j<r+3;j++)
			{
				res[count] = this.grille.getGrille()[i][j];
				count ++;
			}
		}

		return res;
	}

	public boolean verifRegion()
	{
		ArrayList<char[]> listR = new ArrayList<char[]>();

		for (int m=0; m<9; m+=3)
		{
			for (int n=0; n<3; n+=3)
			{
				listR.add(createRegionArray(m,n));
			}
		}

		for(char[] temp:listR)
		{
			for (int m=0; m<9; m++)
			{
				for (int n= m+1; n<9; n++)
				{
					if(temp[m]!='0' && temp[n] != '0')
					{
						if(Character.compare(temp[m], temp[n]) == 0)
						{
							return false;
						}
					}
				}
			}
		}
		return true;
	}


	public boolean verifUnic()
	{
		if(verifRow() && verifLine() && verifRegion())
			return true;
		else return false;
	}
	
	public boolean isAutorized(char c)
	{
		for(char test:this.grille.getAutorise())
		{
			if(Character.compare(c, test) == 0)
				return true;
		}
		return false;
	}

	public void displayGrid()
	{
		for(int i = 0;i<9;i++)
		{
			System.out.println("--------------------------");
			for(int j = 0;j<9;j++)
			{
				System.out.print("|"+this.grille.getGrille()[i][j]+"|");
			}
			System.out.println();
			System.out.println("--------------------------");
		}
	}

	public boolean playCoup(int x,int y,char coup)
	{
		char temp;


		if(x>=0 && x<=8 && y>=0 && y<=8)
		{
			if(isAutorized(coup) && Character.compare(this.grille.getGrille()[x][y], '0') == 0)
			{
				temp = this.grille.getGrille()[x][y];
				this.grille.getGrille()[x][y] = coup;
				if(!verifUnic())
				{
					this.grille.getGrille()[x][y] = temp;
					return false;
				}
			}
		}
		
		return true;
	}



	public int getChance() {
		return chance;
	}


	public void setChance(int chance) {
		this.chance = chance;
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
}
