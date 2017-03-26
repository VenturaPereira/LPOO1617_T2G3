package gameLogic;


/**
 * The Class Mapa1.
 */
public class Mapa1 extends MapGame {
	
	
	/** The board. */
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
	
	
	/**
	 * Instantiates a new mapa 1.
	 *
	 * @param level the level
	 */
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
	
	/* (non-Javadoc)
	 * @see gameLogic.MapGame#getMap()
	 */
	public char[][] getMap(){
		return board;
	}
	
	/* (non-Javadoc)
	 * @see gameLogic.MapGame#setDoors()
	 */
	public void setDoors(){
		board[5][0]= STAIRS;
		board[6][0]=STAIRS;
	}
	
	/* (non-Javadoc)
	 * @see gameLogic.MapGame#printBoard(gameLogic.Hero, gameLogic.Enemy)
	 */
	public String printBoard(Hero hero, Enemy guard){
	
	String mapa = "";
	int hx=this.getHero().getHi();
	int hy = this.getHero().getHj();
	int gx = this.getGuard().getI();
	int gj= this.getGuard().getJ();
	 
		for (int i = 0; i < board.length; i++) {
		    for (int j = 0; j < board[i].length; j++) {
		    	if(i == hx && j == hy){mapa = mapa + ("H|"); j++;}
		    	if((i == gx && j == gj) && guard instanceof Drunken && guard.isSleeping()){
		    		mapa = mapa + ("g|");
		    		j++;
		    	} else if((i == gx && j == gj) && guard instanceof Drunken && !guard.isSleeping()){
		    		mapa = mapa + ("G|");
		    		j++;
		    	}else if((i == gx && j == gj) && guard instanceof Suspicious){
		    		mapa = mapa + ("S|");
		    		j++;
		    	}else if((i == gx && j == gj) && guard instanceof Rookie){
		    		mapa = mapa + ("R|");
		    		j++;
		    	}
		        mapa = mapa + board[i][j] + "|";
		    }
		    mapa = mapa + (" ") + "\n";
		}
		return mapa;
	}
}
