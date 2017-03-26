package gameLogic;

// TODO: Auto-generated Javadoc
/**
 * The Class WeaponMoveCheck.
 */
public class WeaponMoveCheck {
      
	
	/** The ogre. */
	private Enemy ogre;
	
	/**
	 * Instantiates a new weapon move check.
	 *
	 * @param ogre the ogre
	 */
	public WeaponMoveCheck(Enemy ogre){
		this.ogre = ogre;
	}
	
	
	/**
	 * Check move.
	 *
	 * @param dir the direction
	 * @param map the map
	 * @return true, if successful
	 */
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
