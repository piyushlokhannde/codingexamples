package test.java.translator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.hamcrest.Matchers.hasItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.cmdmapper.CmdExecutor;
import main.java.cmdmapper.CommandMapperRepo;
import main.java.cmdmapper.CreditCmdMapper;
import main.java.cmdmapper.HowManyCreditCmdMapper;
import main.java.cmdmapper.HowMuchIsCmdMapper;
import main.java.cmdmapper.WordCmdMapper;
import main.java.translator.Translator;

public class TranslatorTest {

	CommandMapperRepo repo;
	CmdExecutor cmdExecutor;
	List<String> inputCommands;
	@Before
	public void setUp() throws Exception {		
		repo = new CommandMapperRepo();
		cmdExecutor= new CmdExecutor(repo);
		cmdExecutor.addCommandMapper(new WordCmdMapper());
		cmdExecutor.addCommandMapper(new CreditCmdMapper());
		cmdExecutor.addCommandMapper(new HowManyCreditCmdMapper());
		cmdExecutor.addCommandMapper(new HowMuchIsCmdMapper());
		inputCommands = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTranslatorForHowMuchCommand() {		
		inputCommands.add("glob is I");
		inputCommands.add("prok is V");
		inputCommands.add("pish is X");
		inputCommands.add("tegj is L");
		inputCommands.add("how much is pish tegj glob glob ?");
		Translator translator = new Translator(cmdExecutor, inputCommands);
		List<String> outputList = translator.translate();
		assertThat(outputList, iterableWithSize(1));
		assertThat(outputList,hasItem("pish tegj glob glob is 42"));
	}
	
	@Test
	public void testTranslatorForHowMuchInvalidCommand() {	
		inputCommands.add("glob is I");
		inputCommands.add("prok is V");
		inputCommands.add("pish is X");
		inputCommands.add("tegj is L");
		inputCommands.add("how much is pish1 tegj glob glob ?");
		Translator translator = new Translator(cmdExecutor, inputCommands);
		List<String> outputList = translator.translate();
		assertThat(outputList, iterableWithSize(1));
		assertThat(outputList,hasItem("I have no idea what you are talking about"));
	}
	
	
	@Test
	public void testTranslatorForHowManyCommand() {	
		inputCommands.add("glob is I");
		inputCommands.add("prok is V");
		inputCommands.add("pish is X");
		inputCommands.add("tegj is L");
		inputCommands.add("glob glob Silver is 34 Credits");
		inputCommands.add("how many Credits is glob prok Silver ?");
		Translator translator = new Translator(cmdExecutor, inputCommands);
		List<String> outputList = translator.translate();
		assertThat(outputList, iterableWithSize(1));
		assertThat(outputList,hasItem("glob prok Silver is 68 Credits"));
	}
	
	@Test
	public void testTranslatorForHowManyCommandInvalid() {	
		inputCommands.add("glob is I");
		inputCommands.add("prok is V");
		inputCommands.add("pish is X");
		inputCommands.add("tegj is L");
		//inputCommands.add("glob glob Silver is 34 Credits");
		inputCommands.add("how many Credits is glob prok Silver ?");
		Translator translator = new Translator(cmdExecutor, inputCommands);
		List<String> outputList = translator.translate();
		assertThat(outputList, iterableWithSize(1));
		assertThat(outputList,hasItem("I have no idea what you are talking about"));
	}

}
