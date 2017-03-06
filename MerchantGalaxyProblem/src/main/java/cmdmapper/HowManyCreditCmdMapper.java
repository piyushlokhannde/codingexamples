package main.java.cmdmapper;

import main.java.cmdmapper.exception.CommandDecipherException;
import main.java.cmdmapper.exception.WordMappingNotExist;
import main.java.cmdmapper.util.WordMapperUtil;
import main.java.romannumerial.RomanNumber;

public class HowManyCreditCmdMapper  implements CmdMapper {

	@Override
	public String decipher(String command, CommandMapperRepo commandMapperRepo) throws CommandDecipherException {
		
		String answer = null;
		try {
			String cmd = WordMapperUtil.trimQuestonCommnad(command).trim();
			
			String metalName = cmd.substring(cmd.lastIndexOf(" "), cmd.length()).trim();
			
			String cryptRomanString = cmd.substring(0, cmd.lastIndexOf(" "));
			
			RomanNumber	romanNumercal =	WordMapperUtil
					.convertCmdStringToRomanNumerical(cryptRomanString, commandMapperRepo);
			
			int totalValue = romanNumercal.getDecimalValue() * commandMapperRepo.getValueForMetal(metalName);
			answer = cryptRomanString+ " "+metalName+" is "+ totalValue +" Credits";
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommandDecipherException("Error in deciphering command "+command);		
		}
		
		return answer;
	}

	@Override
	public boolean isPatternMathcing(String command) {		
		return command.endsWith("?") && command.startsWith("how many Credits is");
	}
	
	
	
	

}
