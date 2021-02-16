package cracking.coding.interview;

public class OneSubstringCall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//is bottlewater  rotation of waterbottle 
	
	public boolean isRotation(String s1, String s2){
		
		if(s1 != null && s2 != null && s1.length() > 0 && s2.length() >0 && s1.length() == s2.length()){
		
			String s1s1 = s1 +s1;
			return isSubString(s1s1,s2);
		}
		
		return false;
	}
	
	public boolean isSubString(String s1, String s2){
		return true;
	}

}
