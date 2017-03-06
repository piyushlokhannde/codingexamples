package main.java.cmdmapper;

import java.util.ArrayList;
import java.util.List;

import main.java.cmdmapper.exception.CommandDecipherException;

public class CmdExecutor {
	
	private CommandMapperRepo commandMapperRepo;	
	
	private List<CmdMapper> commandList = new ArrayList<>();
	

	public CmdExecutor(CommandMapperRepo repo) {
		this.commandMapperRepo =  repo;
	}


	public String decipher(String cmd) {		
		String output=null;
		try {
			output =commandList.stream()
			.filter(e ->e.isPatternMathcing(cmd))			
			.findFirst().orElse(new CmdMapper() {
				@Override
				public String decipher(String cmd, CommandMapperRepo commandMapperRepo)
						throws CommandDecipherException {					
					throw new CommandDecipherException("");				
				}
				@Override
				public boolean isPatternMathcing(String command) {
					
					return false;
				}})
			
			.decipher(cmd, commandMapperRepo);

		} catch (CommandDecipherException e) {
			output = cmd.endsWith("?")? "I have no idea what you are talking about":null;
			e.printStackTrace();
		}
		return output;
	}
	
	
	public  static class  CmdMapperBuilder  {
		
		private CommandMapperRepo wordToRomanNumerical;
		private WordCmdMapper wordCmdMapper;
		
		public void withWordToRomanNumericalRepo(CommandMapperRepo wordToRomanNumerical) {
			this.wordToRomanNumerical = wordToRomanNumerical;
		}
		
		public void withWordCmdMapper(WordCmdMapper wordCmdMapper) {
			this.wordCmdMapper = wordCmdMapper;
		}
		
		/*public  CmdMapper build() {			
			CmdMapper cmdMapper  = new CmdMapper();
			cmdMapper.wordCmdMapper = this.wordCmdMapper;
			cmdMapper.wordToRomanNumerical = this.wordToRomanNumerical;
			return cmdMapper;
		}*/
	}


	public void addCommandMapper(CmdMapper cmdMapper) {
		commandList.add(cmdMapper);
		
	}
	
}
