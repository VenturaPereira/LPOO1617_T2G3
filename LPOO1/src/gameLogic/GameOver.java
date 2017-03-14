package gameLogic;

public class GameOver {
	private Hero hero;
	private Enemy guard;

	
	public GameOver(Hero hero, Enemy guard){
		this.hero=hero;
		this.guard=guard;
		
	}
	
	public boolean getGame(){
		if((this.hero.getHi() == guard.getI()+1 && this.hero.getHj() == this.guard.getJ()) || (this.hero.getHi()== guard.getI()-1) && (this.hero.getHj() == this.guard.getJ()) || (this.hero.getHi() == this.guard.getI() && (this.hero.getHj() == this.guard.getJ()+1 ||this.hero.getHj() == this.guard.getJ()-1 ) || (this.hero.getHi() == this.guard.getI() && this.hero.getHj() == this.guard.getJ()))){
			return true;
		} else{
			return false;
		}
	}
	
	
	

}
