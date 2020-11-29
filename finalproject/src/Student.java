import java.lang.String;

public class Student{
    String ID;
    String firstN;
    String lastN;
    String program;
    String academicLevel;
    String ASURITE;
    int time;

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
    }
    public void setTime(int t){
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

    public int getTime() {
        return time;
    }
    
    public String getID() {
    	return ID;
    }
}