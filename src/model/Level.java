package model;
public class Level{
	
	private String id;
	private int scoreNeeded;
	//private difficultyLevel difficulty;

	private Treasure[] treasure;
	private Enemy[] enemy;

	public static final int SIZE_OF_TREASURES = 10;//por nivel
	public static final int SIZE_OF_ENEMIES = 10; //por nivel

	public Level(String inId, int inScoreNeeded){ //Constructor
		id = inId;
		scoreNeeded = inScoreNeeded;
		//difficulty = ...;
		treasure = new Treasure[SIZE_OF_TREASURES];
		enemy = new Enemy[SIZE_OF_ENEMIES];
	}

	public String addTreasureWithObject(Treasure objectTreasure){
		String msj = "Maximun capacity reached";
		boolean sw = false;
		for(int i = 0; i < SIZE_OF_TREASURES && !sw; i++){
			if(treasure[i] == null){
				treasure[i] = objectTreasure;
				sw = true;
				msj = "The treasure was added succesfully";
				
			}
		}
		return msj;
	}

	public String addEnemyWithObject(Enemy objectEnemy){
		String msj = "Maximun capacity reached";
		boolean sw = false;
		for(int i = 0; i <SIZE_OF_ENEMIES && !sw; i++){
			if(enemy[i] == null){
				enemy[i] = objectEnemy;
				sw = true;
				msj = "The enemy was added succesfully";
			}
		}
		return msj;
	}

	public String getId(){
		return id;
	}


}