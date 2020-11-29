import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class Menu extends JFrame {
	static JFrame frame;
	static JMenuBar menuBar;
	static JMenu file, about;
	static MyJTable table;
	static JMenuItem loadRoster, addAttendance, save, plotData, aboutItem;
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
		
		//Create the menu items
		loadRoster = new JMenuItem("Load a roster");
		addAttendance = new JMenuItem("Add attendance");
		save = new JMenuItem("Save");
		plotData = new JMenuItem("Plot data");
		aboutItem = new JMenuItem("About");
		
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
					//This if statement will be replaced with a true/false if attendance is added
					if(true)
					{
						JPanel attendancePanel = new JPanel();
						attendancePanel.setLayout(new BoxLayout(attendancePanel, BoxLayout.PAGE_AXIS));
						JDialog attendanceDialog = new JDialog(frame, "About");
						JLabel attendanceLabel = new JLabel("Data loaded for " + " users in the roster");
						attendancePanel.add(attendanceLabel);
						//If statement for if additional attendees not on roster
						if(true) 
						{
							JLabel additionalLabel = new JLabel(" attional attendee was found:");
							//this will be a for loop for x users loaded
							JLabel additionalLabelInfo = new JLabel(", connected for " + " minute");
							attendancePanel.add(additionalLabel);
							attendancePanel.add(additionalLabelInfo);
						}
						attendancePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
						attendanceDialog.add(attendancePanel);
						attendanceDialog.setSize(400, 400);
						attendanceDialog.setVisible(true);
					}
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
		
		aboutItem.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event)
			{
				//This is where we open a dialog box 
				JDialog aboutBox = new JDialog(frame, "About");
				JLabel aboutTeam = new JLabel("CSE 360 Final Project by Ethan Co, Jordan Slater and Hunter Carmona");
				aboutBox.add(aboutTeam);
				aboutBox.setSize(400, 400);
				aboutBox.setVisible(true);
			}
			
		});
		//Add menu items to file menu
		file.add(loadRoster);
		file.add(addAttendance);
		file.add(save);
		file.add(plotData);
		
		about.add(aboutItem);
		
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
