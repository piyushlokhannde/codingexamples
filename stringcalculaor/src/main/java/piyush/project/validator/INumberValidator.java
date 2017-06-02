package piyush.project.validator;

import piyush.project.exception.InvalidNumbersException;

/**
 * Created by devil jin on 5/24/2017.
 */
public interface INumberValidator {

     void validateNumbers(Number[] numbers) throws InvalidNumbersException;
}
