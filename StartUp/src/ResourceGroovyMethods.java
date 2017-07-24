import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.codehaus.groovy.runtime.IOGroovyMethods;

public class ResourceGroovyMethods {
	public static String getText(File file, String charset) throws IOException {
	 return IOGroovyMethods.getText(newReader(file, charset));
	}
//start
	private static InputStream newReader(File file, String charset) {
		return null;
	}
//end
}
