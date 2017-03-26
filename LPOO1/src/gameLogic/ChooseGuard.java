package gameLogic;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class ChooseGuard.
 */
public class ChooseGuard {
  
	/** The guard. */
	private Enemy guard;
	
	/**
	 * Instantiates a new choose guard.
	 *
	 * @param guard the guard
	 */
	public ChooseGuard(Enemy guard){
		this.guard=guard;
	}
	
	
	/**
	 * Sets the guard.
	 *
	 * @return the enemy
	 */
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
