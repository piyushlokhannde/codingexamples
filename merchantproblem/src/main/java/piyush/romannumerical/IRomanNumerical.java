package main.java.piyush.romannumerical;

/**
 * This interface is used by the classes which finds out the value of the roman numerical. It defines the enum of roman numerical.
 *
 */
public interface IRomanNumerical {
	
  /**
     * Gives the decimal value for roman sequence.
     * @param romanSringArray
     * @return
     */
    int getDecimalNumberFromRoman(RomanNumeral[] romanSringArray);
    
    /**
     * Validate the Roman Sequence.
     * 
     * @param romanSringArray
     * @return
     */
    boolean isValid(RomanNumeral[] romanSringArray);
    
    /**
     * Convert into the string into roman sequence.
     * @param inputString
     * @return
     */
    RomanNumeral findRomanNumberical(String inputString);

}
