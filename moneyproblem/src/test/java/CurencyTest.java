package test.java;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.Curency;
import main.java.CurrencyEnum;
import main.java.CurrencyRateProvider;
import main.java.exception.CurrencyTransformException;
import main.java.exception.RateNotFoundException;

public class CurencyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCurencyMulitplyWithConstant() {		
		Curency currency = Curency.create(10, CurrencyEnum.USD);
		Curency  newCurency = currency.multiply(2);
		assertThat(Curency.create(20, CurrencyEnum.USD), equalTo(newCurency));		
	}

	@Test
	public void testCurrenyAddWithAnotherCurreny() throws CurrencyTransformException {
		Curency currency1 = Curency.create(10, CurrencyEnum.USD);
		Curency currency2 = Curency.create(10, CurrencyEnum.USD);
		Curency currency3  = currency1.add(currency2);
		assertThat(Curency.create(20, CurrencyEnum.USD), equalTo(currency3));		
		
	}
	
	@Test(expected = CurrencyTransformException.class)
	public void testCurrenyAddWithDiffCureencysCurreny() throws CurrencyTransformException {
		Curency currency1 = Curency.create(10, CurrencyEnum.USD);
		Curency currency2 = Curency.create(10, CurrencyEnum.CHF);
		currency1.add(currency2);		
	}
	
	@Test
	public void testCurrencyReduceToOtherCurency() throws CurrencyTransformException {	
		CurrencyRateProvider currenyRateProvider = new CurrencyRateProvider();
		Curency originCurrency  = Curency.create(10, CurrencyEnum.CHF);
		Curency tranformCurrency = originCurrency.tranform(CurrencyEnum.USD, currenyRateProvider);
		assertThat(Curency.create(5, CurrencyEnum.USD), equalTo(tranformCurrency));	
		
	}
	
	
	@Test
	public void testCurrencyReduceToOSameCurency() throws CurrencyTransformException {	
		CurrencyRateProvider currenyRateProvider = new CurrencyRateProvider();
		Curency originCurrency  = Curency.create(10, CurrencyEnum.USD);
		Curency tranformCurrency = originCurrency.tranform(CurrencyEnum.USD, currenyRateProvider);
		assertThat(Curency.create(10, CurrencyEnum.USD), equalTo(tranformCurrency));	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
