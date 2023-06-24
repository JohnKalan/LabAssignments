package codeanalyzer.metricsexporter;

import java.util.Map;

/**
 * Interface for exporting metrics.
 * @author JohnKalan
 */
public interface Exporter {
    void exportMetrics(Map<String, Integer> metrics, String filepath);
}
