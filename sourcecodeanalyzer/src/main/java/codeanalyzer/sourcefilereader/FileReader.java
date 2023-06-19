package codeanalyzer.sourcefilereader;

import java.util.List;
import java.io.IOException;

/**
 * FileReader interface for reading files.
 * @author JohnKalan
 */
public interface FileReader {
    List<String> readFileIntoList(String filepath) throws IOException;
    String readFileIntoString(String filepath) throws IOException;
}
