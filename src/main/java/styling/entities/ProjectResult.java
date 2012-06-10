package styling.entities;

import java.util.List;

public class ProjectResult {

	private List<ClassResult> classResultList;
	
	public ProjectResult(List<ClassResult> classResultList) {
		this.classResultList = classResultList;
	}

	public List<ClassResult> getClassResultList() {
		return classResultList;
	}

	public void setClassResultList(List<ClassResult> classResultList) {
		this.classResultList = classResultList;
	}
}
