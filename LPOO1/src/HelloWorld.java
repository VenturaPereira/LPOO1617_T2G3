import java.util.Scanner;

public class HelloWorld {

	
	public static void game(DnD game){
		String answer;
		Scanner scan = new Scanner(System.in);
		System.out.println("Here's the initial board! If you dare to play press Y, otherwise, press N.");
		game.printBoard();
		answer = scan.next().toUpperCase();
		switch(answer){
		case "Y":
			decisions(game);
			
			
			break;
		case "N":
			break;
			
			default:
				break;
		}
			
		
		
	}
	
	public static void decisions(DnD game){
		int i = 0;
		Scanner scanner = new Scanner(System.in);
		while(i < 5){
		
		System.out.println("Where do you wish to move? /n D - down /n U  - up /n  R - right /n L - left");
		String answer = scanner.next().toUpperCase();
		
		switch(answer){
		case "D":
			game.moveDown();
			game.guardMove();
			game.printBoard();
			i++;
			break;
	case "U":
		game.moveUp();
		game.guardMove();
		game.printBoard();
		i++;
		break;
	
  case "R":
	game.moveRight();
	game.guardMove();
	game.printBoard();
	i++;
	break;
case "L":
	game.moveLeft();
	game.guardMove();
	game.printBoard();
	i++;
	break;
}}
	}
	
	
	
	public static void main(String[] args) {
	  
		DnD game= new DnD();
        game(game);
		
	}

	
}
