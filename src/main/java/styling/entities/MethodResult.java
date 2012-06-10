package styling.entities;

public class MethodResult {

	private String name;
	private int numberOfLines;
	
	public MethodResult(String name, int numberOfLines) {
		this.name = name;
		this.numberOfLines = numberOfLines;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumberOfLines() {
		return numberOfLines;
	}
	
	public void setNumberOfLines(int numberOfLines) {
		this.numberOfLines = numberOfLines;
	}
}
