package codeanalyzer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import codeanalyzer.metricsexporter.Exporter;
import codeanalyzer.metricsexporter.ExporterFactory;
import codeanalyzer.metricsexporter.MetricsExporter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MetricsExporterTest {
	
	MetricsExporter mex = new MetricsExporter();
	
	@Test
	public void testWriteCsv() {
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
		
		// generate and write the output file
		String outputFilepath = "src/test/resources/output_metrics";
		mex.writeFile("csv", metrics, outputFilepath);
		
		// evaluate that the file exists
		File outputFile = new File(outputFilepath + ".csv");
		Assert.assertTrue(outputFile.exists());
		
		// delete the generated file
		outputFile.delete();
	}
	
	@Test
    public void testWriteJson() {
        ExporterFactory exporterFactory = mock(ExporterFactory.class);
        Exporter exporter = mock(Exporter.class);
        MetricsExporter metricsExporter = new MetricsExporter();

        // Create an empty metrics content
        Map<String, Integer> metrics = new HashMap<>();
        String outputFilepath = "whatever-path";

        // Configure mock objects
        when(exporterFactory.createExporter("csv")).thenReturn(exporter);

        // Call the method to be tested
        metricsExporter.setExporterFactory(exporterFactory);
        metricsExporter.writeFile("csv", metrics, outputFilepath);

        // Verify that the appropriate methods were called
        verify(exporter).exportMetrics(metrics, outputFilepath);
    }

	@Test(expected = IllegalArgumentException.class)
	public void testWriteFileWithUknownFIleType() {
		mex.writeFile("non-existing-type", null, null);
	}

}

