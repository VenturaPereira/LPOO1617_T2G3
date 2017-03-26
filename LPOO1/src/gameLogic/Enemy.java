package gameLogic;

// TODO: Auto-generated Javadoc
/**
 * The Class Enemy.
 */
public abstract class Enemy extends Character
{
	
	/** The i and j positions. */
	private  int i, j;
	
	/** The sleeping boolean. */
	private boolean sleeping=false;

	/**
	 * Gets the i position.
	 *
	 * @return the i
	 */
	public int getI() {
		return i;
	}

	/**
	 * Sets the i position.
	 *
	 * @param i the new i
	 */
	public void setI(int i) {
		this.i = i;
	}

	/**
	 * Gets the j position.
	 *
	 * @return the j
	 */
	public int getJ() {
		return j;
	}

	/**
	 * Sets the j positiond.
	 *
	 * @param j the new j
	 */
	public void setJ(int j) {
		this.j = j;
	}
	
	
	/**
	 * Enemy move.
	 *
	 * @param the map
	 */
	public abstract void enemyMove(MapGame map);

	/**
	 * Checks if is sleeping.
	 *
	 * @return true, if is sleeping
	 */
	public boolean isSleeping() {
		return sleeping;
	}

	/**
	 * Sets the sleeping.
	 *
	 * @param sleeping boolean
	 */
	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}

	
	
	
}
