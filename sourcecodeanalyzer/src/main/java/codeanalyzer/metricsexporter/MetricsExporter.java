package codeanalyzer.metricsexporter;

import java.util.Map;

/**
 * Exports (writes) the metrics to a given output.
 * The output can be CSV or JSON files.
 * This class follows SOLID principles and uses the Factory pattern.
 * It delegates the export functionality to specialized exporter classes.
 * 
 * The ExporterFactory is responsible for creating the appropriate exporter based on the output type.
 * Each exporter implements the Exporter interface, providing a unified exportMetrics method.
 * This allows for easy extensibility to support additional output formats in the future.
 * 
 * Usage:
 * ExporterFactory exporterFactory = new ExporterFactory();
 * Exporter exporter = exporterFactory.createExporter(outputType);
 * exporter.exportMetrics(metrics, filepath);
 * 
 * Note: The JSON exporter is not implemented in this example.
 *  
 * @author JohnKalan
 */
public class MetricsExporter {
    private ExporterFactory exporterFactory;

    public MetricsExporter() {
        this.exporterFactory = new ExporterFactory();
    }

    public void setExporterFactory(ExporterFactory exporterFactory) {
        this.exporterFactory = exporterFactory;
    }

    public void writeFile(String outputType, Map<String, Integer> metrics, String filepath) {
        Exporter exporter = exporterFactory.createExporter(outputType);
        exporter.exportMetrics(metrics, filepath);
    }
}
