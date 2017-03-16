package userInt;

import java.util.Random;
import java.util.Scanner;

import gameLogic.ChooseGuard;
import gameLogic.Drunken;
import gameLogic.Enemy;
import gameLogic.GameOver;
import gameLogic.Guard;
import gameLogic.Hero;
import gameLogic.Levels;
import gameLogic.MapGame;
import gameLogic.Mapa1;
import gameLogic.Mapa2;
import gameLogic.Message;
import gameLogic.Ogre;
import gameLogic.Rookie;
import gameLogic.Suspicious;

import gameLogic.WinGame;
public class ClientInt{
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
	public static void decisionsNextLvl(Mapa2 map, Hero hero, Ogre ogre, boolean advance){
		if(advance == true){
		 int i = 14854151;
		 hero.setHi(7);
		 hero.setHj(1);
		 map.printBoard(hero, ogre);
		Scanner scanner = new Scanner(System.in);
		GameOver gameOver = new GameOver(hero, ogre);
		Message msg = new Message();
		while (!gameOver.getGameOver()) {
             
			System.out.println("Where do you wish to move?  S - down  W - up  D - right  A - left");
			String answer = scanner.next().toUpperCase();

			switch (answer) {
			case "S":

				ogre.enemyMove(map);
				ogre.ogreAttack(map);
				hero.commandMove(map, 's');
				map.printBoard(hero, ogre);
				i++;
				break;
			case "W":
				ogre.enemyMove(map);
				ogre.ogreAttack(map);
				hero.commandMove(map, 'w');
				map.printBoard(hero, ogre);
				i++;
				break;

			case "D":
				ogre.enemyMove(map);
				ogre.ogreAttack(map);
				hero.commandMove(map, 'd');
				map.printBoard(hero, ogre);
				i++;
				break;
			case "A":
				ogre.enemyMove(map);
				ogre.ogreAttack(map);
				hero.commandMove(map, 'a');
				map.printBoard(hero, ogre);
				i++;
				break;
			}
		}
		
		if(gameOver.getGameOver())
		{
			msg.gameOverMsgMap2();
		}
	}
	}

	public static boolean decisions(Hero hero, Mapa1 map1, Enemy guard, GameOver game, WinGame win) {
	   map1.setRunning(true);
		Message msg = new Message();
		Scanner scanner = new Scanner(System.in);
		while (!game.getGame()&& !win.getWin()){
			

			System.out.println("Where do you wish to move?  S - down  W - up  D - right  A - left");
			String answer = scanner.next().toUpperCase();

			switch (answer) {
			case "S":
				guard.enemyMove(map1);
				hero.commandMove(map1, 's');
				map1.printBoard(hero, guard);
				//i++;
				break;
			case "W":
				guard.enemyMove(map1);
				hero.commandMove(map1, 'w');
				map1.printBoard(hero, guard);
			
				//i++;
				break;

			case "D":
				guard.enemyMove(map1);
				hero.commandMove(map1, 'd');
				map1.printBoard(hero, guard);
				//i++;
				break;
			case "A":
				guard.enemyMove(map1);
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
       Levels leveling = new Levels();
		Mapa1 map1= new Mapa1(leveling);
		GameOver game= new GameOver(map1.getHero(), map1.getGuard());
		WinGame win = new WinGame(map1.getHero());
		map1.printBoard(map1.getHero(), map1.getGuard());
		boolean next =decisions(map1.getHero(), map1,  map1.getGuard(), game, win);	
		Mapa2 map2 = new Mapa2(leveling);		
		System.out.println(leveling.getLevels().size());
		decisionsNextLvl( map2, map2.getHero(), map2.getOgre(), next);
	
		

	}

	
}


