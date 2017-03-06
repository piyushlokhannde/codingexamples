package main.java.cmdmapper;

import main.java.cmdmapper.exception.CommandDecipherException;

public class WordCmdMapper  implements  CmdMapper {
	
	
	
	public String decipher(String cmd, CommandMapperRepo commandMapperRepo) throws CommandDecipherException {
		try {
			String[] cmdBreaker = cmd.split(" is ");
			
			if(cmdBreaker[0] ==null || cmdBreaker[0].equals("") ||
					"".equals(cmdBreaker[1]) || !cmdBreaker[1].matches("[IVXLCDM]{1}")) {
				throw new CommandDecipherException("Error in parsing the command " +cmd);
			}		
			
			commandMapperRepo.addWordToRomanNumerical(cmdBreaker[0], cmdBreaker[1]);		
			return null;
		} catch (Exception e) {			
			e.printStackTrace();
			throw new CommandDecipherException("Error in parsing the command " +cmd);
		}		
	}

	@Override
	public boolean isPatternMathcing(String command) {		
		return command.matches("[0-9A-Za-z ]+ is [IVXLCDM]{1}");
	}	

}
