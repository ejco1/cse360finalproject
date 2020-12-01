import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.util.List;

import java.util.ArrayList;

public class Menu extends JFrame {
	/**
	 * Default SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	static JFrame frame;
	static JMenuBar menuBar;
	static JMenu file, about;
	static JTable table;
	static DefaultTableModel dtm;
	static JMenuItem loadRoster, addAttendance, save, plotData, aboutItem;
	Menu()
	{
		//Create the frame
		frame = new JFrame("CSE360 Final Project");
		
		//Create the menu bar
		menuBar = new JMenuBar();
		
		//Create the JTable
		table = new JTable();
		table.setOpaque(true);
		
		//JPanel for JTable
		JPanel panel = new JPanel();
		
		//Create the menu bar items
		file = new JMenu("File");
		about = new JMenu("About");
    
		//Create the menu items
		loadRoster = new JMenuItem("Load a roster");
		addAttendance = new JMenuItem("Add attendance");
		save = new JMenuItem("Save");
		plotData = new JMenuItem("Plot data");
		aboutItem = new JMenuItem("About");
		
		//Data Items
		ArrayList<Date> days = new ArrayList<Date>();
		ArrayList<Student> students = new ArrayList<Student>();
		
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
					table.setVisible(true);
					
					myFile = fileChooser.getSelectedFile();
					FileHandler test = new FileHandler();
					ArrayList<Student> testStudents = test.FileReadCSV(myFile);
					//create defaule JTable to add students to
					dtm = new DefaultTableModel(0, 0);
					String[] header = {"ID",        						
							"First Name",
			                "Last Name",
			                "Program & Plan",
			                "Academic Level",
			                "ASURITE"};
					dtm.setColumnIdentifiers(header);
					table.setModel(dtm);
					for(Student a : testStudents)
					{	
						//add each student to JTable
						dtm.addRow(new Object[] {a.ID, a.firstN, a.lastN, a.program, a.academicLevel, a.ASURITE});
					}
					//and set the panel to visible
					panel.setVisible(true);
				}
			}
		});
		addAttendance.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event)
			{
				JPanel attendanceOptions = new JPanel();
				attendanceOptions.setLayout(new GridLayout(0, 2, 5, 5));
				JDialog attendanceBox = new JDialog(frame, "Choose an attendance file and insert the date");
				String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
				JComboBox monthList = new JComboBox(months);
				String[] numbers = new String[31];
				for(int i = 0; i < 31; i++)
				{
					numbers[i] = String.valueOf(i+1);
				}
				JComboBox numberList = new JComboBox(numbers);
				JButton fileButton = new JButton();
				fileButton.setText("Select a file");
				
				attendanceOptions.add(monthList);
				attendanceOptions.add(numberList);
				attendanceOptions.add(fileButton);
				
				attendanceBox.add(attendanceOptions);
				attendanceBox.setSize(500,100);
				attendanceBox.setLocationRelativeTo(null);
				attendanceBox.setVisible(true);
				//This is where we add attendance
				fileButton.addActionListener(new ActionListener()	{
					public void actionPerformed(ActionEvent event)
					{
						File myFile2;
						Scanner fileChosen;
						int response;
						JFileChooser fileChooser = new JFileChooser("");
						fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
						response = fileChooser.showOpenDialog(null);
						if(response == JFileChooser.APPROVE_OPTION)
						{
							//add date column to JTable
							String columnName = String.valueOf(monthList.getSelectedItem()) + " " + String.valueOf(numberList.getSelectedItem());
							dtm.addColumn(columnName);
							
							//This is where we call method to parse file and add to table
							myFile2 = fileChooser.getSelectedFile();
							FileHandler test = new FileHandler();
							Date testDate = test.FileReadCSVDate(myFile2, columnName);
							days.add(testDate);
							
							//This if statement will be replaced with a true/false if attendance is added
							if(!testDate.getStudents().isEmpty())
							{
								JPanel attendanceInfoPanel = new JPanel();
								attendanceInfoPanel.setLayout(new BoxLayout(attendanceInfoPanel, BoxLayout.PAGE_AXIS));
								JDialog attendanceDialog = new JDialog(frame, "About");
								
								
								//getting size for the label below
								int numOfLoaded = 0;
								numOfLoaded = testDate.getStudents().size();
								
								JLabel attendanceLabel = new JLabel("Data loaded for " + numOfLoaded + " users in the roster");
								attendanceInfoPanel.add(attendanceLabel);
								//If statement for if additional attendees not on roster
								if(true) 
								{
									JLabel additionalLabel = new JLabel(" attional attendee was found:");
									//this will be a for loop for x users loaded
									//while(testDate)
									JLabel additionalLabelInfo = new JLabel(", connected for " + " minute");
									attendanceInfoPanel.add(additionalLabel);
									attendanceInfoPanel.add(additionalLabelInfo);
								}
								attendanceInfoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
								attendanceDialog.add(attendanceInfoPanel);
								attendanceDialog.setLocationRelativeTo(null);
								attendanceDialog.setSize(400, 400);
								attendanceDialog.setVisible(true);
							}
						}
					}
				});
			}
		});
		
		save.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event)
			{		
				//This is where we save the roster
				int response;
				File myFile;
				JFileChooser fileChooser = new JFileChooser("");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				response = fileChooser.showSaveDialog(null);
				if(response == JFileChooser.APPROVE_OPTION)
				{
					table.setVisible(true);
					myFile = fileChooser.getSelectedFile();
					FileHandler test = new FileHandler();
					test.FileSaveCSV(dtm, myFile);
				}
			}
		});
		/*
		The constructor for ScatterPlot holds the Pane to be created, just fix up the size of the window here.
		*/
		plotData.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event)
			{
				//This is where we print the graph
				ScatterPlot example = new ScatterPlot("Plot Attendance Data");
				// Instantiate a list of Dates for a Student..
				
				// Input into a dataset..
				example.addDataset(days);
				// Either add a JPanel, replace JTable, or use JTabbedPane
				
            	example.setSize(800,400);
            	example.setLocationRelativeTo(null);
            	example.setVisible(true);
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
				aboutBox.setLocationRelativeTo(null);
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
		panel.setVisible(false);
		panel.add(new JScrollPane(table));
		frame.add(panel);
		
		frame.setSize(1000, 1000);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new Menu();
	}
}