
import java.util.Scanner;

public class HelloWorld {

	public static void game(DnD game) {
		String answer;
		Scanner scan = new Scanner(System.in);
		System.out.println("Here's the initial board! If you dare to play press Y, otherwise, press N.");
		game.printBoard();
		answer = scan.next().toUpperCase();
		switch (answer) {
		case "Y":
			decisions(game);

			break;
		case "N":
			break;

		default:
			break;
		}

	}
	public static void decisionsNextLvl(DnD game){
		 int i = 0;
		 game.newLevel();
		Scanner scanner = new Scanner(System.in);
		while (!game.analyseOgre()) {
             
			System.out.println("Where do you wish to move?  S - down  W - up  D - right  A - left");
			String answer = scanner.next().toUpperCase();

			switch (answer) {
			case "S":
				game.moveDown(game.nextLevelBoard);
				game.moveOgre();
				game.newLevel();
				i++;
				break;
			case "W":
				game.moveUp(game.nextLevelBoard);
				game.moveOgre();
				game.newLevel();
				i++;
				break;

			case "D":
				game.moveRight(game.nextLevelBoard);
				game.moveOgre();
				game.newLevel();
				i++;
				break;
			case "A":
				game.moveLeft(game.nextLevelBoard);
				game.moveOgre();
				game.newLevel();
				i++;
				break;
			}
		}
		if(game.analyseOgre())
		{
			System.out.println("The ogre caught you! Game over.");
		}else if(game.analyseStairs(game.nextLevelBoard))
		{
			System.out.println("You won!!!");
			if(game.whichBoard(game.nextLevelBoard))
	        decisionsNextLvl(game);
		}
		
		
	}

	public static void decisions(DnD game) {
		
		Scanner scanner = new Scanner(System.in);
		while (!game.analyseGuard() && (!game.analyseStairs(game.board) || !game.analyseStairs(game.nextLevelBoard))) {

			System.out.println("Where do you wish to move?  S - down  W - up  D - right  A - left");
			String answer = scanner.next().toUpperCase();

			switch (answer) {
			case "S":
				game.moveDown(game.board);
				game.guardMove();
				game.printBoard();
				
				break;
			case "W":
				game.moveUp(game.board);
				game.guardMove();
				game.printBoard();
				
				break;

			case "D":
				game.moveRight(game.board);
				game.guardMove();
				game.printBoard();
				
				break;
			case "A":
				game.moveLeft(game.board);
				game.guardMove();
				game.printBoard();
				
				break;
			}
		}
		if(game.analyseGuard())
		{
			System.out.println("The guard caught you! Game over.");
		}
		else if(game.analyseStairs(game.board))
		{
			System.out.println("You've reached the stairs!");
			if(game.whichBoard(game.board))
	        decisionsNextLvl(game);
		}
	}
	
	

	public static void main(String[] args) {

		DnD game = new DnD();
		game(game);

	}

}