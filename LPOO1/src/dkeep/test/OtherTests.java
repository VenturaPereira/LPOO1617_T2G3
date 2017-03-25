package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;

import gameLogic.Enemy;
import gameLogic.GameOver;
import gameLogic.Guard;
import gameLogic.Hero;
import gameLogic.Levels;
import gameLogic.MapGame;
import gameLogic.Mapa1;
import gameLogic.Mapa2;
import gameLogic.NewMapGame;
import gameLogic.Ogre;
import gameLogic.Orde;
import gameLogic.Rookie;
import gameLogic.Suspicious;
import gameLogic.WinGame;
import gameLogic.Game;

public class OtherTests {
	
	
	String map1 = "X|X|X|X|X|X|X|X|X|X| \nX|H| | | | |X| |R|X| \nX|X|X| |X|X|X| | |X| \nX| |I| |I| |X| | |X| \nX|X|X| |X|X|X| | |X| \nI| | | | | | | | |X| \nI| | | | | | | | |X| \nX|X|X| |X|X|X|X| |X| \nX| |I| |I| |X|K| |X| \nX|X|X|X|X|X|X|X|X|X| \n";
	
	String map2 = "X|X|X|X|X|X|X|X|X|\nI| | | |0|*| |k|X|\nX| | | | | | | |X|\nX| | | | | | | |X|\nX| | | | | | | |X|\nX| | | | | | | |X|\nX| | | | | | | |X|\nX|A| | | | | | |X|\nX|X|X|X|X|X|X|X|X|\n";
	
	char [][] keepmap = {{'X','X','X','X','X'},
			 {'X','H',' ','0','X'},
			 {'I',' ',' ',' ','X'},
			 {'I','K',' ',' ','X'},
			 {'X','X','X','X','X'}};
	
	@Test
	public void testHeroVsWall(){
		Levels leveling = new Levels();
		Mapa1 map = new Mapa1(leveling);
		map.getHero().commandMove(map, 'w');
		assertEquals(1, map.getHero().getHi());
		assertEquals(1, map.getHero().getHj());
		
	}
	
	@Test
	public void guardMoves(){
		Levels leveling = new Levels();
		Mapa1 map = new Mapa1(leveling);
		Enemy guard = new Rookie();
		map.setGuard(guard);
		assertEquals(1, guard.getI());
	}
	
	@Test
	public void newGame()
	{
		String typeOfGuard = "Rookie";
		int i = 1;
		
		Game game = new Game(i, typeOfGuard);
		
		assertEquals(game.getChooseGuard(), typeOfGuard);
		assertFalse(game.getGameOver().getGameOver(game.getMap1()));
		assertFalse(game.getGameOverlvl2().getGameOver(game.getMap2()));
		assertFalse(game.getWinning().getWin());
		assertFalse(game.getWinlvl2().getWin());
		assertEquals(game.getCurrentMap(), game.getMap1());

	}
	
	
	@Test
	public void printMap1()
	{
		Levels leveling = new Levels();
		Mapa1 map = new Mapa1(leveling);
		Hero hero = new Hero();
		Enemy guard = new Rookie();
		
		System.out.println(map.printBoard(hero, guard));
		
		
		assertEquals(map.printBoard(hero, guard),map1);
	}
	
	@Test
	public void heroGetsCaught()
	{
		Levels leveling = new Levels();
		Mapa1 map = new Mapa1(leveling);
		Enemy guard = new Suspicious();
		map.setGuard(guard);
		GameOver gameOver = new GameOver(map.getHero(), guard, map);
		
		map.getGuard().enemyMove(map);
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		assertTrue(gameOver.getGameOver(map));
	}
	
	@Test
	public void failsToLeave(){
		Levels leveling = new Levels();
		Mapa1 map = new Mapa1(leveling);
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		assertEquals(1, map.getHero().getHj());	
	}
	
	@Test
	public void arrivesDoor() {
		Levels leveling = new Levels();
		Mapa1 map = new Mapa1(leveling);
		Mapa2 map2 = new Mapa2(leveling);
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		assertTrue(map.isArrived());
		assertEquals(map.getMap()[5][0], 'S');
	
	
	}
	
	@Test
	public void winsGame()
	{
		Levels leveling = new Levels();
		Mapa1 map = new Mapa1(leveling);
		Mapa2 map2 = new Mapa2(leveling);
		WinGame winGame = new WinGame(map);
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		assertTrue(winGame.getWin());
	}
	
	@Test
	public void entersKeep()
	{
		Levels leveling = new Levels();
		Mapa1 map = new Mapa1(leveling);
		Mapa2 map2 = new Mapa2(leveling);
		WinGame winGame = new WinGame(map);
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 's');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		assertTrue(map2.getRunning());
	}
	
	@Test
	public void printMap2()
	{
		Levels leveling = new Levels();
		Mapa2 map = new Mapa2(leveling);
		Hero hero = new Hero();
		Orde orde = new Orde(1);
		
		assertEquals(map.printBoard(hero, orde), map2);
		
	}
	
	@Test
	public void failsToLeave2()
	{
		Levels leveling = new Levels();
		Mapa2 map = new Mapa2(leveling);
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		assertEquals(1, map.getHero().getHj());	
	}
	
	@Test
	public void arrivesDoor2()
	{
		Levels leveling = new Levels();
		Mapa2 map = new Mapa2(leveling);
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		map.getHero().commandMove(map, 'a');
		assertEquals(map.getMap()[1][0], 'I');
		
		
	}
	

	

	@Test
	public void heroIsKilled()
	{
		Levels leveling = new Levels();
		Mapa2 map = new Mapa2(leveling);
		Orde orde = new Orde(1);
		GameOver gameOver = new GameOver(map.getHero(), orde, map);
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		map.getHero().commandMove(map, 'w');
		assertTrue(gameOver.getGameOver(map));
	}
	
	
	
	
	

}
