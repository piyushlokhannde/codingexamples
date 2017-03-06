package test.java.cmdmapper;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Spy;

import static org.mockito.Mockito.*;
import main.java.cmdmapper.CommandMapperRepo;
import main.java.cmdmapper.HowMuchIsCmdMapper;
import main.java.cmdmapper.WordCmdMapper;
import main.java.cmdmapper.exception.CommandDecipherException;
import main.java.cmdmapper.exception.WordMappingNotExist;

public class HowMucIshCmdMapperTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	WordCmdMapper wordCmdMapper;
	HowMuchIsCmdMapper howMuchIsCmdMapper;
	
	
	CommandMapperRepo commandMapperRepo; 
	
	@Before
	public void setUp() throws Exception {
		wordCmdMapper = new WordCmdMapper();
		howMuchIsCmdMapper = new HowMuchIsCmdMapper();
		//commandMapperRepo = new CommandMapperRepo();
		commandMapperRepo = spy( new CommandMapperRepo() );
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHowMuchIsCmdMapperCommand() throws CommandDecipherException, WordMappingNotExist {		
		wordCmdMapper.decipher("pish is X",commandMapperRepo);
		wordCmdMapper.decipher("tegj is L",commandMapperRepo);
		wordCmdMapper.decipher("glob is I",commandMapperRepo);	
		String output = howMuchIsCmdMapper.decipher("how much is pish tegj glob glob ?",commandMapperRepo);
		verify(commandMapperRepo,times(4)).getRomanNumerical(anyString());
		assertThat("pish tegj glob glob is 42", is(equalTo(output)));
	}
	

	public void testHowMuchIsCmdMapperCommandForError() throws CommandDecipherException, WordMappingNotExist {
		thrown.expect(CommandDecipherException.class);
		thrown.expectMessage("Error in decipher the command How Much Is");		
		wordCmdMapper.decipher("pish is X",commandMapperRepo);
		wordCmdMapper.decipher("tegj is L",commandMapperRepo);
		wordCmdMapper.decipher("glob is I",commandMapperRepo);		
		String output = howMuchIsCmdMapper.decipher("how much is pish tegjj glob glob ?",commandMapperRepo);
		verify(commandMapperRepo,times(2)).getRomanNumerical(anyString());
		assertThat("pish tegj glob glob is 42", is(equalTo(output)));
	}
	
	@Test
	public void testPatternMatchingSuccess() throws CommandDecipherException, WordMappingNotExist {		
		assertThat(Boolean.TRUE, is(equalTo(howMuchIsCmdMapper.isPatternMathcing("how much is pish tegj glob glob ?"))));
	}
	
	
	@Test
	public void testPatternMatchingFail() throws CommandDecipherException, WordMappingNotExist {		
		assertThat(Boolean.FALSE, is(equalTo(howMuchIsCmdMapper.isPatternMathcing("how much is pish tegj glob glob "))));
	}
	
	
	
	
	
	
	
	
	

}
