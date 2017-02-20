
	import java.util.Random;

	public class DnD {
		

		 int column = 10;
		 int row = 10;
		 int x =2;
		private static final char DOOR = 'I';
		private static final char WALL = 'X';
		private static  char HERO = 'H';
		private static final char BLANK = ' ';
		private static final char GUARD = 'G';
		private static final char LEVER = 'K';
		private static final char OGRE = 'O';
		private static final char KEY = 'k';
		private static final char CANT = '$';
		private static final char STAIRS = 'S';
		private static final char WEAPON = '*';
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
		
		public void printBoard(){
		  
		
			for (int i = 0; i < board.length; i++) {
			    for (int j = 0; j < board[i].length; j++) {
			        System.out.print(board[i][j] + "|");
			    }
			    System.out.println(" ");
			}
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
		
		
		public void moveUp(char[][]boardToPlay)
		{
			outer_loop:
			for(int i = 0; i < boardToPlay.length; i++)
			{
				for(int j = 0; j < boardToPlay[i].length; j++)
				{
					if(boardToPlay[i][j] == HERO)
					{

						if(i > 0 && i < boardToPlay.length)
						{   
							if(boardToPlay == board){
							if(boardToPlay[i][j] == boardToPlay[8][7] && boardToPlay[i-1][j] == BLANK)
							{
								HERO = 'K';
								boardToPlay[i][j] = LEVER;
								boardToPlay[i-1][j] = HERO;
								break outer_loop;
							}}
							if(boardToPlay == nextLevelBoard){
								if(boardToPlay[i][j] == boardToPlay[1][7] && boardToPlay[i-1][j] == BLANK)
								{
			                        
								boardToPlay[i][j] = BLANK;
								boardToPlay[i-1][j] = HERO;
								break outer_loop;
								}
							}
							if(boardToPlay[i-1][j] == BLANK)
							{

								boardToPlay[i][j] = BLANK;
								boardToPlay[i-1][j] = HERO;
								break outer_loop;
							}
							if(boardToPlay[i-1][j] == STAIRS)
							{
								boardToPlay[i][j] = BLANK;
								boardToPlay[i+1][j] = HERO;
								break outer_loop;
							}
							if(boardToPlay == board){
							if(boardToPlay[i-1][j] == LEVER)
							{
								boardToPlay[i][j] = BLANK;
								boardToPlay[i+1][j] = HERO;
								turnDoorsIntoStairs(boardToPlay);
								break outer_loop;
							}}
							if(boardToPlay == nextLevelBoard){
								if(boardToPlay[i-1][j] == KEY)
								{
									boardToPlay[i][j] = BLANK;
									boardToPlay[i-1][j] = HERO;
									break outer_loop;
								}
							}
					}
				}
			}
		}	
	}
		
		public void moveDown(char[][] boardToPlay)
		{ 
			outer_loop:
			for(int i = 0; i < boardToPlay.length; i++)
			{
				for(int j = 0; j < boardToPlay[i].length; j++)
				{
					if(boardToPlay[i][j] == HERO)
					{
	
						if(i > 0 && i < boardToPlay.length)
						{if(boardToPlay == board){
							if(boardToPlay[i][j] == boardToPlay[8][7] && boardToPlay[i+1][j] == BLANK)
							{
								boardToPlay[i][j] = LEVER;
								boardToPlay[i+1][j] = HERO;
								break outer_loop;
								
							}}
						if(boardToPlay == nextLevelBoard){
							if(boardToPlay[i][j] == boardToPlay[1][7] && boardToPlay[i+1][j] == BLANK)
							{
								HERO = 'K';
							boardToPlay[i][j] = BLANK;
							boardToPlay[i+1][j] = HERO;
							break outer_loop;
							}
						}
							if(boardToPlay[i+1][j] == BLANK)
							{
								boardToPlay[i][j] = BLANK;
								boardToPlay[i+1][j] = HERO;
								break outer_loop;
								
							}
							if(boardToPlay[i+1][j] == STAIRS)
							{
								boardToPlay[i][j] = BLANK;
								boardToPlay[i+1][j] = HERO;
								break outer_loop;
							}
							if(boardToPlay == board){
							if(boardToPlay[i+1][j] == LEVER)
							{
								boardToPlay[i][j] = BLANK;
								boardToPlay[i+1][j] = HERO;
								turnDoorsIntoStairs(boardToPlay);
								break outer_loop;
							}}
							if(boardToPlay == nextLevelBoard){
								if(boardToPlay[i+1][j] == KEY)
								{
									boardToPlay[i][j] = BLANK;
									boardToPlay[i+1][j] = HERO;
									break outer_loop;
								}
							}
						}
					}
				}
			}
			
		}
		
		public void moveRight(char[][] boardToPlay)
		{
			outer_loop:
			for(int i = 0; i < boardToPlay.length; i++)
			{
				for(int j = 0; j < boardToPlay[i].length; j++)
				{
					if(boardToPlay[i][j] == HERO)
					{
						if(j > 0 && j < boardToPlay.length)
						{if(boardToPlay == board){
							//reprinting the lever cell after the player steps on it
							if(boardToPlay[i][j] == boardToPlay[8][7] && boardToPlay[i][j+1] == BLANK)
							{
								boardToPlay[i][j] = LEVER;
								boardToPlay[i][j+1] = HERO;
								break outer_loop;
							}}
						if(boardToPlay == nextLevelBoard){
							HERO = 'K';
							if(boardToPlay[i][j] == boardToPlay[1][7] && boardToPlay[i][j+1] == BLANK)
							{
							boardToPlay[i][j] = BLANK;
							boardToPlay[i][j+1] = HERO;
							break outer_loop;
							}
						}
							//if the next cell is blank
							if(boardToPlay[i][j+1] == BLANK)
							{
								boardToPlay[i][j] = BLANK;
								boardToPlay[i][j+1] = HERO;
								break outer_loop;
							}
							//if the next cell is stairs
							if(boardToPlay[i][j+1] == STAIRS)
							{
								boardToPlay[i][j] = BLANK;
								boardToPlay[i][j+1] = HERO;
								break outer_loop;
							}if(boardToPlay == board){
							//if the next cell is a lever
							if(boardToPlay[i][j+1] == LEVER)
							{
								boardToPlay[i][j] = BLANK;
								boardToPlay[i][j+1] = HERO;
								turnDoorsIntoStairs(boardToPlay);
								break outer_loop;

							}}
							if(boardToPlay == nextLevelBoard){
								if(boardToPlay[i][j+1] == KEY)
								{
									boardToPlay[i][j] = BLANK;
									boardToPlay[i][j+1] = HERO;
									break outer_loop;
								}
							}
							
						}
					}
				}
			}
		}
		
		public void moveLeft(char[][] boardToPlay)
		{
			outer_loop:
			for(int i = 0; i < boardToPlay.length; i++)
			{
				for( int j = 0; j < boardToPlay[i].length; j++)
				{
					if(boardToPlay[i][j] == HERO)
					{
						if(j > 0 && j < boardToPlay.length)
						{if(boardToPlay == board){
							if(boardToPlay[i][j] == boardToPlay[8][7] && boardToPlay[i][j-1] == BLANK)
							{
								boardToPlay[i][j] = LEVER;
								boardToPlay[i][j-1] = HERO;
								break outer_loop;
							}}
						if(boardToPlay == nextLevelBoard){
							HERO = 'K';
							if(boardToPlay[i][j] == boardToPlay[1][7] && boardToPlay[i][j-1] == BLANK)
							{
							boardToPlay[i][j] = BLANK;
							boardToPlay[i][j-1] = HERO;
							break outer_loop;
							}
						}
							if(boardToPlay[i][j-1] == BLANK)
							{
								boardToPlay[i][j] = BLANK;
								boardToPlay[i][j-1] = HERO;
								break outer_loop;
							}
                			if(boardToPlay[i][j-1] == STAIRS)
							{
                				boardToPlay[i][j] = BLANK;
                				boardToPlay[i][j-1] = HERO;
								break outer_loop;
							}if(boardToPlay == board){
							if(boardToPlay[i][j-1] == LEVER)
							{
								boardToPlay[i][j] = BLANK;
								boardToPlay[i][j-1] = HERO;
								turnDoorsIntoStairs(boardToPlay);
								break outer_loop;
							}}
							if(boardToPlay == nextLevelBoard){
								if(boardToPlay[i][j-1] == KEY)
								{
									boardToPlay[i][j] = BLANK;
									boardToPlay[i][j-1] = HERO;
									break outer_loop;
								}
							}
							if(boardToPlay == nextLevelBoard){
								if(nextLevelBoard[i][j-1] == nextLevelBoard[1][0]){
									turnDoorsIntoStairs(nextLevelBoard);
								}
							}
								
						}
					}
				}
			}
		}
		
		public void guardMove()
		{
			outer_loop:
			for(int i = 0; i < row; i++)
			{
				for( int j = 0; j < column; j++)
				{	
					
					
					if(board[i][j] == GUARD)
					{
						if(i == 1 && j == 8){
							board[1][8] = BLANK;
							board[1][7] = GUARD;
							break outer_loop;
						} else if(j == 7 && i < 5){
							if( 0 < i && i <  5){
								board[i][j] = BLANK;
								board[i+1][j] = GUARD;
								break outer_loop;
							}
							
						}
						else if(i == 5 && j > 1  && j < 8){
							board[i][j] = BLANK;
							board[i][j-1] = GUARD;
							break outer_loop;
						}
						else if( j == 1 && i == 5){
							board[i][j] = BLANK;
							board[i+1][j]= GUARD;
							break outer_loop;
						}
						else if(i == 6 && j < 8){
							board[i][j] = BLANK;
							board[i][j+1] = GUARD;
							break outer_loop;
						}
						else if(j == 8 && i > 1){
							board[i][j] = BLANK;
							board[i-1][j] = GUARD;
							break outer_loop;
						}
						
						
						
					}
				 }
			}
		}	
		public void newLevel(){
		 for(int i = 0; i < nextLevelBoard.length; i++){
			 for(int j =0; j < nextLevelBoard[i].length; j++){
				 System.out.print(nextLevelBoard[i][j] + "|");
			 }
			 System.out.println(" ");
		 }
			
		}
		
		public boolean pickedKey()
		{
			boolean picked = false;
			
			if(nextLevelBoard[1][0] == STAIRS)
			{
				picked = true;
			}
			
			return picked;
		}
	  
		public void moveOgre(){
			int goTo;
			Random rnd = new Random();
		    goTo= rnd.nextInt(4);
		    switch(goTo){
		    case 0:
		    	outer_loop:
		    	for(int i =0; i < nextLevelBoard.length; i++){
	    		  for(int j=0;j < nextLevelBoard[i].length; j++){
	    			  if((nextLevelBoard[i][j]==OGRE || nextLevelBoard[i][j] == CANT) && nextLevelBoard[i+1][j] != WALL){
	    				 if(i == 1 && j == 7 && pickedKey() == false){
	    					 nextLevelBoard[i][j] = KEY;
	    					 nextLevelBoard[i+1][j] = OGRE;
	    					 break outer_loop;
	    				 }
	    				  else{
	    				  nextLevelBoard[i][j] = BLANK;
	    				  if(nextLevelBoard[i+1][j] == KEY){	  
	    					  nextLevelBoard[i+1][j] = CANT;
	    					  break outer_loop;
	    					  }
	    					  else{
	    				  nextLevelBoard[i+1][j] = OGRE;
	    				  break outer_loop;
	    				  }
	    			  }
	    		  }
		    	}
		    	}
		    	
		    	break;
		    case 1:
		    	outer_loop:
		    	for(int i =0; i < nextLevelBoard.length; i++){
		    		  for(int j=0;j < nextLevelBoard[i].length; j++){
		    			  if((nextLevelBoard[i][j]==OGRE || nextLevelBoard[i][j] == CANT) && nextLevelBoard[i-1][j] != WALL){
		    				  if(i == 1 && j == 7 && pickedKey() == false){
		    					  nextLevelBoard[i][j] = KEY;
		    					  nextLevelBoard[i-1][j] = OGRE;
		    					  break outer_loop;
		    					 }
		    				  else{
		    				  nextLevelBoard[i][j] = BLANK;
		    				  if(nextLevelBoard[i-1][j] == KEY){	  
		    					  nextLevelBoard[i-1][j] = CANT;
		    					  break outer_loop;
		    					  }
		    					  else{
		    				  nextLevelBoard[i-1][j] = OGRE;
		    				  break outer_loop;
		    				  }
		    			  }
		    		  }
			    	}
		    	}
		    	break;
		    case 2: 
		    	outer_loop:
		    	for(int i =0; i < nextLevelBoard.length; i++){
	  		        for(int j=0;j < nextLevelBoard[i].length; j++){
				  if((nextLevelBoard[i][j]==OGRE || nextLevelBoard[i][j] == CANT) && nextLevelBoard[i][j+1] != WALL){
					  if(i == 1 && j == 7 && pickedKey() == false){
    						nextLevelBoard[i][j] = KEY;
    						nextLevelBoard[i][j+1] = OGRE;
    						break outer_loop;
    					 
    				  }
					  else{
					  nextLevelBoard[i][j] = BLANK;
					  if(nextLevelBoard[i][j+1] == KEY){	  
					  nextLevelBoard[i][j+1] = CANT;
					  break outer_loop;
					  }
					  else{
						  nextLevelBoard[i][j+1] = OGRE;
						  break outer_loop;
					  }
				  }
			  }
	    	}
		    	}
		    break;
		    case 3:
		    	outer_loop:
		    	for(int i =0; i < nextLevelBoard.length; i++){
		    		  for(int j=0;j < nextLevelBoard[i].length; j++){
		    			  if((nextLevelBoard[i][j]==OGRE || nextLevelBoard[i][j] == CANT) && nextLevelBoard[i-1][j] != WALL){
		    				  if(i == 1 && j == 7 && pickedKey() == false)
		    				  {
		    				  	nextLevelBoard[i][j] = KEY;
		    				  	nextLevelBoard[i][j-1] = OGRE;
			    					 break outer_loop;
		    				  }
		    				  else{
		    				  nextLevelBoard[i][j] = BLANK;
		    				  if(nextLevelBoard[i][j-1] == KEY){	  
		    					  nextLevelBoard[i][j-1] = CANT;
		    					  break outer_loop;
		    					  }
		    					  else{
		    				  nextLevelBoard[i][j-1] = OGRE;
		    				  break outer_loop;
		    				  }
		    			  }
		    		  }
			    	}
		    }
		    	break;
		    	
		}
		}
		public void clearWeapon()
		{
			for(int i = 0; i < nextLevelBoard.length; i++)
			{
				for(int j = 0; j < nextLevelBoard[i].length; j++)
				{
					if(nextLevelBoard[i][j] == WEAPON)
					{
						nextLevelBoard[i][j] = BLANK;
					}
					else if(nextLevelBoard[i][j] == CANT && nextLevelBoard[i+1][j] == OGRE)
					{
						nextLevelBoard[i][j] = KEY;
					}
					else if(nextLevelBoard[i][j] == CANT && nextLevelBoard[i][j-1] == OGRE)
					{
						nextLevelBoard[i][j] = KEY;
					}
				}
			}
		}
		
		public void moveWeapon()
		{
			int goTo;
			Random rnd = new Random();
			goTo = rnd.nextInt(4);
			
			outer_loop:
			
			if(goTo == 0)
			{
				for(int i = 0; i < nextLevelBoard.length; i++)
				{
					for(int j = 0; j < nextLevelBoard[i].length; j++)
					{
						if(nextLevelBoard[i][j] == OGRE || nextLevelBoard[i][j] == CANT)
						{
							if(i < 7)
							{
								clearWeapon();
								if(nextLevelBoard[i+1][j] == nextLevelBoard[1][7] && pickedKey() == false)
								{
									nextLevelBoard[i+1][j] = CANT;
								}
								else
								{
									nextLevelBoard[i+1][j] = WEAPON;
								}
								break outer_loop;
							}
							else
							{
								clearWeapon();
								if(nextLevelBoard[i-1][j] == nextLevelBoard[1][7] && pickedKey() == false)
								{
									nextLevelBoard[i-1][j] = CANT;
								}
								else
								{	
									nextLevelBoard[i-1][j] = WEAPON;
								}
								break outer_loop;
							}
						}
					}
				}
			}
			else if(goTo == 1)
			{
				for(int i = 0; i < nextLevelBoard.length; i++)
				{
					for(int j = 0; j < nextLevelBoard[i].length; j++)
					{
						if(nextLevelBoard[i][j] == OGRE || nextLevelBoard[i][j] == CANT)
						{
							if(i > 1)
							{
								clearWeapon();
								if(nextLevelBoard[i-1][j] == nextLevelBoard[1][7] && pickedKey() == false)
								{
									nextLevelBoard[i-1][j] = CANT;
								}
								else
								{
									nextLevelBoard[i-1][j] = WEAPON;
								}
								break outer_loop;
							}
							else
							{
								clearWeapon();
								if(nextLevelBoard[i+1][j] == nextLevelBoard[1][7] && pickedKey() == false)
								{
									nextLevelBoard[i+1][j] = CANT;
								}
								else
								{
									nextLevelBoard[i+1][j] = WEAPON;
								}
								break outer_loop;
							}
						}
					}
				}
			}
			else if(goTo == 2)
			{
				for(int i = 0; i < nextLevelBoard.length; i++)
				{
					for(int j = 0; j < nextLevelBoard[i].length; j++)
					{
						if(nextLevelBoard[i][j] == OGRE || nextLevelBoard[i][j] == CANT)
						{
							if(j < 7)
							{
								clearWeapon();
								if(nextLevelBoard[i][j+1] == nextLevelBoard[1][7] && pickedKey() == false)
								{
									nextLevelBoard[i][j+1] = CANT;
								}
								else
								{
									nextLevelBoard[i][j+1] = WEAPON;
								}
								break outer_loop;
							}
							else
							{
								clearWeapon();
								if(nextLevelBoard[i][j-1] == nextLevelBoard[1][7] && pickedKey() == false)
								{
									nextLevelBoard[i][j-1] = CANT;
								}
								else
								{
									nextLevelBoard[i][j-1] = WEAPON;
								}
								break outer_loop;
							}
						}
					}
				}
			}
			else if(goTo == 3)
			{
				for(int i = 0; i < nextLevelBoard.length; i++)
				{
					for(int j = 0; j < nextLevelBoard[i].length; j++)
					{
						if(nextLevelBoard[i][j] == OGRE || nextLevelBoard[i][j] == CANT)
						{
							if(j > 1)
							{
								clearWeapon();
								if(nextLevelBoard[i][j-1] == nextLevelBoard[1][7] && pickedKey() == false)
								{
									nextLevelBoard[i][j-1] = CANT;
								}
								else
								{
									nextLevelBoard[i][j-1] = WEAPON;
								}
								break outer_loop;
							}
							else
							{
								clearWeapon();
								if(nextLevelBoard[i][j+1] == nextLevelBoard[1][7] && pickedKey() == false)
								{
									nextLevelBoard[i][j+1] = CANT;
								}
								else
								{
									nextLevelBoard[i][j+1] = WEAPON;
								}
								break outer_loop;
							}
						}
					}
				}
			}
			
			
			
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
		
		
	}



