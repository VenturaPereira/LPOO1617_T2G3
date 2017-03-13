package gameLogic;

public class Guard extends Character {
	private int gx, gj, index;
	private int[][] addMovement= {{1,7},{2,7},{3,7}, {4,7} ,{5,7},{5,6},{5,5},{5,4},{5,3},{5,2},{5,1},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{6,7},{6,8},{5,8},{4,8},{3,8},{2,8},{1,8}};
	public Guard(){
		this.gx =1;
		this.gj =8;
		this.index=0;
	}
	public void setGx(int i){
		this.gx=i;
	}
	public void setGj(int j){
		this.gj=j;
	}
	public int getGx(){
		return this.gx;
	}
	public int getGj(){
		return this.gj;
	}
	public void guardMove(MapGame map){
	{
		if(this.index == (this.addMovement.length-1)){
			this.index=0;
		}
		this.gx =this.addMovement[index][0];
		this.gj = this.addMovement[index][1];
		index++;
	}
	
		
		/*
           		
		
			if(this.gx == 1 && this.gj == 8){
				
				this.gj =  this.gj + this.addMovement[index];
				this.index++;
			}else if(this.gj == 7 && this.gx !=  5){
				this.gx= this.gx + this.addMovement[index];
				this.index++;			
			} else if(this.gx == 5 && this.gj ==7){
				this.gj = this.gj + this.addMovement[index];
				this.index++;
			} else if(this.gx == 5 && this.gj > 1 && this.gj < 7){
				this.gj = this.gj + this.addMovement[index];
				this.index++;
			}
			  else if(this.gj==1 && this.gx == 5){
				this.gx = this.gx + this.addMovement[index];
				this.index++;
			} else if(this.gx == 6 && this.gj == 1){
				this.gj= this.gj + this.addMovement[index];
				this.index++;
			} else if(this.gx==6 && this.gj>1){
			
			}else if(this.gj==8){
			}
				this.gx = this.gx + this.addMovement[index];
				this.index++;
			}
	*/	
	}
	

}
