import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class FA2019_BinarySearchTreeDemo_Bhattarai {

    public static void main(String[] args){
        displayMainMenu();
    }

    public static void displayMainMenu(){
        String menu = "\tBINARY SEARCH TREE DEMO - Bhattarai\n" +
                "1. Insert\t" +
                "2. Fetch\t" +
                "3. Encapsulation\t" +
                "4. Update\t" +
                "5. Delete\t" +
                "6. Show All\t" +
                "0. Exit";
        System.out.println(menu);

        Scanner menuScanner = new Scanner(System.in);
        BinarySearchTree_Bhattarai binarySearchTree_bhattarai = new BinarySearchTree_Bhattarai();

        switch (menuScanner.nextInt()){
            case 1:
                insertMenu(binarySearchTree_bhattarai);
                break;
            case 2:
                fetchMenu(binarySearchTree_bhattarai);
                break;
            case 3:
                encapsulationMenu(binarySearchTree_bhattarai);
                break;
            case 4:
                updateMenu(binarySearchTree_bhattarai);
                break;
            case 5:
                deleteMenu(binarySearchTree_bhattarai);
                break;
            case 6:
                showAllMenu(binarySearchTree_bhattarai);
                break;
            case 0:
                exit();
                break;
            default:
                System.out.println("Invalid output");
                break;
        }
    }

    private static void exit() {
        System.exit(0);
    }

    private static void showAllMenu(BinarySearchTree_Bhattarai searchTreeBhattarai) {
        searchTreeBhattarai.showAll();
    }

    private static void deleteMenu(BinarySearchTree_Bhattarai searchTreeBhattarai) {
        System.out.println("Enter student ID to delete : ");
        Scanner deleteScanner = new Scanner(System.in);
        String id = deleteScanner.nextLine();

        if (searchTreeBhattarai.delete(id)){
            System.out.println("Student with the id "+id+" is deleted");
        }else{
            System.out.println("Delete not success");
        }
    }

    private static void updateMenu(BinarySearchTree_Bhattarai searchTreeBhattarai) {
        System.out.println("Please provide student details: ");
        Scanner studentDetailsScanner = new Scanner(System.in);
        System.out.println("Last name: ");
        String lastName = studentDetailsScanner.nextLine();
        System.out.println("First name");
        String firstName = studentDetailsScanner.nextLine();
        System.out.println("Class name");
        String className = studentDetailsScanner.nextLine();


        Class aClass = new Class(className);
        Student_Bhattarai student_bhattarai = new Student_Bhattarai(lastName,firstName,aClass);

        searchTreeBhattarai.insert(student_bhattarai);

        System.out.println("Please provide new name of student : ");
        String updatedName = studentDetailsScanner.nextLine();

        String studentID = student_bhattarai.getStudentID();

        student_bhattarai.setFirstName(updatedName);

        if(searchTreeBhattarai.update(studentID,student_bhattarai)){
            System.out.println("The first name is changed");
        }else{
            System.out.println("Update not success");
        }

    }

    private static void encapsulationMenu(BinarySearchTree_Bhattarai searchTreeBhattarai) {
        System.out.println("Please provide student details: ");
        Scanner studentDetailsScanner = new Scanner(System.in);
        System.out.println("Last name: ");
        String lastName = studentDetailsScanner.nextLine();
        System.out.println("First name");
        String firstName = studentDetailsScanner.nextLine();
        System.out.println("Class name");
        String className = studentDetailsScanner.nextLine();


        Class aClass = new Class(className);
        Student_Bhattarai inputStudent = new Student_Bhattarai(lastName,firstName,aClass);

        searchTreeBhattarai.insert(inputStudent);

        String id = inputStudent.getStudentID();

        System.out.println("Please provide new name of student : ");
        String newLastName = studentDetailsScanner.nextLine();
        inputStudent.setLastName(newLastName);

        Student_Bhattarai fetchedStudent = searchTreeBhattarai.fetch(id);

        if (fetchedStudent.getLastName().equals(inputStudent.getLastName())){
            System.out.println("Binary search tree is not encapsulated");
        }else{
            System.out.println("Binary search tree is encapsulated");
        }
    }

    private static void fetchMenu(BinarySearchTree_Bhattarai searchTreeBhattarai) {
        System.out.println("Enter student ID to delete : ");
        Scanner fetchScanner = new Scanner(System.in);
        String id = fetchScanner.nextLine();

        Student_Bhattarai returnedStudent = searchTreeBhattarai.fetch(id);
        if (returnedStudent == null){
            System.out.println("Student cannot be found");
        }else{
            System.out.println(returnedStudent.toString());
        }

    }

    private static void insertMenu(BinarySearchTree_Bhattarai searchTreeBhattarai) {
        System.out.println("Please provide student details: ");
        Scanner studentDetailsScanner = new Scanner(System.in);
        System.out.println("Last name: ");
        String lastName = studentDetailsScanner.nextLine();
        System.out.println("First name");
        String firstName = studentDetailsScanner.nextLine();
        System.out.println("Class name");
        String className = studentDetailsScanner.nextLine();


        Class aClass = new Class(className);
        Student_Bhattarai inputStudent = new Student_Bhattarai(lastName,firstName,aClass);
        if (searchTreeBhattarai.insert(inputStudent)){
            System.out.println("Insert success");
        }else{
            System.out.println("Insert failed");
        }
    }
}
