package main.java.piyush.symbolparser.command;

import main.java.piyush.symbolparser.ISymbolParserContext;

public class HowMuchCreditQuestionCommand implements ITextCommand {
	
	private static String INVALID_HOW_MUCH_CREDIT_CMD = "Invalid How Much Credit Command : ";

	@Override
	public String execute(String textCommand, ISymbolParserContext context) {
		
		textCommand =	textCommand.replaceAll("how many Credits is ", "").
				replaceAll("\\?", "").trim();		
		String metalName = CommandUtil.getMetalName(textCommand);	
		if(!context.isMetalPresent(metalName)) {
			throw new IllegalArgumentException(INVALID_HOW_MUCH_CREDIT_CMD+"Metal is not present");
		}
		String romanNumericCommand = textCommand.replaceAll(metalName, "").trim();
		int decimalNum = context.convertRomanNumericStringToDecimal(romanNumericCommand);
		
		return textCommand+" is "+Float.valueOf(decimalNum*context.getMetalUnit(metalName)).toString().toString().replaceAll("\\.?0*$", "")+" "+"Credits";
	}

}
