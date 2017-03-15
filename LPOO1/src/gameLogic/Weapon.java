package gameLogic;

import java.util.Random;

public class Weapon extends Enemy {
	Enemy ogre;
	WeaponMoveCheck check;
	
	public Weapon(Enemy ogre)
	{
		super(ogre.getI(), ogre.getJ());
		this.ogre=ogre;
		this.check= new WeaponMoveCheck(ogre, this);
	};
	

	public void enemyMove(MapGame map)
	{
		
		int goTo;
		Random rnd = new Random();
		goTo = rnd.nextInt(4);
		switch(goTo) {
		case 0:
			int testdown;
			System.out.println(ogre.getI());
			testdown = ogre.getI()+1;
			if(move(map, testdown, ogre.getJ()) && !check.checkMove())
			{
				setI(ogre.getI()-1);
				setJ(ogre.getJ());
			}
			else
			{
				enemyMove(map);
			}
			System.out.println(getI());
			System.out.println(getJ());
			break;
		case 1:
			int testup;
			testup = ogre.getI()-1;
			System.out.println(ogre.getI());
			if(move(map, testup, ogre.getJ()) && !check.checkMove())
			{
				setI(testup);
				setJ(ogre.getJ());
			}
			else
			{
				setI(ogre.getI()+1);
				setJ(ogre.getJ());
			}
			System.out.println(getI());
			System.out.println(getJ());
			break;
		case 2:
			int testright;
			System.out.println(ogre.getJ());
			testright = ogre.getJ()+1;
			if(move(map, ogre.getI(), testright) && !check.checkMove())
			{
				setI(ogre.getI());
				setJ(testright);
			}
			else
			{
				setI(ogre.getI());
				setJ(ogre.getJ()-1);
			}
			System.out.println(getI());
			System.out.println(getJ());
			break;
		case 3:
			int testleft;
			System.out.println(ogre.getJ());
			testleft = ogre.getJ()-1;
			if(move(map, ogre.getI(), testleft) && !check.checkMove())
			{
				setI(ogre.getI());
				setJ(ogre.getJ()+1);
			}
			else
			{
				enemyMove(map);
			}
			System.out.println(getI());
			System.out.println(getJ());
			break;
		}
	}
	
	
}

