package general;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientSerializeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Dog d = new Dog (1,10);	
	
	try {
		FileOutputStream fo;
	
		fo = new FileOutputStream ("transientSerlizedfile.ser");
	
		ObjectOutputStream objO = new ObjectOutputStream(fo);
		objO.writeObject(d);
		objO.close();
		
		FileInputStream fi = new FileInputStream("transientSerlizedfile.ser");
		ObjectInputStream objI = new ObjectInputStream(fi);
		Dog cd = (Dog)objI.readObject();
		
		System.out.println("Breed-" + cd.breed + "\nBeltName-"+ cd.b.name);
		 
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	}

}
