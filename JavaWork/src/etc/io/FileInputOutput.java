package etc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class FileInputOutput {
	public static void main(String[] arg){
		saveFile("src/etc/io/inText.txt", "src/etc/io/outText.txt");
		
		readTextFromFile("src/etc/io/outText.txt");
		
		MyObject myObject = new MyObject();
		saveFileMyObject("src/etc/io/object.txt", myObject);
		
		
		MyObject readMyObject = readFileMyObject("src/etc/io/object.txt");
		System.out.println(readMyObject.name);
	}
	
	public static void saveFile(String inFile, String outFile){
		File in = new File(inFile);
		File out = new File(outFile);
		
		try {
			InputStream is = new FileInputStream(in);
			OutputStream os = new FileOutputStream(out);
			
			byte[] buffer = new byte[8 * 1024];
			int length;
			
			while((length = is.read(buffer))>= 0){
				if(length>0){
					os.write(buffer, 0, length);
				}
			}
			os.flush();
			is.close();
			os.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readTextFromFile(String file){
		File inFile = new File(file);
		try {
			InputStream is = new FileInputStream(inFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			
			String line;
			while((line=br.readLine()) != null){
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void saveFileMyObject(String file, MyObject myObject){
		File out = new File(file);
		
		try {
			OutputStream os = new FileOutputStream(out);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject(myObject);
			
			oos.flush();
			oos.close();
			os.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static MyObject readFileMyObject(String file){
		File in = new File(file);
		
		try {
			InputStream is = new FileInputStream(in);
			ObjectInputStream ois = new ObjectInputStream(is);
			
			return (MyObject)ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
}
