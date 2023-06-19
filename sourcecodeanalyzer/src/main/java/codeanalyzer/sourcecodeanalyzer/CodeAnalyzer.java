package codeanalyzer.sourcecodeanalyzer;

import java.io.IOException;

public interface CodeAnalyzer {
    int calculateLOC(String filepath) throws IOException;
    int calculateNOM(String filepath) throws IOException;
    int calculateNOC(String filepath) throws IOException;
}
