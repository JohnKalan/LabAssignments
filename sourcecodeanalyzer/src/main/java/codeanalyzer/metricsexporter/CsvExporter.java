package codeanalyzer.metricsexporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Concrete exporter class for exporting metrics to CSV format.
 * @author JohnKalan
 */

public class CsvExporter implements Exporter {
    @Override
    public void exportMetrics(Map<String, Integer> metrics, String filepath) {
        File outputFile = new File(filepath + ".csv");
        StringBuilder metricsNames = new StringBuilder();
        StringBuilder metricsValues = new StringBuilder();

        for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
            metricsNames.append(entry.getKey()).append(",");
            metricsValues.append(entry.getValue()).append(",");
        }

        try {
            FileWriter writer = new FileWriter(outputFile);
            writer.append(metricsNames).append("\n");
            writer.append(metricsValues).append("\n");
            writer.close();
            System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
