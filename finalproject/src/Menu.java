/*
Authors: Hunter Carmona, Ethan Co, Jordan Slater
Description: This is the menu, which is the gui for the program. Also contains the main function
*/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Menu extends JFrame {
	/**
	 * Default SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	//Declare static variables for the gui
	static JFrame frame;
	static JMenuBar menuBar;
	static JMenu file, about;
	static JTable table;
	static DefaultTableModel dtm;
	static JMenuItem loadRoster, addAttendance, save, plotData, aboutItem;
	/*
	 * Constructor for Menu, creates the gui and implements its action listeners
	 */
	Menu()
	{
		frame = new JFrame("CSE360 Final Project");
		
		menuBar = new JMenuBar();
		
		table = new JTable();
		table.setOpaque(true);
		
		JPanel panel = new JPanel();
		
		file = new JMenu("File");
		about = new JMenu("About");
    
		loadRoster = new JMenuItem("Load a roster");
		addAttendance = new JMenuItem("Add attendance");
		save = new JMenuItem("Save");
		plotData = new JMenuItem("Plot data");
		aboutItem = new JMenuItem("About");
		
		ArrayList<Date> days = new ArrayList<Date>();
		ArrayList<Student> students = new ArrayList<Student>();
		loadRoster.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event)
			{
				File myFile;
				int response;
				JFileChooser fileChooser = new JFileChooser("");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				response = fileChooser.showOpenDialog(null);
				if(response == JFileChooser.APPROVE_OPTION)
				{
					table.setVisible(true);
					myFile = fileChooser.getSelectedFile();
					FileHandler test = new FileHandler();
					ArrayList<Student> testStudents = new ArrayList<Student>();
					testStudents = test.FileReadCSV(myFile);
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
						students.add(a);
						dtm.addRow(new Object[] {a.ID, a.firstN, a.lastN, a.program, a.academicLevel, a.ASURITE});
					}
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
				fileButton.addActionListener(new ActionListener()	{
					public void actionPerformed(ActionEvent event)
					{
						File myFile2;
						int response;
						JFileChooser fileChooser2 = new JFileChooser("");
						fileChooser2.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
						response = fileChooser2.showOpenDialog(null);
						if(response == JFileChooser.APPROVE_OPTION)
						{
							String columnName = String.valueOf(monthList.getSelectedItem()) + " " + String.valueOf(numberList.getSelectedItem());
							dtm.addColumn(columnName);
							myFile2 = fileChooser2.getSelectedFile();
							
							FileHandler test2 = new FileHandler();
							Date testDate = test2.FileReadCSVDate(myFile2, columnName);
							Date realStuds = new Date(columnName);
							ArrayList<Student> newStuds = new ArrayList<Student>();
							
							int newStudNum = 0;
							int index = -1;
							int indexYeet;
							boolean found = false;
							
							for(Student a : testDate.getStudents())
							{								
								for(Student b : students)
								{
						            if(b.ASURITE.compareTo(a.ASURITE) == 0)
						            {
						            	found = true;
						                indexYeet = index;
						            }
						            index++;
						        }
								if(found == true)
								{
									realStuds.addStudent(a, a.time);
								}
								else
								{
									newStuds.add(a);
									newStudNum++;
								}
								found = false;
							}

							days.add(realStuds);
							
							dtm.getDataVector().removeAllElements();
						    revalidate();
						    
						    for(Student a : students)
							{
								double time = 0;
								ArrayList<Student> temp = testDate.getStudents();
								for(Student i : temp)
								{
									if(i.ASURITE.compareTo(a.ASURITE) == 0)
									{
										time = i.time;
									}
								}
								dtm.addRow(new Object[] {a.ID, a.firstN, a.lastN, a.program, a.academicLevel, a.ASURITE, time});
							}
						    
							if(!testDate.getStudents().isEmpty())
							{
								JPanel attendanceInfoPanel = new JPanel();
								attendanceInfoPanel.setLayout(new BoxLayout(attendanceInfoPanel, BoxLayout.PAGE_AXIS));
								JDialog attendanceDialog = new JDialog(frame, "Pick A Date");
								int numOfLoaded = 0;
								numOfLoaded = realStuds.getStudents().size();
								
								JLabel attendanceLabel = new JLabel("Data loaded for " + numOfLoaded + " users in the roster");
								attendanceInfoPanel.add(attendanceLabel);
								if(true) 
								{
									String nonStuds = "";
									JLabel additionalLabel = new JLabel(newStudNum + " additional attendee was found:");
									for(Student a : newStuds)
									{
										nonStuds = nonStuds + a.ASURITE + ", connected for " + a.time + " minutes<br/>";
									}
									JLabel additionalLabelInfo = new JLabel("<html>" + nonStuds + "</html>");
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
		plotData.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event)
			{
				ScatterPlot example = new ScatterPlot("Plot Attendance Data");
				example.addDataset(days);
            	example.setSize(800,400);
            	example.setLocationRelativeTo(null);
            	example.setVisible(true);
			}
			
		});
		aboutItem.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event)
			{
				JDialog aboutBox = new JDialog(frame, "About");
				JLabel aboutTeam = new JLabel("CSE 360 Final Project by Ethan Co, Jordan Slater and Hunter Carmona");
				aboutBox.add(aboutTeam);
				aboutBox.setSize(400, 400);
				aboutBox.setLocationRelativeTo(null);
				aboutBox.setVisible(true);
			}
		});
		file.add(loadRoster);
		file.add(addAttendance);
		file.add(save);
		file.add(plotData);
		about.add(aboutItem);
		
		menuBar.add(file);
		menuBar.add(about);

		frame.setJMenuBar(menuBar);

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