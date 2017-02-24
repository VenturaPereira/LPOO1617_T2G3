package gameLogic;

public class Hero extends Character {
    private int hi = 1, hj =1;
    
    
    
    
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
    
    
    public void commandMove(char direction){
    	int i, j;
    	
    	switch(direction){
    	  
    	
    	case 'w':
    		i =-1;
           break;
    	case 's':
    		i = 1;
    		break;
    	case 'a':
    		j = -1;
    		break;
    	case 'd':
    		j = 1;
    		break;
    	}
    	
    	
    	
    }
	
	
}
