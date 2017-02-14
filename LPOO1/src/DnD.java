




public class DnD {
	

	 int column = 10;
	 int row = 10;

	private static final char DOOR = 'I';
	private static final char WALL = 'X';
	private static final char HERO = 'H';
	private static final char BLANK = ' ';
	private static final char GUARD = 'G';
	private static final char LEVER = 'K';
	char board[][] = {{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}, 
			{WALL, HERO, BLANK, BLANK,DOOR,BLANK,WALL,BLANK, GUARD, WALL},
			{WALL, WALL, WALL, BLANK, WALL, WALL, WALL, BLANK, BLANK, WALL},
			{WALL, BLANK, DOOR, BLANK, DOOR, BLANK, WALL, BLANK, BLANK, WALL},
			{WALL, WALL, WALL, BLANK, WALL, WALL, WALL, BLANK, BLANK, WALL},
			{DOOR, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{DOOR, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, WALL, WALL, BLANK, WALL, WALL, WALL, WALL, BLANK, WALL},
			{WALL, BLANK, DOOR, BLANK, DOOR, BLANK, WALL, LEVER, BLANK, WALL},
			{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}};
	
	
	public void printBoard(){
	  
	
		for (int i = 0; i < board.length; i++) {
		    for (int j = 0; j < board[i].length; j++) {
		        System.out.print(board[i][j] + "|");
		    }
		    System.out.println(" ");
		}
	}
	
	
	public void moveUp()
	{
		outer_loop:
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
				if(board[i][j] == HERO)
				{
					if(i > 0 && i < 9)
					{
						if(board[i-1][j] == BLANK)
						{
							board[i][j] = BLANK;
							board[i-1][j] = HERO;
							break outer_loop;
						}
							
					}
				}
			}
		}
			
	}
	
	public void moveDown()
	{ 
		outer_loop:
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
				if(board[i][j] == HERO)
				{
					if(i > 0 && i < 9)
					{
						if(board[i+1][j] == BLANK)
						{
							board[i][j] = BLANK;
							board[i+1][j] = HERO;
							break outer_loop;
							
						}
					}
				}
			}
		}
		
	}
	
	public void moveRight()
	{
		outer_loop:
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
				if(board[i][j] == HERO)
				{
					if(j > 0 && j < 9)
					{
						if(board[i][j+1] == BLANK)
						{
							board[i][j] = BLANK;
							board[i][j+1] = HERO;
							break outer_loop;
						}
					}
				}
			}
		}
	}
	
	public void moveLeft()
	{
		outer_loop:
		for(int i = 0; i < row; i++)
		{
			for( int j = 0; j < column; j++)
			{
				if(board[i][j] == HERO)
				{
					if(j > 0 && j < 9)
					{
						if(board[i][j-1] == BLANK)
						{
							board[i][j] = BLANK;
							board[i][j-1] = HERO;
							break outer_loop;
						}
					}
				}
			}
		}
	}



}

