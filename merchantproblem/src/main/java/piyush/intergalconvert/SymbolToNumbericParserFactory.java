package main.java.piyush.intergalconvert;

import java.util.ArrayList;
import java.util.List;

import main.java.piyush.romannumerical.RomanNumber;
import main.java.piyush.romannumerical.validator.IRomanNumericalValidator;
import main.java.piyush.romannumerical.validator.RepeatSymbolValidator;
import main.java.piyush.romannumerical.validator.SubstractionValidator;
import main.java.piyush.symbolparser.ISymbolToNumbericParser;
import main.java.piyush.symbolparser.SymbolToRomanNumericParser;
import main.java.piyush.symbolparser.ISymbolToNumbericParser.TextCommandEnum;
import main.java.piyush.symbolparser.command.CreditTextCommand;
import main.java.piyush.symbolparser.command.HowMuchCreditQuestionCommand;
import main.java.piyush.symbolparser.command.HowMuchIsQuestionCommand;
import main.java.piyush.symbolparser.command.IsTextCommand;

public class SymbolToNumbericParserFactory {
	
	public static ISymbolToNumbericParser getInstance(ParserType variable) {	
		ISymbolToNumbericParser parser = null;
		
		if(ParserType.SYMBOL_ROMAN_NUMERIC.equals(variable)) {
			List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
			validatorList.add(new RepeatSymbolValidator());
			validatorList.add(new SubstractionValidator());
			RomanNumber romanNumberical = new RomanNumber(validatorList);		
			parser = new SymbolToRomanNumericParser(romanNumberical);
			parser.addCommandPocessorToParser(TextCommandEnum.IS, new IsTextCommand());
			parser.addCommandPocessorToParser(TextCommandEnum.CREDIT_TEXT, new CreditTextCommand());
			parser.addCommandPocessorToParser(TextCommandEnum.HOW_MUCH_IS, new HowMuchIsQuestionCommand());
			parser.addCommandPocessorToParser(TextCommandEnum.HOW_MUCH_CREDIT, new HowMuchCreditQuestionCommand());
		}	
		
		return parser;
	}

}
