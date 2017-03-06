package main.java.piyush.symbolparser;

import main.java.piyush.romannumerical.RomanNumeral;

public interface ISymbolParserContext {
		
	void addSymbolToContext(String symbol,RomanNumeral number);
	
	Boolean isMetalPresent(String metalName);
	
	Boolean isSymbolPresent(String symbol);	
	
	void addMetalUnits(String metalName, float unitValue);
	
	RomanNumeral getRomanNumbericalFromText(String text); 
	
	RomanNumeral getRomanNumbericalFromSymbol(String symbol);
	
	int convertRomanNumericStringToDecimal(String romanNumbericString);
	
	float getMetalUnit(String metalName);
	
	
	

}
