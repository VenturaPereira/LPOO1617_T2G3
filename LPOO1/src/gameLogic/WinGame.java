package gameLogic;

public class WinGame {

	private MapGame map;

	
	public WinGame(MapGame map){
		this.map=map;

	}
	
	
	public boolean getWin(){
		if(this.map.isArrived()){
			
			return true;
		}else {
			return false;
		}
	}
}
