package gameLogic;

public class NewMapGame extends MapGame {

	private char[][] map;
	private Levels level;
	private Ogre ogre;
	private Hero hero;
	private Enemy guard;
	private boolean hasOgre = false;
	private boolean hasGuard = false;
	
	
	public NewMapGame(char[][] map, Levels level){
		this.setMap(new char[map.length][map[0].length]);
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				if(map[i][j] == 'H'){
					this.getMap()[i][j] = ' ';
					setHero(new Hero());
					getHero().setHi(i);
					getHero().setHj(j);		
				}
				if(map[i][j] == 'G'){
					setHasGuard(true);
					this.getMap()[i][j]=' ';
					setGuard(new Rookie());
					ChooseGuard which = new ChooseGuard(getGuard());
					setGuard(which.setGuard());
					getGuard().setI(i);
					getGuard().setJ(j);
				}else if(map[i][i] == '0'){
					setHasOgre(true);
					this.getMap()[i][j] = ' ';
					setOgre(new Ogre());
					getOgre().setI(i);
					getOgre().setJ(j);
				}
				else{
					this.map[i][j]=map[i][j];
				}
			}
		}
		this.level=level;
		this.level.addLevel(this);
	}
	
	public void setDoors(){
		for(int i =0; i < getMap().length;i++){
			for(int j=0; j < getMap()[i].length; j++){
				if(getMap()[i][j] == DOOR){
					getMap()[i][j] = STAIRS;
				}
			}
		}
	}
	
	
	public void printBoard(Hero hero, Enemy guard) {
	  int hi = this.getHero().getHi();
	  int hj = this.getHero().getHj();
	 
	  for (int i = 0; i < getMap().length; i++) {
		    for (int j = 0; j < getMap()[i].length; j++) {
		    	if(i == hi && j == hj){
		    		//board[i][j]= HERO;
		    		System.out.print("H|");
		    		j++;
		    	}if(this.isHasGuard()){
		    		
		    	
		    	if(i == this.getGuard().getI() && j == this.getGuard().getJ()){
		    		System.out.print("G|");
		    		j++;
		    	} 
		    	}else if(this.isHasOgre()){
		    		
		    		if(i == this.getOgre().getI() && j == this.getOgre().getJ()){
			    		System.out.print("0|");
			    		j++;
			    	} 
		    		
		    	}
		        System.out.print(getMap()[i][j] + "|");
		    }
		    System.out.println(" ");
		}
	  }
		


	@Override
	public char[][] getMap() {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		
	}

	public void setMap(char[][] map) {
		this.map = map;
	}

	public Ogre getOgre() {
		return ogre;
	}

	public void setOgre(Ogre ogre) {
		this.ogre = ogre;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Enemy getGuard() {
		return guard;
	}

	public void setGuard(Enemy guard) {
		this.guard = guard;
	}

	public boolean isHasOgre() {
		return hasOgre;
	}

	public void setHasOgre(boolean hasOgre) {
		this.hasOgre = hasOgre;
	}

	public boolean isHasGuard() {
		return hasGuard;
	}

	public void setHasGuard(boolean hasGuard) {
		this.hasGuard = hasGuard;
	}

}
