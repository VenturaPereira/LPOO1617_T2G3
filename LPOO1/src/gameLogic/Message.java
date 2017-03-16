package gameLogic;

public class Message {
	
	public Message()
	{};
	
	public void victoryMsgMap1()
	{
		System.out.println("You won! You have entered the dungeon level."); 
	}
	
	public void gameOverMsgMap1()
	{
		System.out.println("The guard caught you. Game Over!");
	}
	
	public void gameOverMsgMap2()
	{
		System.out.println("The ogre strikes his club and kills you. Game Over!");
	}
}
