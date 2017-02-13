package test.java;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.Curency;
import main.java.CurrencyEnum;
import main.java.CurrencyReport;
import main.java.ReportElement;

public class MultiCurrencyReportTest {

	CurrencyReport report;
	@Before
	public void setUp() throws Exception {
		report = new CurrencyReport();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void calcualteTotalWithOneShareAndFixedPrice() {
		report = new CurrencyReport();
		ReportElement element1 = new ReportElement.ReportElementBuilder()
				.withInstrument("IBM").withNoOfShares(1)
				.withPriceOfShares(Curency.create(10, CurrencyEnum.USD)).build();				
		report.add(element1);		
		assertThat(Curency.create(10, CurrencyEnum.USD), is(report.getTotal(CurrencyEnum.USD)));
	}
	
	@Test
	public void calculateTotalWihTwoShares() {
		ReportElement element1 = new ReportElement.ReportElementBuilder()
				.withInstrument("IBM").withNoOfShares(1).withPriceOfShares(Curency.create(10, CurrencyEnum.USD)).build();	
		ReportElement element2 =new ReportElement.ReportElementBuilder()
				.withInstrument("Apple").withNoOfShares(2).withPriceOfShares(Curency.create(10, CurrencyEnum.USD)).build();
		report.add(element1);
		report.add(element2);		
		assertThat(Curency.create(30, CurrencyEnum.USD), is(report.getTotal(CurrencyEnum.USD)));
	}
	
	
	@Test
	public void calculateTotalWihTwoSharesWithDifferentCurrencyToUS() {
		ReportElement element1 = new ReportElement.ReportElementBuilder()
				.withInstrument("IBM").withNoOfShares(1000).
				withPriceOfShares(Curency.create(10, CurrencyEnum.USD)).build();	
		ReportElement element2 =new ReportElement.ReportElementBuilder()
				.withInstrument("Novartis").withNoOfShares(400).withPriceOfShares(Curency.create(25, CurrencyEnum.CHF)).build();
		report.add(element1);
		report.add(element2);	
		report.printReport();
		assertThat(Curency.create(15000, CurrencyEnum.USD), is(report.getTotal(CurrencyEnum.USD)));
	}
	
	@Test
	public void calculateTotalWihTwoSharesWithDifferentCurrencyToCHD() {
		ReportElement element1 = new ReportElement.ReportElementBuilder()
				.withInstrument("IBM").withNoOfShares(1000).
				withPriceOfShares(Curency.create(10, CurrencyEnum.USD)).build();	
		ReportElement element2 =new ReportElement.ReportElementBuilder()
				.withInstrument("Novartis").withNoOfShares(400).withPriceOfShares(Curency.create(25, CurrencyEnum.CHF)).build();
		report.add(element1);
		report.add(element2);	
		report.printReport();
		assertThat(Curency.create(30000, CurrencyEnum.CHF), is(report.getTotal(CurrencyEnum.CHF)));
	}

}
