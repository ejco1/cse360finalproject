import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
public class MyJTable extends JPanel { 
	//global declare the data to be updated
	Object[][] data;
    public MyJTable() {
        super(new GridLayout(1,0));
 
        String[] columnNames = {"ID",        						
                				"First Name",
                                "Last Name",
                                "Program & Plan",
                                "Academic Level",
                                "ASURITE"};
 
        Object[][] data = {
        {"4916284751", "Kathy", "Smith",
         "Music", "Freshman", "kksmith1"},
        {"1346796431", "John", "Doe",
         "Mathematics", "Senior", "jsdoe"},
        {"1478523698", "Sue", "Black",
         "Art", "Senior", "seblack5"},
        {"1234567890", "Jane", "White",
         "Computer Science", "Junior", "jowhite"},
        {"1649358752", "Joe", "Brown",
         "Business and Finance", "Sophomore", "jebrown12"}
        };
 
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(900, 900));
        table.setFillsViewportHeight(true);
 
        //Create the scroll pane and add the table to it.
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        //in case of emergency: need scrollbars always
        /*
        scrollPane.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		*/
        //Add the scroll pane to this panel.
        add(scrollPane);
    }
}