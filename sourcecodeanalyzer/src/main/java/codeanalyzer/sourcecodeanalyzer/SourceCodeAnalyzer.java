package codeanalyzer.sourcecodeanalyzer;

import java.io.IOException;
import codeanalyzer.sourcefilereader.FileReader;

public class SourceCodeAnalyzer {
    private CodeAnalyzer codeAnalyzer;

    public SourceCodeAnalyzer(String analyzerType, FileReader fileReader) {
        this.codeAnalyzer = CodeAnalyzerFactory.createCodeAnalyzer(analyzerType, fileReader);
    }

    public int calculateLOC(String filepath) throws IOException {
        return codeAnalyzer.calculateLOC(filepath);
    }

    public int calculateNOM(String filepath) throws IOException {
        return codeAnalyzer.calculateNOM(filepath);
    }

    public int calculateNOC(String filepath) throws IOException {
        return codeAnalyzer.calculateNOC(filepath);
    }
}
