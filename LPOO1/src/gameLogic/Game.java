package gameLogic;

public class Game {
 
	private Levels leveling;
	private Mapa1 map1;
	private Mapa2 map2;
	private GameOver gameOver, gameOverlvl2;
	private WinGame winning;
	private int numberOfOgres;
	private String chooseGuard;
	private Orde orde;
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
		 this.setChooseGuard(chooseGuard);
	}
	public MapGame getCurrentMap(){
		for(int i = 0; i < leveling.getLevels().size(); i++){
			if(leveling.getLevels().get(i).getRunning()){
				return leveling.getLevels().get(i);
			}
		}
		return null;
	}
	public Levels getLeveling() {
		return leveling;
	}
	public void setLeveling(Levels leveling) {
		this.leveling = leveling;
	}
	public Mapa1 getMap1() {
		return map1;
	}
	public void setMap1(Mapa1 map1) {
		this.map1 = map1;
	}
	public Mapa2 getMap2() {
		return map2;
	}
	public void setMap2(Mapa2 map2) {
		this.map2 = map2;
	}
	public GameOver getGameOver() {
		return gameOver;
	}
	public void setGameOver(GameOver gameOver) {
		this.gameOver = gameOver;
	}
	
	public WinGame getWinning() {
		return winning;
	}
	public void setWinning(WinGame winning) {
		this.winning = winning;
	}
	public Orde getOrde() {
		return orde;
	}
	public void setOrde(Orde orde) {
		this.orde = orde;
	}
	public String getChooseGuard() {
		return chooseGuard;
	}
	public void setChooseGuard(String chooseGuard) {
		this.chooseGuard = chooseGuard;
	}
	public GameOver getGameOverlvl2() {
		return gameOverlvl2;
	}
	public void setGameOverlvl2(GameOver gameOverlvl2) {
		this.gameOverlvl2 = gameOverlvl2;
	}
	
	
}
