package gameLogic;

public class Mapa1 extends MapGame {
	
	
	
	char board[][] = {{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}, 
			{WALL, BLANK, BLANK, BLANK,BLANK, BLANK, WALL,BLANK, BLANK,WALL},
			{WALL, WALL, WALL, BLANK, WALL, WALL, WALL, BLANK, BLANK, WALL},
			{WALL, BLANK, DOOR, BLANK, DOOR, BLANK, WALL, BLANK, BLANK, WALL},
			{WALL, WALL, WALL, BLANK, WALL, WALL, WALL, BLANK, BLANK, WALL},
			{DOOR, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{DOOR, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, WALL, WALL, BLANK, WALL, WALL, WALL, WALL, BLANK, WALL},
			{WALL, BLANK, DOOR, BLANK, DOOR, BLANK, WALL, LEVER, BLANK, WALL},
			{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}};
	
	
	public char[][] getFirstMap(){
		return board;
	}
	
	
public void printBoard(Hero hero, Guard guard){
		int hx, hy, gx, gy;  
		
		for (int i = 0; i < board.length; i++) {
		    for (int j = 0; j < board[i].length; j++) {
		    	if(i == hx && j == hy){
		    		board[i][j]= HERO;
		    	}else if(i == gx && j == gy){
		    		board[i][j] = GUARD;
		    	}
		        System.out.print(board[i][j] + "|");
		    }
		    System.out.println(" ");
		}
	}

}
