package gameLogic;

public class GameOver {
	private Hero hero;
	private Enemy guard;
	private Ogre ogre;

	
	public GameOver(Hero hero, Enemy guard){
		this.hero=hero;
		this.guard=guard;
		
	}
	
	public GameOver(Hero hero, Ogre ogre)
	{
		this.hero = hero;
		this.ogre = ogre;
	}
	
	public boolean getGame(){
		if(guard instanceof Drunken && guard.isSleeping()){
			return false;
		}
		else if((this.hero.getHi() == guard.getI()+1 && this.hero.getHj() == this.guard.getJ()) || (this.hero.getHi()== guard.getI()-1) && (this.hero.getHj() == this.guard.getJ()) || (this.hero.getHi() == this.guard.getI() && (this.hero.getHj() == this.guard.getJ()+1 ||this.hero.getHj() == this.guard.getJ()-1 ) || (this.hero.getHi() == this.guard.getI() && this.hero.getHj() == this.guard.getJ()))){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean getGameOver() 
	{
		if((this.hero.getHi() == this.ogre.getI() && this.hero.getHj() == this.ogre.getJ()) || (this.hero.getHi() == this.ogre.getI()-1 && this.hero.getHj() == this.ogre.getJ()) || (this.hero.getHi() == this.ogre.getI()+1 && this.hero.getHj() == this.ogre.getJ()) || (this.hero.getHi() == this.ogre.getI() && this.hero.getHj() == this.ogre.getJ()+1) || (this.hero.getHi() == this.ogre.getI() && this.hero.getHj() == this.ogre.getJ()-1))
		{
			return true;
		}
		else if((this.hero.getHi() == this.ogre.getWeaponI() && this.hero.getHj() == this.ogre.getWeaponJ()) || (this.hero.getHi() == this.ogre.getWeaponI()-1 && this.hero.getHj() == this.ogre.getWeaponJ()) || (this.hero.getHi() == this.ogre.getWeaponI()+1 && this.hero.getHj() == this.ogre.getWeaponJ()) || (this.hero.getHi() == this.ogre.getWeaponI() && this.hero.getHj() == this.ogre.getWeaponJ()-1) || (this.hero.getHi() == this.ogre.getWeaponI() && this.hero.getHj() == this.ogre.getWeaponJ()+1))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	

}
