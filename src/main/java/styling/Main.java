package styling;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import styling.entities.ClassResult;
import styling.entities.ProjectResult;
import styling.parser.ProjectParser;

public class Main {

    public static void main(String[] args) {

        KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kBuilder.add(ResourceFactory.newFileResource("src/main/resources/style_rules.drl"), ResourceType.DRL);

        KnowledgeBaseConfiguration kBaseConfiguration = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();

        KnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase(kBaseConfiguration);
        kBase.addKnowledgePackages(kBuilder.getKnowledgePackages());

        StatefulKnowledgeSession kSession = kBase.newStatefulKnowledgeSession();

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
