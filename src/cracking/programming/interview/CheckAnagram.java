package cracking.programming.interview;

public class CheckAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(checkAnagram("anuradha","radhaanu"));
		System.out.println(checkAnagram("anuradha","radhaa"));
		System.out.println(checkAnagram("",""));
		System.out.println(checkAnagram(null,"radhaa"));
		System.out.println(checkAnagram(null,null));
	}
	
	
	public static boolean checkAnagram(String s1, String s2){
		
		if(s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int[] flag = new int[256];
		for(int i=0; i<c1.length;i++){
			flag[c1[i]]++;
		}
		
		for(int i=0; i<c2.length;i++){
			
			if(flag[c2[i]]--  <0){
				return false;
			}
		}
		return true;
	}

}

