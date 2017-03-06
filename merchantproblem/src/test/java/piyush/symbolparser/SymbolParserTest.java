package test.java.piyush.symbolparser;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.java.piyush.romannumerical.RomanNumber;
import main.java.piyush.romannumerical.validator.IRomanNumericalValidator;
import main.java.piyush.romannumerical.validator.RepeatSymbolValidator;
import main.java.piyush.romannumerical.validator.SubstractionValidator;
import main.java.piyush.symbolparser.ISymbolToNumbericParser.TextCommandEnum;
import main.java.piyush.symbolparser.SymbolToRomanNumericParser;
import main.java.piyush.symbolparser.command.CreditTextCommand;
import main.java.piyush.symbolparser.command.HowMuchCreditQuestionCommand;
import main.java.piyush.symbolparser.command.HowMuchIsQuestionCommand;
import main.java.piyush.symbolparser.command.ITextCommand;
import main.java.piyush.symbolparser.command.IsTextCommand;

public class SymbolParserTest {

	@Test
	public void testIsCommand() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		ITextCommand textCmand = new IsTextCommand();
		assertEquals(textCmand.execute("glob is I", parser), "");
	}
	
	@Test(expected = IllegalArgumentException.class)	
	public void testInvalidIsCommand() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		ITextCommand textCmand = new IsTextCommand();
		textCmand.execute("glob isI", parser);
	}
	
	@Test(expected = IllegalArgumentException.class)	
	public void testInvalidIsCommand1() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		ITextCommand textCmand =new IsTextCommand();
		textCmand.execute("glob is A", parser);
	}
	
	@Test	
	public void testCreditCommand() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		ITextCommand istCmand = new IsTextCommand();
		istCmand.execute("glob is I", parser);
		ITextCommand creditCommand =  new CreditTextCommand();		
		assertEquals(creditCommand.execute("glob glob Silver is 34 Credits", parser), "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreditInvalidCommand() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		ITextCommand istCmand = new IsTextCommand();
		istCmand.execute("glob is I", parser);
		ITextCommand creditCommand =  new CreditTextCommand();	
		creditCommand.execute("glob blob Silver is 34 Credits", parser);
	
	}
	
	@Test	
	public void testHowMuchIsCommand() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		ITextCommand istCmand = new IsTextCommand();
		istCmand.execute("glob is I", parser);
		ITextCommand creditCommand = new HowMuchIsQuestionCommand();
		assertEquals(creditCommand.execute("how much is glob glob ?", parser), "glob glob is 2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHowMuchIsInvalidCommand() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		ITextCommand istCmand = new IsTextCommand();
		istCmand.execute("glob is I", parser);
		ITextCommand creditCommand = new HowMuchIsQuestionCommand();
		creditCommand.execute("how much is glob glob blog ?", parser);
	}
	
	@Test
	public void testHowMuchCreditIsCommand() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		ITextCommand istCmand = new IsTextCommand();
		istCmand.execute("glob is I", parser);
		ITextCommand creditCommand =  new CreditTextCommand();	
		creditCommand.execute("glob glob Silver is 34 Credits", parser);		
		ITextCommand howmuchCreditCmd =  new HowMuchCreditQuestionCommand();
		assertEquals(howmuchCreditCmd.execute("how many Credits is glob Silver ?", parser), "glob Silver is 17 Credits");
		
	}
	
	@Test
	public void testHowMuchCreditIsCommand1() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		ITextCommand istCmand = new IsTextCommand();
		istCmand.execute("glob is I", parser);
		istCmand.execute("prok is V", parser);
		ITextCommand creditCommand = new CreditTextCommand();
		creditCommand.execute("glob glob Silver is 34 Credits", parser);
		ITextCommand howmuchCreditCmd = new HowMuchCreditQuestionCommand();
		assertEquals(howmuchCreditCmd.execute("how many Credits is glob prok Silver ?", parser),
				"glob prok Silver is 68 Credits");

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHowMuchCreditIsInvalidCommand() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		ITextCommand istCmand = new IsTextCommand();
		istCmand.execute("glob is I", parser);
		istCmand.execute("prok is V", parser);
		ITextCommand creditCommand = new CreditTextCommand();
		creditCommand.execute("glob glob Silver is 34 Credits", parser);
		ITextCommand howmuchCreditCmd = new HowMuchCreditQuestionCommand();
		howmuchCreditCmd.execute("how many Credits is glob prok mark Silver ?", parser);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHowMuchCreditIsInvalidCommand2() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		ITextCommand istCmand = new IsTextCommand();
		istCmand.execute("glob is I", parser);
		istCmand.execute("prok is V", parser);
		ITextCommand creditCommand = new CreditTextCommand();
		creditCommand.execute("glob glob Silver is 34 Credits", parser);
		ITextCommand howmuchCreditCmd = new HowMuchCreditQuestionCommand();
		howmuchCreditCmd.execute("how many Credits is glob prok Iron ?", parser);

	}
	
	@Test
	public void testSymbolToRomanNumericParser() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		parser.addCommandPocessorToParser(TextCommandEnum.IS, new IsTextCommand());
		parser.addCommandPocessorToParser(TextCommandEnum.CREDIT_TEXT, new CreditTextCommand());
		parser.addCommandPocessorToParser(TextCommandEnum.HOW_MUCH_IS, new HowMuchIsQuestionCommand());
		parser.addCommandPocessorToParser(TextCommandEnum.HOW_MUCH_CREDIT, new HowMuchCreditQuestionCommand());
		parser.decodeSymbol("glob is I");
		parser.decodeSymbol("glob glob Silver is 34 Credits");
		assertEquals(parser.decodeSymbol("how many Credits is glob Silver ?"), "glob Silver is 17 Credits");		
	}

	
	/**
	 * when symbol value is Z
	 * */
	@Test
	public void testSymbolToRomanNumericParserInValid() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		parser.addCommandPocessorToParser(TextCommandEnum.IS, new IsTextCommand());
		parser.addCommandPocessorToParser(TextCommandEnum.CREDIT_TEXT, new CreditTextCommand());
		parser.addCommandPocessorToParser(TextCommandEnum.HOW_MUCH_IS, new HowMuchIsQuestionCommand());
		parser.addCommandPocessorToParser(TextCommandEnum.HOW_MUCH_CREDIT, new HowMuchCreditQuestionCommand());
		parser.decodeSymbol("glob is Z");
		parser.decodeSymbol("glob glob Silver is 34 Credits");
		assertEquals(parser.decodeSymbol("how many Credits is glob Silver ?"), "I have no idea what you are talking about");
	}
	
	/**
	 * last command is invalid
	 * */
	@Test
	public void testSymbolToRomanNumericParserInValid1() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber romanNumerical = new RomanNumber(validatorList);
		SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
		parser.addCommandPocessorToParser(TextCommandEnum.IS, new IsTextCommand());
		parser.addCommandPocessorToParser(TextCommandEnum.CREDIT_TEXT, new CreditTextCommand());
		parser.addCommandPocessorToParser(TextCommandEnum.HOW_MUCH_IS, new HowMuchIsQuestionCommand());
		parser.addCommandPocessorToParser(TextCommandEnum.HOW_MUCH_CREDIT, new HowMuchCreditQuestionCommand());
		parser.decodeSymbol("glob is Z");
		parser.decodeSymbol("glob glob Silver is 34 Credits");
		assertEquals(parser.decodeSymbol("how manyssCredits is glob Silver ?"), "I have no idea what you are talking about");
	}
	
	@Test
		public void testSymbolToRomanNumericParserInValidFor() {		
			List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
			validatorList.add(new RepeatSymbolValidator());
			validatorList.add(new SubstractionValidator());
			RomanNumber romanNumerical = new RomanNumber(validatorList);
			SymbolToRomanNumericParser parser = new SymbolToRomanNumericParser(romanNumerical);
			parser.addCommandPocessorToParser(TextCommandEnum.IS, new IsTextCommand());
			parser.addCommandPocessorToParser(TextCommandEnum.CREDIT_TEXT, new CreditTextCommand());
			parser.addCommandPocessorToParser(TextCommandEnum.HOW_MUCH_IS, new HowMuchIsQuestionCommand());
			parser.addCommandPocessorToParser(TextCommandEnum.HOW_MUCH_CREDIT, new HowMuchCreditQuestionCommand());
			parser.decodeSymbol("glob is I");
			parser.decodeSymbol("prok is V");
			parser.decodeSymbol("pish is X");
			parser.decodeSymbol("tegj is L");
			parser.decodeSymbol("pish pish Iron is 3910 Credits");
			assertEquals(parser.decodeSymbol("how many Credits is glob prok Iron ?"), "glob prok Iron is 782 Credits");
		}
	
	

}
