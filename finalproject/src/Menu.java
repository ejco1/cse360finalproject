import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
	static JFrame frame;
	static JMenuBar menuBar;
	static JMenu file, about;
	static MyJTable table;
	static JMenuItem loadRoster, addAttendace, save, plotData;
	public static void main(String[] args)
	{
		//Create the frame
		frame = new JFrame("CSE360 Final Project");
		
		//Create the menu bar
		menuBar = new JMenuBar();
		
		//Create the JTable
		table = new MyJTable();
		table.setOpaque(true);
		
		//Create the menu bar items
		file = new JMenu("File");
		about = new JMenu("About");
		
		//Create the menu items
		loadRoster = new JMenuItem("Load a roster");
		addAttendace = new JMenuItem("Add attendance");
		save = new JMenuItem("Save");
		plotData = new JMenuItem("Plot data");
		
		loadRoster.addActionListener(new MyActionListener());
		addAttendace.addActionListener(new MyActionListener());
		save.addActionListener(new MyActionListener());
		plotData.addActionListener(new MyActionListener());
		
		//Add menu items to file menu
		file.add(loadRoster);
		file.add(addAttendace);
		file.add(save);
		file.add(plotData);
		
		//Add menu's to menu bar
		menuBar.add(file);
		menuBar.add(about);
		
		//Add menu bar to the frame
		frame.setJMenuBar(menuBar);
		
		//Add the JTable to the frame
		JPanel panel = new JPanel();
		panel.add(new JScrollPane(table));
		frame.add(panel);
		
		frame.setSize(1000, 1000);
		frame.setVisible(true);
	}
	
	
}
