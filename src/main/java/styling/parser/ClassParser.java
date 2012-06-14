package styling.parser;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import styling.entities.ClassResult;
import styling.entities.MethodResult;

public abstract class ClassParser {

	public static ClassResult parse(File file) throws IOException {

		List<String> lineList = FileUtils.readLines(file);
		int numberOfImports = 0;
		int numberOfLines = 0;
		int numberOfAttributes = 0;
		String className = "";
		
		boolean insideClass = false;
		boolean insideMethod = false;
		
		Pattern methodPattern = Pattern.compile("(public|protected|private) (static )?\\w+(<\\w+>)? \\w+\\(.*\\)");
		Pattern attributePattern = Pattern.compile("(public|protected|private) \\w+(<\\w+>)? \\w+");
		
		List<MethodResult> methodResultList = new LinkedList<MethodResult>();
		MethodResult newMethod = null;
		int numberOflinesOfMethod = 0;
		
		for (String line : lineList) {
			
			if (line.startsWith("import")) {
				numberOfImports++;
			}
			
			if (insideClass) {
				numberOfLines++;
			}
			
			if (insideMethod) {
				numberOflinesOfMethod++;
			}

			if (line.startsWith("public") && line.contains("class") && className.isEmpty()) {
				insideClass = true;
				String[] resultado = line.split(" ");
				
				className = resultado[resultado.length - 2];
				continue;
			}

			boolean isMethod = methodPattern.matcher(line).find();

			if (isMethod) {

				if (newMethod != null) {
					newMethod.setNumberOfLines(numberOflinesOfMethod - 1);
					methodResultList.add(newMethod);
				}

				String methodName = line.substring(line.lastIndexOf(' ', line.indexOf('(')) + 1, line.indexOf('('));

				newMethod = new MethodResult(methodName, 0);

				numberOflinesOfMethod = 0;
				insideMethod = true;
			}

			if (!isMethod && attributePattern.matcher(line).find()) {
				numberOfAttributes++;
			}

			if (line.startsWith("\t}")) {
				insideMethod = false;
			}
		}

		newMethod.setNumberOfLines(numberOflinesOfMethod - 1);
		methodResultList.add(newMethod);

		return new ClassResult(className, numberOfLines - 1, numberOfImports, numberOfAttributes, methodResultList);
	}
}
