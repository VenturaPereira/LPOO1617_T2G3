package gameLogic;


/**
 * The Class WinGame.
 */
public class WinGame {

	/** The map. */
	private MapGame map;

	
	/**
	 * Instantiates a new win game.
	 *
	 * @param map the map
	 */
	public WinGame(MapGame map){
		this.map=map;

	}
	
	
	/**
	 * Gets the win.
	 *
	 * @return the win
	 */
	public boolean getWin(){
		if(this.map.isArrived()){
			for(int i =0; i < map.getLevels().getLevels().size(); i++){
				if(map == map.getLevels().getLevels().get(i)){
					if(map instanceof Mapa1){
					int a = i+1;
					map.getLevels().getLevels().get(a).setRunning(true);
					break;
					}
					else{
						map.getLevels().getLevels().get(i).setRunning(false);
						break;
					}
				}
			}
			
			return true;
		}else {
			return false;
		}
	}
}
