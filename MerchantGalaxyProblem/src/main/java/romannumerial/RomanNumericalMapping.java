package main.java.romannumerial;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class RomanNumericalMapping {
	
	private static Map<String, RomanNumericalEnum> romanNumMap;
	
	static {
	
		romanNumMap = Arrays.stream(RomanNumericalEnum.values())
				.collect(Collectors.toMap(RomanNumericalEnum::getValue, c->c));
	}
	
	public static Integer getDecimalValueOfRomanNumeral(String romanNumerical) {
		return romanNumMap.get(romanNumerical).getDecimalValue();
	}
	
	public static enum RomanNumericalEnum {
		
		I("I",1),V("V",5),X("X",10),L("L",50),C("C",100),D("D",500),M("M",1000);
		
		private String value;
		private Integer decimalValue;
		
		
		
		RomanNumericalEnum(String value, Integer decimalValue) {
			this.value =value;
			this.decimalValue = decimalValue;
			
		}
		
		@Override
		public String toString() {		
			return value;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Integer getDecimalValue() {
			return decimalValue;
		}
		public void setDecimalValue(Integer decimalValue) {
			this.decimalValue = decimalValue;
		}

	}
	
}
