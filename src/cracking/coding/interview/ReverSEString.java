package cracking.coding.interview;

public class ReverSEString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(reverseStringByBuff(null));
		System.out.println(reverseString(null));
		//System.out.println(reverseString(""));
		System.out.println(reverseString("anu"));

	}

	
public static String reverseString(String str){
		
		if(null == str || (str.length() == 0)) return null;
				
		int end = str.length()-1;
		int start = 0;
		char[] charArray = str.toCharArray();
		
		while (start<end){
			char c = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = c;
			start++;
			end--;
		}
		
		str = new String(charArray);
		return str;
	}
	
	public static String reverseStringByBuff(String str){
		
		if(null == str) return null;
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
		
	}
}
