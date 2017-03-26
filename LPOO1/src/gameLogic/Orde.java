package gameLogic;

import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class Orde.
 */
public class Orde extends Enemy{
	
	/** The orde. */
	Vector<Ogre> orde;
	
	/**
	 * Instantiates a new orde.
	 *
	 * @param n the n
	 */
	public Orde(int n)
	{
		orde = new Vector<Ogre>();
		for(int i = 0; i < n; i++)
		{
			Ogre o = new Ogre();
			this.orde.add(o);
		}
	}
	
	/**
	 * Instantiates a new orde.
	 */
	public Orde()
	{
		this.orde = new Vector<Ogre>();
	}
	
	/**
	 * Gets the orde.
	 *
	 * @return the orde
	 */
	public Vector<Ogre> getOrde()
	{
		return this.orde;
	}
	
	/**
	 * Move orde.
	 *
	 * @param map the map
	 */
	public void moveOrde(MapGame map)
	{
		for(int i = 0; i < orde.size(); i++)
		{
			orde.get(i).enemyMove(map);
			orde.get(i).ogreAttack(map);
		}
	}

	/* (non-Javadoc)
	 * @see gameLogic.Enemy#enemyMove(gameLogic.MapGame)
	 */
	@Override
	public void enemyMove(MapGame map) {}
}
