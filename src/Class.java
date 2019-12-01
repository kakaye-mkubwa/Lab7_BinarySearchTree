public class Class
{
    String name;
    char letterGrade;

    public Class(String name) {
        this.name = name;
        this.letterGrade = 'X';
    }

    public String toString(){
        return name+"\t- "+letterGrade;
    }

}
