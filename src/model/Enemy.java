package model;
public class Enemy{
	
	private String idName;
	//private typeOfEEnemy type;
	private int scoreRemove;
	private int scoreGive;
	private String numLevel;


	public Enemy(String inIdName, int inScoreRemove, int inScoreGive, String inNumLevel){
		idName = inIdName;
		scoreRemove = inScoreRemove;
		scoreGive = inScoreGive;
		numLevel = inNumLevel;
		// type = ... (enumeración);
	}

}