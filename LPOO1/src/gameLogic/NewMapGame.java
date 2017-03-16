package gameLogic;

public class NewMapGame extends MapGame {

	private char[][] map;
	private Levels level;
	
	public NewMapGame(char[][] map, Levels level){
		this.map=map;
		this.level=level;
		this.level.addLevel(this);
	}
	
	public void setDoors(){
		for(int i =0; i < map.length;i++){
			for(int j=0; j < map[i].length; j++){
				if(map[i][j] == DOOR){
					map[i][j] = STAIRS;
				}
			}
		}
	}
	
	
	public void printBoard(Hero hero, Enemy guard) {
	  int hi = hero.getHi();
	  int hj = hero.getHj();
	  int gi = guard.getI();
	  int gj = guard.getJ();
	  for (int i = 0; i < map.length; i++) {
		    for (int j = 0; j < map[i].length; j++) {
		    	if(i == hi && j == hj){
		    		//board[i][j]= HERO;
		    		System.out.print("H|");
		    		j++;
		    	}
		    	if(i == gi && j == gj){
		    		System.out.print("G|");
		    		j++;
		    	} 
		        System.out.print(map[i][j] + "|");
		    }
		    System.out.println(" ");
		}
	  }
		


	@Override
	public char[][] getMap() {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		
	}

}
