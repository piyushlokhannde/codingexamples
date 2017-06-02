package piyush.project.validator;

import piyush.project.exception.InvalidNumbersException;

/**
 * Created by devil jin on 5/24/2017.
 */
public class NegativeNumberValidator implements INumberValidator {

    @Override
    public void validateNumbers(Number[] numbers) throws InvalidNumbersException {
        StringBuilder builder = new StringBuilder();
        for(Number number: numbers) {
            if(number.intValue() <0) {
                builder.append(", "+number.intValue());
            }
        }
        if(builder.length() > 0) {
            throw new InvalidNumbersException("negatives not allowed :"+builder.toString().replaceFirst(",", " "));
        }


    }
}
