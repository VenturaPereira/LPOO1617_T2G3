package gameLogic;

public abstract  class Guard extends Enemy {
	private int index;
	
	private int[][] addMovement= {{1,7},{2,7},{3,7}, {4,7} ,{5,7},{5,6},{5,5},{5,4},{5,3},{5,2},{5,1},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{6,7},{6,8},{5,8},{4,8},{3,8},{2,8},{1,8}};
	public Guard(){
		setI(1);
		setJ(8);
		this.setIndex(0);
		
	}
	public abstract void enemyMove(MapGame map);
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int[][] getAddMovement() {
		return addMovement;
	}
	public void setAddMovement(int[][] addMovement) {
		this.addMovement = addMovement;
	}
	
	
}
