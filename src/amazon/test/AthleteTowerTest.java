package amazon.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class AthleteTowerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		List<Athlete> atheletes = new ArrayList<Athlete>();
		
		atheletes.add(new Athlete(3, 4));
		atheletes.add(new Athlete(3, 2));
		atheletes.add(new Athlete(2, 1));
		atheletes.add(new Athlete(1, 1));
		atheletes.add(new Athlete(7, 6));
		atheletes.add(new Athlete(3, 5));
//		atheletes.add(new Athlete(7, 8));
		
		Collections.sort(atheletes, new StrengthComparator());
		
		for(Athlete athelete : atheletes)
		{
			System.out.println("Athelete : " + athelete.getMass() + ", " + athelete.getStrength());
		}
		
		AthleteTowerTest testAtheleteTower = new AthleteTowerTest();
		
		System.out.println("Highest number of people in tower: " + testAtheleteTower.findHigestPeopleInTower(atheletes));
		
		

	}
	
	public int findHigestPeopleInTower(List<Athlete> atheletes)
	{
		
		int highestNoPeople = 0;
		
		if(atheletes.isEmpty())
		{
			return highestNoPeople;
		}
		
		Athlete lastAtheleteInList = atheletes.get(atheletes.size()-1);
		
		int highestStrength = lastAtheleteInList.getStrength();
		int sum = 0;
		
		for(int i = 0; i< atheletes.size() -1; i++)
		{
			sum = sum + atheletes.get(i).getMass();
			if(sum <=  highestStrength)
			{
				highestNoPeople++;
			}
			else
			{
				break;
			}
		}
		
		return highestNoPeople + 1;
	}

}
