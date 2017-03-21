package dkeep.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import gameLogic.GameOver;
import gameLogic.Levels;
import gameLogic.NewMapGame;
import gameLogic.WinGame;

public class TestKeep {
	
	char [][] keepmap = {{'X','X','X','X','X'},
						 {'X','H',' ','0','X'},
						 {'I',' ',' ',' ','X'},
						 {'I','K',' ',' ','X'},
						 {'X','X','X','X','X'}};
	
	@Test
	
	public void ogreKillsHero()
	{
		Levels leveling = new Levels();
	    NewMapGame maptest = new NewMapGame(keepmap, leveling);
	    if(maptest.isHasOgre()){
	    	 GameOver gameOver = new GameOver(maptest.getHero(), maptest.getOrde(), maptest); 	
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
	public void getsKey()
	{
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(keepmap, leveling);
		if(maptest.getHero().getPickedKey())
		{
				assertTrue(maptest.getMap()[maptest.getHero().getHi()][maptest.getHero().getHj()] == 'K');
		}
	}
	
	@Test
	public void heroCantOpenDoor()
	{
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(keepmap, leveling);
		
		maptest.getHero().commandMove(maptest, 's');
		int hi = maptest.getHero().getHi();
		int hj = maptest.getHero().getHj();
		maptest.getHero().commandMove(maptest, 'a');
		assertTrue(hi == maptest.getHero().getHi() && hj == maptest.getHero().getHj());
		assertTrue(maptest.getMap()[2][0] == 'I');
	}
	
	@Test
	public void heroCanOpenDoor()
	{
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(keepmap, leveling);
		if(maptest.getHero().getPickedKey())
		{
			maptest.getHero().commandMove(maptest, 's');
			maptest.getHero().commandMove(maptest, 'a');
			assertTrue(maptest.getMap()[2][0] == 'S');
			assertEquals(1, maptest.getHero().getHi());
		}
	}
	
	@Test
	public void heroWins()
	{
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(keepmap, leveling);
		WinGame win = new WinGame(maptest);
		if(maptest.getHero().getPickedKey())
		{
			maptest.getHero().commandMove(maptest, 's');
			maptest.getHero().commandMove(maptest, 'a');
			assertTrue(maptest.getMap()[2][0] == 'S');
			maptest.getHero().commandMove(maptest, 's');
			assertEquals(0, maptest.getHero().getHi());
			assertTrue(win.getWin());
			
		}
	}
	
	
}
