package gradeshistogram; 

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HistogramGenerator {
	public static void main(String[] args) throws IOException {
		try {
	        List<String> data = new ArrayList<String>();
	        Scanner sc = new Scanner(new FileReader("grades.txt"));
	        String str;
	        while (sc.hasNext()) {
	            str = sc.next();
	            data.add(str);
	        }
	        String[] grades = data.toArray(new String[0]);
	        sc.close();
	        
	        generateChart(grades);
	    } catch (FileNotFoundException e) {
	        System.out.println("File not found.");
	    }
	}
	public static void generateChart(String[] grades) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (grades) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the grades. There might be many
		 * series in one grades.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		
		for (int i = 0; i < grades.length; i++) {
			data.add(i, Integer.parseInt(grades[i]));
		}

		// add the series to the grades
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}
}
