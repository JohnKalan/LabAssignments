package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import codeanalyzer.sourcefilereader.*;

public class SourceFileReaderTest {
    private static SourceFileReader sfr;
    private static List<String> expectedList;
    private static String expectedString;
    private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
    private final static String TEST_CLASS_WEB = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";

    @BeforeClass
    public static void setUp() throws IOException {
        sfr = new SourceFileReader();
        expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
        expectedString = String.join("\n", expectedList);
    }

    @Test
    public void testReadFileIntoListLocal() throws IOException {
        List<String> actualList = sfr.readFileIntoList(TEST_CLASS_LOCAL, "local");

        String[] expecteds = expectedList.toArray(new String[0]);
        String[] actuals = actualList.toArray(new String[0]);

        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testReadFileIntoListWeb() throws IOException {
        List<String> actualList = sfr.readFileIntoList(TEST_CLASS_WEB, "web");

        String[] expecteds = expectedList.toArray(new String[0]);
        String[] actuals = actualList.toArray(new String[0]);

        assertArrayEquals(expecteds, actuals);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReadFileIntoListInvalidType() throws IOException {
        sfr.readFileIntoList(TEST_CLASS_LOCAL, "invalid-type");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReadFileIntoStringInvalidType() throws IOException {
        sfr.readFileIntoString(TEST_CLASS_LOCAL, "invalid-type");
    }

    @Test
    public void testReadFileIntoStringWeb() throws IOException {
        String actuals = sfr.readFileIntoString(TEST_CLASS_WEB, "web");
        assertEquals(expectedString, actuals);
    }

    @Test
    public void testReadFileIntoStringLocal() throws IOException {
        String actuals = sfr.readFileIntoString(TEST_CLASS_LOCAL, "local");
        assertEquals(expectedString, actuals);
    }
}