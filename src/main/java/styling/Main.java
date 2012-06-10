package styling;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class Main {

    public static void main(String[] args) {

        KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kBuilder.add(ResourceFactory.newFileResource("src/main/resources/drools_example.drl"), ResourceType.DRL);

        KnowledgeBaseConfiguration kBaseConfiguration = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();

        KnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase(kBaseConfiguration);
        kBase.addKnowledgePackages(kBuilder.getKnowledgePackages());

        StatefulKnowledgeSession kSession = kBase.newStatefulKnowledgeSession();

        insertFacts(kSession);
        
        kSession.dispose();
    }

    private static void insertFacts(StatefulKnowledgeSession kSession) {
        
    	Integer prueba = new Integer(5);
    	
        kSession.insert(prueba);
        kSession.fireAllRules();
    }
}
