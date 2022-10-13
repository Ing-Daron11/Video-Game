package model;

import java.lang.Math;

public class Treasure{
	
	private String name;
	private String image;
	private String numLevel;
	private double posX;
	private double posY;

	public Treasure(String inName, String inImage, String inNumLevel){
		name = inName;
		image = inImage;
		numLevel = inNumLevel;
		posX = Math.random() *1280 + 720;
		posY = Math.random() *1280 + 720;
	}
}