package codeanalyzer.metricsexporter;

/**
 * Factory class responsible for creating the appropriate Exporter based on the output type.
 * @author JohnKalan
 */
public class ExporterFactory {
    public Exporter createExporter(String outputType) {
        if (outputType.equals("csv")) {
            return new CsvExporter();
        } else if (outputType.equals("json")) {
            return new JsonExporter();
        } else {
            throw new IllegalArgumentException("Unknown type: " + outputType);
        }
    }
}
