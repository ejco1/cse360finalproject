import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class Menu extends JFrame {
	/**
	 * Default SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	static JFrame frame;
	static JMenuBar menuBar;
	static JMenu file, about;
	static MyJTable table;
	static JMenuItem loadRoster, addAttendance, save, plotData;
	Menu()
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

		about.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event){
				String authors = "Ethan Co, Hunter Carmona, Jordan Slater\n";
				String desc = "This is a program designed to load in a class roster, add in the attendance for specific days and plot attendance data per student.\n";
				
				JPanel panel = new JPanel();
				panel.setLayout(new FlowLayout());
				panel.add(new JLabel(authors));
				panel.add(new JLabel(desc));

				final JDialog d = new JDialog();
				d.setSize(200, 200);
				d.setLocationRelativeTo(null);
				d.add(panel);
				d.setVisible(true);


			}
		});
		
		//Create the menu items
		loadRoster = new JMenuItem("Load a roster");
		addAttendance = new JMenuItem("Add attendance");
		save = new JMenuItem("Save");
		plotData = new JMenuItem("Plot data");
		
		loadRoster.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event)
			{
				//This is where we load roster
				File myFile;
				Scanner fileChosen;
				int response;
				JFileChooser fileChooser = new JFileChooser("");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				response = fileChooser.showOpenDialog(null);
				if(response == JFileChooser.APPROVE_OPTION)
				{
					myFile = fileChooser.getSelectedFile();
					//This is where we call method to parse file and add to table
				}
			}
		});
		addAttendance.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event)
			{
				//This is where we add attendance
				File myFile;
				Scanner fileChosen;
				int response;
				JFileChooser fileChooser = new JFileChooser("");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				response = fileChooser.showOpenDialog(null);
				if(response == JFileChooser.APPROVE_OPTION)
				{
					myFile = fileChooser.getSelectedFile();
					//This is where we call method to parse file and add to table
				}
			}
		});
		save.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event)
			{		
				//This is where we save the roster	
			}
		});
		plotData.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event)
			{
				//This is where we print the graph
			}
			
		});
		
		//Add menu items to file menu
		file.add(loadRoster);
		file.add(addAttendance);
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
	public static void main(String[] args) 
	{
		new Menu();
	}
}
