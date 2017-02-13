package main.java;

import java.util.HashMap;
import  java.util.Map;

import main.java.exception.RateNotFoundException;


public class CurrencyRateProvider {
	
	private static float RETURN_WHEN_CURRENCY_EQUAL =1f;

	public Map<CurrencyEnum, Map<CurrencyEnum, Float>> currencyRateHolder;
	
	public CurrencyRateProvider() {
		
		currencyRateHolder = new HashMap<>();
		
		Map<CurrencyEnum, Float> CHF_OTHER = new HashMap<>();
		CHF_OTHER.put(CurrencyEnum.USD, 0.5f);
		
		Map<CurrencyEnum, Float> USD_OTHER = new HashMap<>();
		USD_OTHER.put(CurrencyEnum.CHF, 2f);
		
		
		currencyRateHolder.put(CurrencyEnum.CHF, CHF_OTHER);
		currencyRateHolder.put(CurrencyEnum.USD, USD_OTHER);
	}

	public float currenyRate(CurrencyEnum source, CurrencyEnum target) throws RateNotFoundException {
		
		if(source.equals(target)) {
			return RETURN_WHEN_CURRENCY_EQUAL;
		} 			
		
		if(!currencyRateHolder.containsKey(source) || 
				!currencyRateHolder.get(source).containsKey(target)) {			
			throw new RateNotFoundException();
		}
		return currencyRateHolder.get(source).get(target);
		
		
		
	}
	
	

}
