package gameLogic;

public class WeaponMoveCheck {
      
	private Enemy ogre;
	private Enemy weapon;
	
	public WeaponMoveCheck(Enemy ogre, Enemy weapon){
		this.ogre = ogre;
		this.weapon=weapon;
	}
	
	
	public boolean checkMove(){
		if(this.ogre.getI() == this.weapon.getI() && this.ogre.getJ() == this.weapon.getJ() ){
			return true;
		} else{
			return false;
		}
	}
	
	
}
