package main.java.piyush.intergalconvert;

/**
 *Reads teh command line
 *
 */
public interface ICommandReader {
	
	/**
	 * Check if has next command.
	 * @return
	 */
	boolean hasNextCommand();
	
	/**
	 * Get the next command.
	 * @return
	 */
	String nextCommand();

}
