package test.java;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.CurrencyEnum;
import main.java.CurrencyRateProvider;
import main.java.exception.RateNotFoundException;


public class CurrenyRateProviderTest {
	
	  @Rule
	    public ExpectedException thrown = ExpectedException.none();


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRateProvoderCHFToUSD() throws RateNotFoundException {
		CurrencyRateProvider provder = new CurrencyRateProvider();
		float rate =	provder.currenyRate( CurrencyEnum.CHF, CurrencyEnum.USD);				
		assertThat(0.5f, is(rate));		
	}
	
	
	@Test
	public void testRateProvoderUSDToUSD() throws RateNotFoundException {
		CurrencyRateProvider provder = new CurrencyRateProvider();
		float rate =	provder.currenyRate( CurrencyEnum.USD, CurrencyEnum.USD);				
		assertThat(1f, is(rate));		
	}
	
	
	@Test
	public void testRateProvoderUSDToCHF() throws RateNotFoundException {
		CurrencyRateProvider provder = new CurrencyRateProvider();
		float rate = provder.currenyRate( CurrencyEnum.USD, CurrencyEnum.CHF);				
		assertThat(2f, is(rate));		
	}
	
	@Test(expected = RateNotFoundException.class)
	public void testRateDoesNotExists() throws RateNotFoundException {	
		CurrencyRateProvider provder = new CurrencyRateProvider();
		float rate = provder.currenyRate( CurrencyEnum.USD, CurrencyEnum.EURO);
	}
	
	
	
	
	
	

}
