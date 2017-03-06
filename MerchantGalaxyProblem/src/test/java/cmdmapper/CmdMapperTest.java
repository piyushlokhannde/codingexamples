package test.java.cmdmapper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.equalTo;
import org.mockito.runners.MockitoJUnitRunner;


import main.java.cmdmapper.CmdExecutor;
import main.java.cmdmapper.WordCmdMapper;
import main.java.cmdmapper.CommandMapperRepo;
import main.java.cmdmapper.CreditCmdMapper;
import main.java.cmdmapper.HowManyCreditCmdMapper;
import main.java.cmdmapper.HowMuchIsCmdMapper;
import main.java.cmdmapper.exception.CommandDecipherException;

@RunWith(MockitoJUnitRunner.class)
public class CmdMapperTest {
	
	@Spy
	CommandMapperRepo repo;
	
	@Spy
	WordCmdMapper wordCmdMapper;
	
	@Spy
	CreditCmdMapper  creditCmdMapper;
	
	@Spy 
	HowManyCreditCmdMapper howManyCreditCmdMapper;
	
	HowMuchIsCmdMapper howMuchIsCmdMapper;
	
	@InjectMocks
	CmdExecutor cmdMapper;
	

	@Before
	public void setUp() throws Exception {
		repo =spy(new CommandMapperRepo());
		wordCmdMapper = spy( new WordCmdMapper());
		creditCmdMapper =spy(new CreditCmdMapper());
		howMuchIsCmdMapper = spy(new HowMuchIsCmdMapper() );
		howManyCreditCmdMapper = spy(new HowManyCreditCmdMapper());
		cmdMapper = new CmdExecutor(repo);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWordCmdMapperToRomanNumerical() throws CommandDecipherException {
		
		cmdMapper.addCommandMapper(wordCmdMapper);
		String output = cmdMapper.decipher("glob is I");
		verify(wordCmdMapper).decipher("glob is I", repo);
		verify(repo).addWordToRomanNumerical("glob", "I");		
		assertNull(output);
	}
	
	@Test
	public void testCreditCmdMApper() throws CommandDecipherException {
		CmdExecutor cmdMapper = new CmdExecutor(repo);
		cmdMapper.addCommandMapper(wordCmdMapper);
		cmdMapper.addCommandMapper(creditCmdMapper);
		cmdMapper.decipher("glob is I");
		String output = cmdMapper.decipher("glob glob Silver is 34 Credits");
		verify(creditCmdMapper).decipher("glob glob Silver is 34 Credits", repo);
		verify(repo).addMetalBaseValue("Silver", 17);
		assertNull(output);
	}
	
	@Test
	public void testWhenPatternDoesNotMatchForNonQuestion()  {
		cmdMapper.addCommandMapper(wordCmdMapper);
		String output = cmdMapper.decipher("glob is II");	
		assertNull(output);		
	}
	
	@Test
	public void testWhenPatternDoesNotMatchForQuestion()  {
		cmdMapper.addCommandMapper(wordCmdMapper);		
		cmdMapper.addCommandMapper(howMuchIsCmdMapper);
		cmdMapper.decipher("glob is I");	
		String output = cmdMapper.decipher(" much is pish tegj glob glob ?");
		assertThat("I have no idea what you are talking about", equalTo(output));
		
	}
	
	@Test
	public void testHowMuchIsCreditCommandSuccess()  {
		cmdMapper.addCommandMapper(wordCmdMapper);		
		cmdMapper.addCommandMapper(howMuchIsCmdMapper);
		cmdMapper.decipher("glob is I");
		cmdMapper.decipher("pish is X");
		cmdMapper.decipher("tegj is L");
		String output = cmdMapper.decipher("how much is pish tegj glob glob ?");
		assertThat("pish tegj glob glob is 42", equalTo(output));
		
	}
	
	@Test
	public void testHowManyCreditCommandSuccess()  {
		cmdMapper.addCommandMapper(wordCmdMapper);		
		cmdMapper.addCommandMapper(creditCmdMapper);
		cmdMapper.addCommandMapper(howManyCreditCmdMapper);
		cmdMapper.decipher("glob is I");
		cmdMapper.decipher("pish is X");
		cmdMapper.decipher("tegj is L");
		cmdMapper.decipher("prok is V");
		cmdMapper.decipher("glob glob Silver is 34 Credits");
		String output = cmdMapper.decipher("how many Credits is glob prok Silver ?");
		assertThat("glob prok Silver is 68 Credits", equalTo(output));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
