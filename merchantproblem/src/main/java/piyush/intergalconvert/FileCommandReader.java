package main.java.piyush.intergalconvert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileCommandReader implements ICommandReader {
	
	private Scanner scanner;
	
	public FileCommandReader(String filePath) {
		
		File file = new File(filePath);
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			throw  new RuntimeException("Command File Not Found");
		}
	}

	@Override
	public boolean hasNextCommand() {
		return scanner.hasNextLine();
	}

	@Override
	public String nextCommand() {		
		return scanner.nextLine();
	}

}
