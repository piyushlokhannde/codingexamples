package main.java.cmdmapper.util;

import main.java.cmdmapper.CommandMapperRepo;
import main.java.cmdmapper.exception.WordMappingNotExist;
import main.java.romannumerial.exception.InavalidRomanNumberException;
import main.java.romannumerial.RomanNumber;

public class WordMapperUtil {
	
	public static RomanNumber convertCmdStringToRomanNumerical(String cmd,
			CommandMapperRepo repo) throws WordMappingNotExist, InavalidRomanNumberException {
		String[] commandArray = convertCommandToWordArray(cmd);
		StringBuilder builder = new StringBuilder();
		for (String word : commandArray) {			
			builder.append(repo.getRomanNumerical(word));
		}
		RomanNumber romanNumercal =  RomanNumber.getInstance(builder.toString());
		return romanNumercal;
	}
	
	public static String[] convertCommandToWordArray(String command) {
		String[] commandArray = command.split(" ");
		return commandArray;
	}
	
	public static String trimQuestonCommnad(String command) {
		command = command.substring(
				command.indexOf("is")+2, command.length()-1).trim();
		return command;		
	}
	
	
	
	
	
	

}
