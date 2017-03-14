package gameLogic;

public abstract class Enemy extends Character
{
	
	private  int i, j;
	
	public Enemy(int i, int j){
		this.setI(i);
		this.setJ(j);
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	
	public abstract void enemyMove(MapGame map);
	
	
	
	
}
