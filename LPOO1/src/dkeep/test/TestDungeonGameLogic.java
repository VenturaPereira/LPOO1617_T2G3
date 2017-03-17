package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;

import gameLogic.Enemy;
import gameLogic.GameOver;
import gameLogic.Guard;
import gameLogic.Hero;
import gameLogic.Levels;
import gameLogic.Mapa2;
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
	    	 GameOver gameOver = new GameOver(maptest.getHero(), maptest.getGuard(), maptest); 	
	    	 assertFalse(gameOver.getGameOver(maptest));	    
	    	 maptest.getHero().commandMove(maptest, 'd');
	    	 assertTrue(gameOver.getGameOver(maptest));
	    } else {
	    	 GameOver gameOver = new GameOver(maptest.getHero(), maptest.getOrde(), maptest);
	    	 assertFalse(gameOver.getGameOver(maptest));
	    	 maptest.getHero().commandMove(maptest, 'd');
	    	 assertTrue(gameOver.getGameOver(maptest));
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
	
	@Test
	public void failsToLeave(){
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(map,leveling);
		NewMapGame mapPassed = new NewMapGame(map,leveling);
		maptest.getHero().commandMove(maptest, 's');
		maptest.getHero().commandMove(maptest, 'a');
		assertEquals(1, maptest.getHero().getHj());
	    assertFalse(mapPassed.getRunning());	
	}
	
	
	@Test
	public void entersTheKeep(){
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(map,leveling);
		Mapa2 map2 = new Mapa2(leveling);
		maptest.getHero().commandMove(maptest, 's');
		maptest.getHero().commandMove(maptest, 's');
		maptest.getHero().commandMove(maptest, 'a');
		assertTrue(map2.getRunning());
	}
	
	
	
	
	
	
}
