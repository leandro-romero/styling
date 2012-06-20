package styling;

import java.util.LinkedList;

import org.drools.runtime.StatefulKnowledgeSession;

import styling.drools.DroolsHelper;
import styling.entities.ClassResult;
import styling.entities.ProjectResult;
import styling.parser.ProjectParser;

public class Main {

    public static void main(String[] args) {

        StatefulKnowledgeSession kSession = DroolsHelper.createSession("src/main/resources/style_rules.drl");
        kSession.setGlobal("OUTPUT_LIST", new LinkedList<String>());        
        
        insertFacts(kSession);
        
        kSession.dispose();
    }

    private static void insertFacts(StatefulKnowledgeSession kSession) {

    	ProjectResult projectResult = ProjectParser.parse("src/main/java");
   	
    	for (ClassResult classResult : projectResult.getClassResultList()) {
    		kSession.insert(classResult);
		}
    	
    	kSession.fireAllRules();
    }
}
