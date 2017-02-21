package gameLogic;

public class MapGame {
	
	 int column = 10;
	 int row = 10;
	private  final char DOOR = 'I';
	private  final char WALL = 'X';
	private   char HERO = 'H';
	private  final char BLANK = ' ';
	private  final char GUARD = 'G';
	private  final char LEVER = 'K';
	private  final char OGRE = '0';
	private  final char KEY = 'k';
	private  final char CANT = '$';
	private  final char STAIRS = 'S';
	private  final char WEAPON = '*';
	char board[][] = {{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}, 
			{WALL, HERO, BLANK, BLANK,DOOR, BLANK, WALL,BLANK, GUARD,WALL},
			{WALL, WALL, WALL, BLANK, WALL, WALL, WALL, BLANK, BLANK, WALL},
			{WALL, BLANK, DOOR, BLANK, DOOR, BLANK, WALL, BLANK, BLANK, WALL},
			{WALL, WALL, WALL, BLANK, WALL, WALL, WALL, BLANK, BLANK, WALL},
			{DOOR, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{DOOR, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, WALL, WALL, BLANK, WALL, WALL, WALL, WALL, BLANK, WALL},
			{WALL, BLANK, DOOR, BLANK, DOOR, BLANK, WALL, LEVER, BLANK, WALL},
			{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}};
	
	char nextLevelBoard[][] = {{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}, 
			{DOOR, BLANK, BLANK, BLANK, OGRE,BLANK,BLANK,KEY, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, HERO, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}};
	
	
	public char[][] getFirstMap(){
		return board;
	}
	
	public char[][] getSecondMap(){
		return nextLevelBoard;
	}
	public void turnDoorsIntoStairs(char[][] boardToPlay)
	{
		if(boardToPlay == board){
			
		
		board[5][0] = STAIRS;
		board[6][0] = STAIRS;
	} else if(boardToPlay == nextLevelBoard){
		boardToPlay[1][0] = STAIRS;
	}
		
	}
	public boolean pickedKey()
	{
		boolean picked = false;
		
		if(HERO == 'K')
		{
			picked = true;
		}
		
		return picked;
	}
	
	  public boolean whichBoard(char[][] boardToPlay){
    	  boolean which = false;
    	  if(boardToPlay == board){
    		  return true;
    	  }else{
    		  return false;
    	  }
      }
	
	  public boolean analyseOgre()
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
		
		public boolean analyseWeapon()
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
		}
		public boolean analyseStairs(char[][] boardToPlay)
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
		}
		public boolean analyseGuard()
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
	    }
}
