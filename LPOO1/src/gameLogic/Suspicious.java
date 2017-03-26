package gameLogic;

import java.util.Random;


/**
 * The Class Suspicious.
 */
public class Suspicious extends Guard{

	/**
	 * Instantiates a new suspicious.
	 */
	public Suspicious(){
		setI(super.getI());
		setJ(super.getJ());
		setSleeping(false);
	}

	/* (non-Javadoc)
	 * @see gameLogic.Guard#enemyMove(gameLogic.MapGame)
	 */
	@Override
	public void enemyMove(MapGame map) {
		Random rnd = new Random();
		 boolean choose = rnd.nextBoolean();
		if(choose == true){
		if(getI()==2 && getJ()==7){
			setI(1);
			setJ(7);
			setIndex(0);
		}else if(getI()==1 && getJ()==7){
			setI(1);
			setJ(8);
			setIndex(getAddMovement().length-1);
		}else{
		if(getIndex() == 0){
			setIndex(getAddMovement().length-2);
			int index = getIndex();
			
			setI(getAddMovement()[index][0]);
		     setJ(getAddMovement()[index][1]);
		     setIndex(index);
		}else{
		int index = getIndex();
		
		setI(getAddMovement()[index][0]);
	     setJ(getAddMovement()[index][1]);	   
	     index--;
	     setIndex(index); 
		} 
			}
		
	} else{
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
}
