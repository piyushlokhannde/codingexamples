package test.java.romannumerial;

import static main.java.romannumerial.RomanNumericalMapping.RomanNumericalEnum.C;
import static main.java.romannumerial.RomanNumericalMapping.RomanNumericalEnum.D;
import static main.java.romannumerial.RomanNumericalMapping.RomanNumericalEnum.I;
import static main.java.romannumerial.RomanNumericalMapping.RomanNumericalEnum.L;
import static main.java.romannumerial.RomanNumericalMapping.RomanNumericalEnum.M;
import static main.java.romannumerial.RomanNumericalMapping.RomanNumericalEnum.V;
import static main.java.romannumerial.RomanNumericalMapping.RomanNumericalEnum.X;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.romannumerial.CheckInvalidPattern;
import main.java.romannumerial.exception.DecimalConversionException;
import main.java.romannumerial.exception.InavalidRomanNumberException;
import main.java.romannumerial.RomanNumber;
import main.java.romannumerial.ValidateSecondArgumentForSubstraction;

public class RomanNumerialTest {
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInvalidPatternPresentIntheRomanNumerical() {
		CheckInvalidPattern  validator = new  CheckInvalidPattern(); 
		validator.addInvalidPattern(""+I+I+I+I);
		validator.addInvalidPattern(""+X+X+X+X);
		validator.addInvalidPattern(""+C+C+C+C);
		validator.addInvalidPattern(""+M+M+M+M);
		validator.addInvalidPattern(""+D+D);
		validator.addInvalidPattern(""+L+L);
		validator.addInvalidPattern(""+V+V);
		
		String[] invalipattInput = {"XIIII", "VXXXX","CCCCM",
				"MMMMD","DDMMM","LLDM", "VVM"};
		
		for(String pattern: invalipattInput) {
			
			boolean validate = validator.validate(pattern);
			assertFalse(validate);
		}	
	}
	
	@Test
	public void testSubstractValidationPattern() {

		ValidateSecondArgumentForSubstraction validator = new ValidateSecondArgumentForSubstraction();
		validator.addValidPattern(I.toString(), V + X.toString());
		validator.addValidPattern(X.toString(), L + C.toString());
		validator.addValidPattern(C.toString(), D + M.toString());

		String[][] invalipattInput = { { V.toString(), I.toString() }, { L.toString(), X.toString() },
				{ M.toString(), C.toString() } };

		for (String[] pattern : invalipattInput) {
			boolean validate = validator.validate(pattern[0], pattern[1]);
			assertTrue(validate);
		}
	}
	
	
	
	@Test
	public void testSubstractInValidSecondParameter() {

		ValidateSecondArgumentForSubstraction validator = new ValidateSecondArgumentForSubstraction();
		validator.addInvalidSecondParmeters(""+V+L+D+"");

		String[][] invalipattInput = { { I.toString(), D.toString() }, { M.toString(), L.toString() },
				{ M.toString(), V.toString() } };

		for (String[] pattern : invalipattInput) {
			boolean validate = validator.validate(pattern[0], pattern[1]);
			assertFalse(validate);
		}
	}
	
	@Test
	public void testRomanNumericalForInvalidPattern() throws InavalidRomanNumberException {
		String romanNumberStr  = "IIII";
		thrown.expect(InavalidRomanNumberException.class);
		thrown.expectMessage("Invalid Roman Number :"+romanNumberStr);
		RomanNumber romanNumber = RomanNumber.getInstance(romanNumberStr);
	}
	
	@Test
	public void testRomanNumericalForValidNumerical() throws InavalidRomanNumberException, DecimalConversionException {
		String[] romanNumberArray = {"II", "VI", "V"};	
		int[] outputArray =  {2,6,5};		
		for(int i=0;i<romanNumberArray.length;i++) {
			RomanNumber romanNumber = RomanNumber.getInstance(romanNumberArray[i]);
			assertThat(outputArray[i],is(equalTo(romanNumber.getDecimalValue())));
		}	
	}
	
	@Test
	public void testRomanNumericalForValidNumericalWithSubstract() throws InavalidRomanNumberException, DecimalConversionException {
		String[] romanNumberArray = {"IV", "DCCCXC","LXXXIII", "XXXIV", "LXXXVIII"};	
		int[] outputArray =  {4, 890, 83, 34,88};		
		for(int i=0;i<romanNumberArray.length;i++) {
			RomanNumber romanNumber = RomanNumber.getInstance(romanNumberArray[i]);
			assertThat(outputArray[i],is(equalTo(romanNumber.getDecimalValue())));
		}	
	}
	
	
	@Test
	public void testRomanNumericalForInvalidRomanNumerical() throws InavalidRomanNumberException, DecimalConversionException {
		thrown.expect(InavalidRomanNumberException.class);
		String[] romanNumberArray = {"IIII"};					
		for(int i=0;i<romanNumberArray.length;i++) {
			RomanNumber romanNumber = RomanNumber.getInstance(romanNumberArray[i]);
			
		}	
	}
	
	
	
	
	
	
	

}
