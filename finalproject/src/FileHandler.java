import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class FileHandler 
{
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
	public static Date FileReadCSVDate(File myFile, String d)
	{
		Date date1 = new Date(d);
		File newFile = myFile;
		String line = "";
		String delimeter = ",";
		try(BufferedReader br = new BufferedReader(new FileReader(newFile)))
		{
			line = br.readLine();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	public static Date createDate(String[] elements)
	{
		String ASURITE = elements[0];
		String time = elements[1];
		//Date tempDate = addStudent(ASURITE, time);
		return tempDate;
	}
	*/
}
