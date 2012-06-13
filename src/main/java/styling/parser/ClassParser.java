package styling.parser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import styling.entities.ClassResult;

public abstract class ClassParser {

	public static ClassResult Parse(File file) throws IOException {

		List<String> lineList = FileUtils.readLines(file);
		int numberOfImports = 0;
		int numberOfLines = 0;
		int numberOfMethods = 0;
		int numberOfAttributes = 0;
		
		boolean insideClass = false;
		
		Pattern methodPattern = Pattern.compile("(public|protected|private) (static )?\\w+ \\w+\\(.*\\)");
		Pattern attributePattern = Pattern.compile("(public|protected|private) \\w+ \\w+");		
		
		for (String line : lineList) {
			
			if (line.startsWith("import ")) {
				numberOfImports++;
			}
			
			if (insideClass) {
				numberOfLines++;
			}
			
			if (line.startsWith("public") && line.contains("class")) {
				insideClass = true;
			}
			
			boolean isMethod = methodPattern.matcher(line).find();
			
			if (isMethod) {
				numberOfMethods++;
				System.out.println(line);
				// Parsear método
			}
			
			if (!isMethod && attributePattern.matcher(line).find()) {
				numberOfAttributes++;
			}
		}
		
		return new ClassResult("nombre_clase", numberOfLines - 1, numberOfImports, numberOfAttributes, null);
	}	
}
