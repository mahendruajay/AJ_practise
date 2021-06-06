package playground.general;

public class ObjectMethods {
	
	int value;
	String name;
	
	public ObjectMethods(int value, String name){
		this.value = value;
		this.name = name;	
		
	}
	
	public String toString(){
		return "ObjectMethods toString - " + this.value + " " + this.name;
	}
	
	public boolean equals(Object o){
		
		if(o instanceof ObjectMethods){
			if(((ObjectMethods) o).name.equalsIgnoreCase(this.name) && ((ObjectMethods)o).value == this.value)
				return true;
			else return false;
		}
		return false;
	}

	public int hashCode(){
	 
		return 0;
	}
	
	public static void main(String [] args){
		ObjectMethods o = new ObjectMethods(1,"one");
		ObjectMethods n = new ObjectMethods(1,"one");
		ObjectMethods n1 = new ObjectMethods(2,"one");
		System.out.println(o);
		System.out.println(o.equals(n));
		System.out.println(o.equals(n1));
		
	}
}

