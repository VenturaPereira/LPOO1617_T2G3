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
import gameLogic.Orde;
import gameLogic.Rookie;
import gameLogic.Stun;
import gameLogic.Suspicious;

import gameLogic.WinGame;
public class ClientInt{
	
	public static void decisionsNextLvl(MapGame map, Hero hero){
			Scanner scanner2 = new Scanner(System.in);
			System.out.println("How many ogres do you want?");
			int choice = scanner2.nextInt();
			Orde orde = new Orde(choice);
			Mapa2 map2 = (Mapa2)map;
			map2.setOrde(orde);
			System.out.println(map2.getOrde().getOrde().size());
			int i = 14854151;
		 hero.setHi(7);
		 hero.setHj(1);
		System.out.println(map2.printBoard(hero, orde)); 
		Scanner scanner = new Scanner(System.in);
		GameOver gameOver = new GameOver(hero, orde, map2);
		WinGame winGame = new WinGame(map);
		Stun stun = new Stun(map);
		Message msg = new Message();
		while (!gameOver.getGameOver(map2) && !winGame.getWin()) {
             
			System.out.println("Where do you wish to move?  S - down  W - up  D - right  A - left");
			String answer = scanner.next().toUpperCase();

			switch (answer) {
			case "S":
				System.out.println(map2.getOrde().getOrde().size());
				orde.moveOrde(map);
				hero.commandMove(map2, 's');
				stun.stun();	
				System.out.println(map2.printBoard(hero, orde)); 
				i++;
				break;
			case "W":
				System.out.println(map2.getOrde().getOrde().size());
				orde.moveOrde(map);
				hero.commandMove(map2, 'w');
				stun.stun();	
				System.out.println(map2.printBoard(hero, orde)); 
				i++;
				break;

			case "D":
				System.out.println(map2.getOrde().getOrde().size());
				orde.moveOrde(map);
				hero.commandMove(map2, 'd');
				stun.stun();	
				System.out.println(map2.printBoard(hero, orde)); 
				i++;
				break;
			case "A":
				System.out.println(map2.getOrde().getOrde().size());
				orde.moveOrde(map);;
				hero.commandMove(map2, 'a');
				stun.stun();	
				System.out.println(map2.printBoard(hero, orde)); 
				i++;
				break;
			}
		}
		
		if(gameOver.getGameOver(map2))
		{
			msg.gameOverMsgMap2();
		}
		
		if(winGame.getWin())
		{
			msg.victoryMsgMap2();
		}
	}

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
				//i++;
				break;
			case "W":
				guard.enemyMove(map1);
				hero.commandMove(map1, 'w');
				System.out.println(map1.printBoard(hero, guard));
			
				//i++;
				break;

			case "D":
				guard.enemyMove(map1);
				hero.commandMove(map1, 'd');
				System.out.println(map1.printBoard(hero, guard));
				//i++;
				break;
			case "A":
				guard.enemyMove(map1);
				hero.commandMove(map1, 'a');
				System.out.println(map1.printBoard(hero, guard));
				//i++;
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
	
	

	public static void main(String[] args) {
      // Levels leveling = new Levels();
		//Mapa1 map1= new Mapa1(leveling);
		
		//GameOver game= new GameOver(map1.getHero(), map1.getGuard(), map1);
		//WinGame win = new WinGame(map1);
		//map1.printBoard(map1.getHero(), map1.getGuard());
		//boolean next =decisions(map1.getHero(), map1,  map1.getGuard(), game, win);	
		//Mapa2 map2 = new Mapa2(leveling);	
		//System.out.println(map2.getRunning());
		//System.out.println(leveling.getLevels().size());
		//decisionsNextLvl( map2, map2.getHero(), map2.getOgre(), next);
		
		Levels leveling = new Levels();
		Mapa1 map1= new Mapa1(leveling);
		map1.setRunning(true);
		Mapa2 map2 = new Mapa2(leveling);
		GameOver game= new GameOver(map1.getHero(), map1.getGuard(), map1);
		WinGame win = new WinGame(map1);
		System.out.println(map1.printBoard(map1.getHero(), map1.getGuard()));
		if(map1.getRunning()){
		decisions(map1.getHero(), map1,  map1.getGuard(), game, win);	
		}
		if(map2.getRunning()){
		decisionsNextLvl( map2, map2.getHero());
		}
	}

	
}


