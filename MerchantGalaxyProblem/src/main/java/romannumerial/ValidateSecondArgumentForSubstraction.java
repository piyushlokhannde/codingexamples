package main.java.romannumerial;

import java.util.HashMap;
import java.util.Map;

public class ValidateSecondArgumentForSubstraction {
	
	private Map<String, String> validPatternMap = new HashMap<>();
	
	private String invalidSecPattern;

	public void addValidPattern(String  firstOperand, String validPattern) {
		validPatternMap.put(firstOperand, validPattern);		
	}

	public boolean validate(String firstParameter, String secondParameter) {
		
		if(this.invalidSecPattern != null &&  this.invalidSecPattern.contains(secondParameter)) {
			return false;
		}
		
		if(validPatternMap.containsKey(secondParameter)) {
			return validPatternMap.get(secondParameter).contains(firstParameter);
		}
		
		return true; 
	}

	public void addInvalidSecondParmeters(String pattern) {
		this.invalidSecPattern = pattern;
		
	}
	
	

}
