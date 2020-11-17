import java.lang.String;

public class Student{
    String ASURITE;
    String firstN;
    String lastN;
    String program;
    String academicLevel;
    int time;

    public Student(){
    ASURITE = "";
    firstN = "";
    lastN = "";
    program = "";
    academicLevel = "";
    time = 0;
    }
    public Student(String ID, String fN, String lN, String prog, String level){
        ASURITE = ID;
        firstN = fN;
        lastN = lN;
        program = prog;
        academicLevel = level;
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
}