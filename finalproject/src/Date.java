/*
Authors: Hunter Carmona, Ethan Co, Jordan Slater
Description: This is the Date Object, where the name of the Date is held, and an arrayList of Students.
*/
import java.lang.String;
import java.util.ArrayList;

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
    Array Index Getter.
    */
	public Student getStudents(int i){
	    return arrStudents.get(i);
	}
	/*
	Date Getter.
	*/
	public String getDate(){
	    return date;
	}
	/*
    Student Adder, takes parameters of student, and time.
    This copies from the parameter so the parameter will not be changed, and looks for the student before adding it.
    If the student is found, it adds the time together, else it creates a new Student Object.
	*/
	public void addStudent(Student s, double t){
	    Student toBeAdded = s;
	    double time = t;
        if(findStudent(s) < 0){
	    toBeAdded.setTime(time);
        arrStudents.add(toBeAdded);
        } else {
            arrStudents.get(findStudent(s)).time = arrStudents.get(findStudent(s)).time + time;
        }
    }
    /*
    Student Finder, returns the index of where the Student was found, if the Student was not found then
    it will return -1.
    */
    public int findStudent(Student s){
        int index = 0;
        for(Student yes : arrStudents){
            if(yes.ASURITE.compareTo(s.ASURITE) == 0){
                return index;
            }
            index++;
        }

        return -1;
    }
}