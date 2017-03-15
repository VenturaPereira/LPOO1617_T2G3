package gameLogic;

public class Rookie extends Guard{

	public Rookie() {
		setI(super.getI());
		setJ(super.getJ());
		setSleeping(false);
		
	}

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
