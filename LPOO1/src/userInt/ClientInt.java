package userInt;

import java.util.Random;
import java.util.Scanner;

import gameLogic.ChooseGuard;
import gameLogic.Drunken;
import gameLogic.Enemy;
import gameLogic.Game;
import gameLogic.GameOver;
import gameLogic.Guard;
import gameLogic.Hero;
import gameLogic.Levels;
import gameLogic.MapGame;
import gameLogic.Mapa1;
import gameLogic.Mapa2;
import gameLogic.Message;
import gameLogic.Ogre;
import gameLogic.Orde;
import gameLogic.Rookie;
import gameLogic.Stun;
import gameLogic.Suspicious;

import gameLogic.WinGame;


/**
 * The Class ClientInt.
 */
public class ClientInt{
	
	/**
	 * Decisions next lvl.
	 *
	 * @param map the map
	 * @param hero the hero
	 * @param orde the orde
	 */
	public static void decisionsNextLvl(MapGame map, Hero hero, Orde orde){
		Mapa2 map2 = (Mapa2)map;

		System.out.println(map2.printBoard(hero, orde)); 
		Scanner scanner = new Scanner(System.in);
		GameOver gameOver = new GameOver(hero, orde, map2);
		WinGame winGame = new WinGame(map);
		Stun stun = new Stun(map2);
		Message msg = new Message();
		while (!gameOver.getGameOver(map2) && !winGame.getWin()) {
             System.out.println("Where do you wish to move?  S - down  W - up  D - right  A - left");
			String answer = scanner.next().toUpperCase();
			switch (answer) {
			case "S":
				orde.moveOrde(map);
				hero.commandMove(map2, 's');
				stun.stun();	
				System.out.println(map2.printBoard(hero, orde)); 
				break;
			case "W":
				orde.moveOrde(map);
				hero.commandMove(map2, 'w');
				stun.stun();	
				System.out.println(map2.printBoard(hero, orde)); 
				break;
			case "D":
				orde.moveOrde(map);
				hero.commandMove(map2, 'd');
				stun.stun();	
				System.out.println(map2.printBoard(hero, orde)); 
				break;
			case "A":
				orde.moveOrde(map);;
				hero.commandMove(map2, 'a');
				stun.stun();	
				System.out.println(map2.printBoard(hero, orde)); 
				break;
			}
		}
		if(gameOver.getGameOver(map2))
		{msg.gameOverMsgMap2();}
		if(winGame.getWin())
		{msg.victoryMsgMap2();}
	}

	/**
	 * Decisions.
	 *
	 * @param hero the hero
	 * @param map the map
	 * @param guard the guard
	 * @param game the game
	 * @param win the win
	 */
	public static void decisions(Hero hero, MapGame map, Enemy guard, GameOver game, WinGame win) {
		Mapa1 map1= (Mapa1)map;
		Message msg = new Message();
		Scanner scanner = new Scanner(System.in);
		while (!game.getGameOver(map1)&& !win.getWin()){
			System.out.println("Where do you wish to move?  S - down  W - up  D - right  A - left");
			String answer = scanner.next().toUpperCase();

			switch (answer) {
			case "S":
				guard.enemyMove(map1);
				hero.commandMove(map, 's');
				System.out.println(map1.printBoard(hero, guard));
				break;
			case "W":
				guard.enemyMove(map1);
				hero.commandMove(map1, 'w');
				System.out.println(map1.printBoard(hero, guard));
				break;
			case "D":
				guard.enemyMove(map1);
				hero.commandMove(map1, 'd');
				System.out.println(map1.printBoard(hero, guard));
				break;
			case "A":
				guard.enemyMove(map1);
				hero.commandMove(map1, 'a');
				System.out.println(map1.printBoard(hero, guard));
				break;
			}
		}
		if(game.getGameOver(map1) == true)
		{
			msg.gameOverMsgMap1();
			map1.setRunning(false);
		}
		if(win.getWin() == true)
		{
			msg.victoryMsgMap1();
		}
}
	
	

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Scanner guard = new Scanner(System.in);
		 
		System.out.println("How many ogres do you want?");
		int goTo= scan.nextInt();
		System.out.println("What guard do you want?");
		String name = guard.next();
		Game game = new Game(goTo, name);
		System.out.println(game.getMap1().printBoard(game.getMap1().getHero(), game.getMap1().getGuard()));
		if(game.getMap1().getRunning()){
		decisions(game.getMap1().getHero(), game.getMap1(),  game.getMap1().getGuard(), game.getGameOver(), game.getWinning());	
		}
		if(game.getMap2().getRunning()){
		decisionsNextLvl( game.getMap2(), game.getMap2().getHero(), game.getOrde());
		}
	}

	
}


