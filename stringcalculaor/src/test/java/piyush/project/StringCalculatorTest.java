package piyush.project;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import piyush.project.exception.InvalidNumbersException;
import piyush.project.parser.IStringParser;
import piyush.project.parser.IStringToNumberConverter;
import piyush.project.parser.StringParser;
import piyush.project.parser.StringToNumberConverter;
import piyush.project.validator.INumberValidator;
import piyush.project.validator.IStringValidator;
import piyush.project.validator.NegativeNumberValidator;
import piyush.project.validator.StringValidator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by devil jin on 5/17/2017.
 */

public class StringCalculatorTest {

    @Rule
    public ExpectedException exceptionGrabber = ExpectedException.none();

    private StringCalculator calculator;
    @Before
    public void setup() {

        IStringValidator validator  = new StringValidator();
        IStringParser parser = new StringParser();
        IStringToNumberConverter converter = new StringToNumberConverter();
        INumberValidator numberValidator = new NegativeNumberValidator();
         calculator = new StringCalculator(validator, parser,converter,numberValidator);
    }

    @Test
    public void testNoNumbersArePassedToMethod() throws InvalidNumbersException {
        int sum = calculator.add("");
        assertThat(sum , is(equalTo(0)));
    }

    @Test
    public void testAdditionOfOnlyOneNumber() throws  InvalidNumbersException{

        int sum = calculator.add("1");
        assertThat(sum , is(equalTo(1)));
    }

    @Test
    public void testAdditionOfTwoNumber() throws  InvalidNumbersException {
        int sum = calculator.add("1,2");
        assertThat(sum , is(equalTo(3)));
    }

    @Test
    public void testAdditionOfThreeNumber() throws  InvalidNumbersException {
        int sum  = calculator.add("1,2,3");
        assertThat(sum, is(equalTo(6)));
    }

    @Test
    public void testAdditionOfFiveNumber() throws  InvalidNumbersException {
        int sum  = calculator.add("1,2,3,4,5");
        assertThat(sum, is(equalTo(15)));
    }

    @Test
    public void testAdditionWithNewLineCharacter() throws  InvalidNumbersException {
        int sum  = calculator.add("1\n2");
        assertThat(sum, is(equalTo(3)));
    }

    @Test
    public void testAdditionWithTwoSeparater() throws  InvalidNumbersException {
        int sum  = calculator.add("1\n2,1\n1\n1");
        assertThat(sum, is(equalTo(6)));
    }

    @Test
    public void testAddMethodWithDiffDelimiters() throws  InvalidNumbersException {
        int sum  = calculator.add("//;\n1;2");
        assertThat(sum, is(equalTo(3)));
    }

    @Test(expected = InvalidNumbersException.class)
    public void testNegativeNumberInTheString() throws  InvalidNumbersException {
        int sum  = calculator.add("//;\n1;-2");
        exceptionGrabber.expect(InvalidNumbersException.class);
        exceptionGrabber.expectMessage(" negatives not allowed : -2");
    }

    @Test(expected = InvalidNumbersException.class)
    public void testMultipleNegativeNumberInTheString() throws  InvalidNumbersException {
        int sum  = calculator.add("//;\n1;-2;-3");
        exceptionGrabber.expect(InvalidNumbersException.class);
       // exceptionGrabber.expectMessage();
        exceptionGrabber.expectMessage(is(equalTo(" negatives not allowed : -2, -3")));
    }

    @Test
    public void testAdditionOfTwoNumbersGreaterThan1k() throws  InvalidNumbersException {
        int sum  = calculator.add("//;\n1;2;1001");
        assertThat(sum, is(equalTo(3)));
    }

    @Test
    public  void testAdditionWithLongDelimiter() throws  InvalidNumbersException  {
        int sum  = calculator.add("//**\n1**2");
        assertThat(sum, is(equalTo(3)));

    }

    @Test
    public  void testAdditionWithLongDelimiterPattern() throws  InvalidNumbersException  {
        int sum  = calculator.add("//bb\n2bb2");
        assertThat(sum, is(equalTo(4)));
    }

    @Test
    public void testAdditionWithMultipleDelimiter() throws  InvalidNumbersException {
        int sum  = calculator.add("//[*][%]\n1*2%3");
        assertThat(sum, is(equalTo(6)));
    }

    @Test
    public void testAdditionWithMultipleDelimiterWithMultipleLength() throws  InvalidNumbersException {
        int sum  = calculator.add("//[****][*%]\n1****2*%3");
        assertThat(sum, is(equalTo(6)));
    }















}