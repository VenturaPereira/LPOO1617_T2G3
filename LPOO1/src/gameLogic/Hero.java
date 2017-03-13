package gameLogic;

public class Hero extends Character {
	private int hi, hj;
	
	public Hero(){
	
	this.hi=1;
	this.hj=1;
	
	}
    
    
    
    
    public int getHi(){
    	return hi;
    }
    
    
    public int getHj(){
    	return hj;
    }
	
    public void setHi(int Hi){
    	this.hi = Hi;
    }
    
    public void setHj(int Hj){
    	this.hj=Hj;
    }
    
    
    public void commandMove( MapGame map,char direction){
    	int i, j;
    	
    	switch(direction){
    	  
    	
    	case 'w':
    		i =-1;
    		int testUp = hi+i;
    		if(move(map, testUp, hj ) == true){
    			setHi(hi+i);
    		}
           break;
    	case 's':
    		i = 1;
    		int testDown = hi+i;
    		if(move(map, testDown, hj) == true){
    			setHi(hi+i);
    		}
    		break;
    	case 'a':
    		j = -1;
    		int testLeft = hj+j;
    		if(move(map, hi, testLeft) == true){
    			setHj(hj+j);
    			
    		}
    		break;
    	case 'd':
    		j = 1;
    		int testRight = hj+j;
    		if(move(map, hi, testRight) == true){
    			setHj(hj+j);
    		}
    		break;
    	}
    	
    	
    	
    }




	
	
	
}
