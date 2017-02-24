package gameLogic;

public abstract class Character {
	
	
	
	
	
	public boolean move(MapGame map, int di, int dj){
		
		if(map instanceof Mapa1 ){
			
			if(map.getMap()[di][dj] == 'X' ){
				return false;
				
			} else if(map.getMap()[di][dj] == 'I'){
				return false;
			}	
		} else if(map instanceof Mapa2){
			
			if(map.getMap()[di][dj] == 'X'){
				return false;
			} else if(map.getMap()[di][dj] == 'I'){
				return false;
			}
			
		}
		
		
		
		
		
		return false;};
	
	
}
