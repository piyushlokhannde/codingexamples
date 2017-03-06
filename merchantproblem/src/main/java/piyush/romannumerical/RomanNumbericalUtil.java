package main.java.piyush.romannumerical;

/**
 * This class defines the util method used by the class RomanNumberical.
 */
public class RomanNumbericalUtil {
	
	public static  String findtheHigherNumbericals(RomanNumeral inputNum) {
		
		String returnString = "";
		for(RomanNumeral num :RomanNumeral.values()) {
			if(num.getvalue() >=inputNum.getvalue()) {
				returnString = returnString+num.toString();
			}		
		}
	if(returnString.length() >0) {
	
		returnString = "["+returnString+ "]";
	}
		
	 return returnString;	 
	}
	
	
	public static String converntRomanNumbericalTOString(RomanNumeral[] romanSringArrays) {
		
		String returnString = "";
		for(RomanNumeral num :romanSringArrays) {
			
				returnString = returnString+num.toString();
					
		}
		
		return returnString;
	}
	
	
	public static boolean isNumbericPresentInArray(RomanNumeral[] numbericalArray, 
			RomanNumeral numToValidate) {
		
		for(RomanNumeral romanNumbericalenum:numbericalArray) {
			if(romanNumbericalenum.equals(numToValidate)) {
				return true;
			}
		}
		
		return false;
	}

}
