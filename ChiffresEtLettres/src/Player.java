public class Player {
	
	//Attributs
		//Identité
	private String nom;			//Nom joueur
	private String prenom;		//Prénom joueur
	
		//Scores
	private int scoreG;			//Score général
	private int scoreSud;		//Score Sudoku 1-9
	private int scoreSudAZ;		//Score Sudoku A-Z
	private int scoreMotMel;	//Score Mots-Mêlés
	private int scorePen;		//Score Pendu
	private int scoreMotus;		//Score Motus
	
		//Nombre de parties
	private int nbPartG;		//Nombre de parties total
	private int nbPartSud;		//Score Sudoku 1-9
	private int nbPartSudAZ;	//Score Sudoku A-Z
	private int nbPartMotMel;	//Score Mots-Mêlés
	private int nbPartPen;		//Score Pendu
	private int nbPartMotus;	//Score Motus
	

	
	//Constructeurs
	public Player(String nom, String prenom,
				int scoreG, int scoreSud, int scoreSudAZ, int scoreMotMel, int scorePen, int scoreMotus,
				int nbPartG, int nbPartSud, int nbPartSudAZ, int nbPartMotMel, int nbPartPen, int nbPartMotus) {
		
		//Initialisation Identité
		this.nom = nom;
		this.prenom = prenom;
		
		//Initialisation Scores
		this.scoreG = scoreG;
		this.scoreSud = scoreSud;
		this.scoreSudAZ = scoreSudAZ;
		this.scoreMotMel = scoreMotMel;
		this.scorePen = scorePen;
		this.scoreMotus = scoreMotus;
		
		//Initialisation nombre Parties
		this.nbPartG = nbPartG;
		this.nbPartSud = nbPartSud;
		this.nbPartSudAZ = nbPartSudAZ;
		this.nbPartMotMel = nbPartMotMel;
		this.nbPartPen = nbPartPen;
		this.nbPartMotus = nbPartMotus;
	}

	public Player(String nom, String prenom) {
	
		//Initialisation Identité
		this.nom = nom;
		this.prenom = prenom;
		
		//Initialisation Scores
		this.scoreG = 0;
		this.scoreSud = 0;
		this.scoreSudAZ = 0;
		this.scoreMotMel = 0;
		this.scorePen = 0;
		this.scoreMotus = 0;
		
		//Initialisation nombre Parties
		this.nbPartG = 0;
		this.nbPartSud = 0;
		this.nbPartSudAZ = 0;
		this.nbPartMotMel = 0;
		this.nbPartPen = 0;
		this.nbPartMotus = 0;
}
	

	
	//Méthodes
	public Player create_new_player(String nom, String prenom) {
		Player new_P = new Player(nom, prenom);
		return new_P;
	}
	
	//Getters & Setters
	public int getScoreG() {
		return scoreG;
	}

	public void setScoreG(int scoreG) {
		this.scoreG = scoreG;
	}

	public int getScoreSud() {
		return scoreSud;
	}

	public void setScoreSud(int scoreSud) {
		this.scoreSud = scoreSud;
	}

	public int getScoreSudAZ() {
		return scoreSudAZ;
	}

	public void setScoreSudAZ(int scoreSudAZ) {
		this.scoreSudAZ = scoreSudAZ;
	}

	public int getScoreMotMel() {
		return scoreMotMel;
	}

	public void setScoreMotMel(int scoreMotMel) {
		this.scoreMotMel = scoreMotMel;
	}

	public int getScorePen() {
		return scorePen;
	}

	public void setScorePen(int scorePen) {
		this.scorePen = scorePen;
	}

	public int getScoreMotus() {
		return scoreMotus;
	}

	public void setScoreMotus(int scoreMotus) {
		this.scoreMotus = scoreMotus;
	}

	public int getNbPartG() {
		return nbPartG;
	}

	public void setNbPartG(int nbPartG) {
		this.nbPartG = nbPartG;
	}

	public int getNbPartSud() {
		return nbPartSud;
	}

	public void setNbPartSud(int nbPartSud) {
		this.nbPartSud = nbPartSud;
	}

	public int getNbPartSudAZ() {
		return nbPartSudAZ;
	}

	public void setNbPartSudAZ(int nbPartSudAZ) {
		this.nbPartSudAZ = nbPartSudAZ;
	}

	public int getNbPartMotMel() {
		return nbPartMotMel;
	}

	public void setNbPartMotMel(int nbPartMotMel) {
		this.nbPartMotMel = nbPartMotMel;
	}

	public int getNbPartPen() {
		return nbPartPen;
	}

	public void setNbPartPen(int nbPartPen) {
		this.nbPartPen = nbPartPen;
	}

	public int getNbPartMotus() {
		return nbPartMotus;
	}

	public void setNbPartMotus(int nbPartMotus) {
		this.nbPartMotus = nbPartMotus;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
}