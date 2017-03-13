package gameLogic;

public class GameOver {
	private Hero hero;
	private Guard guard;
	
	public GameOver(Hero hero, Guard guard){
		this.hero=hero;
		this.guard=guard;
	}
	
	public boolean getGame(){
		if((this.hero.getHi() == guard.getGx()+1 && this.hero.getHj() == this.guard.getGj()) || (this.hero.getHi()== guard.getGx()-1) && (this.hero.getHj() == this.guard.getGj()) || (this.hero.getHi() == this.guard.getGx() && (this.hero.getHj() == this.guard.getGj()+1 ||this.hero.getHj() == this.guard.getGj()-1 ))){
			return true;
		} else{
			return false;
		}
	}
	

}
