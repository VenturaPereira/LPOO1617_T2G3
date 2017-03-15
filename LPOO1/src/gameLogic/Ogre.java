package gameLogic;

import java.util.Random;

public class Ogre extends Enemy {
	WeaponMoveCheck w = new WeaponMoveCheck(this);
	private int weaponI;
	private int weaponJ;
	
	public Ogre()
	{
		setI(1);
		setJ(4);
		this.weaponI = 1;
		this.weaponJ = 5;
	}

	public int getWeaponI()
	{
		return this.weaponI;
	}
	
	public int getWeaponJ()
	{
		return this.weaponJ;
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
			}
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
	
	public void ogreAttack(Mapa2 map)
	{
		int goTo;
		Random rnd = new Random();
		goTo= rnd.nextInt(4);
		switch(goTo){
		case 0:
			if(w.checkMove(0, map))
			{
				weaponI = getI()-1;
				weaponJ = getJ();
				System.out.println(getI() + "," + getJ());
				System.out.println(weaponI + "," + weaponJ);
				break;
			}	
			else
			{
				weaponI = getI()+1;
				weaponJ = getJ();
				System.out.println(getI() + "," + getJ());
				System.out.println(weaponI + "," + weaponJ);
				break;
			}
		case 1:
			if(w.checkMove(1, map))
			{
				weaponI = getI()+1;
				weaponJ = getJ();
				System.out.println(getI() + "," + getJ());
				System.out.println(weaponI + "," + weaponJ);
				break;
			}
			else
			{
				weaponI = getI()-1;
				weaponJ = getJ();
				System.out.println(getI() + "," + getJ());
				System.out.println(weaponI + "," + weaponJ);
				break;
			}
		case 2:
			if(w.checkMove(2, map))
			{
				weaponI = getI();
				weaponJ = getJ()+1;
			//	System.out.println(getI() + "," + getJ());
				//System.out.println(weaponI + "," + weaponJ);
				break;
			}
			else
			{
				weaponI = getI();
				weaponJ = getJ()-1;
				System.out.println(getI() + "," + getJ());
				//System.out.println(weaponI + "," + weaponJ);
				break;
			}
		case 3:
			if(w.checkMove(3, map))
			{
				weaponI = getI();
				weaponJ = getJ()-1;
				//System.out.println(getI() + "," + getJ());
				//System.out.println(weaponI + "," + weaponJ);
				break;
			}
			else
			{
				weaponI = getI();
				weaponJ = getJ()+1;
				//System.out.println(getI() + "," + getJ());
				//System.out.println(weaponI + "," + weaponJ);
				break;
			}
		}
	}
	
	
	
	
	
}
