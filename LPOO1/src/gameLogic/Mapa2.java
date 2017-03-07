package gameLogic;

public class Mapa2 extends MapGame {
	

	 private char nextLevelBoard[][] = {{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}, 
			{DOOR, BLANK, BLANK, BLANK, OGRE,BLANK,BLANK,KEY, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, HERO, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}};
	
	
	public char[][] getMap(){
		return nextLevelBoard;
	}
	
	public void printBoard(Hero hero, Ogre ogre, Weapon weapon){
		int hx=hero.getHi();
		int hy = hero.getHj();
		//, ox, oy, wx, wy;  
		
		for (int i = 0; i < nextLevelBoard.length; i++) {
		    for (int j = 0; j < nextLevelBoard[i].length; j++) {
		    	if(i == hx && j == hy){
		    		nextLevelBoard[i][j]= HERO;
		    	}//else if(i == ox && j == oy){
		    		//nextLevelBoard[i][j] = GUARD;
		    	//} else if(i == wx && j == wy){
		    		//nextLevelBoard[i][j] = WEAPON;
		    	//}
		        System.out.print(nextLevelBoard[i][j] + "|");
		    }
		    System.out.println(" ");
		}
	}

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		
	}

	
}
