package gameLogic;

// TODO: Auto-generated Javadoc
/**
 * The Class Stun.
 */
public class Stun {
	
	
	/** The map. */
	private MapGame map;
	
	/**
	 * Instantiates a new stun.
	 *
	 * @param map the map
	 */
	public Stun(MapGame map)
	{
		this.map = map;
	}
	
	/**
	 * Stun.
	 */
	public void stun()
	{
		for(int k = 0; k < this.map.getOrde().getOrde().size(); k++)
		{
			
			int oi = this.map.getOrde().getOrde().get(k).getI();
			int oj = this.map.getOrde().getOrde().get(k).getJ();
			if((this.map.getHero().getHi() == oi && this.map.getHero().getHj() == oj) || (this.map.getHero().getHi() == oi-1 && this.map.getHero().getHj() == oj) || (this.map.getHero().getHi() == oi+1 && this.map.getHero().getHj() == oj) || (this.map.getHero().getHi() == oi && this.map.getHero().getHj() == oj+1) || (this.map.getHero().getHi() == oi && this.map.getHero().getHj() == oj-1))
			{
				this.map.getOrde().getOrde().get(k).stun(4);
			}
		}
		
	}
}
