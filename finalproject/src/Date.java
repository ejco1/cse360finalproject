import java.lang.String;
import java.util.ArrayList;
/*
Date Object for the last columns of the JTable. This may also be used for the JTable for the roster.
Date objects should be held in a Date Array to be put in the last columns of the table.
--WARNING: This does not separate students not in the roster. Will have to be done in the MyActionListener.java file.
*/
public class Date {
    ArrayList<Student> arrStudents;
    String date;

/*
Constructor for the class, setting the size of the array,
We are given that the Date from DatePicker will be given in the form of a special String.
*/
public Date(String d){
    arrStudents = new ArrayList<Student>();
    date = d;
}
/*
Array Getter.
*/
public ArrayList<Student> getStudents(){
    return arrStudents;
}
/*
Date Getter.
*/
public String getDate(){
    return date;
}
/*
Student Adder, to be used manually for testing purposes & through a bufferedReader for the Table purposes.
*/
public void addStudent(Student s, double t){
    Student toBeAdded = s;
    double time = Math.round(t/75) * 100;

    toBeAdded.setTime(time);
    arrStudents.add(toBeAdded);
}
}