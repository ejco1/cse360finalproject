import java.lang.String;
/*
The object that will display all necessary information from the About Menu Select.
 */
public class AboutInfo {
    String members;
    String description;
    public AboutInfo(){
        members = "";
        description = "";
    }
    /*
    Grants the ability to Set the Information wanting to be given from the main method.
     */
    public void setInfo(String m, String d){
        members = "Authors: " + m;
        description = "Description: " + d;
    }
    /*
    Returns the strings to be displayed onto the JPopup Menu
     */
    public String getMembers(){
        return members;
    }
    /*
    Returns the strings to be displayed onto the JPopup Menu
     */
    public String getDesc(){
        return description;
    }
}
