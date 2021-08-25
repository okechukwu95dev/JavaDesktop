package com.sg.classroster.ui;//This handles the UI logic

import com.sg.classroster.dto.Student;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 *
 * ClassRosterView only knows that it is interacting with user
 * it doesn't know that it is reading and writing to console
 * it could be to a GUI or other methods
 * EVERYTHING THAT HAS TO DO WITH INPUT/OUTPUT RESIDES IN OUR VIEW
 *
 * */

public class ClassRosterView {

// use dependency injection instead for loose coupling
//private UserIO io = new UserIOConsoleImpl();
    private UserIO io;

    //io member field constructor
    public ClassRosterView(UserIO io){
        this.io = io;

    }

    //public method that returns selection from menu
    public int printMenuAndGetSelection() {
        //Print Menu
        io.print("Main Menu");
        io.print("1. List Student IDs");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");
        //Get Selection
        return io.readInt("Please pick one from the choices above", 1, 5);
    }


    //view method to gather user information and create new student object
    public Student createNewStudentInfo(){
        //ask user for each field and set to variables
        String studentId = io.readString("Please enter studentID ");
        Student currentStudent = new Student(studentId);//create new user object

        String firstName = io.readString("Please enter First Name");
        currentStudent.setFirstName(firstName);

        String lastName = io.readString("Please enter Last Name");
        currentStudent.setLastName(lastName);

        String cohort = io.readString("Please enter Cohort");
        currentStudent.setCohort(cohort);

        return currentStudent;
    }
    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }
    public void displayCreateSuccessBanner() { io.readString("Student successfully created.  Please hit enter to continue"); }




    //view method that takes in list of student objects from students.values() collection
    //displays each item as string with template literal
    public void displayStudentList ( List<Student> studentList){
        for (Student currentStudent : studentList){
            //string literals
            String studentInfo = String.format("#%s : %s %s",
                    currentStudent.getStudentId(),
                    currentStudent.getFirstName(),
                    currentStudent.getLastName());
            io.print(studentInfo);//print template with values
        }
        io.readString("Press enter to continue");
    }
    public void displayDisplayAllBanner() { io.print("=== Display All Students ==="); }


    //view methods to display single student
    public void displaySingleStudent(Student student){
        if(student!=null){
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        }
        else{
            io.print("Student does not exist");
        }
        io.readString("Please hit enter to continue");

    }
    public String getStudentIdChoice() { return io.readString("Please enter the Student ID."); }
    public void displayDisplayStudentBanner () {
        io.print("=== Display Student ===");
    }


    //view methods to remove student by student id key
    public void removeStudent (Student studentRecord){
        if(studentRecord != null) {
            io.print("Students successfully removed");
        }else{
            io.print("No such student");
        }
        io.readString("Please hit enter to continue");
    }
    public void displayRemoveStudentBanner(){io.print("=== Remove Student ===");}


    //view methods for exiting and unknown commands
    public void displayExitBanner() { io.print("Good Bye!!!"); }
    public void displayUnknownCommandBanner() {io.print("Unknown Command!!!"); }
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }









}
