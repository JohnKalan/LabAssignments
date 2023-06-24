package codeanalyzer.sourcecodeanalyzer;

import codeanalyzer.sourcefilereader.FileReader;

public class CodeAnalyzerFactory {
    public static CodeAnalyzer createCodeAnalyzer(String analyzerType, FileReader fileReader) {
        if (analyzerType.equals("regex")) {
            return new RegexCodeAnalyzer(fileReader);
        } else if (analyzerType.equals("strcomp")) {
            return new StringComparisonCodeAnalyzer(fileReader);
        }
        throw new IllegalArgumentException("Invalid analyzer type");
    }
}