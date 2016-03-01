package taskManager.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import taskManager.subject.DashBoardSubject;

public class FileProcessor {
	static String filename;

	public static void readfromFile(File file,String given_filename) throws FileNotFoundException {
		Logger.getInstance().printToStdout(3, "readfromFile method called");
		filename = given_filename;
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		DashBoardSubject si = new DashBoardSubject();
		try {
			while ((line = bufferedReader.readLine()) != null) {
				si.setupdates(line);
			}

		} catch (IOException e) {
			System.err.println("Exception while reading from file");
			System.exit(1);
		} finally{
			if(fileReader != null){
				try{
					fileReader.close();
				} catch(IOException i){
					System.err.println("Message - " + i.getMessage());
					System.exit(1);
				}
			}
		}
	}
	public static void writeToFile() {
		Logger.getInstance().printToStdout(3, "writeToFile method called");
		PrintStream out;
		try {
			out = new PrintStream(new FileOutputStream(filename, true));
			System.setOut(out);
			
		} catch (FileNotFoundException e) {
			System.err.println("Message - " + e.getMessage());
			System.exit(1);
		}

	}
	
	public static void writeTolog(){
		PrintStream out1;
		try {
			out1 = new PrintStream(new FileOutputStream("log.txt", true));
			System.setOut(out1);
			
		} catch (FileNotFoundException e) {
			System.err.println("Message - " + e.getMessage());
			System.exit(1);
		}
		
	}

}
