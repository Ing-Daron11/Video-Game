package model;
public class Enemy{

	private int type;
	private TypeEnemy typeEnemy;
	private int scoreRemove;
	private int scoreGive;
	private int numLevel;

	/**Constructor
	 */
	public Enemy(int type, int scoreRemove, int scoreGive, int numLevel){
		this.scoreRemove = scoreRemove;
		this.scoreGive = scoreGive;
		this.numLevel = numLevel;
		this.type = type;
		typeEnemy();
	}

	/**This method allows to calculate and asign the type to the a enemy 
	 * @param: none
	 * @return: none
	 */
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

	//Getters and setters
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