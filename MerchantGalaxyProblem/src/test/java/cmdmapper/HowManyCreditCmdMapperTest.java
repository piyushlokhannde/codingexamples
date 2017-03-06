package test.java.cmdmapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import main.java.cmdmapper.CommandMapperRepo;
import main.java.cmdmapper.CreditCmdMapper;
import main.java.cmdmapper.HowManyCreditCmdMapper;
import main.java.cmdmapper.WordCmdMapper;
import main.java.cmdmapper.exception.CommandDecipherException;

public class HowManyCreditCmdMapperTest {


	CommandMapperRepo commandMapperRepo;
	WordCmdMapper wordCmdMapper;
	CreditCmdMapper creditCmdMapper;
	
	@Before
	public void setUp() throws Exception {
		commandMapperRepo = spy(new CommandMapperRepo());
		wordCmdMapper = spy(new WordCmdMapper());
		creditCmdMapper= spy(new CreditCmdMapper());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHowManyCreditCmdForSilver() throws CommandDecipherException {	
		wordCmdMapper.decipher("glob is I", commandMapperRepo);
		wordCmdMapper.decipher("prok is V", commandMapperRepo);
		creditCmdMapper.decipher("glob glob Silver is 34 Credits", commandMapperRepo);
		HowManyCreditCmdMapper howManyCreditCmdMapper = new HowManyCreditCmdMapper();
		String output =  howManyCreditCmdMapper.decipher("how many Credits is glob prok Silver ?" ,commandMapperRepo);
		assertThat("glob prok Silver is 68 Credits", is(equalTo(output)));
	}
	
	
	@Test
	public void testHowManyCreditCmdSuccess() throws CommandDecipherException {			
		HowManyCreditCmdMapper howManyCreditCmdMapper = new HowManyCreditCmdMapper();		
		assertThat(Boolean.TRUE, 
				is(equalTo(howManyCreditCmdMapper
						.isPatternMathcing("how many Credits is glob prok Silver ?"))));
	}
	
	@Test
	public void testHowManyCreditCmdFail() throws CommandDecipherException {			
		HowManyCreditCmdMapper howManyCreditCmdMapper = new HowManyCreditCmdMapper();		
		assertThat(Boolean.FALSE, 
				is(equalTo(howManyCreditCmdMapper
						.isPatternMathcing("how  Credits is glob prok Silver ?"))));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
