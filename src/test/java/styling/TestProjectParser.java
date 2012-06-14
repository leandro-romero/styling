package styling;

import junit.framework.Assert;

import org.junit.Test;

import styling.entities.ProjectResult;
import styling.parser.ProjectParser;

public class TestProjectParser {

	@Test
	public void testFolder() {
		
		ProjectResult result = ProjectParser.parse("src/test/java/dummyclasses");
		
		Assert.assertEquals(1, result.getClassResultList().size());
		Assert.assertEquals("Example", result.getClassResultList().get(0).getClassName());
	}	
}
