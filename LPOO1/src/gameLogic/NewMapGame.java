package gameLogic;

import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class NewMapGame.
 */
public class NewMapGame extends MapGame {

	/** The map. */
	private char[][] map;
	
	/** The orde. */
	private Orde orde;
	
	/** The hero. */
	private Hero hero;
	
	/** The guard. */
	private Enemy guard;
	
	/** The has ogre. */
	private boolean hasOgre = false;
	
	/** The has guard. */
	private boolean hasGuard = false;
	
	
	/**
	 * Instantiates a new new map game.
	 *
	 * @param map the map
	 * @param level the level
	 */
	public NewMapGame(char[][] map, Levels level){
		this.setMap(new char[map.length][map[0].length]);
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				if(map[i][j] == 'H'){this.getMap()[i][j] = ' '; setHero(new Hero());
					getHero().setHi(i);getHero().setHj(j);	}
				if(map[i][j] == 'G'){
					setHasGuard(true);
					this.getMap()[i][j]=' ';
					setGuard(new Rookie());
					ChooseGuard which = new ChooseGuard(getGuard());
					setGuard(which.setGuard());
					getGuard().setI(i);
					getGuard().setJ(j);
				}else if(map[i][j] == '0'){
					Ogre o = new Ogre();
					setHasOgre(true);
					this.getMap()[i][j] = ' ';
					o.setI(i);
					o.setJ(j);
					setOrde(new Orde(0));
					this.orde.getOrde().add(o);
				}
				else{this.map[i][j]=map[i][j];}
			}
		}this.levels=level; this.levels.addLevel(this);
	}
	
	/* (non-Javadoc)
	 * @see gameLogic.MapGame#setDoors()
	 */
	public void setDoors(){
		for(int i =0; i < getMap().length;i++){
			for(int j=0; j < getMap()[i].length; j++){
				if(getMap()[i][j] == DOOR){
					getMap()[i][j] = STAIRS;
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see gameLogic.MapGame#printBoard(gameLogic.Hero, gameLogic.Enemy)
	 */
	@Override
	public String printBoard(Hero hero, Enemy guard) {
	  int hi = this.getHero().getHi();
	  int hj = this.getHero().getHj();
	 
	  for (int i = 0; i < getMap().length; i++) {
		    for (int j = 0; j < getMap()[i].length; j++) {
		    	if(i == hi && j == hj){
		    		System.out.print("H|");
		    		j++;
		    	}if(this.isHasGuard()){
		    		
		    	
		    	if(i == this.getGuard().getI() && j == this.getGuard().getJ()){
		    		System.out.print("G|");
		    		j++;
		    	} 
		    	}else if(this.isHasOgre()){
		    		for(int k = 0; k < orde.getOrde().size(); k++)
		    		{
		    			if(i == orde.getOrde().get(k).getI() && j == orde.getOrde().get(k).getJ()){
				    		System.out.print("0|");
				    		j++;
				    	} 
		    		}
		    		
		    		
		    	}
		        System.out.print(getMap()[i][j] + "|");
		    }
		    System.out.println(" ");
		}
	  return " ";
	  }
		


	/* (non-Javadoc)
	 * @see gameLogic.MapGame#getMap()
	 */
	@Override
	public char[][] getMap() {
		return map;
	}



	/**
	 * Sets the map.
	 *
	 * @param map the new map
	 */
	public void setMap(char[][] map) {
		this.map = map;
	}

	/* (non-Javadoc)
	 * @see gameLogic.MapGame#getOrde()
	 */
	public Orde getOrde() {
		return orde;
	}
	
	/* (non-Javadoc)
	 * @see gameLogic.MapGame#setOrde(gameLogic.Orde)
	 */
	public void setOrde(Orde orde) {this.orde = orde;}
	
	/* (non-Javadoc)
	 * @see gameLogic.MapGame#getHero()
	 */
	public Hero getHero() {return hero;}

	/* (non-Javadoc)
	 * @see gameLogic.MapGame#setHero(gameLogic.Hero)
	 */
	public void setHero(Hero hero) {this.hero = hero;}

	/* (non-Javadoc)
	 * @see gameLogic.MapGame#getGuard()
	 */
	public Enemy getGuard() {return guard;}

	/* (non-Javadoc)
	 * @see gameLogic.MapGame#setGuard(gameLogic.Enemy)
	 */
	public void setGuard(Enemy guard) {
		this.guard = guard;
	}

	/* (non-Javadoc)
	 * @see gameLogic.MapGame#isHasOgre()
	 */
	public boolean isHasOgre() {
		return hasOgre;
	}

	/* (non-Javadoc)
	 * @see gameLogic.MapGame#setHasOgre(boolean)
	 */
	public void setHasOgre(boolean hasOgre) {
		this.hasOgre = hasOgre;
	}

	/* (non-Javadoc)
	 * @see gameLogic.MapGame#isHasGuard()
	 */
	public boolean isHasGuard() {
		return hasGuard;
	}

	/* (non-Javadoc)
	 * @see gameLogic.MapGame#setHasGuard(boolean)
	 */
	public void setHasGuard(boolean hasGuard) {
		this.hasGuard = hasGuard;
	}

}
