package gameLogic;

public class Mapa2 extends MapGame {
	

	 private char nextLevelBoard[][] = {{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}, 
			{DOOR, BLANK, BLANK, BLANK, BLANK,BLANK,BLANK,KEY, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}};
	
	
	public char[][] getMap(){
		return nextLevelBoard;
	}
	
	public int getSizeI()
	{
		return nextLevelBoard.length;
	}
	
	public int getSizeJ()
	{
		return nextLevelBoard[0].length;
	}
	
	public void printBoard(Hero hero, Ogre ogre){
		
		
		
		int hx=hero.getHi();
		int hy = hero.getHj();
		int oi = ogre.getI();
		int oj = ogre.getJ();
		int wi = ogre.getWeaponI();
		int wj =  ogre.getWeaponJ();
	
		for (int i = 0; i < nextLevelBoard.length; i++) {
		    for (int j = 0; j < nextLevelBoard[i].length; j++) {
		    	if(i == hx && j == hy){
		    		System.out.print("H|");
		    		j++;
		    	}
		    	if(i ==wi && j == wj && wj < oj){
		    		System.out.print("*|");
		    		System.out.print("0|");
		    		j++;
		    		j++;
		    	}else{
		    	 if(i ==oi && j == oj){
		    		 if(i == 1 && j == 7)
		    		 {
		    			 System.out.print("$|");
			    		 j++;
		    		 }
		    		 else
		    		 {
		    			 System.out.print("0|");
			    		 j++;
		    		 }
		    		
		    	}

		    	 if(i == wi && j == wj)
		    	{
		    		 if(i == 1 && j == 7)
		    		 {
		    			 System.out.print("$|");
			    		 j++;
		    		 }
		    		 else
		    		 {
		    			 System.out.print("*|");
			    		 j++;
		    		 }
		    		 
		    	}
		    	}
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
