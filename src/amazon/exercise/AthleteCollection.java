package amazon.exercise;


import java.util.Collections;
import java.util.List;


/**
 * This class represents group of athletes and operation that can be performed on the group of athletes.
 * 
 * 
 * findHighestTower()
 * 
 * @author anu
 *
 */
public class AthleteCollection {
	
	private List<Athlete> athletes;
	
	public AthleteCollection(List<Athlete> athletes){
		
		this.athletes = athletes;
	}
	
	//Sort the list of athletes on  their strength in ascending order. 
	
	private void sortAthleteCollection(){
	
		Collections.sort(this.athletes);
	}
	
	/**
	 * Find the tower of athletes with max height.
	 * Condition - An athlete can hold a tower of athletes with total mass equal to his strength or less than his strength.
	 *  
	 * @return int - max height of the tower
	 */
	
	public int findHighestTower(){
		
		int maxNoAthlete = 0;
		int maxStrength = 0;
		int strengthSum = 0;
		
		if(this.athletes.isEmpty())
		{
			return maxNoAthlete;
		}
		
		this.sortAthleteCollection();  //sort list of athletes by strength in an ascending order. 
		
		//Sorted list will have max mass and stregth athlete at the end of the list
		Athlete maxStrengthAthlete = this.athletes.get(this.athletes.size()-1);  
		maxStrength = maxStrengthAthlete.getStrength();
		
		maxNoAthlete++;  //One athlete with max strength is added to the tower
		
		for(int i = 0; i< (this.athletes.size()-1) ; i++)
		{
			strengthSum += this.athletes.get(i).getMass();
			if(strengthSum <=  maxStrength)   //Go on adding the athletes to the tower until maxStrength <= addition of each new athlete's mass
			{
				maxNoAthlete++;
			}
			else
			{
				break;
			}
		}
		
		return maxNoAthlete;	
		
	}	

}
