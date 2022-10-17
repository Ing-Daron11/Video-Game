package model;

public class Videogame{
	
	public static final int SIZE_OF_PLAYERS = 30;
	public static final int SIZE_OF_LEVELS = 10;

	private Player[] player;
	private Level[] level;
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

	public String addTreasureToLevel(int type, String image, int numLevel){
		Treasure newTreasure = new Treasure(type, image, numLevel);
		String msj = "The level wasn't found";
		int posLevel = searchLevelById(numLevel);
		if(posLevel != -1){
			msj = level[posLevel].addTreasureWithObject(newTreasure);
		}
		return msj;
	}

	public String addEnemyToLevel(int type, int scoreRemove, int scoreGive, int numLevel){
		Enemy newEnemy = new Enemy(type, scoreRemove, scoreGive, numLevel);
		String msj = "The level wasn't found.";
		int posLevel = searchLevelById(numLevel);
		if (posLevel !=-1){
			msj = level[posLevel].addEnemyWithObject(newEnemy);
		}
		return msj;
	}

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

	public String countTreasureOfAllLevels(int typeTreasure){
		String msj = ""; ////////////////////////////////////////////////////////////
		int counter = 0;
		for (int i = 0; i < SIZE_OF_LEVELS;i++){
			counter += level[i].countSpecificTreasure(typeTreasure);
		}
		msj = "The amount of this treasure in all levels are: " + counter + ".";
		return msj;
	}

	public String countEnemieOfAllLevels(int typeEnemy){
		String msj = "";
		int counter = 0;
		for (int i = 0; i < SIZE_OF_LEVELS; i++){
			counter += level[i].countSpecificEnemy(typeEnemy);
		}
		msj = "The amount of this enemie in all levels are: " + counter + ".";
		return msj;
	}

	public boolean validateLevelExist(int numLevel){
		boolean levelExist = false;
		if(numLevel >=0 && numLevel <=9){
			levelExist = true;
		}
		return levelExist;
	}

	public boolean validateCorrectOption(int option){
		boolean isOptionCorrect = false;
		if(option >=0 && option <=3){
			isOptionCorrect = true;
		}
		return isOptionCorrect;
	}
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
		if(counter0 > counter1){
			semifinalist1 = counter0;
			msj1 = "The most repeated treasure is: RUBY";
		}else{
			semifinalist1 = counter1;
			msj1 = "The most repeated treasure is: EMERALD";
		}
		if (counter2 > counter3){
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

}