package gameLogic;

public class WeaponMoveCheck {
      
	
	private Enemy ogre;
	
	public WeaponMoveCheck(Enemy ogre){
		this.ogre = ogre;
	}
	
	
	public boolean checkMove(int dir, MapGame map){
		if(dir == 0){
			if(ogre.getI() > 1){
				return true;
			}
		}
		else if(dir == 1){
			if(ogre.getI() < map.getSizeI()-2){
				return true;
			}
		}
		else if(dir == 2){
			if(ogre.getJ() < map.getSizeJ()-2){
				return true;
			}
		}
		else if(dir == 3){
			if(ogre.getJ() > 1){
				return true;
			}
		}
		
		return false;
	}
}
