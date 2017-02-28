package practise.collns.pkg;

import java.io.IOException;

public class MyExceptionTest {

	
	public void myMethod(){
		
		try{
			throw new MyException();
						
		}catch(MyException e){
			
		}
	}
	
	
	public void myTest() throws MyException{
		
	}
	
	public void doStuff() throws Exception{
		
		try{
			
		}catch(Exception e){
			
			throw e;//cause of this statement it added throws clause above
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
