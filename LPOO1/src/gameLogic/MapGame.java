package gameLogic;

public abstract class MapGame {
	
	protected  final char DOOR = 'I';
	protected  final char WALL = 'X';
	protected   char HERO = 'H';
	protected  final char BLANK = ' ';
	protected  final char GUARD = 'G';
	protected  final char LEVER = 'K';
	protected  final char OGRE = '0';
	protected  final char KEY = 'k';
	protected  final char CANT = '$';
	protected  final char STAIRS = 'S';
	protected  final char WEAPON = '*';
	
	
	
	
	
	/*public void turnDoorsIntoStairs(char[][] boardToPlay)
	{
		if(boardToPlay == board){
			
		
		board[5][0] = STAIRS;
		board[6][0] = STAIRS;
	} else if(boardToPlay == nextLevelBoard){
		boardToPlay[1][0] = STAIRS;
	}
		
	}*/
	/*public boolean pickedKey()
	{
		boolean picked = false;
		
		if(HERO == 'K')
		{
			picked = true;
		}
		
		return picked;
	}
	*/
	/*  public boolean whichBoard(char[][] boardToPlay){
    	  boolean which = false;
    	  if(boardToPlay == board){
    		  return true;
    	  }else{
    		  return false;
    	  }
      }*/
	
	  /*public boolean analyseOgre()
		{
			boolean gameOver = false;
			
			 for(int i = 0; i < nextLevelBoard.length; i++)
		        {
		            for(int j = 0; j < nextLevelBoard[i].length; j++)
		            {
		                if(nextLevelBoard[i][j] == HERO)
		                {
		                    if((i > 0 && i < 8) && (j > 0 && j < 8))
		                    {
		                        if(nextLevelBoard[i+1][j] == OGRE || nextLevelBoard[i+1][j] == CANT) //|| nextLevelBoard[i+1][j] == WEAPON)
		                        {
		                            gameOver = true;
		                        }
		                        else if(nextLevelBoard[i-1][j] == OGRE || nextLevelBoard[i-1][j] == CANT) //|| nextLevelBoard[i-1][j] == WEAPON)
		                        {
		                            gameOver = true;
		                        }
		                        else if(nextLevelBoard[i][j+1] == OGRE || nextLevelBoard[i][j+1] == CANT) // || nextLevelBoard[i][j+1] == WEAPON)
		                        {
		                            gameOver = true;
		                        }
		                        else if(nextLevelBoard[i][j-1] == OGRE || nextLevelBoard[i][j-1] == CANT) // || nextLevelBoard[i][j-1] == WEAPON)
		                        {
		                            gameOver = true;
		                        }
		                    }
		                }  
		            }
		        }
			
			return gameOver;
		}
		*/
		/*public boolean analyseWeapon()
		{
			boolean gameOver = false;
			
			for(int i = 0; i < nextLevelBoard.length; i++)
			{
				for(int j = 0; j < nextLevelBoard[i].length; j++)
				{
					if(nextLevelBoard[i][j] == WEAPON)
					{
						if(nextLevelBoard[i-1][j] == HERO)
						{
							gameOver = true;
						}
						else if(nextLevelBoard[i+1][j] == HERO)
						{
							gameOver = true;
						}
						else if(nextLevelBoard[i][j-1] == HERO)
						{
							gameOver = true;
						}
						else if(nextLevelBoard[i][j+1] == HERO)
						{
							gameOver = true;
						}
					}
				}
			}
			
			return gameOver;
		}*/
		/*public boolean analyseStairs(char[][] boardToPlay)
		{
			boolean inStairs = false;
			if(boardToPlay == board){
			if(board[5][0] == HERO)
			{
				inStairs = true;
			}
			else if(board[6][0] == HERO)
			{
				inStairs = true;
			}
			} else if(boardToPlay == nextLevelBoard){
				if(boardToPlay[1][0] == HERO){
					inStairs = true;
				}
			}
			return inStairs;
		}*/
		/*public boolean analyseGuard()
	    {  
	        boolean gameOver = false;
	       
	        for(int i = 0; i < board.length; i++)
	        {
	            for(int j = 0; j < board[i].length; j++)
	            {
	                if(board[i][j] == HERO)
	                {
	                    if((i > 0 && i < 9) && (j > 0 && j < 9))
	                    {
	                        if(board[i+1][j] == GUARD)
	                        {
	                            gameOver = true;
	                        }
	                        else if(board[i-1][j] == GUARD)
	                        {
	                            gameOver = true;
	                        }
	                        else if(board[i][j+1] == GUARD)
	                        {
	                            gameOver = true;
	                        }
	                        else if(board[i][j-1] == GUARD)
	                        {
	                            gameOver = true;
	                        }
	                    }
	                }  
	            }
	        }
	       
	        return gameOver;
	    }*/
	  
	 
	  
}
