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
				"4. Level up (Player)\n" +
				"5. List enemies and tresures of a level \n" +
				"6. search amount of a tresure in all levels \n" +
				"7. search amount of a enemy in all levels \n" +
				"8. What's the treasure most repeated? \n" +
				"9. search for the enemy with highest score \n" +
				"10. Show the sum of consonants of all enemies \n" +
				"11. Show the 5 best players \n" +
				"0. Exit.\n"; 
	}

	public void executeOption(int option){
		String msj = "";

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
				System.out.print("Type the name of the treasure: ");
				String treasureName = input.next();
				System.out.print("Type the URL of the image of the treasure: ");
				String treasureImage = input.next();
				System.out.print("Type the level where is going to be added the treasure: ");
				String numLevel = input.next();
				msj = videogame.addTreasureToLevel(treasureName, treasureImage, numLevel);
				System.out.println(msj);
				break;

			case 3://Add a enemy to a level
				System.out.print("Type the name of the enemy: ");
				String enemyName = input.next();
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
				System.out.print("Type the level where is going to be added the enemy: ");
				numLevel = input.next();
				msj = videogame.addEnemyToLevel(enemyName, scoreRemove, scoreGive, numLevel);
				System.out.println(msj);
				break;

			case 4:

				break;

			case 5:

				break;

			case 6:

				break;

			case 7:

				break;

			case 8:

				break;

			case 9:

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