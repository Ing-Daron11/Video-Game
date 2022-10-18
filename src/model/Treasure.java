package model;

import java.lang.Math;

public class Treasure{
	
	private int type;
	private TypeTreasure typeTreasure;
	private String image;
	private int numLevel;
	private double posX;
	private double posY;

	public Treasure(int type, String image, int numLevel){
		this.type = type;
		this.image = image;
		this.numLevel = numLevel;
		posX = Math.random() *1280;
		posY = Math.random() *720;
		typeTreasure();
	}

	/**This method allows to calculate and asign the type to the a treasure 
	 * @param: none
	 * @return: none
	 */
	public void typeTreasure(){
		if (type == 0){
			typeTreasure = TypeTreasure.RUBY;
		}else if (type == 1){
			typeTreasure = TypeTreasure.EMERALD;
		}else if(type == 2){
			typeTreasure = TypeTreasure.DIAMOND;
		}else if( type == 3){
			typeTreasure = TypeTreasure.COAL;
		}
	}

	//Getters and setters
	public TypeTreasure getTypeTreasure(){
		return typeTreasure;
	}

	public String getImage(){
		return image;
	}

	public double getPosX(){
		return posX;
	}

	public double getPosY(){
		return posY;
	}
	
	public int getOnlyTypeTreasure(){
		return type;
	}


}
