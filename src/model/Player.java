package model;
public class Player{
	private String id;
	private String nickname;
	private int score;
	private int lives;
	private int level;

	/**Constructor
	 */
	public Player(String inId, String inNickname){
		id = inId;
		nickname = inNickname;
		score = 10;
		lives = 5;
		level = 0;
	}

	//Getters and setters
	public String getNickname(){
		return nickname;
	}

	public String getId(){
		return id;
	}

	public int getLevel(){
		return level;
	}

	public void setLevel(int newLevel){
		level = newLevel;
	}

	public int getScore(){
		return score;
	}

	public void setScore(int newScore){
		score += newScore;

	} 
}