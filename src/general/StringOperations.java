package general;

public class StringOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String x = "Java";
		System.out.println(x);
		x.concat("Concatenate");
		System.out.println(x);
		x.replace('a', 'x');
		System.out.println(x);
		x.toUpperCase();
		System.out.println(x);
		
		x = x.concat("Concatenate");
		System.out.println(x);
		x = x.replace('a', 'x');
		System.out.println(x);
		x = x.toUpperCase();
		System.out.println(x);
		
		//all string operations work with start index =0
		System.out.println(x.charAt(0));
		System.out.println(x.equalsIgnoreCase("Java"));
		System.out.println(x.contains("J"));
		
		//StringBuilder (NOT threadSafe) StringBuffer(ThreadSafe) classes should be used when 
		//lot of modifications needs ot be done
		//both classes have the exact same API
		//these classes work on the same string object..they are not immutable
		
		StringBuilder sb = new StringBuilder("abcdef");
		sb.append("ghi");
		sb.reverse();
		sb.insert(0, false);  //offset,boolean
		sb.insert(0, "abc"); //offset, string
		sb.insert(0, 'z'); //offset, char
		System.out.println(sb);
		System.out.println(sb.toString());
		
		
		
		
		
		
		//
	}

}
