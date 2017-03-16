package gameLogic;

public class Mapa1 extends MapGame {
	
	
	private char board[][] = {{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}, 
			{WALL, BLANK, BLANK, BLANK,BLANK, BLANK, WALL,BLANK, BLANK,WALL},
			{WALL, WALL, WALL, BLANK, WALL, WALL, WALL, BLANK, BLANK, WALL},
			{WALL, BLANK, DOOR, BLANK, DOOR, BLANK, WALL, BLANK, BLANK, WALL},
			{WALL, WALL, WALL, BLANK, WALL, WALL, WALL, BLANK, BLANK, WALL},
			{DOOR, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{DOOR, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, WALL},
			{WALL, WALL, WALL, BLANK, WALL, WALL, WALL, WALL, BLANK, WALL},
			{WALL, BLANK, DOOR, BLANK, DOOR, BLANK, WALL, LEVER, BLANK, WALL},
			{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}};
	
	
	public Mapa1(Levels level){	
		this.levels=level;
		this.levels.addLevel(this);
		Hero hero = new Hero();
		this.setHero(hero);
		Enemy guard = new Rookie();
		ChooseGuard which = new ChooseGuard(guard);
		guard = which.setGuard();
		this.setGuard(guard);
	}
	
	public char[][] getMap(){
		return board;
	}
	public void setDoors(){
		board[5][0]= STAIRS;
		board[6][0]=STAIRS;
	}
	
	public void printBoard(Hero hero, Enemy guard){
	
	
	int hx=this.getHero().getHi();
	int hy = this.getHero().getHj();
	int gx = this.getGuard().getI();
	int gj= this.getGuard().getJ();
	//gx, gy;  
		
		for (int i = 0; i < board.length; i++) {
		    for (int j = 0; j < board[i].length; j++) {
		    	if(i == hx && j == hy){
		    		//board[i][j]= HERO;
		    		System.out.print("H|");
		    		j++;
		    	}//else if(i == gx && j == gy){
		    		//board[i][j] = GUARD;
		    	//}
		    	if((i == gx && j == gj) && guard instanceof Drunken && guard.isSleeping()){
		    		System.out.print("g|");
		    		j++;
		    	} else if((i == gx && j == gj) && guard instanceof Drunken && !guard.isSleeping()){
		    		System.out.print("G|");
		    		j++;
		    	}else if((i == gx && j == gj) && guard instanceof Suspicious){
		    		System.out.print("S|");
		    		j++;
		    	}else if((i == gx && j == gj) && guard instanceof Rookie){
		    		System.out.print("R|");
		    		j++;
		    	}
		        System.out.print(board[i][j] + "|");
		    }
		    System.out.println(" ");
		}
	}

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		
	}




}
