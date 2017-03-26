
package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;

import gameLogic.Drunken;
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
import gameLogic.Stun;
import gameLogic.Suspicious;
import gameLogic.WinGame;
import gameLogic.Game;

// TODO: Auto-generated Javadoc
/**
 * The Class OtherTests.
 */
public class OtherTests {
	
	
	/** The map 1. */
	String map1 = "X|X|X|X|X|X|X|X|X|X| \nX|H| | | | |X| |R|X| \nX|X|X| |X|X|X| | |X| \nX| |I| |I| |X| | |X| \nX|X|X| |X|X|X| | |X| \nI| | | | | | | | |X| \nI| | | | | | | | |X| \nX|X|X| |X|X|X|X| |X| \nX| |I| |I| |X|K| |X| \nX|X|X|X|X|X|X|X|X|X| \n";
	
	/** The map 2. */
	String map2 = "X|X|X|X|X|X|X|X|X|\nI| | | |0|*| |k|X|\nX| | | | | | | |X|\nX| | | | | | | |X|\nX| | | | | | | |X|\nX| | | | | | | |X|\nX| | | | | | | |X|\nX|A| | | | | | |X|\nX|X|X|X|X|X|X|X|X|\n";
	
	/** The next level board. */
	char nextLevelBoard[][] = {{'X','X','X','X','X','X','X','X','X'}, 
				{'I', ' ', ' ', ' ', ' ',' ',' ','K', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X','X','X','X','X','X','X','X','X'}};
	
	/** The keepmap. */
	char [][] keepmap = {{'X','X','X','X','X'},
			 {'X','H',' ','0','X'},
			 {'I',' ',' ',' ','X'},
			 {'I','K',' ',' ','X'},
			 {'X','X','X','X','X'}};
	
	/** The map 3. */
	String map3 = "X|X|X|X|X|\nI| | | |X|\nI|K| | |X|\nX|X|X|X|X|";
	
	/**
	 * Test hero vs wall.
	 */
	@Test
	public void testHeroVsWall(){
		Levels leveling = new Levels();
		Mapa1 map = new Mapa1(leveling);
		map.getHero().commandMove(map, 'w');
		assertEquals(1, map.getHero().getHi());
		assertEquals(1, map.getHero().getHj());
		
	}
	
	/**
	 * Guard moves.
	 */
	@Test
	public void guardMoves(){
		Levels leveling = new Levels();
		Mapa1 map = new Mapa1(leveling);
		Enemy guard = new Rookie();
		map.setGuard(guard);
		assertEquals(1, guard.getI());
	}
	
	/**
	 * New game.
	 */
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
	
	
	/**
	 * Prints the map 1.
	 */
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
	
	/**
	 * Hero gets caught by drunken.
	 */
	@Test
	public void heroGetsCaughtByDrunken()
	{
		Levels leveling = new Levels();
		Mapa1 map = new Mapa1(leveling);
		Enemy guard = new Drunken();
		map.setGuard(guard);
		GameOver gameOver = new GameOver(map.getHero(), guard, map);
		
		map.getGuard().enemyMove(map);
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 'd');
		map.getHero().commandMove(map, 's');

		assertFalse(gameOver.getGameOver(map));
	}
	
	/**
	 * Suspicious moves.
	 */
	@Test
	public void suspiciousMoves()
	{
		Levels leveling = new Levels();
		Mapa1 map = new Mapa1(leveling);
		Enemy guard = new Suspicious();
		map.setGuard(guard);
		GameOver gameOver = new GameOver(map.getHero(), guard, map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		map.getGuard().enemyMove(map);
		
		
		assertFalse(gameOver.getGameOver(map));
		
	}
	
	/**
	 * Hero gets caught.
	 */
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
	
	/**
	 * Fails to leave.
	 */
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
	
	/**
	 * Arrives door.
	 */
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
	
	/**
	 * Wins game.
	 */
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
	
	/**
	 * Enters keep.
	 */
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
	
	/**
	 * Prints the map 2.
	 */
	@Test
	public void printMap2()
	{
		Levels leveling = new Levels();
		Mapa2 map = new Mapa2(leveling);
		Hero hero = new Hero();
		Orde orde = new Orde(1);
		
		assertEquals(map.printBoard(hero, orde), map2);
		
	}
	
	/**
	 * Fails to leave 2.
	 */
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
	
	/**
	 * Arrives door 2.
	 */
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
		assertEquals(map.getMap()[1][0], 'S');
		
		
	}
	

	

	/**
	 * Hero is killed.
	 */
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
	
	/**
	 * Sets the mapa 2.
	 */
	@Test
	public void setMapa2()
	{
		Levels leveling = new Levels();
		Mapa2 map = new Mapa2(leveling);
		map.setMap(nextLevelBoard);
		boolean lmao = true;
		assertTrue(lmao);
	}
	
	/**
	 * Prints the new map game.
	 */
	@Test
	public void printNewMapGame()
	{
		Levels leveling = new Levels();
		NewMapGame map = new NewMapGame(keepmap, leveling);
		Orde orde = new Orde(1);
		assertEquals(map.printBoard(map.getHero(), orde), " ");
		
	}
	
	/**
	 * Gets the mapa 2 sizes.
	 *
	 * @return the mapa 2 sizes
	 */
	@Test
	public void getMapa2Sizes()
	{
		Levels leveling = new Levels();
		Mapa2 map = new Mapa2(leveling);
		assertEquals(map.getSizeI(), 9);
		assertEquals(map.getSizeJ(), 9);
	}
	
	/**
	 * Ogre moves A lot.
	 */
	@Test
	public void ogreMovesALot()
	{
		Levels leveling = new Levels();
		Mapa2 map = new Mapa2(leveling);
		Orde orde = new Orde(1);
		map.setOrde(orde);
		GameOver gameOver = new GameOver(map.getHero(), map.getOrde(), map);
		
		map.getOrde().moveOrde(map);
		map.getOrde().moveOrde(map);
		map.getOrde().moveOrde(map);
		map.getOrde().moveOrde(map);
		
		assertFalse(gameOver.getGameOver(map));
	}
	
	/**
	 * Picks key.
	 */
	@Test
	public void picksKey()
	{
		Levels leveling = new Levels();
		Mapa2 map = new Mapa2(leveling);
		map.pickKey();
		assertTrue(map.getHero().getPickedKey());
		assertEquals(map.getMap()[1][7], ' ');
	}
	
	
	
	/**
	 * Sets the A movement.
	 */
	@Test
	public void setAMovement(){
		Rookie rook = new Rookie();
		int[][] somemoves = {{1,2}, {1,3}};
		rook.setAddMovement(somemoves);
		assertEquals(2, rook.getAddMovement()[0][1]);
	}
	/**
	 * Sets a guard
	 */
	@Test
	public void setaspecificguard(){
		Game game = new Game(1,"Suspicious");
		assertTrue(game.getMap1().getGuard() instanceof Suspicious);
	}
	/**
	 * Sets another guard
	 */
	@Test
	public void setaspecificguardDrunken(){
		Game game = new Game(1,"Drunken");
		assertTrue(game.getMap1().getGuard() instanceof Drunken);
	}
	/**
	 * Tests stun return
	 */
	@Test
	public void testAStun(){
		Game game = new Game(1, "Drunken");
		Stun hi = new Stun(game.getMap2());
		game.setStun(hi);
		assertEquals(hi, game.getStun());
	}
	

}

