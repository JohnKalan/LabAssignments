package codeanalyzer.sourcefilereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * FileReader implementation for reading local files.
 * @author JohnKalan
 */
class LocalFileReader implements FileReader {
    @Override
    public List<String> readFileIntoList(String filepath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    @Override
    public String readFileIntoString(String filepath) throws IOException {
        List<String> lines = readFileIntoList(filepath);
        return String.join("\n", lines);
    }
}

