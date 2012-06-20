package styling;

import org.drools.runtime.StatefulKnowledgeSession;

import styling.drools.DroolsHelper;
import styling.drools.DroolsResult;
import styling.entities.ClassResult;
import styling.entities.ProjectResult;
import styling.parser.ProjectParser;

public class Main {

    public static void main(String[] args) {

        StatefulKnowledgeSession kSession = DroolsHelper.createSession("src/main/resources/style_rules.drl");
        
        DroolsResult result = new DroolsResult();
        
        kSession.setGlobal("DROOLS_RESULT", result);        
        
        insertFacts(kSession);
        
        kSession.dispose();
        
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

    private static void insertFacts(StatefulKnowledgeSession kSession) {

    	ProjectResult projectResult = ProjectParser.parse("src/main/java");
   	
    	for (ClassResult classResult : projectResult.getClassResultList()) {
    		kSession.insert(classResult);
		}
    	
    	kSession.fireAllRules();
    }
}
