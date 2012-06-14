package styling;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import styling.entities.ClassResult;
import styling.entities.MethodResult;
import styling.parser.ClassParser;

public class TestClassParser {

	@Test
	public void testSimpleClass() throws IOException {
		
		File file = new File("src/test/java/dummyclasses/Example.java");
		
		ClassResult classResult = ClassParser.parse(file);
		
		Assert.assertEquals("Example", classResult.getClassName());
		Assert.assertEquals(2, classResult.getNumberOfAttributes());
		Assert.assertEquals(3, classResult.getMethodResultList().size());
		Assert.assertEquals(0, classResult.getNumberOfImports());

		Assert.assertEquals(1, classResult.getMethodResultList().get(1).getNumberOfLines());

		MethodResult methodResult = classResult.getMethodResultList().get(2);

		Assert.assertEquals("longMethod", methodResult.getName());
		Assert.assertEquals(6, methodResult.getNumberOfLines());
	}
}
