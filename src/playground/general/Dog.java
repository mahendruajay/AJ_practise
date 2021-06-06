package playground.general;

import java.io.*;
public class Dog implements Serializable {

	int breed;
	transient Belt b;
	
	public Dog(int breed, int name){
		this.breed = breed;
		this.b = new Belt(name);		
	}

	
	private void writeObject(ObjectOutputStream os){
		
		try {
			os.defaultWriteObject();
			os.writeInt(this.b.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void readObject(ObjectInputStream is){
		
		
		try {
			is.defaultReadObject();
			this.b = new Belt(is.readInt());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
