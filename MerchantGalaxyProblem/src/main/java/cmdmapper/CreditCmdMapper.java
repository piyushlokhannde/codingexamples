package main.java.cmdmapper;

import main.java.cmdmapper.exception.CommandDecipherException;
import main.java.cmdmapper.exception.WordMappingNotExist;
import main.java.cmdmapper.util.WordMapperUtil;
import main.java.romannumerial.RomanNumber;

public class CreditCmdMapper  implements  CmdMapper {

	public String decipher(String cmd, CommandMapperRepo commandMapperRepo) throws CommandDecipherException {		
		try {
			cmd = cmd.substring(0, cmd.indexOf("Credits")).trim();
		
			String[] command = cmd.split(" is ");			
			String metalName = command[0].substring(				
					command[0].lastIndexOf(" "), command[0].length()).trim();
			
			if(metalName == null  || "".equals(metalName)
					||checkIfWordExistInMapper(metalName, commandMapperRepo)) {
				throw new CommandDecipherException("Error in command deciphrt in credit");
			}			
			
					
			RomanNumber	romanNumercal =	WordMapperUtil
					.convertCmdStringToRomanNumerical(command[0].substring(	0			
					, command[0].lastIndexOf(" ")).trim(), commandMapperRepo);
			int totalValue  = Integer.valueOf(command[1]);			
			commandMapperRepo.addMetalBaseValue(metalName,totalValue/romanNumercal.getDecimalValue());
			return null;
		} catch (Exception e) {
			e.printStackTrace();			
			throw new CommandDecipherException("Error in commsnd deciphrt in credit");
		}
	}

	

	
	
	
	private boolean checkIfWordExistInMapper(String word,  CommandMapperRepo commandMapperRepo) {
		try {
			commandMapperRepo.getRomanNumerical(word);
			return true;
		} catch (WordMappingNotExist e) {
			
			return false;
		}
	}






	@Override
	public boolean isPatternMathcing(String command) {
		
		return command.matches("[\\w ]+ is [0-9]+ Credits");
	}

	
	
	
	

}
