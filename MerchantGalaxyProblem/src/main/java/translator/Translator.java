package main.java.translator;

import java.util.ArrayList;
import java.util.List;

import main.java.cmdmapper.CmdExecutor;
import main.java.cmdmapper.CommandMapperRepo;
import main.java.cmdmapper.CreditCmdMapper;
import main.java.cmdmapper.HowManyCreditCmdMapper;
import main.java.cmdmapper.HowMuchIsCmdMapper;
import main.java.cmdmapper.WordCmdMapper;

public class Translator {
	
	private CmdExecutor cmdExecutor;
	
	private List<String> inputCommands;
	

	public Translator(CmdExecutor cmdExecutor, List<String> inputCommands) {
		this.cmdExecutor = cmdExecutor;
		this.inputCommands = inputCommands;
	}

	public List<String> translate() {
		
		List<String> outputList = new ArrayList<>();
		inputCommands.stream().forEach(e -> { String output =cmdExecutor.decipher(e);
		if(output !=null) {
			outputList.add(output);
		}});		
		return outputList;
	}
	
	public static void main(String[] args) {
		List<String> inputCommands = new ArrayList<>();
		inputCommands.add("glob is I");
		inputCommands.add("prok is V");
		inputCommands.add("pish is X");
		inputCommands.add("tegj is L");
		inputCommands.add("glob glob Silver is 34 Credits");
		inputCommands.add("glob prok Gold is 57800 Credits");
		inputCommands.add("pish pish Iron is 3910 Credits");
		inputCommands.add("how much is pish tegj glob glob ?");
		inputCommands.add("how many Credits is glob prok Silver ?");
		inputCommands.add("how many Credits is glob prok Gold ?");
		inputCommands.add("how many Credits is glob prok Iron ?");
		inputCommands.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
		CommandMapperRepo repo = new CommandMapperRepo();
		CmdExecutor cmdExecutor= new CmdExecutor(repo);
		cmdExecutor.addCommandMapper(new WordCmdMapper());
		cmdExecutor.addCommandMapper(new CreditCmdMapper());
		cmdExecutor.addCommandMapper(new HowManyCreditCmdMapper());
		cmdExecutor.addCommandMapper(new HowMuchIsCmdMapper());
		List<String> outputList = new Translator(cmdExecutor, inputCommands).translate();
		outputList.stream().forEach(System.out::println);
	}

}
