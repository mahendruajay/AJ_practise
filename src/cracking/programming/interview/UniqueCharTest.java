package cracking.programming.interview;

public class UniqueCharTest {

	
	
	public static void main(String[] args){
		 
		System.out.print(UniqueCharTest.isUniqueChar("sdfghjkle"));
		System.out.print(isUniqueCharbyBit("sadfgfd"));
		
	}
	
	
	//Problem 1.1
	public static boolean isUniqueChar(String inStr){
		
		//Considering that the chars are from ascii set
		if(inStr.length() > 256){
			return false;
		}
		else{
			boolean [] charSet = new boolean[256];
			for (int i=0; i<inStr.length(); i++){
				if(charSet[inStr.charAt(i)]){
					return false;
				}
				charSet[inStr.charAt(i)] = true;
			}
		}
		return true;
	}
	
	public static boolean isUniqueCharbyBit(String inStr){
		
		int bitVector =0;
		for (int i=0;i<inStr.length();i++){
			
			int val = inStr.charAt(i) -'a';
			
			if((bitVector & (1 << val)) >0){
				return false;
			}
			
			bitVector |= (1 << val);
		}
		
		return true;
	}
	
	
}
