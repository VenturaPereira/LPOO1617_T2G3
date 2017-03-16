package gameLogic;

public class GameOver {
	private Hero hero;
	private Enemy guard;
	private Ogre ogre;
	private MapGame map;

	
	public GameOver(Hero hero, Enemy guard, MapGame map){
		this.hero=hero;
		this.guard=guard;
		this.map = map;
		
	}
	
	public GameOver(Hero hero, Ogre ogre, MapGame map)
	{
		this.hero = hero;
		this.ogre = ogre;
		this.map = map;
	}
	
	
	public boolean getGameOver(MapGame map) 
	{
		if(map instanceof Mapa1)
		{
			if(guard instanceof Drunken && guard.isSleeping()){
				return false;
			}
			else if((this.hero.getHi() == guard.getI()+1 && this.hero.getHj() == this.guard.getJ()) || (this.hero.getHi()== guard.getI()-1) && (this.hero.getHj() == this.guard.getJ()) || (this.hero.getHi() == this.guard.getI() && (this.hero.getHj() == this.guard.getJ()+1 ||this.hero.getHj() == this.guard.getJ()-1 ) || (this.hero.getHi() == this.guard.getI() && this.hero.getHj() == this.guard.getJ()))){
				return true;
			} else{
				return false;
			}
		}
		else if(map instanceof Mapa2) 
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
		else
		{
			if(guard instanceof Drunken && guard.isSleeping()){
				return false;
			}
			else if((this.hero.getHi() == guard.getI()+1 && this.hero.getHj() == this.guard.getJ()) || (this.hero.getHi()== guard.getI()-1) && (this.hero.getHj() == this.guard.getJ()) || (this.hero.getHi() == this.guard.getI() && (this.hero.getHj() == this.guard.getJ()+1 ||this.hero.getHj() == this.guard.getJ()-1 ) || (this.hero.getHi() == this.guard.getI() && this.hero.getHj() == this.guard.getJ()))){
				return true;
			} else{
				return false;
			}
		
		}
	}
	
	
	

}
