package test.java;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.Curency;
import main.java.CurrencyEnum;
import main.java.ReportElement;

public class ReportElementTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReportElementWithOneValue() {
		ReportElement element1 = new ReportElement.ReportElementBuilder()
				.withInstrument("IBM").withNoOfShares(1).withPriceOfShares(Curency.create(10,CurrencyEnum.USD)).build();
		assertThat(Curency.create(10,CurrencyEnum.USD), equalTo(element1.calculateTotalSharePrice()));
		
	}
	

	@Test
	public void testReportElementforMulitplyWithDecimal() {
		ReportElement element1 = new ReportElement.ReportElementBuilder()
				.withInstrument("IBM").withNoOfShares(2).withPriceOfShares(Curency.create(2.7f,CurrencyEnum.USD)).build();
		assertThat(Curency.create(5.4f,CurrencyEnum.USD), equalTo(element1.calculateTotalSharePrice()));
		
	}


}
