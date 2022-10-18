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

	/**Constructor
	 */
	public Level(int inId, int inScoreNeeded){
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


	/**This metyhopd allows to add a treasure with the obhject already created.
	 * @param: objectTreasure: Treasure = Its the object already created.
	 * @return: msj: String = It says that the treasure was succefully added or not
	 */
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

	/**This metyhopd allows to add a enemy with the obhject already created.
	 * @param: objectEnemy: Enemy = Its the object already created.
	 * @return: msj: String = It says that the enemy was succefully added or not
	 */
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

	/**This method allows to list the enemies of one level
	 * @return: msj: String = it conytains the information of the enemies
	 */
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

	/**This method allows to list the treasures of one level
	 * @return: msj: String = it conytains the information of the treasures
	 */
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

	/**This method allows to count the amount of units of a specific treasure in one level.
	 * @param: typeTreasure: int = It contains the type of the treasure that is going to be searched
	 * @return: counter: int = It contains the units of the treasure searched.
	 */
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

	/**This method allows to count the amount of units of a specific enemy in one level.
	 * @param: typeEnemy: int = It contains the type of the enemy that is going to be searched
	 * @return: counter: int = It contains the units of the enemy searched.
	 */
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

	/**This method allows to find the enemy with the hieghes score
	 * @param: none
	 * @return: highestScore: int = It contains the hieghest score of the enemy.
	 */
	public int enemyWhithHighestScoreInt(){
		int highestScore = 0;
		for(int i = 0; i< SIZE_OF_ENEMIES; i++){
			if(enemy[i] != null){
				if(enemy[i].getScoreGive() > highestScore){
					highestScore = enemy[i].getScoreGive();
				}
			}
		}
		return highestScore;
	}

	/**This method allows to obtain the name of the enemy with the hieghest score based on his score.
	 * @param: scoreGive: int = It contains the score of the enemy with the hieghest score
	 * @return: msj: String = It contais name of this enemy
	 */
	public String getEnemyName(int scoreGive){
		String msj = "";
		boolean sw = false;
		for(int i = 0; i < SIZE_OF_ENEMIES && !sw; i ++){
			if(scoreGive == enemy[i].getScoreGive()){
				sw = true;
				if(enemy[i].getOnlyTypeEnemy() == 0){
					msj = "OGRE";
				}else if(enemy[i].getOnlyTypeEnemy() == 1){
					msj = "ABSTRACT";
				}else if(enemy[i].getOnlyTypeEnemy() == 2){
					msj = "BOSS";
				}else{
					msj = "MAGIC";
				}
			}
		}
		return msj;
	}

	/**This method allows to count the consonants of the names of the enemies in the game.
	 * @param: none.
	 * @return: counter: int = It Contains the number 
	 */
	public int showConsonantsOfEnemies(){
		int counter = 0;
		for(int i = 0; i < SIZE_OF_ENEMIES; i++){
			if(enemy[i] != null){
				if(enemy[i].getOnlyTypeEnemy() == 0){
				counter += 2;
				}else if(enemy[i].getOnlyTypeEnemy() == 1){
					counter += 6;
				}else if(enemy[i].getOnlyTypeEnemy() == 2){
					counter += 3;
				}else{
					counter += 3;
				}
			}
			
		}
		return counter;
	}
		
	//Getters and setters
	public int getId(){
		return id;
	}

	public int getScoreNeeded(){
		return scoreNeeded;
	}

}