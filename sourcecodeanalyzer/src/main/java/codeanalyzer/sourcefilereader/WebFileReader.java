package codeanalyzer.sourcefilereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * FileReader implementation for reading web files.
 * @author JohnKalan
 */
class WebFileReader implements FileReader {
    @Override
    public List<String> readFileIntoList(String filepath) throws IOException {
        List<String> lines = new ArrayList<>();
        URL url = new URL(filepath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
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
