package model;

import java.lang.Math;

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
		treasure = new Treasure[SIZE_OF_TREASURES]; //int type, String image, int numLevel
		treasure[0] = new Treasure((int)(Math.random() *4),"https://assets.stickpng.com/images/589b24bd2096a705e895cd7b.png", (int)(Math.random() *10));
		treasure[1] = new Treasure((int)(Math.random() *4),"https://assets.stickpng.com/images/589b24bd2096a705e895cd7b.png", (int)(Math.random() *10));
		treasure[2] = new Treasure((int)(Math.random() *4),"https://assets.stickpng.com/images/589b24bd2096a705e895cd7b.png", (int)(Math.random() *10));
		treasure[3] = new Treasure((int)(Math.random() *4),"https://assets.stickpng.com/images/589b24bd2096a705e895cd7b.png", (int)(Math.random() *10));
		treasure[4] = new Treasure((int)(Math.random() *4),"https://assets.stickpng.com/images/589b24bd2096a705e895cd7b.png", (int)(Math.random() *10));
		enemy = new Enemy[SIZE_OF_ENEMIES];
		enemy[0] = new Enemy((int)(Math.random() *4), (int)(Math.random() *10), (int)(Math.random() *10), (int)(Math.random() *10));
		enemy[1] = new Enemy((int)(Math.random() *4), (int)(Math.random() *10), (int)(Math.random() *10), (int)(Math.random() *10));
		enemy[2] = new Enemy((int)(Math.random() *4), (int)(Math.random() *10), (int)(Math.random() *10),  (int)(Math.random() *10));
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

	public int countSpecificTreasure(int typeTreasure){
		int counter = 0;
		for (int i = 0;i < SIZE_OF_TREASURES;i++){
			if(treasure[i] != null){ 
				if(treasure[i].getOnlyTypeTreasure() == typeTreasure){
				counter++;
				}
			}
			
		}
		return counter;
	}

	public int countSpecificEnemy(int typeEnemy){
		int counter = 0;
		for (int i = 0; i < SIZE_OF_ENEMIES;i++){
			if(enemy[i] != null){
				if(enemy[i].getOnlyTypeEnemy()== typeEnemy){
					counter++;
				}
				
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