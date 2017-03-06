package main.java.piyush.symbolparser.command;

import main.java.piyush.symbolparser.ISymbolParserContext;

/**
 * @author devil jinThis interface is implemented by the classes which parses each type of command.
 *
 */
public interface ITextCommand {
	
	/**
	 * Parse the command text.
	 * @param textCommand
	 * @param context
	 * @return
	 */
	String execute(String textCommand, ISymbolParserContext context);

}
