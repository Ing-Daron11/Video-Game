package model;
public class Player{
	private String id;
	private String nickname;
	private int score;
	private int lives;

	//Constructor
	public Player(String inId, String inNickname){
		id = inId;
		nickname = inNickname;
		score = 0;
		lives = 5;
	}

	public String getNickname(){
		return nickname;
	}

	public String getId(){
		return id;
	}

}