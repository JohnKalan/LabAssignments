package codeanalyzer.sourcefilereader;

/**
 * FileReaderFactory for creating the appropriate FileReader based on the file type.
 * @author JohnKalan
 */
public class FileReaderFactory {
    public FileReader createFileReader(String type) {
        if (type.equals("local")) {
            return new LocalFileReader();
        } else if (type.equals("web")) {
            return new WebFileReader();
        } else {
            throw new IllegalArgumentException("Invalid file reader type: " + type);
        }
    }
}
