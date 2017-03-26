package gameLogic;


/**
 * The Class Game.
 */
public class Game {
 
	/** The leveling. */
	private Levels leveling;
	
	/** The map 1. */
	private Mapa1 map1;
	
	/** The map 2. */
	private Mapa2 map2;
	
	/** The game overlvl 2. */
	private GameOver gameOver, gameOverlvl2;
	
	/** The winlvl 2. */
	private WinGame winning, winlvl2;
	
	/** The number of ogres. */
	private int numberOfOgres;
	
	/** The choose guard. */
	private String chooseGuard;
	
	/** The orde. */
	private Orde orde;
	
	/** The stun. */
	private Stun stun;
	
	/**
	 * Instantiates a new game.
	 *
	 * @param numberOfOgres the number of ogres
	 * @param chooseGuard the choose guard
	 */
	public Game(int numberOfOgres, String chooseGuard){
		
		 setLeveling(new Levels());
		 setMap1(new Mapa1(getLeveling()));
		 setChooseGuard(chooseGuard);
		 switch(chooseGuard){
		 case "Rookie":
			 map1.setGuard(new Rookie());
			 break;
		 case "Drunken":
			 map1.setGuard(new Drunken());
			 break;
		 case "Suspicious":
			 map1.setGuard(new Suspicious());
			 break;
		 }
		 getMap1().setRunning(true);
		 setMap2(new Mapa2(getLeveling()));
		 setGameOver(new GameOver(getMap1().getHero(), getMap1().getGuard(), getMap1()));
		 setWinning(new WinGame(getMap1()));
		 this.numberOfOgres = numberOfOgres;
		 setOrde(new Orde(numberOfOgres));
         map2.setOrde(this.orde);	
         setGameOverlvl2(new GameOver(getMap2().getHero(), getMap2().getOrde(), getMap2()));
         setStun(new Stun(map2));
         setWinlvl2(new WinGame(map2));
		 this.setChooseGuard(chooseGuard);
	}
	
	/**
	 * Gets the current map.
	 *
	 * @return the current map
	 */
	public MapGame getCurrentMap(){
		for(int i = 0; i < leveling.getLevels().size(); i++){
			if(leveling.getLevels().get(i).getRunning()){
				return leveling.getLevels().get(i);
			}
		}
		return null;
	}
	
	/**
	 * Gets the leveling.
	 *
	 * @return the leveling
	 */
	public Levels getLeveling() {
		return leveling;
	}
	
	/**
	 * Sets the leveling.
	 *
	 * @param leveling the new leveling
	 */
	public void setLeveling(Levels leveling) {
		this.leveling = leveling;
	}
	
	/**
	 * Gets the map 1.
	 *
	 * @return the map 1
	 */
	public Mapa1 getMap1() {
		return map1;
	}
	
	/**
	 * Sets the map 1.
	 *
	 * @param map1 the new map 1
	 */
	public void setMap1(Mapa1 map1) {
		this.map1 = map1;
	}
	
	/**
	 * Gets the map 2.
	 *
	 * @return the map 2
	 */
	public Mapa2 getMap2() {
		return map2;
	}
	
	/**
	 * Sets the map 2.
	 *
	 * @param map2 the new map 2
	 */
	public void setMap2(Mapa2 map2) {
		this.map2 = map2;
	}
	
	/**
	 * Gets the game over.
	 *
	 * @return the game over
	 */
	public GameOver getGameOver() {
		return gameOver;
	}
	
	/**
	 * Sets the game over.
	 *
	 * @param gameOver the new game over
	 */
	public void setGameOver(GameOver gameOver) {
		this.gameOver = gameOver;
	}
	
	/**
	 * Gets the winning.
	 *
	 * @return the winning
	 */
	public WinGame getWinning() {
		return winning;
	}
	
	/**
	 * Sets the winning.
	 *
	 * @param winning the new winning
	 */
	public void setWinning(WinGame winning) {
		this.winning = winning;
	}
	
	/**
	 * Gets the orde.
	 *
	 * @return the orde
	 */
	public Orde getOrde() {
		return orde;
	}
	
	/**
	 * Sets the orde.
	 *
	 * @param orde the new orde
	 */
	public void setOrde(Orde orde) {
		this.orde = orde;
	}
	
	/**
	 * Gets the choose guard.
	 *
	 * @return the choose guard
	 */
	public String getChooseGuard() {
		return chooseGuard;
	}
	
	/**
	 * Sets the choose guard.
	 *
	 * @param chooseGuard the new choose guard
	 */
	public void setChooseGuard(String chooseGuard) {
		this.chooseGuard = chooseGuard;
	}
	
	/**
	 * Gets the game overlvl 2.
	 *
	 * @return the game overlvl 2
	 */
	public GameOver getGameOverlvl2() {
		return gameOverlvl2;
	}
	
	/**
	 * Sets the game overlvl 2.
	 *
	 * @param gameOverlvl2 the new game overlvl 2
	 */
	public void setGameOverlvl2(GameOver gameOverlvl2) {
		this.gameOverlvl2 = gameOverlvl2;
	}
	
	/**
	 * Gets the stun.
	 *
	 * @return the stun
	 */
	public Stun getStun() {
		return stun;
	}
	
	/**
	 * Sets the stun.
	 *
	 * @param stun the new stun
	 */
	public void setStun(Stun stun) {
		this.stun = stun;
	}
	
	/**
	 * Gets the winlvl 2.
	 *
	 * @return the winlvl 2
	 */
	public WinGame getWinlvl2() {
		return winlvl2;
	}
	
	/**
	 * Sets the winlvl 2.
	 *
	 * @param winlvl2 the new winlvl 2
	 */
	public void setWinlvl2(WinGame winlvl2) {
		this.winlvl2 = winlvl2;
	}
	
	
}
