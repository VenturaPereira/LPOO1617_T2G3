package gameLogic;

public abstract class Character {
	
	
	
	
	public boolean move(MapGame map, int di, int dj){
		
		if(map instanceof Mapa1 ){
			if(map.getMap()[di][dj] == 'X' ){return false;} 
			else if(map.getMap()[di][dj] == 'I'){return false;}
			else if(map.getMap()[di][dj] == 'G' || map.getMap()[di][dj] == 'H'){return false;}
			else if(map.getMap()[di][dj] == 'K'){((Mapa1) map).setDoors();return true;}
			else if(map.getMap()[di][dj] == ' '){return true;}
			else if(map.getMap()[di][dj] == 'S'){map.setArrived(true);map.setRunning(false);
					for(int i=0; i < map.getLevels().getLevels().size(); i++){
						if(map.getLevels().getLevels().get(i) == map)
						{int a= i+1;map.getLevels().getLevels().get(a).setRunning(true);}
					}
				  return true;}
		} else if(map instanceof Mapa2){
			if(map.getMap()[di][dj] == 'X'){
				return false;
			}else if(map.getMap()[di][dj] == 'I'){
				if(map.hero.getPickedKey() && map.getHero().getHj() == dj+1)
				{
					((Mapa2) map).setDoors();
				}
				return false;
			}
			else if(map.getMap()[di][dj] == ' ')
			{
				return true;
			}else if(map.getMap()[di][dj] == 'S'){
				  map.setArrived(true);
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
			}else if(map.getMap()[di][dj] == 'S'){
				 map.setArrived(true);
				  map.setRunning(false);
					for(int i=0; i < map.getLevels().getLevels().size(); i++){
						if(map.getLevels().getLevels().get(i) == map)
						{int a= i+1;map.getLevels().getLevels().get(a).setRunning(true);}
					}
				  return true;
				}
			}
			return true;
		}
		

}
