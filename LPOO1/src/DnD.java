
public class DnD {
	
	int column = 10;
	int row = 10;
	
	char board[][];
	
	public void moveUp()
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
				if(board[i][j] == 'H')
				{
					if(i > 0 && i < 9)
					{
						if(board[i-1][j] == ' ')
						{
							board[i][j] = ' ';
							board[i-1][j] = 'H';
						}
							
					}
				}
			}
		}
			
	}
	
	public void moveDown()
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
				if(board[i][j] == 'H')
				{
					if(i > 0 && i < 9)
					{
						if(board[i+1][j] == ' ')
						{
							board[i][j] = ' ';
							board[i+1][j] = 'H';
						}
					}
				}
			}
		}
		
	}
	
	public void moveRight()
	{
		for(int i = 0; i < row; i++)
		{
			for( int j = 0; j < column; j++)
			{
				if(board[i][j] == 'H')
				{
					if(j > 0 && j < 9)
					{
						if(board[i][j+1] == ' ')
						{
							board[i][j] = ' ';
							board[i][j+1] = 'H';
						}
					}
				}
			}
		}
	}
	
	public void moveLeft()
	{
		for(int i = 0; i < row; i++)
		{
			for( int j = 0; j < column; j++)
			{
				if(board[i][j] == 'H')
				{
					if(j > 0 && j < 9)
					{
						if(board[i][j-1] == ' ')
						{
							board[i][j] = ' ';
							board[i][j-1] = 'H';
						}
					}
				}
			}
		}
	}


	
	
	
	
}
