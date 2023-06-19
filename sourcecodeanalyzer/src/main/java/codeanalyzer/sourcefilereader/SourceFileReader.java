package codeanalyzer.sourcefilereader;

import java.io.IOException;
import java.util.List;

/**
 * Retrieves (reads) the contents of a given file.
 * The file can be stored locally or exist on the web.
 * This class follows the Facade pattern, SOLID principles, and incorporates the Factory pattern.
 *
 * Note: The code assumes that the type parameter is always provided and valid.
 * If no type is given, an IllegalArgumentException will be thrown.
 *
 * @author JohnKalan
 */
public class SourceFileReader {

    private FileReaderFactory fileReaderFactory;

    public SourceFileReader() {
        fileReaderFactory = new FileReaderFactory();
    }

    /**
     * Reads a file and returns its content in a List.
     *
     * @param filepath the URL or path of the file
     * @return a List that contains the contents of the file
     * @throws IOException if an I/O error occurs during file reading
     */
    public List<String> readFileIntoList(String filepath, String type) throws IOException {
        FileReader fileReader = fileReaderFactory.createFileReader(type);
        return fileReader.readFileIntoList(filepath);
    }

    /**
     * Reads a file and returns its content as a single String.
     *
     * @param filepath the URL or path of the file
     * @return a String that contains the contents of the file
     * @throws IOException if an I/O error occurs during file reading
     */
    public String readFileIntoString(String filepath, String type) throws IOException {
        FileReader fileReader = fileReaderFactory.createFileReader(type);
        return fileReader.readFileIntoString(filepath);
    }
}
