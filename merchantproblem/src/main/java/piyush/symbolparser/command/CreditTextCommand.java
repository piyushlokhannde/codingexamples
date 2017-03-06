package main.java.piyush.symbolparser.command;

import main.java.piyush.symbolparser.ISymbolParserContext;

/**
 * Parses the pish pish Iron is 3910 Credits type of commands.
 *
 */
public class CreditTextCommand implements ITextCommand {
	
	private static final String INVALID_CREDT_CMD = "Invalid Credit Command : ";

	@Override
	public String execute(String textCommand, ISymbolParserContext context) {
		textCommand =	textCommand.replaceAll(" is", "").
				replaceAll(" Credits", "");		
		Integer credit = Integer.valueOf(textCommand.substring(textCommand.lastIndexOf(" ")+1));
		textCommand = textCommand.substring(0, textCommand.lastIndexOf(" "));
		String metalName = CommandUtil.getMetalName(textCommand);
		if(context.isMetalPresent(metalName)) {
			throw new IllegalArgumentException(INVALID_CREDT_CMD+"Metal is already present");
		}
		
		if(context.isSymbolPresent(metalName)) {
			throw new IllegalArgumentException(INVALID_CREDT_CMD+"Metal Names coincides with symbol");
		}
		textCommand = textCommand.substring(0, textCommand.lastIndexOf(" ")).trim();
		
		int units = context.convertRomanNumericStringToDecimal(textCommand);
		context.addMetalUnits(metalName,  ((float)credit/units));		
			
		return "";
		
	}

}
