package gameLogic;


/**
 * The Class MapGame.
 */
public abstract class MapGame {
	
	/** The door. */
	protected  final char DOOR = 'I';
	
	/** The wall. */
	protected  final char WALL = 'X';
	
	/** The hero. */
	protected   Hero hero;
	
	/** The ogre. */
	protected Ogre ogre;
	
	/** The orde. */
	protected Orde orde;
	
	/** The guard. */
	protected Enemy guard;
	
	/** The levels. */
	protected Levels levels;
	
	/** The has ogre. */
	protected boolean hasOgre = false;
	
	/** The has guard. */
	protected boolean hasGuard = false;
	
	/** The blank. */
	protected  final char BLANK = ' ';
	
	/** The guard. */
	protected  final char GUARD = 'G';
	
	/** The lever. */
	protected  final char LEVER = 'K';
	
	/** The ogre. */
	protected  final char OGRE = '0';
	
	/** The key. */
	protected  final char KEY = 'k';
	
	/** The cant. */
	protected  final char CANT = '$';
	
	/** The stairs. */
	protected  final char STAIRS = 'S';
	
	/** The weapon. */
	protected  final char WEAPON = '*';
	
	/** The running. */
	protected boolean running=false;
	
	/** The arrived. */
	private boolean arrived=false;
	
	/**
	 * Sets the running.
	 *
	 * @param gameState the new running
	 */
	public void setRunning(boolean gameState){
		this.running=gameState;
	};
	
	/**
	 * Gets the running.
	 *
	 * @return the running
	 */
	public boolean getRunning(){
		return running;
	}
	
	/**
	 * Prints the board.
	 *
	 * @param hero the hero
	 * @param enemy the enemy
	 * @return the string
	 */
	public abstract String printBoard(Hero hero, Enemy  enemy);
    
    /**
     * Gets the map.
     *
     * @return the map
     */
    public abstract char[][] getMap(); 
    
    /**
     * Sets the doors.
     */
    public abstract void setDoors();
    
    /**
     * Gets the orde.
     *
     * @return the orde
     */
    public Orde getOrde()
    {
    	return orde;
    }
    
    /**
     * Sets the orde.
     *
     * @param the new orde
     */
    public void setOrde(Orde o)
    {
    	this.orde = o;
    }
    
	/**
	 * Gets the hero.
	 *
	 * @return the hero
	 */
	public Hero getHero() {
		return hero;
	}
	
	/**
	 * Sets the hero.
	 *
	 * @param hero the new hero
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	/**
	 * Gets the guard.
	 *
	 * @return the guard
	 */
	public Enemy getGuard() {
		return guard;
	}
	
	/**
	 * Sets the guard.
	 *
	 * @paramthe new guard
	 */
	public void setGuard(Enemy guard) {
		this.guard = guard;
	}

	
	/**
	 *	Hero picks the key.
	 */
	public void pickKey()
	{
		this.hero.setPickedKey(true);
		
		for (int i = 0; i < getMap().length; i++) {
		    for (int j = 0; j < getMap().length; j++) {
		    	if(getMap()[i][j] == KEY || getMap()[i][j] == 'k')
		    	{
		    		getMap()[i][j] = BLANK;
		    	}
		    }
		}
	}

	/**
	 * Checks if is arrived.
	 *
	 * @return true, if is arrived
	 */
	public boolean isArrived() {
		return arrived;
	}
	
	/**
	 * Sets the arrived.
	 *
	 * @param arrived the new arrived
	 */
	public void setArrived(boolean arrived) {
		this.arrived = arrived;
	}
	
	/**
	 * Gets the levels.
	 *
	 * @return the levels
	 */
	public Levels getLevels() {
		return levels;
	}
	
	/**
	 * Sets the levels.
	 *
	 * @param levels the new levels
	 */
	public void setLevels(Levels levels) {
		this.levels = levels;

	}
	
	/**
	 * Gets the size I.
	 *
	 * @return the size I
	 */
	public int getSizeI() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Gets the size J.
	 *
	 * @return the size J
	 */
	public int getSizeJ() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Checks if is checks for ogre.
	 *
	 * @return true, if is checks for ogre
	 */
	public boolean isHasOgre() {
		return hasOgre;
	}

	/**
	 * Sets the checks for ogre.
	 *
	 * @param hasOgre the new checks for ogre
	 */
	public void setHasOgre(boolean hasOgre) {
		this.hasOgre = hasOgre;
	}

	/**
	 * Checks if is checks for guard.
	 *
	 * @return true, if is checks for guard
	 */
	public boolean isHasGuard() {
		return hasGuard;
	}

	/**
	 * Sets the checks for guard.
	 *
	 * @param hasGuard the new checks for guard
	 */
	public void setHasGuard(boolean hasGuard) {
		this.hasGuard = hasGuard;
	}
	
    
}
