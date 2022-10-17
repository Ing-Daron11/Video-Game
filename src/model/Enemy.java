package model;
public class Enemy{

	private int type;
	private TypeEnemy typeEnemy;
	private int scoreRemove;
	private int scoreGive;
	private int numLevel;


	public Enemy(int type, int scoreRemove, int scoreGive, int numLevel){
		this.scoreRemove = scoreRemove;
		this.scoreGive = scoreGive;
		this.numLevel = numLevel;
		this.type = type;
		typeEnemy();
	}

	public void typeEnemy(){
		if (type == 0){
			typeEnemy = TypeEnemy.OGRE;
		}else if(type == 1){
			typeEnemy = TypeEnemy.ABSTRACT;
		}else if(type == 2){
			typeEnemy = TypeEnemy.BOSS;
		}else if(type == 3){
			typeEnemy = TypeEnemy.MAGIC;
		}
	}

	public TypeEnemy getTypeEnemy(){
		return typeEnemy;
	}
	public int getScoreRemove(){
		return scoreRemove;
	}

	public int getScoreGive(){
		return scoreGive;
	}

	public int getOnlyTypeEnemy(){
		return type;
	}

}