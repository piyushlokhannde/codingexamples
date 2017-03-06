package main.java.piyush.symbolparser.command;

import main.java.piyush.romannumerical.RomanNumeral;
import main.java.piyush.symbolparser.ISymbolParserContext;

public class IsTextCommand implements ITextCommand {
	
	private static String INVALID_IS_CMD = "Invalid Is Command : ";

	@Override
	public String execute(String textCommand, ISymbolParserContext context) {
		String[] commandArray = textCommand.split(" is ");	
		
		if(commandArray == null || commandArray.length != 2) {
			throw new IllegalArgumentException(INVALID_IS_CMD+"Has less than or more variable expected");
		}
		
		RomanNumeral romanNumbericalenum = context.getRomanNumbericalFromText(commandArray[1]);
		if(romanNumbericalenum == null) {
			throw new IllegalArgumentException(INVALID_IS_CMD+"Invalid Roman Numerical in Command");
		}
		context.addSymbolToContext(commandArray[0], romanNumbericalenum);
			
		return "";
	
	}

}
