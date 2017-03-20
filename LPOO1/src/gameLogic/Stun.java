package gameLogic;

public class Stun {
	
	
	private MapGame map;
	
	public Stun(MapGame map)
	{
		this.map = map;
	}
	
	public void stun()
	{
		for(int k = 0; k < this.map.getOrde().getOrde().size(); k++)
		{
			
			int oi = this.map.getOrde().getOrde().get(k).getI();
			int oj = this.map.getOrde().getOrde().get(k).getJ();
			if((this.map.getHero().getHi() == oi && this.map.getHero().getHj() == oj) || (this.map.getHero().getHi() == oi-1 && this.map.getHero().getHj() == oj) || (this.map.getHero().getHi() == oi+1 && this.map.getHero().getHj() == oj) || (this.map.getHero().getHi() == oi && this.map.getHero().getHj() == oj+1) || (this.map.getHero().getHi() == oi && this.map.getHero().getHj() == oj-1))
			{
				this.map.getOrde().getOrde().get(k).stun(3);
			}
		}
		
	}
}
