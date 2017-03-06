package main.java.piyush.romannumerical.validator;

import main.java.piyush.romannumerical.RomanNumeral;

/**
 * This interface is implemented by the class who defines the roman numerical rules,
 *
 */
public interface IRomanNumericalValidator {
	
	/**
	 * Override this method to define the valid rules for the roman numericals.
	 * @param romanSringArray
	 * @return
	 */
	Boolean validate(RomanNumeral[] romanSringArray);
}
