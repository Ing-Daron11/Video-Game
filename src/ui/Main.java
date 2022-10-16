package ui;

import java.util.Scanner;
import model.Videogame;

public class Main{

	private Scanner input;
	private Videogame videogame;

	public Main(){ //Constructor
		input = new Scanner(System.in);
		videogame = new Videogame();
	}

	public static void main(String args[]){ //Método main
		Main main = new Main();
		int option = -1; 
			//System.out.println(main.banner()); //para imprimir el dibujito
			do{
				option = main.getOptionShowMenu(); 
				main.executeOption(option);

			}while(option != 0);

	}

	public int validateIntegerOption(){
			int option = 0; 

			if (input.hasNextInt()){
				option = input.nextInt();
			}else{
				//Se limpia el scanner
				input.next();
				option = -1;
			}

			return option;
	}

	public int getOptionShowMenu(){
		int option = 0; 
			System.out.println(printMenu());

			option = validateIntegerOption(); 

			return option; 
	}

	public String printMenu(){
			return 
				"\n" +
				"<< --------------------------------------------------------------------- >>\n" +
				"<< -                                Welcome                            - >>\n" +
				"<< --------------------------------------------------------------------- >>\n" +
				"1. Add a player \n" +
				"2. Add a treasure to a level \n" + 
				"3. Add a enemy to a level\n" +
				"4. Modify a player's Score \n" +
				"5. Level up (Player)\n" +
				"6. List enemies and tresures of a level \n" +
				"7. search amount of a tresure in all levels \n" +
				"8. search amount of a enemy in all levels \n" +
				"9. What's the treasure most repeated? \n" +
				"10. search for the enemy with highest score \n" +
				"11. Show the sum of consonants of all enemies \n" +
				"12. Show the 5 best players \n" +
				"0. Exit.\n"; 
	}

	public void executeOption(int option){
		String msj = "";
		boolean sw = true;
		boolean sw2 = true;

		switch(option){
			case 1: //Add a player
				System.out.print("Type the id of the player: ");
				String idPlayer = input.next();
				System.out.print("Type the nickname of the player: ");
				String nicknamePlayer = input.next();
				msj = videogame.addPlayer(idPlayer, nicknamePlayer);
				System.out.println(msj);
				break;

			case 2: //Add a treasure to a level
				while (sw){
					System.out.print("Type the name of the treasure: \n" +
									 "0. RUBY \n" +
									 "1. EMERALD \n" +
									 "2. DIAMOND \n" +
									 "3. COAL \n");
					while (!input.hasNextInt()){
						input.next();
						System.out.println("Enter a valid integer number ");
					}
					int numPrueba = input.nextInt();
					if (videogame.validateCorrectOption(numPrueba)){
						sw = false;
						int treasureType = numPrueba;
						System.out.print("Type the URL of the image of the treasure: ");
						String treasureImage = input.next();
						while(sw2){
							System.out.print("Type the level where is going to be added the treasure: ");
							while (!input.hasNextInt()){
								input.next();
								System.out.println("Enter a valid integer number ");
							}
							int numLevelPrueba = input.nextInt();
							if(numLevelPrueba == 0){
								System.out.println("The levels avaiable are: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ");
							}else if(videogame.validateLevelExist(numLevelPrueba)){
								sw2 = false;
								int numLevel = numLevelPrueba;
								msj = videogame.addTreasureToLevel(treasureType, treasureImage, numLevel);
								System.out.println(msj);
							}else{
								System.out.println("The level does not exist");
							}
						}
					}else{
						System.out.println("Invalid option");
					}
					
				}
				
				break;

			case 3://Add a enemy to a level
				while(sw){
					System.out.println("Type the name of the enemy: \n" +
								 	 "0. OGRE \n" +
								 	 "1. ABSTRACT \n" +
								 	 "2. BOSS \n" +
								 	 "3. MAGIC");
					while (!input.hasNextInt()){
						input.next();
						System.out.println("Enter a valid integer number ");
					}
					int numPrueba = input.nextInt();
					if (videogame.validateCorrectOption(numPrueba)){
						sw = false;
						int enemyType = numPrueba;
						System.out.print("Type the ponits it removes in case the enemy wins: ");
						while (!input.hasNextInt()){
							input.next();
							System.out.println("Enter a valid integer number ");
						}
						int scoreRemove = input.nextInt(); 
						System.out.print("Type the points it gives in case the enemy loses: ");
						while (!input.hasNextInt()){
							input.next();
							System.out.println("Enter a valid integer number ");
						}
						int scoreGive = input.nextInt();

						while(sw2){
							System.out.print("Type the level where is going to be added the enemy: ");
							while (!input.hasNextInt()){
								input.next();
								System.out.println("Enter a valid integer number ");
							}
							int numLevelPrueba = input.nextInt();
							if(numLevelPrueba == 0){
								System.out.println("The levels avaiable are: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10");
							}else if(videogame.validateLevelExist(numLevelPrueba)){
								sw2 = false;
								int numLevel = numLevelPrueba;
								msj = videogame.addEnemyToLevel(enemyType, scoreRemove, scoreGive, numLevel);
								System.out.println(msj);
							}else{
								System.out.println("There are only 10 avaible levels. choose one of them.");
							}
						}
						
					}else{
						System.out.println("Invalid option");
					}
				}
				
				
				break;

			case 4: //Modify a player's Score
				System.out.print("Type the id of the player you want to modify its Score: ");
				idPlayer = input.next();
				String msj2 = videogame.statusPlayer(idPlayer);
				int posPlayer = videogame.searchPlayerById(idPlayer);
				if(posPlayer == -1){
					System.out.println("The player does not exist");
				}else{
					System.out.println(msj2);
					System.out.print("Type the points you want to sum to the player's Score: ");
					while (!input.hasNextInt()){
						input.next();
						System.out.println("Enter a valid integer number ");
					}
					int newScorePlayer = input.nextInt();
					msj = videogame.modifyPlayerScore(idPlayer, newScorePlayer);
					System.out.println(msj);
				}

				break;

			case 5: //Level up (Player)
				System.out.print("Type the id of the player you want to level up: ");
				idPlayer = input.next();
				msj = videogame.levelUpPlayer(idPlayer);
				System.out.println(msj);
				break;

			case 6: //List enemies and tresures of a level
				System.out.print("Type the level you want to know the iformation: ");
				while (!input.hasNextInt()){
					input.next();
					System.out.println("Enter a valid integer number ");
				}
				int numLevel = input.nextInt();
				System.out.print("|<<<<<<<<<<ENEMIES>>>>>>>>>| \n");
				msj = videogame.listEnemiesOfALevel(numLevel);
				System.out.println(msj);
				System.out.print("|<<<<<<<<<<TREASURES>>>>>>>>>|\n");
				msj2 = videogame.listTreasuresOfALevel(numLevel);
				System.out.println(msj2);

				break;

			case 7: //search amount of a tresure in all levels
				msj = videogame.countTreasuresOfAllLevels();
				System.out.println(msj);
				break;

			case 8: //search amount of a enemy in all levels
				msj = videogame.countEnemiesOfAllLevels();
				System.out.println(msj);
				break;

			case 9: //What's the treasure most repeated?
					
				break;

			case 10:

				break;

			case 11:

				break;

			case 12:

				break;

			case 0:
				System.out.println("Exit program");
				break;

			default:
				System.out.println("Invalid option");
				break;

		}
	}

}