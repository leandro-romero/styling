package styling;

import java.util.LinkedList;

import junit.framework.Assert;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

import styling.entities.ClassResult;
import styling.entities.MethodResult;

public class TestDrools {

	@Test
	public void testRule() {
	
		StatefulKnowledgeSession kSession = createSession();
		
		kSession.insert(new Integer(0));
		
		int rulesFiredFirstAttempt = kSession.fireAllRules();
		
		Assert.assertEquals(0, rulesFiredFirstAttempt);
		
		ClassResult classResult = new ClassResult("TestClass", 500, 40, 20, new LinkedList<MethodResult>());
		
		kSession.insert(classResult);
		
		int rulesFiredSecondAttempt = kSession.fireAllRules();
		
		Assert.assertEquals(3, rulesFiredSecondAttempt);

		kSession.dispose();
	}

	private StatefulKnowledgeSession createSession() {
		KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kBuilder.add(ResourceFactory.newFileResource("src/main/resources/style_rules.drl"), ResourceType.DRL);

		KnowledgeBaseConfiguration kBaseConfiguration = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();

		KnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase(kBaseConfiguration);
		kBase.addKnowledgePackages(kBuilder.getKnowledgePackages());

		return kBase.newStatefulKnowledgeSession();
	}
}