package gameLogic;

public class CurrentMap extends MapGame {
	
	public void printBoard(char[][] currentMapBoard){
		  
		
		for (int i = 0; i < currentMapBoard.length; i++) {
		    for (int j = 0; j < currentMapBoard[i].length; j++) {
		        System.out.print(currentMapBoard[i][j] + "|");
		    }
		    System.out.println(" ");
		}
	}

}
