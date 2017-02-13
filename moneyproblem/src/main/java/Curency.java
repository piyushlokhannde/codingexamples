package main.java;

import java.math.BigDecimal;

import main.java.exception.CurrencyTransformException;
import main.java.exception.RateNotFoundException;

public class Curency {
	
	private final BigDecimal amount;
	public BigDecimal getAmount() {
		return amount;
	}

	public CurrencyEnum getCurrencyType() {
		return currencyType;
	}

	private final CurrencyEnum currencyType;	

	public static Curency create(double amount, CurrencyEnum currencyType) {		
		return new Curency(BigDecimal.valueOf(amount), currencyType);
	}
	
	private Curency(BigDecimal amount, CurrencyEnum currencyType) {
		this.amount = amount;
		this.currencyType = currencyType;
	}

	public Curency multiply(float multiplyer) {		
		return Curency.create(multiplyWith(multiplyer),
				this.currencyType);
	}
	
	@Override
	public int hashCode() {		
		return super.hashCode()*31
				+(this.amount.hashCode()*31)
				+(this.currencyType.hashCode()*31);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		if(!this.getClass().equals(obj.getClass())) {
			return false;
		}
		Curency otherObject = (Curency)obj;
		
		
		if(this.getCurrencyType().equals(otherObject.getCurrencyType())
				&& this.getAmount().equals(otherObject.getAmount())){
			return true;
		}
		
		return false;
	}

	public Curency add(Curency currency) throws CurrencyTransformException {
		
		if(!this.currencyType.equals(currency.getCurrencyType()))  {			
			throw new CurrencyTransformException();
		}
		return Curency.create(this.amount
				.add(currency.getAmount()).floatValue(), this.currencyType);
	}

	public Curency tranform(CurrencyEnum targerCurrency, CurrencyRateProvider currenyRateProvider) throws CurrencyTransformException {
		
		try {
			float rate = currenyRateProvider.currenyRate(this.currencyType, targerCurrency);
			return Curency.create(multiplyWith(rate),
					targerCurrency);
		} catch (RateNotFoundException e) {			
			throw new CurrencyTransformException();
		}
	}

	
	private double multiplyWith(float multiplier) {
		return this.getAmount().doubleValue()*multiplier;
	}
}
