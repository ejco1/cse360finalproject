import java.lang.String;

public class Student{
    String ID;
    String firstN;
    String lastN;
    String program;
    String academicLevel;
    String ASURITE;
    double time;

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