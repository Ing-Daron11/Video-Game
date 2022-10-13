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
		level = new Level[SIZE_OF_LEVELS];
		level[0] = new Level("1", 10);
		level[1] = new Level("2", 15);
		level[2] = new Level("3", 20);
		level[3] = new Level("4", 25);
		level[4] = new Level("5", 30);
		level[5] = new Level("6", 35);
		level[6] = new Level("7", 40);
		level[7] = new Level("8", 45);
		level[8] = new Level("9", 50);
		level[9] = new Level("10", 55);
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

	public int searchLevelById(String numLevel){
		int pos = -1;
		boolean sw = false;
		for (int i = 0; i <SIZE_OF_LEVELS && !sw; i++){
			if(level[i].getId().equalsIgnoreCase(numLevel)){
				pos = i;
				sw = true;
			}
		}
		return pos;
	}

	public String addTreasureToLevel(String name, String image, String numLevel){
		Treasure newTreasure = new Treasure(name, image, numLevel);
		String msj = "The level wasn't found";
		int posLevel = searchLevelById(numLevel);
		if(posLevel != -1){
			msj = level[posLevel].addTreasureWithObject(newTreasure);
		}
		return msj;
	}

	public String addEnemyToLevel(String idName, int scoreRemove, int scoreGive, String numLevel){
		Enemy newEnemy = new Enemy(idName, scoreRemove, scoreGive, numLevel);
		String msj = "The level wasn't found.";
		int posLevel = searchLevelById(numLevel);
		if (posLevel !=-1){
			msj = level[posLevel].addEnemyWithObject(newEnemy);
		}
		return msj;
	}

}