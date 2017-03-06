/**
 * 
 */
package main.java.piyush.intergalconvert;

import main.java.piyush.symbolparser.ISymbolToNumbericParser;


public class InterGalacticConverterImpl  {

	private ICommandReader commandReader;
	
	private ISymbolToNumbericParser praser;
	
	private IOutputWriter writer;
	
	public InterGalacticConverterImpl (ICommandReader commandReaderIn,
			ISymbolToNumbericParser praserIn, IOutputWriter writerIn) {
		
		this.commandReader = commandReaderIn;
		this.praser = praserIn;
		this.writer = writerIn;
	}
	
	
	public void convert() {		
		while(commandReader.hasNextCommand()) {
			writer.writeOutput(praser.decodeSymbol(commandReader.nextCommand()));
		}
		writer.setOutputFinished(true);
	}
	
	public static void main(String[] args) {

		ISymbolToNumbericParser praser = SymbolToNumbericParserFactory.getInstance(ParserType.SYMBOL_ROMAN_NUMERIC);
		IOutputWriter writer = new ConsoleOutputWriter();		
		
		ICommandReader commandReader = new FileCommandReader(args[0]);

		InterGalacticConverterImpl converter = new InterGalacticConverterImpl(commandReader, praser, writer);
		converter.convert();
	}

}
