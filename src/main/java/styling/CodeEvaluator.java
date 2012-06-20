package styling;

import org.drools.runtime.StatefulKnowledgeSession;

import styling.drools.DroolsHelper;
import styling.drools.DroolsResult;
import styling.entities.ClassResult;
import styling.entities.ProjectResult;
import styling.parser.ProjectParser;

public abstract class CodeEvaluator {

	public static DroolsResult evaluate(String pathToCode) {

		StatefulKnowledgeSession kSession = DroolsHelper.createSession("src/main/resources/style_rules.drl");

		DroolsResult result = new DroolsResult();

		kSession.setGlobal("DROOLS_RESULT", result);

		ProjectResult projectResult = ProjectParser.parse(pathToCode);
		
		insertFacts(kSession, projectResult);

		kSession.dispose();
		
		return result;
	}

	private static void insertFacts(StatefulKnowledgeSession kSession, ProjectResult projectResult) {

		for (ClassResult classResult : projectResult.getClassResultList()) {
			kSession.insert(classResult);
		}

		kSession.fireAllRules();
	}
}
