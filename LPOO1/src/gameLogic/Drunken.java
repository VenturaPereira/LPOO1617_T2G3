package gameLogic;

import java.util.Random;

public class Drunken extends Guard {
   
	
	public Drunken(){
		setI(super.getI());
		setJ(super.getJ());
		
	}
	
	
	@Override
	public void enemyMove(MapGame map) {
		Random rnd = new Random();
		boolean sleeping = rnd.nextBoolean();
		setSleeping(sleeping);
		if(sleeping == true){
			int index = getIndex();
			System.out.println(index);
			setI(getAddMovement()[index][0]);
		    setJ(getAddMovement()[index][1]);
		}else if(sleeping == false){
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

