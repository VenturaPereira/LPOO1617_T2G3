package gameLogic;

import java.util.Random;

public class Ogre extends Character {
	private int oi, oj;
	
	public Ogre()
	{
		this.oi = 1;
		this.oj = 4;
		
	}
	
	public int getOi()
	{
		return this.oi;
	}
	
	public int getOj()
	{
		return this.oj;
	}
	
	public void setOi(int a)
	{
		this.oi = a;
	}
	
	public void setOj(int a)
	{
		this.oj = a;
	}
	
	
	public void ogreMove(MapGame map){
		int goTo;
		Random rnd = new Random();
		goTo= rnd.nextInt(4);
		switch(goTo){
		case 0:
			int testdown;
			testdown = this.oi + 1;
			if(move(map, testdown, this.oj) == true){
				setOi(testdown);
			}
			break;
		case 1:
			int testup;
			testup = this.oi - 1;
			if(move(map, testup, this.oj) == true){
				setOi(testup);
			}
			break;
		case 2:
			int testRight;
			testRight = this.oj + 1;
			if(move(map, this.oi, testRight) == true){
				setOj(testRight);
			}
			break;
		case 3:
			int testLeft;
			testLeft = this.oj - 1;
			if(move(map, this.oi, testLeft) == true){
				setOj(testLeft);
			}
			break;
		}
		
		
	}
	
	
	
	
	
}
