package amazon.test;

import java.util.Comparator;

public class StrengthComparator implements Comparator<Athlete> 
{
	@Override
	public int compare(Athlete one, Athlete two) 
	{
		return ((Integer)one.getStrength()).compareTo(((Integer)two.getStrength()));
	}
}
