package gameLogic;

import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class Levels.
 */
public class Levels {
	
	/** The levels. */
	private Vector<MapGame> levels;
	
	/**
	 * Instantiates a new levels.
	 */
	public Levels(){
		levels = new Vector<MapGame>();
	}

	/**
	 * Gets the levels.
	 *
	 * @return the levels
	 */
	public Vector<MapGame> getLevels() {
		return levels;
	}

	/**
	 * Sets the levels.
	 *
	 * @param levels the new levels
	 */
	public void setLevels(Vector<MapGame> levels) {
		this.levels = levels;
	}
	
	/**
	 * Adds the level.
	 *
	 * @param map the map
	 */
	public void addLevel(MapGame map){
		levels.add(map);
	}
	
	

}
