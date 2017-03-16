package gameLogic;

public abstract class Character {
	
	
	
	//so esta feito para o Hero. Falta acrescentar para o guarda e ogre.Diferença é que para o guarda temos que acrescentar a condiçao do hero (apenas fazer um "ou" na linha 19) e para o ogre além do ou há que tratar do $ quando vai para cima da chave)
	public boolean move(MapGame map, int di, int dj){
		
		if(map instanceof Mapa1 ){
			
			if(map.getMap()[di][dj] == 'X' ){
				return false;
				
			} else if(map.getMap()[di][dj] == 'I'){
				return false;
			}else if(map.getMap()[di][dj] == 'G' || map.getMap()[di][dj] == 'H'){
				return false;
			}else if(map.getMap()[di][dj] == 'K'){ 
				((Mapa1) map).setDoors();
			    return true;
			}else if(map.getMap()[di][dj] == ' '){
				return true;
			}else if(map.getMap()[di][dj] == 'S'){
				map.setRunning(false);
				
				return true;
			}
		} else if(map instanceof Mapa2){
			
			if(map.getMap()[di][dj] == 'X'){
				return false;
			}else if(map.getMap()[di][dj] == 'I'){
				return false;
			}
			else if(map.getMap()[di][dj] == ' ')
			{
				return true;
			}
			
		}else if(map instanceof NewMapGame){
			if(map.getMap()[di][dj] == 'X'){
				return false;
			}else if(map.getMap()[di][dj] == 'I'){
				return false;
			}
			else if(map.getMap()[di][dj] == ' ')
			{
				return true;
			}else if(map.getMap()[di][dj] == 'G' || map.getMap()[di][dj] == 'H'){
				return false;
			}else if(map.getMap()[di][dj] == 'K'){ 
				((NewMapGame) map).setDoors();
			    return true;
			}
			
		}
			
		return true;
		}
		

}
