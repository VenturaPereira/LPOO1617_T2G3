package gameLogic;

import java.util.Random;

public class Weapon extends Ogre {
	private int wi, wj;
	Ogre ogre;
	
	public Weapon(Ogre ogre)
	{
		ogre = this.ogre;
	};
	
	
	public void weaponMove(MapGame map)
	{
		int goTo;
		Random rnd = new Random();
		goTo = rnd.nextInt(4);
		switch(goTo) {
		case 0:
			int testdown;
			testdown = ogre.getOi()+1;
			if(move(map, testdown, ogre.getOj()))
			{
				this.wi = testdown;
				this.wj = ogre.getOj();
			}
			break;
		case 1:
			int testup;
			testup = ogre.getOi()-1;
			if(move(map, testup, ogre.getOj()))
			{
				this.wi = testup;
				this.wj = ogre.getOj();
			}
			break;
		case 2:
			int testright;
			testright = ogre.getOj()+1;
			if(move(map, ogre.getOi(), testright))
			{
				this.wi = ogre.getOi();
				this.wj = testright;
			}
			break;
		case 3:
			int testleft;
			testleft = ogre.getOj()-1;
			if(move(map, ogre.getOi(), testleft))
			{
				this.wi = ogre.getOi();
				this.wj = testleft;
			}
			break;
		}
	}
	
}
