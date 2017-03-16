package gameLogic;

import java.util.Vector;

public class Levels {
	private Vector<MapGame> levels;
	
	public Levels(){
		levels = new Vector<MapGame>();
	}

	public Vector<MapGame> getLevels() {
		return levels;
	}

	public void setLevels(Vector<MapGame> levels) {
		this.levels = levels;
	}
	
	public void addLevel(MapGame map){
		levels.add(map);
	}
	
	

}
