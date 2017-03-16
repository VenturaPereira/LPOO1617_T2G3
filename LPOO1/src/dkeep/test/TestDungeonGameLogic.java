package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;

import gameLogic.Enemy;
import gameLogic.GameOver;
import gameLogic.Guard;
import gameLogic.Hero;
import gameLogic.Levels;
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
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(map, leveling);
		assertEquals(1, maptest.getHero().getHi());
		assertEquals(1, maptest.getHero().getHj());
		maptest.getHero().commandMove(maptest, 's');
		assertEquals(2, maptest.getHero().getHi());
		assertEquals(1, maptest.getHero().getHj());
		
	}
	
	@Test
	public void testHeroIsCapturedByGuard(){
		
		Levels leveling = new Levels();
	    NewMapGame maptest = new NewMapGame(map, leveling);
	    if(maptest.isHasGuard()){
	    	 GameOver gameOver = new GameOver(maptest.getHero(), maptest.getGuard()); 	
	    	 assertFalse(gameOver.getGame());	    
	    	 maptest.getHero().commandMove(maptest, 'd');
	    	 assertTrue(gameOver.getGame());
	    } else {
	    	 GameOver gameOver = new GameOver(maptest.getHero(), maptest.getOgre());
	    	 assertFalse(gameOver.getGame());
	    	 maptest.getHero().commandMove(maptest, 'd');
	    	 assertTrue(gameOver.getGame());
	    }
	}
	
	@Test
	public void testHeroVsWall(){
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(map, leveling);
		maptest.getHero().commandMove(maptest, 'w');
		assertEquals(1, maptest.getHero().getHi());
		assertEquals(1, maptest.getHero().getHj());
		
	}
	
	@Test
	public void testLeverWorking(){
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(map, leveling);
		maptest.getHero().commandMove(maptest, 's');
		maptest.getHero().commandMove(maptest, 's');
		assertTrue(maptest.getMap()[2][0] == 'S' && maptest.getMap()[3][0] == 'S');	
	}
	
	
	
	
	
	
}
