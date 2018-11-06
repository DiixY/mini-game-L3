package Interfaces;


public interface ITFWordManagement {
	
	public String takeWord();//prend un mot aleatoire dans le dictionnaire
	public boolean checkWord(String WordInDictionnary, String WordToTest);//verifie si le mot est present dans le dictionnaires
	public boolean checkLetter(String word,String LetterToTest);//verifie si la lettre est presente dans le mot
}
