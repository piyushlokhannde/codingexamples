package main.java.cmdmapper;

import main.java.cmdmapper.exception.CommandDecipherException;

public interface CmdMapper {
	
	String decipher(String cmd, CommandMapperRepo commandMapperRepo) throws CommandDecipherException;
	
	boolean isPatternMathcing(String command);

}
