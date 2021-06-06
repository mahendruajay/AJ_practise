package playground.general;

public class Stringsplit {

	public static void main(String[] args) {
		String s = "asd asd dfg ghj";
		String [] token = s.split("\\s");
		for (String st : token){
			System.out.println(st);
		}
		
	}
}
