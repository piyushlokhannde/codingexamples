package main.java.piyush.symbolparser.command;

public class CommandUtil {
	
	public static String getMetalName(String command) {
		return command.substring(command.lastIndexOf(" ")+1);
		
	}

}
