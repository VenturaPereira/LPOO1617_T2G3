package gameLogic;

public class WinGame {

	private Hero hero;

	
	public WinGame(Hero hero){
		this.hero=hero;

	}
	
	
	public boolean getWin(){
		if(this.hero.getHj()== 0 && ( this.hero.getHi()== 5 || this.hero.getHi() == 6) ){
			return true;
		}else {
			return false;
		}
	}
}
