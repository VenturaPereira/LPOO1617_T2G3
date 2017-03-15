package gameLogic;

public abstract class Enemy extends Character
{
	
	private  int i, j;
	private boolean sleeping=false;

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

	public boolean isSleeping() {
		return sleeping;
	}

	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}

	
	
	
}
