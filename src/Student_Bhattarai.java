import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Student_Bhattarai
{
    String studentID;
    String lastName;
    String firstName;
    Class aClass;//Class
    String subjectName;
    char letterGrade;

    public Student_Bhattarai(String lastName, String firstName, Class aClass) {
        this.studentID = generateRandomID();
        this.lastName = lastName;
        this.firstName = firstName;
        this.aClass = aClass;
    }

    public String generateRandomID(){
        int initNumber = 0;
        initNumber = (int)((Math.random() * 9000000)+1000000);
//        System.out.print((initNumber));
        return String.valueOf(initNumber);
    }

    public String toString(){
//        Class aClass = new Class(subjectName,letterGrade);

        return "STUDENT\nStudent ID:\t"+studentID+"\nStudent:\t"+firstName+" "+lastName+"\nClasses:\n"+aClass.toString();
    }

    public void toFile(){
        /***
         * TODO:Output after creating class Class
         */
        String gradeString = Character.toString(letterGrade);
        List<List<String>> rows = Arrays.asList(Arrays.asList(studentID,firstName+" "+lastName,subjectName,gradeString));

        try {
            FileWriter csvWriter = new FileWriter("students.csv");
            csvWriter.append("Student ID");
            csvWriter.append(",");
            csvWriter.append("Name");
            csvWriter.append(".");
            csvWriter.append("Classes");
            csvWriter.append("\n");

            for (List<String> rowData : rows) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Student_Bhattarai deepCopy()
    {
        aClass = new Class(subjectName);
        Student_Bhattarai clone=new Student_Bhattarai(lastName, firstName, aClass);
        return clone;
    }
    public int compareTo(String targetKey)
    {
        return(studentID.compareTo(targetKey));
    }

    public String getStudentID() {
        return studentID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
