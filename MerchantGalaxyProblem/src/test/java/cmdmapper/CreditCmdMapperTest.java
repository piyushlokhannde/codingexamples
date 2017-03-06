package test.java.cmdmapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Spy;

import main.java.cmdmapper.CommandMapperRepo;
import main.java.cmdmapper.CreditCmdMapper;
import main.java.cmdmapper.WordCmdMapper;
import main.java.cmdmapper.exception.CommandDecipherException;
import main.java.cmdmapper.exception.WordMappingNotExist;

public class CreditCmdMapperTest {
	
	@Spy
	WordCmdMapper wordCmdMapper = null;
	
	CreditCmdMapper cmpMapper = null;
	
	@Spy
	CommandMapperRepo commandMapperRepo = null;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		
		wordCmdMapper = new WordCmdMapper();
		cmpMapper = new CreditCmdMapper();
		commandMapperRepo = new CommandMapperRepo();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testWordMapperPatternMatch() {
		assertThat(Boolean.TRUE,equalTo(cmpMapper.isPatternMathcing("glob prok Gold is 57800 Credits")));
	}
	
	@Test
	public void testWordMapperPatternDoesNoyMatch() {
		assertThat(Boolean.FALSE,equalTo(cmpMapper.isPatternMathcing(" is 57800 Credits")));
	}


	@Test
	public void testWithOneRomanNumerical() throws CommandDecipherException, WordMappingNotExist {			
		wordCmdMapper.decipher("glob is I", commandMapperRepo);
		cmpMapper.decipher("glob glob Silver is 34 Credits" , commandMapperRepo);	
		assertThat(Integer.valueOf(17), equalTo(commandMapperRepo.getValueForMetal("Silver")));
	}

	
	
	@Test
	public void testTwoRomanNumerical() throws CommandDecipherException, WordMappingNotExist {
		
		thrown.expect(CommandDecipherException.class);
	    thrown.expectMessage("Error in commsnd deciphrt in credit");		
		wordCmdMapper.decipher("glob is I",commandMapperRepo);
		wordCmdMapper.decipher("prok is V",commandMapperRepo);		
		cmpMapper.decipher("glob prok make Gold is 57800 Credits" ,commandMapperRepo);	
		assertThat(Integer.valueOf(14450), equalTo(commandMapperRepo.getValueForMetal("Gold")));
	}
	
	
	@Test
	public void testInvalidCreditCommand() throws CommandDecipherException, WordMappingNotExist {		
		thrown.expect(CommandDecipherException.class);
	    thrown.expectMessage("Error in commsnd deciphrt in credit");		
		wordCmdMapper.decipher("glob is I",commandMapperRepo);
		wordCmdMapper.decipher("prok is V",commandMapperRepo);	
		cmpMapper.decipher("glob make Gold is 57800 Credits",commandMapperRepo);	
		assertThat(Integer.valueOf(14450), equalTo(commandMapperRepo.getValueForMetal("Gold")));
	}
	
	
	@Test
	public void testInvalidCreditCommandWithNoMetalName() throws CommandDecipherException {		
		thrown.expect(CommandDecipherException.class);
	    thrown.expectMessage("Error in commsnd deciphrt in credit");	
		wordCmdMapper.decipher("glob is I",commandMapperRepo);
		wordCmdMapper.decipher("prok is V",commandMapperRepo);		
		cmpMapper.decipher("glob prok is 57800 Credits",commandMapperRepo);	
		
	}
	
	
	
	

}
