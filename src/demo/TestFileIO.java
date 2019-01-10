package demo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestFileIO {
	
	public static void main(String[] args) {
		//Writer/OutputStream/ FileOutputStream /PrintWriter
		try {
			PrintWriter pw=new PrintWriter(new File("a.txt"));
			for (int i = 0; i < 100000; i++)
				pw.println(i);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
