package styling;

import java.util.LinkedList;

import junit.framework.Assert;

import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

import styling.drools.DroolsHelper;
import styling.drools.DroolsResult;
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
		
		StatefulKnowledgeSession kSession = DroolsHelper.createSession("src/main/resources/style_rules.drl");
		
		kSession.setGlobal("DROOLS_RESULT", new DroolsResult());
		
		return kSession;
	}
}