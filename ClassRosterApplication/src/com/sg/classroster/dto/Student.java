package com.sg.classroster.dto;

/**
 * Student class with get and set methods for data transfer
 * */

//This is the Data Transfer Objet that holds all the student info
public class Student {

    //MEMBER VARIABLES
    //they are strings as we are reading form a txt file
    private String firstName;
    private String lastName;
    private String studentId;
    // Programming Language + cohort month/year format
    private String cohort;

    /**
     *
     * StudentID is a read only field
     * There is no setter, only a get method
     * It is passed in as a param to constructor
     * All other fields are set manually
     *
     * */

    //CONSTRUCTOR
    public Student (String studentId ){
        this.studentId = studentId;
    }

    //METHODS
    public String getStudentId(){
        return this.studentId;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
}
