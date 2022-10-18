package model;
import java.util.Arrays;

public class Videogame{
	
	public static final int SIZE_OF_PLAYERS = 30;
	public static final int SIZE_OF_LEVELS = 10;
	public static final int SIZE_OF_PLAYERSSCORE = 30;

	private Player[] player;
	private Level[] level;
	private int[] playerScore;
	private Treasure treasure;
	private Enemy enemy;

	public Videogame(){
		player = new Player[SIZE_OF_PLAYERS];
		player[0] = new Player("111", "Vojaabes");
		player[1] = new Player("112", "Marcos");
		player[2] = new Player("113", "Malking");
		player[3] = new Player("114", "Plaxazs");
		player[4] = new Player("115", "Marcus");
		player[5] = new Player("116", "Nathan");
		player[6] = new Player("117", "MarcoPolo");
		player[7] = new Player("118", "Drake");
		player[8] = new Player("119", "Atreus");
		player[9] = new Player("120", "Eminem");
		player[10] = new Player("121", "Casta");
		player[11] = new Player("122", "ElPillo");
		player[12] = new Player("123", "ElGordo");
		player[13] = new Player("124", "Jaime");
		player[14] = new Player("125", "Disgusting");
		player[15] = new Player("126", "Fisherman");
		player[16] = new Player("127", "Me");
		player[17] = new Player("128", "Marry");
		player[18] = new Player("129", "Nicely");
		player[19] = new Player("130", "WellDone");
		player[20] = new Player("131", "StillAlive");
		level = new Level[SIZE_OF_LEVELS];
		level[0] = new Level(1, 10);
		level[1] = new Level(2, 15);
		level[2] = new Level(3, 20);
		level[3] = new Level(4, 25);
		level[4] = new Level(5, 30);
		level[5] = new Level(6, 35);
		level[6] = new Level(7, 40);
		level[7] = new Level(8, 45);
		level[8] = new Level(9, 50);
		level[9] = new Level(10, 55);
	}

	public void initPlayerScore(){
		playerScore = new int[SIZE_OF_PLAYERSSCORE];
		for(int i = 0; i <SIZE_OF_PLAYERSSCORE; i++){
			if(player[i] != null){
				playerScore[i] = player[i].getScore();
			}
		}
	}

	/** This method allows to add a player to the videogame
	 * @param: id: String = It represents the id of the player
	 * @param: nickname: String = it is the name or nickname of the player
	 * @return: msj: String = It says if the player was added or cannot be added due to a lack of space 
	 */
	public String addPlayer(String id, String nickname){
		Player newPlayer = new Player(id, nickname);
		String msj = "Maximun capacity reached";
		boolean sw = false;
		for (int i = 0; i <SIZE_OF_PLAYERS && !sw ;i++){
			if(player[i] == null){
				player[i] = newPlayer;
				sw = true;
				msj = "The new player was added succesfully";
			}	
		}
		return msj;
	}

	/**This method allows to look for a level by its id
	 * @param: numLevel: int = it represents the level
	 * @return: pos: int = it contains the position of the level or if the level does not exist, it will contain -1
	 */
	public int searchLevelById(int numLevel){
		int pos = -1;
		boolean sw = false;
		for (int i = 0; i <=SIZE_OF_LEVELS && !sw; i++){
			if(level[i].getId() == (numLevel)){
				pos = i;
				sw = true;
			}
		}
		return pos;
	}

	/**This method allows to add a treasure to level selected by the user.
	 * @param: type: int = it cointain the type of the treasure.
	 * @param: image: String = It contais an URL of a image of the treasure.
	 * @param: numLevel: int = 	It contains the level where is going to be added the treasure.
	 * @return: msj: String = It contains a massage that says if the level wasn't found or if it was succesfully added.
	 */
	public String addTreasureToLevel(int type, String image, int numLevel){
		Treasure newTreasure = new Treasure(type, image, numLevel);
		String msj = "The level wasn't found";
		int posLevel = searchLevelById(numLevel);
		if(posLevel != -1){
			msj = level[posLevel].addTreasureWithObject(newTreasure);
		}
		return msj;
	}

	/**This method allows to add a enemy to a level selected by the user.
	 * @param: type: int = it contains the type of the enemy
	 * @param: scoreRemove: int = it contains the score that removes in case if it wins
	 * @param: scoreGive: int = it contains the score that gives in case if it looses.
	 * @param: numLevel: int = 	It contains the level where is going to be added the enemy.
	 * @return: msj: String = it contains a massage that says if the level wasn't found or if it was succesfully added.
	 */
	public String addEnemyToLevel(int type, int scoreRemove, int scoreGive, int numLevel){
		Enemy newEnemy = new Enemy(type, scoreRemove, scoreGive, numLevel);
		String msj = "The level wasn't found.";
		int posLevel = searchLevelById(numLevel);
		if (posLevel !=-1){
			msj = level[posLevel].addEnemyWithObject(newEnemy);
		}
		return msj;
	}

	/**This method allows to look for a player by its id
	 * @param: idPlayer: String = It contains thhe id of the player.
	 * @return: pos: int = it represents the position of the player or -1 if it wasn't found
	 */
	public int searchPlayerById(String idPlayer){
		int pos = -1;
		boolean sw = false;
		for(int i = 0; i < SIZE_OF_PLAYERS && !sw; i++){
			if(player[i] != null){
				if(player[i].getId().equalsIgnoreCase(idPlayer)){
				pos = i;
				sw = true;
				}
			}
			
		}
		return pos;
	}

	/**This method allows to pass a player to the next level.
	 * @param: idPlayer: String = it cointains the id of the player.
	 * @return: msj: String = It says if the player does not exist, how many points are left to pass the level or just say that pass to the next level 
	 */
	public String levelUpPlayer(String idPlayer){
		String msj = "";
		int pos = searchPlayerById(idPlayer);
		if(pos == -1){
			msj = "The player does not exist";
		}else {
			int numLevelPlayer = player[pos].getLevel();
			int numScorePlayer = player[pos].getScore();
			if(numLevelPlayer ==9){
				msj = "Maximun level reached";
			}else if(level[numLevelPlayer+1].getScoreNeeded() <= numScorePlayer){
				player[pos].setLevel(numLevelPlayer+1);
				msj = "The player '" + player[pos].getNickname() + "'' is now in the level: " + (player[pos].getLevel()+1) + "."; 
				}else{
					msj = "The player '" + player[pos].getNickname() + "'' is missing: " + ((level[numLevelPlayer+1].getScoreNeeded()) - (numScorePlayer)) + " points to pass to the next level";
				}
			
		}
		return msj;
	}

	/**This method allows to increase the score of the player
	 * @param: idPlayer: String = it contains the id of the player
	 * @param: inNewScore: int = it represents the score that is going to be added to the previous score
	 * @return: msj: String = It says if the player does not exist or what is the new score.
	 */
	public String modifyPlayerScore(String idPlayer, int inNewScore){
		String msj = "";
		int pos = searchPlayerById(idPlayer);
		if (pos == -1){
			msj = "The player does not exist";
		}else{
			player[pos].setScore(inNewScore);
			msj = "The new score of the player '" + player[pos].getNickname() + "' is now: " + player[pos].getScore() + ".";
		}
		return msj;
	}

	/**This method allows to know the information of the player
	 * @param: idPlayer: String = It's the id of the player
	 * @return: msj. String = It says if the player does not exist or what is the actual score.
	 */
	public String statusPlayer(String idPlayer){
		String msj = "";
		int pos = searchPlayerById(idPlayer);
		if (pos == -1){
			msj = "The player does not exist.";
		}else{
			msj = msj = "The current score of the player is: " + player[pos].getScore() + ". \n";
		}
		return msj;
	}

	/**This method allows to list the enemies of a level
	 * @param: numLevel: int = it represents the level.
	 * @return: msj: String = It says if the level exist or the information of the enemies of that level
	 */
	public String listEnemiesOfALevel(int numLevel){
		String msj = "";
		int posLevel = searchLevelById(numLevel);
		if (posLevel == -1){
			msj = "The level does not exist";
		}else{
			msj = level[posLevel].listEnemies();
		}
		return msj;
	}

	/**This method allows to list the treasures of a level
	 * @param: numLevel: int = it represents the level.
	 * @return: msj: String = It says if the level exist or the information of the treasures of that level
	 */
	public String listTreasuresOfALevel(int numLevel){
		String msj = "";
		int posLevel = searchLevelById(numLevel);
		if (posLevel == -1){
			msj = "The level does not exist";
		}else{
			msj = level[posLevel].listTreasures();
		}
		return msj;
	}

	/**This method allows to count a type of a tresure in all levels
	 * @param: typeTreasure: int = It is the type of the treasure that is going to be searched.
	 * @return: msj: String = It says the amount of treasures found.
	 */
	public String countTreasureOfAllLevels(int typeTreasure){
		String msj = "";
		int counter = 0;
		for (int i = 0; i < SIZE_OF_LEVELS;i++){
			counter += level[i].countSpecificTreasure(typeTreasure);
		}
		msj = "The amount of this treasure in all levels are: " + counter + ".";
		return msj;
	}

	/**This method allows to count a type of a enemy in all levels
	 * @param: typeEnemy: int = It is the type of the enemy that is going to be searched.
	 * @return: msj: String = It says the amount of enemies found.
	 */
	public String countEnemieOfAllLevels(int typeEnemy){
		String msj = "";
		int counter = 0;
		for (int i = 0; i < SIZE_OF_LEVELS; i++){
			counter += level[i].countSpecificEnemy(typeEnemy);
		}
		msj = "The amount of this enemie in all levels are: " + counter + ".";
		return msj;
	}

	/**	this method allows to validate if a level exist
	 * @param: numLevel: int = 	it is the level that is going to be validated
	 * @return: levelExist: boolean = True if yes or False if not exist.
	 */
	public boolean validateLevelExist(int numLevel){
		boolean levelExist = false;
		if(numLevel >=0 && numLevel <=9){
			levelExist = true;
		}
		return levelExist;
	}

	/**	this method allows to validate if the option is correct
	 * @param: option: int = it is the number that is going to be validated
	 * @return: isOptionCorrect: boolean = True if yes or False if not.
	 */
	public boolean validateCorrectOption(int option){
		boolean isOptionCorrect = false;
		if(option >=0 && option <=3){
			isOptionCorrect = true;
		}
		return isOptionCorrect;
	}

	/** This method allows to show the most repeated treasure in all levels
	 * @param: none
	 * @return: msj: String = It contains the name of the most repeated treasure.
	 */
	public String mostRepeatedTreasure(){
		String msj1 = "";
		String msj2 = "";
		int counter0 = 0;
		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;
		int semifinalist1 = 0;
		int semifinalist2 = 0;

		for (int i = 0; i < SIZE_OF_LEVELS;i++){
			counter0 += level[i].countSpecificTreasure(0);
			counter1 += level[i].countSpecificTreasure(1);
			counter2 += level[i].countSpecificTreasure(2);
			counter3 += level[i].countSpecificTreasure(3);
		}
		if(counter0 >= counter1){
			semifinalist1 = counter0;
			msj1 = "The most repeated treasure is: RUBY";
		}else{
			semifinalist1 = counter1;
			msj1 = "The most repeated treasure is: EMERALD";
		}
		if (counter2 >= counter3){
			semifinalist2 = counter2;
			msj2 = "The most repeated treasure is: DIAMOD";
		}else{
			semifinalist2 = counter3;
			msj2 = "The most repeated treasure is: COAL";
		}
		if(semifinalist1 > semifinalist2){
			return msj1;
		}else{
			return msj2;
		}
	}

	/**This method allows to know what is the enemy with the highest score that gives
	 * @param: none
	 * @return: msj: String = It contains the name, number and the level of that enemy.
	 */
	public String enemyWhithHighestScoreAllLevels(){
		String msj = "";
		int max = 0;
		int pos = 0;
		for(int i = 0; i< SIZE_OF_LEVELS; i++){
			if(level[i].enemyWhithHighestScoreInt() > max){
				max = level[i].enemyWhithHighestScoreInt();
				pos = i;
			}
		}
		msj	= "The name of the Enemy with the highest Score ("+ max + ") is:"+ level[pos].getEnemyName(max) +" and is located in level: " + level[pos].getId() + ".";
		return msj;
	}

	/**This method allows to show th eamount of consonants of the names of all enemies in the game.
	 * @param: none
	 * @return: msj: String = It says the amount of consonants.
	 */
	public String showConsonantsOfEnemiesInAllLevels(){
		String msj = "";
		int counter = 0;
		for(int i = 0; i < SIZE_OF_LEVELS; i++){
			counter += level[i].showConsonantsOfEnemies();
		}
		msj = "The amount of consonants of the enemies' names in all levels are: " + counter;
		return msj;
	}

	/**This method allows to print the 5 best scores of the players
	 * @param: none
	 *@return: msj: String = It contains the 5 players with their scores.
	 */
	public String printBestFivePlayers(){
		initPlayerScore(); 
		String msj = "";
		bubleSort(playerScore);
		msj = Arrays.toString(playerScore);	
		return msj;
	}

	/**This method allows to order the array of the playesr's scores
	 * @param: playerScore: int[] = It is the array of the playesr's scores
	 * @return: 
	 * 
	 */
	public array bubleSort(int[] playerScore){
		initPlayerScore();
    	for (int i = 0; i < SIZE_OF_PLAYERS; i++){
        	for (int j = 0; j < SIZE_OF_PLAYERS - 1; j++){
            	int elementoActual = playerScore[j],
            	elementoSiguiente = playerScore[j + 1];
          	 	if (elementoActual < elementoSiguiente) {
              	  // Intercambiar
              	  playerScore[j] = elementoSiguiente;
              	  playerScore[j + 1] = elementoActual;
           		}
       	 	}
    	}
    	return playerScore;
	}

}