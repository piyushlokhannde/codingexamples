package main.java.piyush.symbolparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.piyush.romannumerical.IRomanNumerical;
import main.java.piyush.romannumerical.RomanNumber;
import main.java.piyush.romannumerical.RomanNumeral;
import main.java.piyush.symbolparser.command.ITextCommand;


public class SymbolToRomanNumericParser implements ISymbolToNumbericParser, ISymbolParserContext {
	
	private static final String SYM_ROMAN_PARSER = "Error in  SymbolToRomanNumericParser : ";
	
	private static final String ERROR_STRING = "I have no idea what you are talking about";
	
	private RomanNumber  romanNumerical;
	
	private Map<String,RomanNumeral> symbolMap = new HashMap<String,RomanNumeral>();
	
	private Map<String,Float> metalUnits = new HashMap<String,Float>();
	
	private Map<TextCommandEnum, ITextCommand> commandMap = new HashMap<TextCommandEnum, ITextCommand>();

	@Override
	public String decodeSymbol(String symbolString) {		
		for(TextCommandEnum command:commandMap.keySet()) {			
			if(SearchLocationEnum.END.equals(command.getSeachLocation())
				&& symbolString.matches(".*"+command.getPattern())) {
				 return this.executeCommand(commandMap.get(command), symbolString);
			} else if(SearchLocationEnum.START.equals(command.getSeachLocation())
				&&  symbolString.matches(command.getPattern()+".*")) {
				 return this.executeCommand(commandMap.get(command), symbolString);
			} else if(SearchLocationEnum.CONTAINS.equals(command.getSeachLocation())
					&&  symbolString.matches(".*"+command.getPattern()+".*")) {
				 return this.executeCommand(commandMap.get(command), symbolString);
			}		
		}
		return  ERROR_STRING;
	}
	
	

	public SymbolToRomanNumericParser(RomanNumber romanNumericalIn) {
		this.romanNumerical = romanNumericalIn;		
	}
	
	private  String executeCommand(ITextCommand command, String symbolString) {
		String outputString = null;
		
	  	try {
	  		outputString = command.execute(symbolString, this);
		} catch (IllegalArgumentException e) {
			//TODO:Repalce with logger.
			System.out.println(e.getMessage());
			return ERROR_STRING;
		}
	  	return outputString;
		
	}
		

	@Override
	public void addSymbolToContext(String symbol, RomanNumeral number) {
		if(this.symbolMap.get(symbol) == null)
			this.symbolMap.put(symbol, number);
		
	}

	@Override
	public Boolean isMetalPresent(String metalName) {		
		return this.metalUnits.containsKey(metalName);
	}

	@Override
	public Boolean isSymbolPresent(String symbol) {		
		return this.symbolMap.containsKey(symbol);
	}

	
	
	@Override
	public void addMetalUnits(String metalName, float unitValue) {
		this.metalUnits.put(metalName, unitValue);		
	}

	@Override
	public RomanNumeral getRomanNumbericalFromText(String text) {		
		return romanNumerical.findRomanNumberical(text);
	}

	@Override
	public RomanNumeral getRomanNumbericalFromSymbol(String symbol) {
		
		return symbolMap.get(symbol);
	}

	@Override
	public int convertRomanNumericStringToDecimal(String romanNumbericString) {		
		List<RomanNumeral> numList =  new ArrayList<RomanNumeral>();
		for(String symbol: romanNumbericString.split(" ")) {			
			if(!this.symbolMap.containsKey(symbol)) {
				throw new IllegalArgumentException(SYM_ROMAN_PARSER+"Symbol Not Present");
				
			} else {
				numList.add(this.symbolMap.get(symbol));				
			}			
		}
		RomanNumeral[] arrary = numList.toArray(new RomanNumeral[numList.size()]);
		
		if(!romanNumerical.isValid(arrary)) {			
			throw new IllegalArgumentException(SYM_ROMAN_PARSER+"Invalid Roman Number Sequence");
		}
		Integer units = romanNumerical.getDecimalNumberFromRoman(arrary);
		return units;
	}

	@Override
	public float getMetalUnit(String metalName) {		
		return this.metalUnits.get(metalName);
	}

	@Override
	public void addCommandPocessorToParser(TextCommandEnum command, ITextCommand commandClass) {
		
		commandMap.put(command, commandClass);
	}
	

}
