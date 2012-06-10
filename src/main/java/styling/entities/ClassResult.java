package styling.entities;

import java.util.List;

public class ClassResult {

	private String className;
	
	private int numberOfLines;
	private int numberOfImports;
	private int numberOfAttributes;
	
	private List<MethodResult> methodResultList;

	public ClassResult(String className, int numberOfLines, int numberOfImports,
					   int numberOfAttributes, List<MethodResult> methodResultList) {
		this.className = className;
		this.numberOfLines = numberOfLines;
		this.numberOfImports = numberOfImports;
		this.numberOfAttributes = numberOfAttributes;
		this.methodResultList = methodResultList;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getNumberOfLines() {
		return numberOfLines;
	}

	public void setNumberOfLines(int numberOfLines) {
		this.numberOfLines = numberOfLines;
	}

	public int getNumberOfImports() {
		return numberOfImports;
	}

	public void setNumberOfImports(int numberOfImports) {
		this.numberOfImports = numberOfImports;
	}

	public int getNumberOfAttributes() {
		return numberOfAttributes;
	}

	public void setNumberOfAttributes(int numberOfAttributes) {
		this.numberOfAttributes = numberOfAttributes;
	}

	public List<MethodResult> getMethodResultList() {
		return methodResultList;
	}

	public void setMethodResultList(List<MethodResult> methodResultList) {
		this.methodResultList = methodResultList;
	}
}
