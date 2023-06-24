package codeanalyzer;

import java.io.IOException;
import org.junit.Test;

import codeanalyzer.sourcecodeanalyzer.*;
import codeanalyzer.sourcefilereader.*;

import static org.junit.Assert.*;

public class SourceCodeAnalyzerTest {
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	FileReaderFactory fileReaderFactory = new FileReaderFactory();
	FileReader fileReader = fileReaderFactory.createFileReader("local");
	SourceCodeAnalyzer sca;  
	
	@Test
	public void testCalculateRegexLOC() throws IOException {
		sca = new SourceCodeAnalyzer("regex", fileReader);
		assertEquals(21, sca.calculateLOC(TEST_CLASS));
	}
	
	@Test
	public void testCalculateStrCompLOC() throws IOException {
		sca = new SourceCodeAnalyzer("strcomp", fileReader);
		assertEquals(7, sca.calculateLOC(TEST_CLASS));
	}
	
	@Test
	public void testCalculateRegexNOM() throws IOException {
		sca = new SourceCodeAnalyzer("regex", fileReader);
		assertEquals(3, sca.calculateNOM(TEST_CLASS));
	}
	
	@Test
	public void testCalculateStrCompNOM() throws IOException {
				sca = new SourceCodeAnalyzer("strcomp", fileReader);

		assertEquals(3, sca.calculateNOM(TEST_CLASS));
	}
	
	@Test
	public void testCalculateRegexNOC() throws IOException {
		sca = new SourceCodeAnalyzer("regex", fileReader);
		assertEquals(3, sca.calculateNOC(TEST_CLASS));
	}
	
	@Test
	public void testCalculateStrCompNOC() throws IOException {
		sca = new SourceCodeAnalyzer("strcomp", fileReader);
		assertEquals(3, sca.calculateNOC(TEST_CLASS));
	}
	
}

