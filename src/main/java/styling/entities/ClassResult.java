package styling.entities;

public class ClassResult {

	private int numberOfMethods;
	private int averageNumberOfLines;
	private int maxNumberOfLines;
	
	public ClassResult(int numberOfMethods, int averageNumberOfLines, int maxNumberOfLines) {
		this.numberOfMethods = numberOfMethods;
		this.averageNumberOfLines = averageNumberOfLines;
		this.maxNumberOfLines = maxNumberOfLines;
	}
	
	public int getNumberOfMethods() {
		return numberOfMethods;
	}
	
	public void setNumberOfMethods(int numberOfMethods) {
		this.numberOfMethods = numberOfMethods;
	}
	
	public int getAverageNumberOfLines() {
		return averageNumberOfLines;
	}
	
	public void setAverageNumberOfLines(int averageNumberOfLines) {
		this.averageNumberOfLines = averageNumberOfLines;
	}
	
	public int getMaxNumberOfLines() {
		return maxNumberOfLines;
	}
	
	public void setMaxNumberOfLines(int maxNumberOfLines) {
		this.maxNumberOfLines = maxNumberOfLines;
	}
}
