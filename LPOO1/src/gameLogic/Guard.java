package gameLogic;

// TODO: Auto-generated Javadoc
/**
 * The Class Guard.
 */
public abstract  class Guard extends Enemy {
	
	/** The index. */
	private int index;
	
	/** The add movement. */
	private int[][] addMovement= {{1,7},{2,7},{3,7}, {4,7} ,{5,7},{5,6},{5,5},{5,4},{5,3},{5,2},{5,1},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{6,7},{6,8},{5,8},{4,8},{3,8},{2,8},{1,8}};
	
	/**
	 * Instantiates a new guard.
	 */
	public Guard(){
		setI(1);
		setJ(8);
		this.setIndex(0);
		
	}
	
	/* (non-Javadoc)
	 * @see gameLogic.Enemy#enemyMove(gameLogic.MapGame)
	 */
	public abstract void enemyMove(MapGame map);
	
	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Sets the index.
	 *
	 * @param index the new index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Gets the adds the movement.
	 *
	 * @return the adds the movement
	 */
	public int[][] getAddMovement() {
		return addMovement;
	}
	
	/**
	 * Sets the adds the movement.
	 *
	 * @param addMovement the new adds the movement
	 */
	public void setAddMovement(int[][] addMovement) {
		this.addMovement = addMovement;
	}
	
	
}
