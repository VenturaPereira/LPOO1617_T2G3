package userInt;

import java.util.Scanner;
import gameLogic.DnD;
import gameLogic.Hero;
import gameLogic.MapGame;
import gameLogic.Mapa1;
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

	}
	public static void decisionsNextLvl(DnD game){
		 int i = 0;
		 game.newLevel();
		Scanner scanner = new Scanner(System.in);
		while (!game.analyseOgre() && !game.analyseStairs(game.getSecondMap()) && !game.analyseWeapon()) {
             
			System.out.println("Where do you wish to move?  S - down  W - up  D - right  A - left");
			String answer = scanner.next().toUpperCase();

			switch (answer) {
			case "S":
				game.moveDown(game.getSecondMap());
				game.moveOgre();
				game.moveWeapon();
				game.newLevel();
				i++;
				break;
			case "W":
				game.moveUp(game.getSecondMap());
				game.moveOgre();
				game.moveWeapon();
				game.newLevel();
				i++;
				break;

			case "D":
				game.moveRight(game.getSecondMap());
				game.moveOgre();
				game.moveWeapon();
				game.newLevel();
				i++;
				break;
			case "A":
				game.moveLeft(game.getSecondMap());
				game.moveOgre();
				game.moveWeapon();
				game.newLevel();
				i++;
				break;
			}
		}
		if(game.analyseOgre())
		{
			System.out.println("The ogre caught you! Game over.");
		}else if(game.analyseStairs(game.getSecondMap()))
		{
			System.out.println("You won!!!");
		}
		else if(game.analyseWeapon())
		{
			System.out.println("The ogre swings his club and kills you. Game over.");
		}
		
		
	}
*/
	public static void decisions(Hero hero, Mapa1 map1) {
		int i =0;
		Scanner scanner = new Scanner(System.in);
		while (i < 5000 ) {

			System.out.println("Where do you wish to move?  S - down  W - up  D - right  A - left");
			String answer = scanner.next().toUpperCase();

			switch (answer) {
			case "S":
				
				hero.commandMove(map1, 's');
				map1.printBoard(hero);
				i++;
				break;
			case "W":
				hero.commandMove(map1, 'w');
				map1.printBoard(hero);
				i++;
				break;

			case "D":
				hero.commandMove(map1, 'd');
				map1.printBoard(hero);
				i++;
				break;
			case "A":
				hero.commandMove(map1, 'a');
				map1.printBoard(hero);
				i++;
				break;
			}
		}
		
	}
	
	

	public static void main(String[] args) {

		Mapa1 map1= new Mapa1();
		Hero hero = new Hero();
		map1.printBoard(hero);
		decisions(hero, map1);

	}

}


