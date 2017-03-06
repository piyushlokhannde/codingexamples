package test.java.piyush.romannumerical;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.piyush.romannumerical.RomanNumeral;
import main.java.piyush.romannumerical.validator.RepeatSymbolValidator;
import main.java.piyush.romannumerical.validator.SubstractionValidator;

public class RomanNumbericalValidateTest {

	@Test
	public void testIRepeatValidate() {
		RepeatSymbolValidator testClass = new RepeatSymbolValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[5];
		romanSringArray[0] = RomanNumeral.I;
		romanSringArray[1] = RomanNumeral.I;
		romanSringArray[2] = RomanNumeral.I;
		romanSringArray[3] = RomanNumeral.L;
		romanSringArray[4] = RomanNumeral.I;		
		assertEquals(testClass.validate(romanSringArray), false);
	}
	
	@Test
	public void testXRepeatValidate() {
		RepeatSymbolValidator testClass = new RepeatSymbolValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[5];
		romanSringArray[0] = RomanNumeral.X;
		romanSringArray[1] = RomanNumeral.X;
		romanSringArray[2] = RomanNumeral.X;
		romanSringArray[3] = RomanNumeral.I;
		romanSringArray[4] = RomanNumeral.X;		
		assertEquals(testClass.validate(romanSringArray), true);
	}
	
	@Test
	public void testCRepeatValidate() {
		RepeatSymbolValidator testClass = new RepeatSymbolValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[5];
		romanSringArray[0] = RomanNumeral.C;
		romanSringArray[1] = RomanNumeral.C;
		romanSringArray[2] = RomanNumeral.C;
		romanSringArray[3] = RomanNumeral.X;
		romanSringArray[4] = RomanNumeral.C;		
		assertEquals(testClass.validate(romanSringArray), true);
	}

	@Test
	public void testMRepeatValidate() {
		RepeatSymbolValidator testClass = new RepeatSymbolValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[5];
		romanSringArray[0] = RomanNumeral.M;
		romanSringArray[1] = RomanNumeral.M;
		romanSringArray[2] = RomanNumeral.M;
		romanSringArray[3] = RomanNumeral.C;
		romanSringArray[4] = RomanNumeral.M;		
		assertEquals(testClass.validate(romanSringArray), true);
	}
	
	@Test
	public void testDRepeatValidate() {
		RepeatSymbolValidator testClass = new RepeatSymbolValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[5];
		romanSringArray[0] = RomanNumeral.M;
		romanSringArray[1] = RomanNumeral.D;
		romanSringArray[2] = RomanNumeral.M;
		romanSringArray[3] = RomanNumeral.D;
		romanSringArray[4] = RomanNumeral.M;		
		assertEquals(testClass.validate(romanSringArray), false);
	}
	
	@Test
	public void testLRepeatValidate() {
		RepeatSymbolValidator testClass = new RepeatSymbolValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[5];
		romanSringArray[0] = RomanNumeral.M;
		romanSringArray[1] = RomanNumeral.D;
		romanSringArray[2] = RomanNumeral.M;
		romanSringArray[3] = RomanNumeral.L;
		romanSringArray[4] = RomanNumeral.L;		
		assertEquals(testClass.validate(romanSringArray), false);
	}
	
	@Test
	public void testVRepeatValidate() {
		RepeatSymbolValidator testClass = new RepeatSymbolValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[5];
		romanSringArray[0] = RomanNumeral.V;
		romanSringArray[1] = RomanNumeral.D;
		romanSringArray[2] = RomanNumeral.M;
		romanSringArray[3] = RomanNumeral.V;
		romanSringArray[4] = RomanNumeral.L;		
		assertEquals(testClass.validate(romanSringArray), false);
	}
	
	@Test
	public void testISubstractValidate() {
		SubstractionValidator testClass = new SubstractionValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[2];
		romanSringArray[0] = RomanNumeral.I;
		romanSringArray[1] = RomanNumeral.X;
			
		assertEquals(testClass.validate(romanSringArray), true);
	}
	
	@Test
	public void testXSubstractValidate() {
		SubstractionValidator testClass = new SubstractionValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[2];
		romanSringArray[0] = RomanNumeral.X;
		romanSringArray[1] = RomanNumeral.C;
			
		assertEquals(testClass.validate(romanSringArray), true);
	}
	
	@Test
	public void testCSubstractValidate() {
		SubstractionValidator testClass = new SubstractionValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[2];
		romanSringArray[0] = RomanNumeral.C;
		romanSringArray[1] = RomanNumeral.D;			
		assertEquals(testClass.validate(romanSringArray), true);
	}
	
	@Test
	public void testVSubstractValidate() {
		SubstractionValidator testClass = new SubstractionValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[2];
		romanSringArray[0] = RomanNumeral.V;
		romanSringArray[1] = RomanNumeral.X;
			
		assertEquals(testClass.validate(romanSringArray), false);
	}
	
	@Test
	public void testLSubstractValidate() {
		SubstractionValidator testClass = new SubstractionValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[2];
		romanSringArray[0] = RomanNumeral.L;
		romanSringArray[1] = RomanNumeral.C;		
		assertEquals(testClass.validate(romanSringArray), false);
	}
	
	@Test
	public void testDSubstractValidate() {
		SubstractionValidator testClass = new SubstractionValidator();
		RomanNumeral[] romanSringArray = new RomanNumeral[2];
		romanSringArray[0] = RomanNumeral.D;
		romanSringArray[1] = RomanNumeral.M;		
		assertEquals(testClass.validate(romanSringArray), false);
	}
}
