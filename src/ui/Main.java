package ui;

import java.util.Scanner;
import model.Videogame;

public class Main{

	private scanner input;
	private Videogame videogame;

	public Main(){ //Constructor
		input = new Scanner(System.in);
		videogame = new Videogame();
	}

	public static void main(String args[]){ //Método main
		Main main = new Main();
		int option = -1; 
			System.out.println(main.banner()); //para imprimir el dibujito
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
				input.nextLine();
				option = -1;
			}

			return option;
	}

	public getOptionShowMenu(){
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
				"1. Add a autonomous car \n" +
				"2. Add a person to a autonomous car \n" + 
				"3. Show autonomous' car information\n" +
				"4. get off a person from the autonomous car\n" +
				"0. Exit.\n"; 
	}

	public void executeOption(int option){
		String msj = "";

		switch(option){
			case 1:

				break;

			case 2:

				break;

			case 3:

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

		}
	}

}