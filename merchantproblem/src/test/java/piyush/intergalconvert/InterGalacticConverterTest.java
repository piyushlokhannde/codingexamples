package test.java.piyush.intergalconvert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.piyush.intergalconvert.FileCommandReader;
import main.java.piyush.intergalconvert.ICommandReader;

public class InterGalacticConverterTest {

	@Test
	public void test() {
		ICommandReader commandReader = new FileCommandReader("commandfile.txt");
		int i=0;
		while(commandReader.hasNextCommand()) {
			i++;
			System.out.println(commandReader.nextCommand());
		}
		assertEquals(i, 12);
		
	}

}
