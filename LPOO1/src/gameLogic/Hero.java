package gameLogic;

// TODO: Auto-generated Javadoc
/**
 * The Class Hero.
 */
public class Hero extends Character {
	
	/** The hj. */
	private int hi, hj;
	
	/** The picked key. */
	private boolean pickedKey;
	
	/**
	 * Instantiates a new hero.
	 */
	public Hero(){
	
	this.hi=1;
	this.hj=1;
	this.pickedKey = false;
	
	}
    
    
    
    
    /**
     * Gets the hi.
     *
     * @return the hi
     */
    public int getHi(){
    	return hi;
    }
    
    
    /**
     * Gets the hj.
     *
     * @return the hj
     */
    public int getHj(){
    	return hj;
    }
	
    /**
     * Sets the hi.
     *
     * @param Hi the new hi
     */
    public void setHi(int Hi){
    	this.hi = Hi;
    }
    
    /**
     * Sets the hj.
     *
     * @param Hj the new hj
     */
    public void setHj(int Hj){
    	this.hj=Hj;
    }
    
    /**
     * Gets the picked key.
     *
     * @return the picked key
     */
    public boolean getPickedKey()
    {
    	return this.pickedKey;
    }
    
    
    /**
     * Sets the picked key.
     *
     * @param k the new picked key
     */
    public void setPickedKey(boolean k)
    {
    	this.pickedKey = k;
    }
    
    /**
     * Command move.
     *
     * @param map the map
     * @param direction the direction
     */
    public void commandMove( MapGame map,char direction){
    	int i, j;
    	
    	switch(direction){
    	  case 'w':
    		i =-1;
    		int testUp = hi+i;
    		if(move(map, testUp, hj ) == true){setHi(hi+i);}
           break;
    	case 's':
    		i = 1;
    		int testDown = hi+i;
    		if(move(map, testDown, hj) == true){setHi(hi+i);}
    		break;
    	case 'a':
    		j = -1;
    		int testLeft = hj+j;
    		if(move(map, hi, testLeft) == true){setHj(hj+j);}
    		break;
    	case 'd':
    		j = 1;
    		int testRight = hj+j;
    		if(move(map, hi, testRight) == true){setHj(hj+j);}
    		break;
    	}
    }




	
	
	
}
