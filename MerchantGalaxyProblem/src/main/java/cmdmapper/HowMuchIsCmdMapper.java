package main.java.cmdmapper;

import main.java.cmdmapper.exception.CommandDecipherException;
import main.java.cmdmapper.exception.WordMappingNotExist;
import main.java.cmdmapper.util.WordMapperUtil;
import main.java.romannumerial.RomanNumber;

public class HowMuchIsCmdMapper implements CmdMapper {
	
	

	
	public String decipher(String cmd, CommandMapperRepo repo) throws CommandDecipherException {
		
		String output =null;
		
		try {
			cmd = WordMapperUtil.trimQuestonCommnad(cmd);
			RomanNumber	romanNumercal =	WordMapperUtil
					.convertCmdStringToRomanNumerical(cmd, repo);			
			output =  cmd + " is "+ romanNumercal.getDecimalValue();
		} catch (Exception e) {			
			e.printStackTrace();
			throw new CommandDecipherException("Error in decipher the command How Much Is");
		}
		return output;
	}

	@Override
	public boolean isPatternMathcing(String command) {
		// TODO Auto-generated method stub
		return command.startsWith("how much is ") && command.endsWith(" ?");
	}
	
	
	
	
	

}
