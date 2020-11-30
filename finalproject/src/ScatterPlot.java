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

import java.util.ArrayList;
/*
ScatterPlot object
*/
public class ScatterPlot extends JFrame {
    private static final long serialVersionUID = 6294689542092367723L;
    XYSeriesCollection dataset;
    /* Class Constructor
    */
    public ScatterPlot(String title) {
        super(title);
        dataset = new XYSeriesCollection();

        
        JFreeChart chart = ChartFactory.createScatterPlot(
            "% of Lecture Attended vs Attending Students", 
            "% of Lecture Attended", "Attending Students", dataset, PlotOrientation.VERTICAL, true, false, false);
        
        //Background Color
        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(236, 188, 151));
        
        //Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
    /*
    This iterates through every day to find the number of students at each percentage
    */
    public void addDataset(ArrayList<Date> d){
        int zeroP, tenP, twentyP, thirtyP, fortyP, fiftyP, sixtyP, seventyP, eightyP, ninetyP, oneP;
        zeroP = tenP = twentyP = thirtyP = fortyP = fiftyP = sixtyP = seventyP = eightyP = ninetyP = oneP = 0;
        for(Date day : d){
        XYSeries specificDate = new XYSeries(day.getDate());
            for(Student yes : day.getStudents()){
                if(yes.getTime() == 0)
                    zeroP++;
                else if(yes.getTime() == 10)
                    tenP++;
                else if(yes.getTime() == 20)
                    twentyP++;
                else if(yes.getTime() == 30)
                    thirtyP++;
                else if(yes.getTime() == 40)
                    fortyP++;
                else if(yes.getTime() == 50)
                    fiftyP++;
                else if(yes.getTime() == 60)
                    sixtyP++;
                else if(yes.getTime() == 70)
                    seventyP++;
                else if(yes.getTime() == 80)
                    eightyP++;
                else if(yes.getTime() == 90)
                    ninetyP++;
                else
                    oneP++;
            }
            specificDate.add(0, zeroP); specificDate.add(10, tenP); specificDate.add(20, twentyP); specificDate.add(30, thirtyP);
            specificDate.add(40, fortyP); specificDate.add(50, fiftyP); specificDate.add(60, sixtyP); specificDate.add(70, seventyP);
            specificDate.add(80, eightyP); specificDate.add(90, ninetyP); specificDate.add(100, oneP);

            dataset.addSeries(specificDate);
            zeroP = tenP = twentyP = thirtyP = fortyP = fiftyP = sixtyP = seventyP = eightyP = ninetyP = oneP = 0;
        }
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScatterPlot example = new ScatterPlot("I don't know what this is yet");
            example.setSize(800,400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
    */
}
