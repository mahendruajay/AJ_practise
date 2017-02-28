package cracking.programming.interview;

public class ReverseStringTest {
	
	public static void main(String[] args){
		 
		System.out.print(reverseString("sdfghjkll dds"));
		
	}
	
	public static String reverseString(String str){

		StringBuffer strBuff = new StringBuffer(str);
		
		return strBuff.reverse().toString();	
				
	}

}
