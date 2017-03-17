package gameLogic;

public abstract class MapGame extends Levels {
	
	protected  final char DOOR = 'I';
	protected  final char WALL = 'X';
	private   Hero hero;
	private Ogre ogre;
	private Enemy guard;
	protected boolean hasOgre = false;
	protected boolean hasGuard = false;
	protected  final char BLANK = ' ';
	protected  final char GUARD = 'G';
	protected  final char LEVER = 'K';
	protected  final char OGRE = '0';
	protected  final char KEY = 'k';
	protected  final char CANT = '$';
	protected  final char STAIRS = 'S';
	protected  final char WEAPON = '*';
	protected boolean running;
	
	public void setRunning(boolean gameState){
		this.running=gameState;
	};
	public boolean getRunning(){
		return running;
	}
	public abstract void printBoard();
    public abstract char[][] getMap(); 
    public abstract void setDoors();
	public Ogre getOgre() {
		return ogre;
	}
	public void setOgre(Ogre ogre) {
		this.ogre = ogre;
	}
	public Hero getHero() {
		return hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	public Enemy getGuard() {
		return guard;
	}
	public void setGuard(Enemy guard) {
		this.guard = guard;
	}
	
	public void pickKey()
	{
		this.hero.setPickedKey(true);
		
		for (int i = 0; i < getMap().length; i++) {
		    for (int j = 0; j < getMap().length; j++) {
		    	if(getMap()[i][j] == KEY)
		    	{
		    		getMap()[i][j] = BLANK;
		    	}
		    }
		}
	}
    
}
