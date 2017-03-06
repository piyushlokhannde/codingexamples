package main.java.romannumerial;

import  static main.java.romannumerial.RomanNumericalMapping.RomanNumericalEnum.*;

import static org.mockito.Mockito.*;

import org.mockito.Mockito;

import main.java.romannumerial.exception.DecimalConversionException;
import main.java.romannumerial.exception.InavalidRomanNumberException;

public interface RomanNumber {	
	
	
	public static RomanNumber getInstance(String romanNumber) throws InavalidRomanNumberException{
		
		/* RomanNumber romn = Mockito.mock(RomanNumber.class);
		 if(romanNumerical.equals("II")) {			 
			 when(romn.getDecimalValue()).thenReturn(2); 
		 } else if(romanNumerical.equals("IV")) {
			 when(romn.getDecimalValue()).thenReturn(4);
		 } else if(romanNumerical.equals("XLII")) {
			 when(romn.getDecimalValue()).thenReturn(42);
		 } */
		
		CheckInvalidPattern  invalidPatternValidator = new  CheckInvalidPattern(); 
		invalidPatternValidator.addInvalidPattern(""+I+I+I+I);
		invalidPatternValidator.addInvalidPattern(""+X+X+X+X);
		invalidPatternValidator.addInvalidPattern(""+C+C+C+C);
		invalidPatternValidator.addInvalidPattern(""+M+M+M+M);
		invalidPatternValidator.addInvalidPattern(""+D+D);
		invalidPatternValidator.addInvalidPattern(""+L+L);
		invalidPatternValidator.addInvalidPattern(""+V+V);
		
		ValidateSecondArgumentForSubstraction substractValidator = new ValidateSecondArgumentForSubstraction();
		substractValidator.addValidPattern(I.toString(), V + X.toString());
		substractValidator.addValidPattern(X.toString(), L + C.toString());
		substractValidator.addValidPattern(C.toString(), D + M.toString());
		
		RomanNumberImpl.RomanNumberImplBuilder builder = new RomanNumberImpl.RomanNumberImplBuilder();
		builder.setInvalidPatternValidator(invalidPatternValidator);
		builder.setSecondArgumentValidator(substractValidator);
		builder.setRomanNumber(romanNumber);	 
		return builder.build();
	}
	
	
	 
	int getDecimalValue() throws DecimalConversionException;

}
