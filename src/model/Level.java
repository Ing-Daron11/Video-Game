package model;
public class Level{
	
	private int id;
	private int scoreNeeded;
	//private difficultyLevel difficulty;

	private Treasure[] treasure;
	private Enemy[] enemy;

	public static final int SIZE_OF_TREASURES = 10;//por nivel
	public static final int SIZE_OF_ENEMIES = 10; //por nivel

	public Level(int inId, int inScoreNeeded){ //Constructor
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

	public String listEnemies(){
		String msj = "";
		for(int i = 0; i < SIZE_OF_ENEMIES; i++){
			if(enemy[i] != null){
				msj += "|-----------------------------|\n" +
						"Enemy name: " + enemy[i].getTypeEnemy() + "\n" +
						"Score that removes: " + enemy[i].getScoreRemove() + "\n" +
						"Score that gives: " + enemy[i].getScoreGive() + ". \n";
			}
		}
		return msj;
	}

	public String listTreasures(){
		String msj = "";
		for(int i = 0; i < SIZE_OF_TREASURES; i++){
			if(treasure[i] != null){
				msj += "|-----------------------------| \n" +
						"Treasure name: " + treasure[i].getTypeTreasure() + "\n" +
						"Image: " + treasure[i].getImage() + " \n" +
						"Position : (" + treasure[i].getPosX() + " , " + treasure[i].getPosY() + ") \n";
			}
		}
		return msj;
	}

	public int countTreasures(){
		int counter = 0;
		for (int i = 0;i < SIZE_OF_TREASURES;i++){
			if(treasure[i] != null){
				counter++;
			}
			
		}
		return counter;
	}

	public int countEnemies(){
		int counter = 0;
		for (int i = 0; i < SIZE_OF_ENEMIES;i++){
			if(enemy[i] != null){
				counter++;
			}	
		}
		return counter;
	}

	public int getId(){
		return id;
	}

	public int getScoreNeeded(){
		return scoreNeeded;
	}

}