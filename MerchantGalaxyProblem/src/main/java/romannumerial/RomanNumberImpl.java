package main.java.romannumerial;

import main.java.romannumerial.exception.DecimalConversionException;
import main.java.romannumerial.exception.InavalidRomanNumberException;

public class RomanNumberImpl implements RomanNumber {
	
	private CheckInvalidPattern invalidPatternValidator;
	
	private ValidateSecondArgumentForSubstraction secondArgumentValidator;
	
	private String romanNumber;
	
	private Integer decimalValue;

	@Override
	public int getDecimalValue() throws DecimalConversionException {
		
		if(decimalValue == null) {
			this.parseRomanNumber();
		}		
		return decimalValue;
	}
	
	private void parseRomanNumber() throws DecimalConversionException {
		int total  =0;		
		char[] charArray = romanNumber.toCharArray();
		for(int i=charArray.length-1; i  >=0;i-=2) {
			
			int firstCharValue =RomanNumericalMapping
					.getDecimalValueOfRomanNumeral(charArray[i]+"");
			int secondCharValue = (i-1)<0? 0:RomanNumericalMapping
					.getDecimalValueOfRomanNumeral(charArray[i-1]+"");
			
			if(isPriviousElementExists(i)) {
				total = addRemainingElementToTotal(total,firstCharValue);
			} else if (isAdditionRequired(firstCharValue, secondCharValue)) {
				total = performAddition(total, firstCharValue, secondCharValue);				
			} else if (isSubstractionRequired(firstCharValue, secondCharValue) ) {
				total = performSubstraction(total, charArray, i, firstCharValue, secondCharValue);				
			}		
		}
		this.decimalValue = total;
	}

	private int performSubstraction(int total, char[] charArray, int i, int firstCharValue, int secondCharValue)
			throws DecimalConversionException {
		if(!secondArgumentValidator.validate(charArray[i]+"", charArray[i-1]+"")) {
			throw new DecimalConversionException("Validattion error");
		}
		total =total +(firstCharValue-secondCharValue);
		return total;
	}

	private boolean isSubstractionRequired(int firstCharValue, int secondCharValue) {
		return secondCharValue < firstCharValue;
	}

	private int performAddition(int total, int firstCharValue, int secondCharValue) {
		total =total+firstCharValue+secondCharValue;
		return total;
	}

	private boolean isAdditionRequired(int firstCharValue, int secondCharValue) {
		return secondCharValue>= firstCharValue;
	}
	
	private  RomanNumberImpl() {
		
	}
	
	private boolean isPriviousElementExists(int i) {
		return (i-1)< 0; 	
	}

	private int addRemainingElementToTotal(int total , int firstCharValue) {
		return total+firstCharValue;
	}
	
	public static class RomanNumberImplBuilder {
		
		private CheckInvalidPattern invalidPatternValidator;
		
		private ValidateSecondArgumentForSubstraction secondArgumentValidator;
		
		private String romanNumber;


		public void setInvalidPatternValidator(CheckInvalidPattern invalidPatternValidator) {
			this.invalidPatternValidator = invalidPatternValidator;
		}

		

		public void setSecondArgumentValidator(ValidateSecondArgumentForSubstraction secondArgumentValidator) {
			this.secondArgumentValidator = secondArgumentValidator;
		}

		

		public void setRomanNumber(String romanNumber) {
			this.romanNumber = romanNumber;
		}
		
		public RomanNumberImpl build() throws InavalidRomanNumberException {
			
			if(!invalidPatternValidator.validate(this.romanNumber)) {
				throw new InavalidRomanNumberException("Invalid Roman Number :" + this.romanNumber);
			}
			
			RomanNumberImpl romanNumberImpl = new RomanNumberImpl();
			romanNumberImpl.invalidPatternValidator = this.invalidPatternValidator;
			romanNumberImpl.secondArgumentValidator = this.secondArgumentValidator;
			romanNumberImpl.romanNumber = this.romanNumber;
			return romanNumberImpl;
			
		}
	}
	
}
