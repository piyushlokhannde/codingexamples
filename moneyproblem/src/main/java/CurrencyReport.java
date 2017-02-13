package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import main.java.exception.CurrencyTransformException;



public class CurrencyReport {

	private List<ReportElement> reportElementList = new ArrayList<>();
	
	

	public Curency getTotal(CurrencyEnum targetCurrency) {
		
	CurrencyRateProvider rateProvider = new CurrencyRateProvider();	
		
	Optional<Curency>  mapCurreny =  reportElementList.stream()
				.map(e ->e.calculateTotalSharePrice())
				.collect(Collectors
				.groupingBy(Curency::getCurrencyType,
				Collectors.reducing((Curency c1,Curency c2 )-> {
					try {
						return c1.add(c2);
					} catch (CurrencyTransformException e1) {						
						e1.printStackTrace();
						throw new RuntimeException();
					}
				})))
			.values().stream().map(v -> v.get())
			.reduce((v1,v2) -> {
				try {
					return v1.tranform(targetCurrency, rateProvider).add(v2.tranform(targetCurrency, rateProvider));
				} catch (CurrencyTransformException e2) {					
					e2.printStackTrace();
					throw new RuntimeException();
				}
			});	
		return mapCurreny.get();	
	}

	public void add(ReportElement element) {
		this.reportElementList.add(element);
	}
	
	
	public void printReport() {
		
		reportElementList.stream().forEach(element -> {
			System.out.println("");
			System.out.println( "Instrument " + element.getInstrument());
			System.out.println( "Shares " + element.getNoOfShares());
			System.out.println( "Price Of Shares " + element.getPriceOfShares());
			System.out.println( "Currncy " + element.getPriceOfShares().getCurrencyType());
			System.out.println( "Total Share Price " + element.calculateTotalSharePrice());
		});
		
	//	System.out.println("Total in USD" + this.getTotal());
		
	}

}
