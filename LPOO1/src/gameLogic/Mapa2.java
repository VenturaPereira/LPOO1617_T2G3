package gameLogic;


/**
 * The Class Mapa2.
 */
public class Mapa2 extends MapGame {
	
	 /** The next level board. */
 	private char nextLevelBoard[][] = {{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}, 
			{DOOR, BLANK, BLANK, BLANK, BLANK,BLANK,BLANK,KEY, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}};
	
	 /**
 	 * Instantiates a new mapa 2.
 	 *
 	 * @param level the level
 	 */
 	public Mapa2(Levels level){
		 this.levels= level;
		 this.levels.addLevel(this);
		 Hero hero = new Hero();
		 hero.setHi(7);
		 hero.setHj(1);
	   	this.setHero(hero);
		
	 }
	 
	 /**
 	 * Sets the map.
 	 *
 	 * @param newBoard the new map
 	 */
 	public void setMap(char[][] newBoard){
		 for(int i = 0; i < newBoard.length; i++){
			 for(int j= 0; j < newBoard[0].length;j++){
				 if(i == 0){
					 newBoard[i][j]= WALL;
				 }
				 if(j == 0){
					 newBoard[i][j] = WALL;
				 }
				 if (i == 1 && j == 0){
					 newBoard[i][j] = DOOR;
				 }
				 if(j == newBoard[0].length-1 || i == newBoard.length -1){
					 newBoard[i][j]= WALL;
				 }
			 }
		 }
		 this.nextLevelBoard = newBoard;
		 }
	
	/* (non-Javadoc)
	 * @see gameLogic.MapGame#getMap()
	 */
	public char[][] getMap(){
		return nextLevelBoard;
	}
	
	/* (non-Javadoc)
	 * @see gameLogic.MapGame#getSizeI()
	 */
	public int getSizeI()
	{
		return nextLevelBoard.length;
	}
	
	/* (non-Javadoc)
	 * @see gameLogic.MapGame#getSizeJ()
	 */
	public int getSizeJ()
	{
		return nextLevelBoard[0].length;
	}
	
	
	
	/* (non-Javadoc)
	 * @see gameLogic.MapGame#printBoard(gameLogic.Hero, gameLogic.Enemy)
	 */
	@Override
	public String printBoard(Hero hero, Enemy ord){
		String mapa= "";
		Orde orde = (Orde)ord;
		
		int hx=this.getHero().getHi();
		int hy = this.getHero().getHj();
		
		for (int i = 0; i < nextLevelBoard.length; i++) {
		    for (int j = 0; j < nextLevelBoard[i].length; j++) {
		    	if(i == hx && j == hy){
		    		if(hx == 1 && hy == 7 || hero.getPickedKey() || ((nextLevelBoard[i][j] == 'k') && hx == i && j == hy))
		    		{pickKey() ;mapa = mapa + "K|"; j++;}
		    		else
		    		{mapa = mapa + "A|"; j++;}
		    	}
		    	for(int k = 0; k < orde.getOrde().size(); k++)
		    	{
		    		int oj = orde.getOrde().get(k).getJ();
		    		int oi = orde.getOrde().get(k).getI();
		    		int wi = orde.getOrde().get(k).getWeaponI();
		    		int wj = orde.getOrde().get(k).getWeaponJ();
		    		if(i ==wi && j == wj && wj < oj){
		    			if( oi == 1 && oj == 7){
	    					mapa = mapa + "*|";
	    					mapa = mapa + "$|";
	    					j++;
	    					j++;
	    				}else{
	    					if(orde.getOrde().get(k).getStunned() > 0){mapa = mapa + "*|"; mapa = mapa + "8|"; j++; j++;}
	    					else{mapa = mapa + "*|"; mapa = mapa + "0|"; j++; j++;}
			    		}
		    		}
		    		else{
		    			if(i ==oi && j == oj){
		    				if(i == 1 && j == 7){mapa = mapa +"$|";j++;}
		    				else{
		    					if(orde.getOrde().get(k).getStunned() > 0){mapa = mapa + "8|";j++;}
		    					else{mapa = mapa + "0|";j++;}
		    				}
		    			}
		    			if(i == wi && j == wj){
		    				if(i == 1 && j == 7)
		    				{mapa = mapa +"$|";j++;}
		    				else
		    				{mapa = mapa + "*|";j++;}
		    		 }
		    		}
		    	}
		        mapa = mapa + nextLevelBoard[i][j] + "|";
		    }
		    mapa = mapa +"\n";
		}
		return mapa;
	}

	

	/* (non-Javadoc)
	 * @see gameLogic.MapGame#setDoors()
	 */
	@Override
	public void setDoors() {
		nextLevelBoard[1][0]=STAIRS;
		
	}
	
	
}
