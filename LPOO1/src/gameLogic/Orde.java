package gameLogic;

import java.util.Vector;

public class Orde extends Enemy{
	
	Vector<Ogre> orde;
	
	public Orde(int n)
	{
		orde = new Vector<Ogre>();
		for(int i = 0; i < n; i++)
		{
			Ogre o = new Ogre();
			this.orde.add(o);
		}
	}
	
	public Orde()
	{
		this.orde = new Vector<Ogre>();
	}
	
	public Vector<Ogre> getOrde()
	{
		return this.orde;
	}
	
	public void moveOrde(MapGame map)
	{
		for(int i = 0; i < orde.size(); i++)
		{
			orde.get(i).enemyMove(map);
			orde.get(i).ogreAttack(map);
		}
	}

	@Override
	public void enemyMove(MapGame map) {
		// TODO Auto-generated method stub
		
	}
}
