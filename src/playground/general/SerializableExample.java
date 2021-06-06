package playground.general;

import java.io.*;

public class SerializableExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			System.out.println("Serialize");
			
			Cat c = new Cat(2,"Mani","alsacian");
			//collar object within Cat object needs to be serializable too. 
			//complate object graph needs to be serializable... once all are serializable, it does the deep copy
			
			FileOutputStream fo = new FileOutputStream ("serlizedfile.ser");
			ObjectOutputStream objO = new ObjectOutputStream(fo);
			objO.writeObject(c);
			objO.close();
			
			FileInputStream fi = new FileInputStream("serlizedfile.ser");
			ObjectInputStream objI = new ObjectInputStream(fi);
			Cat cd = (Cat)objI.readObject();
			
			System.out.println("Breed-" + cd.breed + "\nname-"+ cd.c.name + "\ncolor-" + cd.c.color);
			 
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e){
			
		}
			
	}

}
