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
	
	 public Mapa2(Levels level){
		 this.levels= level;
		 this.levels.addLevel(this);
		 Hero hero = new Hero();
		 hero.setHi(7);
		 hero.setHj(1);
	   	this.setHero(hero);
		
	 }
	 
	
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
	
	@Override
	public String printBoard(Hero hero, Enemy ord){
		String mapa= "";
		Orde orde = (Orde)ord;
		
		int hx=this.getHero().getHi();
		int hy = this.getHero().getHj();
		/*int oi = this.getOgre().getI();
		int oj = this.getOgre().getJ();
		int wi = this.getOgre().getWeaponI();
		int wj =  this.getOgre().getWeaponJ();*/
	
		for (int i = 0; i < nextLevelBoard.length; i++) {
		    for (int j = 0; j < nextLevelBoard[i].length; j++) {
		    	if(i == hx && j == hy){
		    		if(hx == 1 && hy == 7 || hero.getPickedKey())
		    		{
		    			pickKey();
		    			mapa = mapa + "K|";
		    			j++;
		    		}
		    		else
		    		{
		    			mapa = mapa + "A|";
			    		j++;
		    		}
		    		
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

	    					if(orde.getOrde().get(k).getStunned() > 0)
	    					{
	    						mapa = mapa + "*|";
	    			    		mapa = mapa + "8|";
	    			    		j++;
	    			    		j++;
	    					}
	    					else
	    					{
	    						mapa = mapa + "*|";
	    			    		mapa = mapa + "0|";
	    			    		j++;
	    			    		j++;
	    					}
			    		
	    				}
		    		}
		    	
		    		else{
		    			if(i ==oi && j == oj){
		    				if(i == 1 && j == 7)
		    				{
		    					mapa = mapa +"$|";
		    					j++;
		    				
		    				
		    				}
		    				else
		    				{

		    					if(orde.getOrde().get(k).getStunned() > 0)
		    					{
		    						mapa = mapa + "8|";
			    					j++;
		    					}
		    					else
		    					{
		    						mapa = mapa + "0|";
			    					j++;
		    					}

		    				}
		    		
		    			}

		    			if(i == wi && j == wj)
		    			{
		    				if(i == 1 && j == 7)
		    				{
		    					mapa = mapa +"$|";
		    					j++;
		    				}
		    				else
		    				{
		    					mapa = mapa + "*|";
		    					j++;
		    				}
		    		 
		    			}
		    		}
		    	}
		        mapa = mapa + nextLevelBoard[i][j] + "|";
		    }
		    mapa = mapa +"\n";
		}
		return mapa;
	}

	

	@Override
	public void setDoors() {
		// TODO Auto-generated method stub
		nextLevelBoard[1][0]=STAIRS;
		
	}
	
	
}
