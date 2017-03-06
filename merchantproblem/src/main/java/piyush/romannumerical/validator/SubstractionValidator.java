package main.java.piyush.romannumerical.validator;

import main.java.piyush.romannumerical.RomanNumbericalUtil;
import main.java.piyush.romannumerical.RomanNumeral;

/**
 * This class implements the IRomanNumericalValidator
 *  and defines the subtraction rules for the roman numerical.
 *
 */
public class SubstractionValidator implements IRomanNumericalValidator {

	@Override
	public Boolean validate(RomanNumeral[] romanSringArray) {
		
		if(!this.validateSubstractionRulesForVXC(RomanNumeral.I, new RomanNumeral[]{ 
				RomanNumeral.X,RomanNumeral.V}, romanSringArray)) {
			return false;
		}
		
		
		if(!this.validateSubstractionRulesForVXC(RomanNumeral.X, new RomanNumeral[]{ 
				RomanNumeral.L,RomanNumeral.C}, romanSringArray)) {
			return false;
		}
		
		if(!this.validateSubstractionRulesForVXC(RomanNumeral.C, new RomanNumeral[]{ 
				RomanNumeral.D, RomanNumeral.M}, romanSringArray)) {
			return false;
		}
		
		if(!this.checkifNumericalSubstracted(RomanNumeral.V, romanSringArray)) {
			return false;
		}
		
		if(!this.checkifNumericalSubstracted(RomanNumeral.L, romanSringArray)) {
			return false;
		}
		
		if(!this.checkifNumericalSubstracted(RomanNumeral.D, romanSringArray)) {
			return false;
		}
		
		return true;
	}
	
	
	private boolean validateSubstractionRulesForVXC(RomanNumeral numToValidate, 
			RomanNumeral[] validNumberical, RomanNumeral[] romanSringArray) {		
		for(int i=0; i<romanSringArray.length;i++) {
			if(romanSringArray[i].equals(numToValidate) && (i+1 <romanSringArray.length)
					&& romanSringArray[i].getvalue() <romanSringArray[i+1].getvalue()) {			
				if(!RomanNumbericalUtil.isNumbericPresentInArray(validNumberical, romanSringArray[i+1])) {
					return false;
				}
			}			
		}
		return true;
	}
	
	private boolean checkifNumericalSubstracted(RomanNumeral numToValidate, 
			RomanNumeral[] romanSringArray) {
		for(int i=0; i<romanSringArray.length;i++) {
			
			if(romanSringArray[i].equals(numToValidate) && (i+1 <romanSringArray.length)
					&& romanSringArray[i].getvalue() <romanSringArray[i+1].getvalue()) {
				return false;
			}
			
		}
		return true;
	}
	
	

}
