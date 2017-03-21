package gameLogic;

public class WinGame {

	private MapGame map;

	
	public WinGame(MapGame map){
		this.map=map;

	}
	
	
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
