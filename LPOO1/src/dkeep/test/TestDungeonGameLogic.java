package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;

import gameLogic.Enemy;
import gameLogic.GameOver;
import gameLogic.Guard;
import gameLogic.Hero;
import gameLogic.NewMapGame;
import gameLogic.Rookie;





public class TestDungeonGameLogic {

	char [][] map = {{'X','X','X','X','X'},
			         {'X','H',' ','G','X'},
			         {'I',' ',' ',' ','X'},
			         {'I','K',' ',' ','X'},
			         {'X','X','X','X','X'}};
	
	@Test
	public void testMoveHeroIntoFreeCell(){
		NewMapGame maptest = new NewMapGame(map);
		Hero hero = new Hero();
		Enemy guard = new Rookie();
		guard.setI(1);
		guard.setJ(3);
		assertEquals(1, hero.getHi());
		assertEquals(1, hero.getHj());
		hero.commandMove(maptest, 's');
		assertEquals(2, hero.getHi());
		assertEquals(1, hero.getHj());
		
	}
	
	@Test
	public void testHeroIsCapturedByGuard(){
	    NewMapGame maptest = new NewMapGame(map);
	    Hero hero = new Hero();
	    Enemy guard = new Rookie();
	    guard.setI(1);
		guard.setJ(3);
	    GameOver gameOver = new GameOver(hero, guard);
	    assertFalse(gameOver.getGame());
	 	hero.commandMove(maptest, 'd');
	 	assertTrue(gameOver.getGame());
		
	}
	
	@Test
	public void testHeroVsWall(){
		NewMapGame maptest = new NewMapGame(map);
	    Hero hero = new Hero();
	    Enemy guard = new Rookie();
	    guard.setI(1);
		guard.setJ(3);
		hero.commandMove(maptest, 'w');
		assertEquals(1, hero.getHi());
		assertEquals(1, hero.getHj());
		
	}
	
	@Test
	public void testLeverWorking(){
		NewMapGame maptest = new NewMapGame(map);
	    Hero hero = new Hero();
	    Enemy guard = new Rookie();
	    guard.setI(1);
		guard.setJ(3);
		hero.commandMove(maptest, 's');
		hero.commandMove(maptest, 's');
		assertTrue(maptest.getMap()[2][0] == 'S' && maptest.getMap()[3][0] == 'S');	
	}
	
	
	
	
	
	
}
