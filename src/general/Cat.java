package general;

import java.io.Serializable;

public class Cat implements Serializable {
	
	Collar c;
	String breed;

	public Cat(int a, String name, String breed){
		this.breed = breed;
		this.c = new Collar(a,name);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
