package gameLogic;

public class Guard extends Character {
	private int gx, gj, index;
	private int[][] addMovement= {{0,-1},{1,0},{1,0}, {1,0} ,{1,0},{0,-1},{0,-1},{0,-1},{0,-1},{0,-1},{0,-1},{1,0},{0,1},{0,1},{0,1},{0,1},{0,1},{0,1},{0,1},{-1,0},{-1,0},{-1,0},{-1,0},{-1,0},{-1,0}};
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
		if(this.index == (this.addMovement.length-1)){
			this.index=0;
		}
		this.gx = this.gx+this.addMovement[index][0];
		this.gj = this.gj+this.addMovement[index][1];
		index++;
		
		
		
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
