package main.java.cmdmapper;

import java.util.HashMap;
import java.util.Map;

import main.java.cmdmapper.exception.WordMappingNotExist;

public class CommandMapperRepo {
	
	private Map<String, String> wordMapperMap = new HashMap<>();
	
	private Map<String, Integer> metalMap = new HashMap<>();
	
	
	public void addWordToRomanNumerical(String word, String romanNumerical) {
		wordMapperMap.put(word, romanNumerical);
	}
	
	public String getRomanNumerical(String word)  throws WordMappingNotExist {
		if(!wordMapperMap.containsKey(word)) {
			throw new WordMappingNotExist(word + " mapping does not exists");
		}		
		return wordMapperMap.get(word);
	}

	public Integer getValueForMetal(String string)   throws WordMappingNotExist {
		if(!metalMap.containsKey(string)) {
			throw new WordMappingNotExist(string + " mapping does not exists");
		}	
		return metalMap.get(string);
	}

	public void addMetalBaseValue(String metalName, int baseValue) {
		metalMap.put(metalName, baseValue);
		
	}
	
}
