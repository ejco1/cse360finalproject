import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;  
import org.jfree.data.xy.XYSeries;  
import org.jfree.data.xy.XYSeriesCollection;

/*
ScatterPlot object
*/
public class ScatterPlot extends JFrame {
    private static final long serialVersionUID = 6294689542092367723L;

    /* Class Constructor
    */
    public ScatterPlot(String title) {

        super(title);
        //Create Dataset
        XYDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createScatterPlot(
            "Cats Penis Size vs Dog Penis Size", 
            "Cats", "Dogs", dataset, PlotOrientation.VERTICAL, true, false, false);
        
        //Background Color
        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(236, 188, 151));
        
        //Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset(){
        XYSeriesCollection dataset = new XYSeriesCollection();

        //Manually Adding Series..
        XYSeries series1 = new XYSeries("First Set");
        
        series1.add(1, 72.9);  
        series1.add(2, 81.6);  
        series1.add(3, 88.9);  
        series1.add(4, 96);  
        series1.add(5, 102.1);  

        dataset.addSeries(series1);

        XYSeries series2 = new XYSeries("Second Set");

        series2.add(1, 72.5);  
        series2.add(2, 80.1);  
        series2.add(3, 87.2);  
        series2.add(4, 94.5);  
        series2.add(5, 101.4);  
  
        dataset.addSeries(series2); 

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScatterPlot example = new ScatterPlot("I don't know what this is yet");
            example.setSize(800,400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }

}
