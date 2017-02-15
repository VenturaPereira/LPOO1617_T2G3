
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

	public static void decisions(DnD game) {
		int i = 0;
		Scanner scanner = new Scanner(System.in);
		while (!game.analyseGuard() && !game.analyseStairs()) {

			System.out.println("Where do you wish to move?  S - down  W - up  D - right  A - left");
			String answer = scanner.next().toUpperCase();

			switch (answer) {
			case "S":
				game.moveDown();
				game.guardMove();
				game.printBoard();
				i++;
				break;
			case "W":
				game.moveUp();
				game.guardMove();
				game.printBoard();
				i++;
				break;

			case "D":
				game.moveRight();
				game.guardMove();
				game.printBoard();
				i++;
				break;
			case "A":
				game.moveLeft();
				game.guardMove();
				game.printBoard();
				i++;
				break;
			}
		}
		if(game.analyseGuard())
		{
			System.out.println("The guard caught you! Game over.");
		}
		else if(game.analyseStairs())
		{
			System.out.println("You've reached the stairs!");
		}
	}

	public static void main(String[] args) {

		DnD game = new DnD();
		game(game);

	}

}
