package test.java.cmdmapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.cmdmapper.CommandMapperRepo;
import main.java.cmdmapper.WordCmdMapper;
import main.java.cmdmapper.exception.CommandDecipherException;
import main.java.cmdmapper.exception.WordMappingNotExist;

public class WordCmdMapperTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	WordCmdMapper mapper;
	
	CommandMapperRepo commandMapperRepo; 
	
	
	@Before
	public void setUp() throws Exception {
		commandMapperRepo = new CommandMapperRepo();
		mapper = new WordCmdMapper(); 
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testWordMapperPatternMatch() {
		assertThat(Boolean.TRUE,equalTo(mapper.isPatternMathcing("glob is I")));
	}
	
	@Test
	public void testWordMapperPatternDoesNoyMatch() {
		assertThat(Boolean.FALSE,equalTo(mapper.isPatternMathcing("glob is II")));
	}


	@Test
	public void testWordMapToRomanSign() throws WordMappingNotExist, CommandDecipherException {			
		mapper.decipher("glob is I", commandMapperRepo);
		mapper.decipher("prok is V", commandMapperRepo);
		mapper.decipher("pish is X",commandMapperRepo);
		mapper.decipher("tegj is L",commandMapperRepo);
		assertThat("I", equalTo(commandMapperRepo.getRomanNumerical("glob")));
		assertThat("V", equalTo(commandMapperRepo.getRomanNumerical("prok")));
		assertThat("X", equalTo(commandMapperRepo.getRomanNumerical("pish")));
		assertThat("L", equalTo(commandMapperRepo.getRomanNumerical("tegj")));
	}
	
	@Test(expected = WordMappingNotExist.class)
	public void testWordMappingDoesNotExists() throws WordMappingNotExist, CommandDecipherException  {		
		mapper.decipher("glob is I",commandMapperRepo);
		commandMapperRepo.getRomanNumerical("apple");		
	}
	
	@Test
	public void testWordMappingifWordisempty() throws CommandDecipherException  {	
		thrown.expect(CommandDecipherException.class);
		thrown.expectMessage("Error in parsing the command " +" is I");
		mapper.decipher(" is I", commandMapperRepo);
				
	}
	
	
	@Test
	public void testWordMappingifWrongRomanNumerical() throws CommandDecipherException  {	
		thrown.expect(CommandDecipherException.class);
		thrown.expectMessage("Error in parsing the command " +"glob is Z");
		mapper.decipher("glob is Z", commandMapperRepo);
				
	}

}
