package amazon.exercise;

/**
 * This class represents and athlete with his/her mass and strength
 * 
 * @author anu
 *
 */

public class Athlete implements Comparable<Athlete>{
	
	
	private int mass;  //mass is a positive integer < 2000000
	private int strength; //strength is a positive integer < 2000000

	public Athlete(int m, int s)
	{
		this.mass = m;
		this.strength = s;
	}
	
	public int getMass() 
	{
		return this.mass;
	}

	public int getStrength() 
	{
		return this.strength;
	}

	@Override
	public int compareTo(Athlete other) {
		
		return ((Integer)this.strength).compareTo((Integer)other.strength);
		
	}

}
