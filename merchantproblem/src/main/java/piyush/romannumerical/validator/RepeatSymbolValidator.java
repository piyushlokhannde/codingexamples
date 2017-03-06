package main.java.piyush.romannumerical.validator;

import java.util.regex.Pattern;

import main.java.piyush.romannumerical.RomanNumbericalUtil;
import main.java.piyush.romannumerical.RomanNumeral;

/**
 *This class implements the IRomanNumericalValidator and defines the repeat rules for the roman numerical.
 *
 */
public class RepeatSymbolValidator implements IRomanNumericalValidator {

	@Override
	public Boolean validate(RomanNumeral[] romanSringArray) {
		
		String romanString  = RomanNumbericalUtil.converntRomanNumbericalTOString(romanSringArray);						
					
		
		if(Pattern.compile(createPattern(RomanNumeral.I)).matcher(romanString).matches()) {
			return false;
		}
		
		
		if(Pattern.compile(createPattern(RomanNumeral.X)).matcher(romanString).matches()) {
			return false;
		}
		
		if(Pattern.compile(createPattern(RomanNumeral.C)).matcher(romanString).matches()) {
			return false;
		}
		
		if(Pattern.compile(createPattern(RomanNumeral.M)).matcher(romanString).matches()) {
			return false;
		}
		
		if(Pattern.compile(createPatternForDLV(RomanNumeral.D)).matcher(romanString).matches()) {
			return false;
		}
		
		if(Pattern.compile(createPatternForDLV(RomanNumeral.L)).matcher(romanString).matches()) {
			return false;
		}
		
		if(Pattern.compile(createPatternForDLV(RomanNumeral.V)).matcher(romanString).matches()) {
			return false;
		}
		
		return true;
	}
	
	private String createPattern(RomanNumeral romaNum) {		
		return romaNum.toString()+"{3}"+RomanNumbericalUtil.findtheHigherNumbericals(romaNum)+
				romaNum.toString();
	} 
	
	private  String createPatternForDLV(RomanNumeral romaNum) {
		
		return ".*"+romaNum.toString()+".*"+romaNum.toString()+".*";
	}

}
