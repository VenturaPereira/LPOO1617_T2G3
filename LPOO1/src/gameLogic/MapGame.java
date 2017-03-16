package gameLogic;

public abstract class MapGame extends Levels {
	
	protected  final char DOOR = 'I';
	protected  final char WALL = 'X';
	protected   char HERO = 'H';
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
    
}
