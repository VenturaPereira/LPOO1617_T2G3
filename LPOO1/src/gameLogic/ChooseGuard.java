package gameLogic;

import java.util.Random;

public class ChooseGuard {
  
	private Enemy guard;
	
	public ChooseGuard(Enemy guard){
		this.guard=guard;
	}
	
	
	public Enemy setGuard(){
		Random rnd = new Random();
		int goTo = rnd.nextInt(3);
		switch(goTo){
		case 0:
			guard = new Rookie();
			break;
		case 1:
			guard = new Suspicious();
			break;
		case 2:
			guard = new Drunken();
			break;
		
		
		}
		return guard;
	}
	
	
}
