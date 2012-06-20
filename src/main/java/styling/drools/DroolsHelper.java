package styling.drools;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public abstract class DroolsHelper {

    public static StatefulKnowledgeSession createSession(String path) {
        
    	KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kBuilder.add(ResourceFactory.newFileResource(path), ResourceType.DRL);

        KnowledgeBaseConfiguration kBaseConfiguration = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();

        KnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase(kBaseConfiguration);
        kBase.addKnowledgePackages(kBuilder.getKnowledgePackages());

        StatefulKnowledgeSession kSession = kBase.newStatefulKnowledgeSession();
        
        return kSession;
    }
}
