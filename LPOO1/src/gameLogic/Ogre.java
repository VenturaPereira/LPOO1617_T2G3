package gameLogic;

import java.util.Random;

public class Ogre extends Enemy {
	
	public Ogre()
	{
		super(1,4);
	}

	
	public void enemyMove(MapGame map){
		int goTo;
		Random rnd = new Random();
		goTo= rnd.nextInt(4);
		switch(goTo){
		case 0:
			int testdown;
			testdown = getI() + 1;
			if(move(map, testdown, getJ()) == true){
				setI(testdown);
				System.out.println("i get here0");
			}
			System.out.println("i get here0");
			break;
		case 1:
			int testup;
			testup = getI() - 1;
			if(move(map, testup, getJ()) == true){
				setI(testup);
				System.out.println("i get here1");
			}
			System.out.println("i get here1");		
			break;
		case 2:
			int testRight;
			testRight = getJ()+ 1;
			if(move(map, getI(), testRight) == true){
				setJ(testRight);
				System.out.println("i get here2");
			}
			System.out.println("i get here2");
			break;
		case 3:
			int testLeft;
			testLeft = getJ() - 1;
			if(move(map, getI(), testLeft) == true){
				setJ(testLeft);
				System.out.println("i get here3");
			}
			System.out.println("i get here3");
			break;
		}
		
		
	}
	
	
	
	
	
}
