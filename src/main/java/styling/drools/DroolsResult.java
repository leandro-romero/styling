package styling.drools;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DroolsResult {

	private HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
	
	public void add(String className, String problemFound) {
		
		if (!getHashMap().containsKey(className)) {
			getHashMap().put(className, new LinkedList<String>());
		}
		
		getHashMap().get(className).add(problemFound);
	}

	public HashMap<String, List<String>> getHashMap() {
		return hashMap;
	}
}
