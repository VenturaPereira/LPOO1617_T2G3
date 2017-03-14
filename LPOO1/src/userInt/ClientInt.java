package userInt;

import java.util.Scanner;
import gameLogic.DnD;
import gameLogic.GameOver;
import gameLogic.Guard;
import gameLogic.Hero;
import gameLogic.MapGame;
import gameLogic.Mapa1;
import gameLogic.Mapa2;
import gameLogic.Message;
import gameLogic.Ogre;
import gameLogic.Weapon;
import gameLogic.WinGame;
public class ClientInt {
	/*
	public static void game(DnD game) {
		String answer;
		int x=1;
		Scanner scan = new Scanner(System.in);
		System.out.println("Here's the initial board! If you dare to play press Y, otherwise, press N.");
		game.printBoard();
		answer = scan.next().toUpperCase();
		switch (answer) {
		case "Y":
			decisions(game);

			break;
		case "N":
			break;

		default:
			break;
		}

	}*/
	public static void decisionsNextLvl(Mapa2 map, Hero hero, Ogre ogre, boolean advance, Weapon weapon){
		if(advance == true){
		 int i = 14854151;
		 hero.setHi(7);
		 hero.setHj(1);
		 map.printBoard(hero, ogre, weapon);
		Scanner scanner = new Scanner(System.in);
		while (i > 500) {
             
			System.out.println("Where do you wish to move?  S - down  W - up  D - right  A - left");
			String answer = scanner.next().toUpperCase();

			switch (answer) {
			case "S":
				ogre.ogreMove(map);
				weapon.weaponMove(map);
				hero.commandMove(map, 's');
				map.printBoard(hero, ogre, weapon);
				i++;
				break;
			case "W":
				ogre.ogreMove(map);
				hero.commandMove(map, 'w');
				weapon.weaponMove(map);
				map.printBoard(hero, ogre, weapon);
				i++;
				break;

			case "D":
				ogre.ogreMove(map);
				weapon.weaponMove(map);
				hero.commandMove(map, 'd');
				map.printBoard(hero, ogre, weapon);
				i++;
				break;
			case "A":
				ogre.ogreMove(map);
				weapon.weaponMove(map);
				hero.commandMove(map, 'a');
				map.printBoard(hero, ogre, weapon);
				i++;
				break;
			}
		}
	}
	}

	public static boolean decisions(Hero hero, Mapa1 map1, Guard guard, GameOver game, WinGame win) {
	
		Message msg = new Message();
		Scanner scanner = new Scanner(System.in);
		while (!game.getGame()&& !win.getWin()){
			

			System.out.println("Where do you wish to move?  S - down  W - up  D - right  A - left");
			String answer = scanner.next().toUpperCase();

			switch (answer) {
			case "S":
				guard.guardMove(map1);
				hero.commandMove(map1, 's');
				map1.printBoard(hero, guard);
				//i++;
				break;
			case "W":
				guard.guardMove(map1);
				hero.commandMove(map1, 'w');
				map1.printBoard(hero, guard);
			
				//i++;
				break;

			case "D":
				guard.guardMove(map1);
				hero.commandMove(map1, 'd');
				map1.printBoard(hero, guard);
				//i++;
				break;
			case "A":
				guard.guardMove(map1);
				hero.commandMove(map1, 'a');
				map1.printBoard(hero, guard);
				//i++;
				break;
			}
		}
		
		if(game.getGame() == true)
		{
			msg.gameOverMsgMap1();
		
		}
		
		if(win.getWin() == true)
		{
			msg.victoryMsgMap1();
			
			
			return true;
			
			
		}
		return false;
		
		
	}
	
	

	public static void main(String[] args) {

		Mapa1 map1= new Mapa1();
		Hero hero = new Hero();
		Guard guard = new Guard();
		Ogre ogre = new Ogre();
		Weapon weapon = new Weapon(ogre);
		GameOver game= new GameOver(hero, guard);
		WinGame win = new WinGame(hero);
		map1.printBoard(hero, guard);
		boolean next =decisions(hero, map1, guard, game, win);	
		Mapa2 map2 = new Mapa2();		
		decisionsNextLvl( map2, hero, ogre, next, weapon);
	
		

	}

}


