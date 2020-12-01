/*
Authors: Hunter Carmona, Ethan Co, Jordan Slater
Description: This is the file handler, which will handle reading, saving and writing to csv files 
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FileHandler 
{
	/*
	 * This method reads from a csv file and returns a student list which is used for the JTable
	 * @param myFile	file to be read from
	 * @return students	ArrayList of Student objects
	 */
	public static ArrayList<Student> FileReadCSV(File myFile)
	{
		ArrayList<Student> students = new ArrayList<>();
		File newFile = myFile;
		String line = "";
		String delimeter = ",";
		try(BufferedReader br = new BufferedReader(new FileReader(newFile)))
		{
			line = br.readLine();
			while(line != null)
			{
				String[] studentElements = line.split(delimeter);
				Student newStudent = createStudent(studentElements);
				students.add(newStudent);
				line = br.readLine();
			}
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		return students;
	}
	/*
	 * FileReadCSVDate will read data from a file and create a Date object from it.
	 * @param myFile is the file to be read.
	 * @return date1 is the Date we are returning.
	 */
	public static Date FileReadCSVDate(File myFile, String d)
	{
		Date date1 = new Date(d);
		File newFile = myFile;
		String line = "";
		String delimeter = ",";
		try(BufferedReader br = new BufferedReader(new FileReader(newFile)))
		{
			line = br.readLine();
			String shit = line.substring(3);
			shit.trim();
			
			while(line != null)
			{
				String[] dateElements = line.split(delimeter);
				double stuTime = Double.parseDouble(dateElements[1]);
				Student temp = new Student();
				temp.ASURITE = dateElements[0];
				date1.addStudent(temp, stuTime);
				line = br.readLine();
			}
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		return date1;
	}
	/*
	 * This method will return a Student given an array of Strings.
	 * @param elements is the string array of Student elements.
	 * @return tempStudent is the Student we are returning.
	 */
	public static Student createStudent(String[] elements)
	{
		String ID = elements[0];
		String firstName = elements[1];
		String lastName = elements[2];
		String programAndPlan = elements[3];
		String academicLevel = elements[4];
		String asuRite = elements[5];
		Student tempStudent = new Student(ID, firstName, lastName, programAndPlan, academicLevel, asuRite);
		return tempStudent;
	}
	/*
	 * This method saves the current JTable to a csv file
	 * @param test	the TableModel displayed on the gui
	 * @param myFile the file to be saved to 
	 */
	public static void FileSaveCSV(DefaultTableModel test, File myFile)
	{
		try 
		{
			FileWriter writer = new FileWriter(myFile);
			for(int i = 0; i < test.getColumnCount(); i++)
			{
				writer.write(test.getColumnName(i) + ",");
			}
			writer.write("\n");
			for(int i = 0; i < test.getRowCount(); i++)
			{
				for(int j = 0; j < test.getColumnCount(); j++)
				{
					writer.write(test.getValueAt(i, j) + ",");
				}
				writer.write("\n");
			}
			writer.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
