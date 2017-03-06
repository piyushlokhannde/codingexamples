package main.java.piyush.romannumerical;

import java.util.ArrayList;
import java.util.List;

import main.java.piyush.romannumerical.validator.IRomanNumericalValidator;

/**
 *This class implements the IRomanNumerical.
These implements the method defined in the IRomanNumerical

 *
 */
public class RomanNumber {
	
	private List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
	
	public RomanNumber(List<IRomanNumericalValidator> validatorListIn) {		
		this.validatorList = validatorListIn;;
	}

	
	public int getDecimalNumberFromRoman(RomanNumeral[] romanSringArray) {	
		
		int startIndex = 0;
		int decimalValue = 0;
		while(startIndex < romanSringArray.length) {
			
			if((startIndex+1) < romanSringArray.length && romanSringArray[startIndex].getvalue() < 
			romanSringArray[startIndex+1].getvalue() ) {
				decimalValue += (romanSringArray[startIndex+1].getvalue()-
						romanSringArray[startIndex].getvalue());
				startIndex++;
			} else  {
				decimalValue += romanSringArray[startIndex].getvalue();
			}			
			startIndex++;
		}
		return decimalValue;
	}
	

	
	public boolean isValid(RomanNumeral[] romanSringArray) {
		for(IRomanNumericalValidator romanNumericalValidator: validatorList) {
			if(!romanNumericalValidator.validate(romanSringArray)) {
				return false;
			}
		}
		return true;
	}


	
	public RomanNumeral findRomanNumberical(String inputString) {
		
		for(RomanNumeral romanNumbericalenumr
				:RomanNumeral.values()) {
			
			if(romanNumbericalenumr.toString().equalsIgnoreCase((inputString.trim()))) {
				return romanNumbericalenumr;
			}
		}
		
		return null;
	}
	
	

	

}
