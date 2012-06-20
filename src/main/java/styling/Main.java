package styling;

import styling.drools.DroolsResult;

public class Main {

    public static void main(String[] args) {

        DroolsResult result = CodeEvaluator.evaluate("src/main/java");
        
		System.out.println("Code Evaluation Result");
		System.out.println("---------------------------");
		System.out.println();

		for (String className : result.getHashMap().keySet()) {
			System.out.println("Class : " + className);
			System.out.println("Problems found: ");

			for (String problemFound : result.getHashMap().get(className)) {
				System.out.println("\t- " + problemFound);
			}

			System.out.println();
		}
    }
}
