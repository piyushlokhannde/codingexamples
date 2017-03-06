package main.java.piyush.symbolparser.command;

import main.java.piyush.symbolparser.ISymbolParserContext;

public class HowMuchIsQuestionCommand implements ITextCommand {
	
	

	@Override
	public String execute(String textCommand, ISymbolParserContext context) {
		
		textCommand =	textCommand.replaceAll("how much is ", "").
				replaceAll("\\?", "").trim();	
		int decimalNum = context.convertRomanNumericStringToDecimal(textCommand);
		return textCommand+ " is "+decimalNum;
	}

}
