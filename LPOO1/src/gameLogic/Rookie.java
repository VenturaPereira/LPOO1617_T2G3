package gameLogic;

// TODO: Auto-generated Javadoc
/**
 * The Class Rookie.
 */
public class Rookie extends Guard{

	/**
	 * Instantiates a new rookie.
	 */
	public Rookie() {
		setI(super.getI());
		setJ(super.getJ());
		setSleeping(false);
		
	}

	/* (non-Javadoc)
	 * @see gameLogic.Guard#enemyMove(gameLogic.MapGame)
	 */
	@Override
	public void enemyMove(MapGame map) {
       int index = getIndex();
       setI(getAddMovement()[index][0]);
       setJ(getAddMovement()[index][1]);
       if(index == getAddMovement().length-1){
			setIndex(0);
		}else{		
			index++;
           setIndex(index); 
           
		}
	}
	


}
