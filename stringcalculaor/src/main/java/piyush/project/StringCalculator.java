package piyush.project;

import piyush.project.exception.InvalidNumbersException;
import piyush.project.parser.IStringParser;
import piyush.project.parser.IStringToNumberConverter;
import piyush.project.validator.INumberValidator;
import piyush.project.validator.IStringValidator;

/**
 * Created by devil jin on 5/17/2017.
 */
public class StringCalculator {

    private IStringValidator validator;

    private IStringParser parser;

    private IStringToNumberConverter numberConverter;

    private INumberValidator numberValidator;

    public StringCalculator(IStringValidator validator, IStringParser parser,
                            IStringToNumberConverter numberConverter, INumberValidator numberValidator) {
        this.parser = parser;
        this.validator = validator;
        this.numberConverter = numberConverter;
        this.numberValidator = numberValidator;
    }


    public int add(String calcString)  throws InvalidNumbersException {

        if(!validator.validate(calcString)) {
            return 0;
        }

        String[] stringNumArray  = parser.parseString(calcString);
        Number[] numbers = numberConverter.convertToNumber(stringNumArray);
        numberValidator.validateNumbers(numbers);

        int sum =0;
        for(Number number : numbers) {
            if(number.intValue()  <=  1000) {
                sum += number.intValue();
            }

        }
        return sum;
    }
}
