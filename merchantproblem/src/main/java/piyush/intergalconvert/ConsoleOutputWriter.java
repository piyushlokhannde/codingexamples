package main.java.piyush.intergalconvert;

public class ConsoleOutputWriter implements IOutputWriter {

	@Override
	public void writeOutput(String output) {
		if(output != null && !"".equals(output)) {
			System.out.println(output);
		}

	}

	@Override
	public void setOutputFinished(Boolean finish) {
		// Not Required for this output

	}

}
