package main.java.romannumerial;

import java.util.ArrayList;
import java.util.List;

public class CheckInvalidPattern {
	
	List<String> invalidPattern = new ArrayList<>();

	public void addInvalidPattern(String invalidPattern) {
		this.invalidPattern.add(invalidPattern);
		
	}

	public boolean validate(String inputNumerical) {		
		return !invalidPattern.stream()
				.anyMatch(e-> inputNumerical.contains(e));
	}
	

}
