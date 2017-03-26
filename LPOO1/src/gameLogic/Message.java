package gameLogic;

// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 */
public class Message {
	
	/**
	 * Instantiates a new message.
	 */
	public Message()
	{};
	
	/**
	 * Victory msg map 1.
	 */
	public void victoryMsgMap1()
	{
		System.out.println("You won! You have entered the dungeon level."); 
	}
	
	/**
	 * Game over msg map 1.
	 */
	public void gameOverMsgMap1()
	{
		System.out.println("The guard caught you. Game Over!");
	}
	
	/**
	 * Victory msg map 2.
	 */
	public void victoryMsgMap2()
	{
		System.out.println("You won! You have escaped the dungeon level."); 
	}
	
	/**
	 * Game over msg map 2.
	 */
	public void gameOverMsgMap2()
	{
		System.out.println("The ogre strikes his club and kills you. Game Over!");
	}
}
