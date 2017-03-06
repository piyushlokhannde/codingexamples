package test.java.piyush.romannumerical;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import main.java.piyush.romannumerical.RomanNumber;
import main.java.piyush.romannumerical.RomanNumeral;
import main.java.piyush.romannumerical.validator.IRomanNumericalValidator;
import main.java.piyush.romannumerical.validator.RepeatSymbolValidator;
import main.java.piyush.romannumerical.validator.SubstractionValidator;

import org.junit.Test;

public class RomanNumericalTest {
	
	
	@Test
	public void testNumbericValue() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber testClass = new RomanNumber(validatorList);
		RomanNumeral[] romanSringArray = new RomanNumeral[]{
		 RomanNumeral.V, RomanNumeral.I, RomanNumeral.I};
		assertEquals(testClass.isValid(romanSringArray), true);
		assertEquals(testClass.getDecimalNumberFromRoman(romanSringArray), 7);
	}
	
	@Test
	public void testNumbericValue1() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber testClass = new RomanNumber(validatorList);
		RomanNumeral[] romanSringArray = new RomanNumeral[]{
				RomanNumeral.I, RomanNumeral.V };	
		assertEquals(testClass.isValid(romanSringArray), true);
		assertEquals(testClass.getDecimalNumberFromRoman(romanSringArray), 4);
	}
	
	@Test
	public void testNumbericValue2() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber testClass = new RomanNumber(validatorList);
		RomanNumeral[] romanSringArray = new RomanNumeral[]{
				RomanNumeral.X, RomanNumeral.I, RomanNumeral.I};	
		assertEquals(testClass.isValid(romanSringArray), true);
		assertEquals(testClass.getDecimalNumberFromRoman(romanSringArray), 12);
	}
	
	@Test
	public void testNumbericValue3() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber testClass = new RomanNumber(validatorList);
		RomanNumeral[] romanSringArray = new RomanNumeral[]{
				RomanNumeral.L, RomanNumeral.V};	
		assertEquals(testClass.isValid(romanSringArray), true);
		assertEquals(testClass.getDecimalNumberFromRoman(romanSringArray), 55);
	}
	
	@Test
	public void testNumbericValue4() {
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber testClass = new RomanNumber(validatorList);
		RomanNumeral[] romanSringArray = new RomanNumeral[] {
				RomanNumeral.L,
				RomanNumeral.X,
				RomanNumeral.I,
				RomanNumeral.I };
		assertEquals(testClass.isValid(romanSringArray), true);
		assertEquals(testClass.getDecimalNumberFromRoman(romanSringArray), 62);
	}
	
	@Test
	public void testNumbericValue5() {
		//LXXVIII
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber testClass = new RomanNumber(validatorList);
		RomanNumeral[] romanSringArray = new RomanNumeral[] {
				RomanNumeral.L,
				RomanNumeral.X,
				RomanNumeral.X,
				RomanNumeral.V,
				RomanNumeral.I,
				RomanNumeral.I,
				RomanNumeral.I};
		assertEquals(testClass.isValid(romanSringArray), true);
		assertEquals(testClass.getDecimalNumberFromRoman(romanSringArray), 78);
	}
	
	 @Test
	public void testNumbericValue6() {
		// DCCCXC
		 List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
			validatorList.add(new RepeatSymbolValidator());
			validatorList.add(new SubstractionValidator());
			RomanNumber testClass = new RomanNumber(validatorList);
		RomanNumeral[] romanSringArray = new RomanNumeral[] {
				RomanNumeral.D,
				RomanNumeral.C,
				RomanNumeral.C,
				RomanNumeral.C,
				RomanNumeral.X,
				RomanNumeral.C };
		assertEquals(testClass.isValid(romanSringArray), true);
		assertEquals(testClass.getDecimalNumberFromRoman(romanSringArray), 890);
	}
	 
	@Test
	public void testNumbericValue7() {
		// MDCCC
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber testClass = new RomanNumber(validatorList);
		RomanNumeral[] romanSringArray = new RomanNumeral[] {
				RomanNumeral.M,
				RomanNumeral.D,
				RomanNumeral.C,
				RomanNumeral.C,
				RomanNumeral.C };
		assertEquals(testClass.isValid(romanSringArray), true);
		assertEquals(testClass.getDecimalNumberFromRoman(romanSringArray), 1800);
	}
	
	@Test
	public void testNumbericValue8() {
		// MCMXLIV
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber testClass = new RomanNumber(validatorList);
		RomanNumeral[] romanSringArray = new RomanNumeral[] {
				RomanNumeral.M,
				RomanNumeral.C,
				RomanNumeral.M,
				RomanNumeral.X,
				RomanNumeral.L,
				RomanNumeral.I,
				RomanNumeral.V
				};
		assertEquals(testClass.isValid(romanSringArray), true);
		assertEquals(testClass.getDecimalNumberFromRoman(romanSringArray), 1944);
	}
	
	
	@Test
	public void testNumbericValue9() {
		// LXXIX
		List<IRomanNumericalValidator> validatorList = new ArrayList<IRomanNumericalValidator>();
		validatorList.add(new RepeatSymbolValidator());
		validatorList.add(new SubstractionValidator());
		RomanNumber testClass = new RomanNumber(validatorList);
		RomanNumeral[] romanSringArray = new RomanNumeral[] {
				RomanNumeral.L,
				RomanNumeral.X,
				RomanNumeral.X,
				RomanNumeral.I,
				RomanNumeral.X

		};
		assertEquals(testClass.isValid(romanSringArray), true);
		assertEquals(testClass.getDecimalNumberFromRoman(romanSringArray), 79);
	}

}
