/*
Authors: Hunter Carmona, Ethan Co, Jordan Slater
Description: This is the Student Object, where it holds all of the information of the Students.
*/
import java.lang.String;
public class Student{
    String ID;
    String firstN;
    String lastN;
    String program;
    String academicLevel;
    String ASURITE;
    double time;

/*
Class Constructors, one without parameters and the other with.
*/
    public Student(){
    ID = "";
    firstN = "";
    lastN = "";
    program = "";
    academicLevel = "";
    ASURITE = "";
    time = 0;
    }
    public Student(String id, String fN, String lN, String prog, String level, String asuRite){
        ID = id;
        firstN = fN;
        lastN = lN;
        program = prog;
        academicLevel = level;
        ASURITE = asuRite;
        time = 0;
    }
    /*
    Getters and Setters for each Variable.
    */
    public void setTime(double t){
        time = t;
    }
    public String getAcademicLevel() {
        return academicLevel;
    }

    public String getFirstN() {
        return firstN;
    }
    public String getLastN(){
        return lastN;
    }

    public String getASURITE() {
        return ASURITE;
    }

    public String getProgram() {
        return program;
    }

    public double getTime() {
        return time;
    }
    
    public String getID() {
    	return ID;
    }
}