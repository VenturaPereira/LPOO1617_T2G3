package dkeep.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import gameLogic.GameOver;
import gameLogic.Levels;
import gameLogic.NewMapGame;
import gameLogic.Orde;
import gameLogic.Stun;
import gameLogic.WinGame;


/**
 * The Class TestKeep.
 */
public class TestKeep {
	
	/** The keepmap. */
	char [][] keepmap = {{'X','X','X','X','X'},
						 {'X','H',' ','0','X'},
						 {'I',' ',' ',' ','X'},
						 {'I','K',' ',' ','X'},
						 {'X','X','X','X','X'}};
	
	/**
	 * Checks for ogre.
	 */
	@Test
	public void HasOgre()
	{
		Levels leveling = new Levels();
	    NewMapGame maptest = new NewMapGame(keepmap, leveling);
	    assertTrue(maptest.isHasOgre());
	}
	
	/**
	 * Hero is killed.
	 */
	@Test
	public void heroIsKilled()
	{
		Levels leveling = new Levels();
	    NewMapGame maptest = new NewMapGame(keepmap, leveling);
	    
	    	 GameOver gameOver = new GameOver(maptest.getHero(), maptest.getOrde(), maptest); 	
	    	 assertFalse(gameOver.getGameOver(maptest));	    
	    	 maptest.getHero().commandMove(maptest, 'd');
	    	 assertTrue(gameOver.getGameOver(maptest));
	    
	    
	}
	
	
	/**
	 * Gets the s key.
	 *
	 * @return the s key
	 */
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
	
	/**
	 * Hero cant open door.
	 */
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
	
	/**
	 * Hero can open door.
	 */
	@Test
	public void heroCanOpenDoor()
	{
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(keepmap, leveling);
		NewMapGame mapPassed = new NewMapGame(keepmap, leveling);
		maptest.getHero().commandMove(maptest, 's');	
		maptest.getHero().commandMove(maptest, 's');
		maptest.getHero().commandMove(maptest, 'a');
		assertTrue(maptest.getMap()[2][0] == 'S');
		assertEquals(3, maptest.getHero().getHi());
		
	}
	
	/**
	 * Hero wins.
	 */
	@Test
	public void heroWins()
	{
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(keepmap, leveling);
		NewMapGame mapPassed = new NewMapGame(keepmap, leveling);
		WinGame win = new WinGame(maptest);
		maptest.getHero().commandMove(maptest, 's');
		maptest.getHero().commandMove(maptest, 's');
		maptest.getHero().commandMove(maptest, 'a');
		assertTrue(maptest.getMap()[2][0] == 'S');
		assertEquals(0, maptest.getHero().getHj());
		assertTrue(win.getWin());
			
	}
	
	/**
	 * Ogre kills hero.
	 */
	@Test(timeout=1000)
	public void ogreKillsHero()
	{
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(keepmap, leveling);
		GameOver gameOver = new GameOver(maptest.getHero(), maptest.getOrde(), maptest);
	
		
		while(!gameOver.getGameOver(maptest))
		{
			maptest.getOrde().moveOrde(maptest);
			if(maptest.getOrde().getOrde().get(0).getI() == 1 && maptest.getOrde().getOrde().get(0).getJ() == 2)
			{
				assertTrue(gameOver.getGameOver(maptest));
			}
			
			
			
		}
	}
	
	
	
	/**
	 * Hero coordenates.
	 */
	@Test
	public void heroCoordenates()
	{
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(keepmap, leveling);
		boolean yup = false;
		
		if(maptest.getHero().getHi() == 1 && maptest.getHero().getHj() == 1)
		{
			yup = true;
		}
		
		assertTrue(yup);
	}
	
	
	/**
	 * Ogre coordenates.
	 */
	@Test
	public void ogreCoordenates()
	{
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(keepmap, leveling);
		boolean yup = false;
		
		
		for(int i = 0; i < maptest.getOrde().getOrde().size(); i++)
		{
			if(maptest.getOrde().getOrde().get(i).getI() == 1 && maptest.getOrde().getOrde().get(i).getJ() == 3)
			{
				yup = true;
			}
		}
		
		assertTrue(yup);
	}
	
	/**
	 * Stun ogre.
	 */
	@Test
	public void stunOgre()
	{
		Levels leveling = new Levels();
		NewMapGame maptest = new NewMapGame(keepmap, leveling);
		Stun stun = new Stun(maptest);
		
		maptest.getHero().commandMove(maptest, 'd');
		stun.stun();
		assertTrue(maptest.getOrde().getOrde().get(0).getStunned() > 0);
	}
	
	
	
	
	
	
	
}
