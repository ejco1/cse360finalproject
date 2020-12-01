import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot; 
import org.jfree.data.xy.XYSeries;  
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;
/*
Authors: Hunter Carmona, Ethan Co, Jordan Slater
Description: This is the Scatter Plot, every time the method is called, it adds a new series to its dataset and displays all of the current points.
*/
public class ScatterPlot extends JFrame {
    private static final long serialVersionUID = 6294689542092367723L;
    XYSeriesCollection dataset;
    /* Class Constructor, it's already predetermined what the Scatter Plot will be about.
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
    This iterates through every day to find the number of students at each percentage, it is divided in percentages of 10 and is rounded to the nearest 10.
    Essentially, it'll consistently have 10 data points on the Scatter Plot.
    */
    public void addDataset(ArrayList<Date> d){
        int zeroP, tenP, twentyP, thirtyP, fortyP, fiftyP, sixtyP, seventyP, eightyP, ninetyP, oneP;
        zeroP = tenP = twentyP = thirtyP = fortyP = fiftyP = sixtyP = seventyP = eightyP = ninetyP = oneP = 0;
        for(Date day : d){
        XYSeries specificDate = new XYSeries(day.getDate());
            for(Student yes : day.getStudents()){
                if(Math.round((yes.getTime()/75) * 100) == 0)
                    zeroP++;
                else if(Math.round((yes.getTime()/75) * 100) == 10)
                    tenP++;
                else if(Math.round((yes.getTime()/75) * 100) == 20)
                    twentyP++;
                else if(Math.round((yes.getTime()/75) * 100) == 30)
                    thirtyP++;
                else if(Math.round((yes.getTime()/75) * 100) == 40)
                    fortyP++;
                else if(Math.round((yes.getTime()/75) * 100) == 50)
                    fiftyP++;
                else if(Math.round((yes.getTime()/75) * 100) == 60)
                    sixtyP++;
                else if(Math.round((yes.getTime()/75) * 100) == 70)
                    seventyP++;
                else if(Math.round((yes.getTime()/75) * 100) == 80)
                    eightyP++;
                else if(Math.round((yes.getTime()/75) * 100) == 90)
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
}
