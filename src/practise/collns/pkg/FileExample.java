package practise.collns.pkg;
import java.io.*;

public class FileExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
		File f = new File("temp.txt");//file not yet created on the disk
		System.out.println(f.exists());
		
		if(!f.exists()){
			
				f.createNewFile();
			} 
		
		System.out.println(f.exists());
		
		fileWriteRead();
		buffReadWrite();
		printReadWrite();
		makeDirFile();
		
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		

	}
	
	public static void fileWriteRead(){
		
		try{
			File fwr = new File ("WriterReader.txt");
			FileWriter fw = new FileWriter(fwr);
			FileReader fr = new FileReader(fwr);
			char [] in = new char[50];
			fw.write("This is a file with file reader writer\n");
			fw.flush();
			fw.close();
			
			fr.read(in);
			fr.close();
			
			System.out.println(in.toString()); //array.toString() does not work
			System.out.println(new String(in));
			
			
			/*for(char c : in){
				System.out.println(c);
			}*/
			
			
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
	}
	




public static void buffReadWrite(){
	
	try{
		File brw = new File("BuffReadWrite.txt");
		FileWriter fw = new FileWriter(brw);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("This is a buffered read write file");
		fw.flush();
		bw.flush();
		fw.close();
		bw.close();
		
		FileReader fr = new FileReader(brw);
		BufferedReader br = new BufferedReader(fr);
		System.out.println(br.readLine());	
		
		fr.close();
		br.close();
		
		
	}catch(IOException e){
		
	}
	
	}	

	public static void printReadWrite(){
		
		try{
			
		
			File prw = new File("PrintWriteRead.txt");
			FileWriter fw = new FileWriter(prw);
			PrintWriter pw = new PrintWriter(fw);
			pw.write("this is a printwrite reader file ");
			pw.print(false);
			pw.println(" This is println ");
			pw.append('a');
			
			pw.flush();
			pw.close();
			
			FileReader fr = new FileReader(prw);
			BufferedReader pr = new BufferedReader(fr);
			System.out.println(pr.readLine());
			
		}catch(IOException e){
			
		}
	}
	
	public static void makeDirFile(){
		
		try{
			File dir = new File("myDir");
			dir.mkdir();
			File myfile = new File(dir, "myFile.txt");
			FileWriter fw = new FileWriter(myfile);
			
			System.out.println(myfile.exists());
			fw.close();
			
		}catch(IOException e){
			
		}
		
	}

}