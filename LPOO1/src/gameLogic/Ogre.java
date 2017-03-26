package gameLogic;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Ogre.
 */
public class Ogre extends Enemy {
	
	/** The w. */
	WeaponMoveCheck w = new WeaponMoveCheck(this);
	
	/** The weapon I. */
	private int weaponI;
	
	/** The weapon J. */
	private int weaponJ;
	
	/** The stunned. */
	private int stunned;
	
	/**
	 * Instantiates a new ogre.
	 */
	public Ogre()
	{
		setI(1);
		setJ(4);
		this.weaponI = 1;
		this.weaponJ = 5;
		this.stunned = 0;
	}

	/**
	 * Sets the weapon I.
	 *
	 * @param i the new weapon I
	 */
	public void setWeaponI(int i ){
		this.weaponI = i;
	}
	
	/**
	 * Sets the weapon J.
	 *
	 * @param j the new weapon J
	 */
	public void setWeaponJ(int j ){
		this.weaponJ = j;
	}
	
	/**
	 * Gets the weapon I.
	 *
	 * @return the weapon I
	 */
	public int getWeaponI()
	{
		return this.weaponI;
	}
	
	/**
	 * Gets the weapon J.
	 *
	 * @return the weapon J
	 */
	public int getWeaponJ()
	{
		return this.weaponJ;
	}
	
	/* (non-Javadoc)
	 * @see gameLogic.Enemy#enemyMove(gameLogic.MapGame)
	 */
	public void enemyMove(MapGame map){
		if(stunned > 0)
		{stun(stunned-1);return;}
		int goTo;
		Random rnd = new Random();
		goTo= rnd.nextInt(4);
		switch(goTo){
		case 0:
			int testdown;
			testdown = getI() + 1;
			if(move(map, testdown, getJ()) == true){setI(testdown);}
			break;
		case 1:
			int testup;
			testup = getI() - 1;
			if(move(map, testup, getJ()) == true){setI(testup);}
			break;
		case 2:
			int testRight;
			testRight = getJ()+ 1;
			if(move(map, getI(), testRight) == true){setJ(testRight);}
			break;
		case 3:
			int testLeft;
			testLeft = getJ() - 1;
			if(move(map, getI(), testLeft) == true){setJ(testLeft);}
			break;
		}
	}
	
	/**
	 * Aux.
	 *
	 * @param i the i
	 * @param j the j
	 */
	public void aux(int i, int j)
	{
		this.weaponI = getI()+i;
		this.weaponJ = getJ()+j;
	}
	
	/**
	 * Ogre attack.
	 *
	 * @param map the map
	 */
	public void ogreAttack(MapGame map)
	{
		if(stunned > 0){stun(stunned-1);return;}
		int goTo;
		Random rnd = new Random();
		goTo= rnd.nextInt(4);
		switch(goTo){
		case 0:
			if(w.checkMove(0, map)){aux(-1,0);break;}	
			else{aux(1,0);break;}
		case 1:
			if(w.checkMove(1, map)){aux(1,0);break;}
			else{aux(-1,0);break;}
		case 2:
			if(w.checkMove(2, map)){aux(0,1);break;}
			else{aux(0,-1);break;}
		case 3:
			if(w.checkMove(3, map)){aux(0,-1);break;}
			else{aux(0,1);break;}
		}
	}
	
	/**
	 * Gets the stunned.
	 *
	 * @return the stunned
	 */
	public int getStunned()
	{
		return this.stunned;
	}
	
	/**
	 * Stun.
	 *
	 * @param i the i
	 */
	public void stun(int i)
	{
		this.stunned = i;
	}
	
	
	
	
}
