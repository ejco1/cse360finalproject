import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
public class MyJTable extends JPanel { 
    public MyJTable() {
        super(new GridLayout(1,0));
 
        String[] columnNames = {"ID",        						
                				"First Name",
                                "Last Name",
                                "Program & Plan",
                                "Academic Level",
                                "ASURITE"};
 
        Object[][] data = {
        {"320", "Kathy", "Smith",
         "Snowboarding", new Integer(5), new Boolean(false)},
        {"yes", "John", "Doe",
         "Rowing", new Integer(3), new Boolean(true)},
        {"send help", "Sue", "Black",
         "Knitting", new Integer(2), new Boolean(false)},
        {"THIS IS AN ID", "Jane", "White",
         "Speed reading", new Integer(20), new Boolean(true)},
        {"56411", "Joe", "Brown",
         "Pool", new Integer(10), new Boolean(false)}
        };
 
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
    }
}