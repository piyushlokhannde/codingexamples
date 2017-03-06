package main.java.piyush.symbolparser;

import main.java.piyush.romannumerical.RomanNumeral;
import main.java.piyush.symbolparser.command.ITextCommand;

/**
 *This interface defines method which accepts the command in text format and convert to number.
 *
 */
public interface ISymbolToNumbericParser {
	
	public enum SearchLocationEnum {
		START,END, CONTAINS;
	}
	
	public enum TextCommandEnum {
		
		IS("is ["+RomanNumeral.I
				+RomanNumeral.V			
				+RomanNumeral.X
				+RomanNumeral.L
				+RomanNumeral.C
				+RomanNumeral.D
				+RomanNumeral.M+"]", SearchLocationEnum.END),
		CREDIT_TEXT("is \\d+"+" Credits",SearchLocationEnum.END),
		HOW_MUCH_CREDIT("how many Credits is ",SearchLocationEnum.START),
		HOW_MUCH_IS("how much is ",SearchLocationEnum.START);
		
		TextCommandEnum(String patternIn,  SearchLocationEnum locationIn) {
			this.pattern = patternIn;
			this.seachLocation =locationIn;
		}
		
		private String pattern;
		private SearchLocationEnum seachLocation;
				
		public String getPattern() {
			return pattern;
		}
		
		public SearchLocationEnum getSeachLocation() {
			return seachLocation;
		}
		
	}
	
	String decodeSymbol(String symbolString);
	
	void addCommandPocessorToParser(TextCommandEnum command, ITextCommand commandClass);
	

}
