package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import com.sg.classroster.service.ClassRosterDataValidationException;
import com.sg.classroster.service.ClassRosterDuplicateIdException;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.ui.ClassRosterView;
//import com.sg.classroster.ui.UserIO;
//import com.sg.classroster.ui.UserIOConsoleImpl;

import java.util.List;

/**
* Brains of Operation, Knows what needs to be done and when
*
* Functions:
* 1- Display Menu
* 2- Get the Users menu choice
* 3- Call Method to perform action based on menu choice
*
* */

public class ClassRosterController {

//use dependency injection instead for loose coupling
//private ClassRosterView view = new ClassRosterView();
//private ClassRosterDao dao = new ClassRosterDaoFileImpl();
//private UserIO io = new UserIOConsoleImpl();

    private ClassRosterView view;// view implements the USERio
    private ClassRosterServiceLayer service; //implements the dao


    public ClassRosterController(ClassRosterView view, ClassRosterServiceLayer service){
        this.view = view;
        this.service = service;
    }


    //run method (kickstart)
    public void run(){
        boolean keepPrintingMenu = true;//key for while loop
        int menuSelection = 0;//initialise menu selection to random int


        try{
        while(keepPrintingMenu){
            //cal get menu selection method(instance of view)
            menuSelection = getMenuSelection();

            //switch actions based on user selection
            switch (menuSelection) {
                case 1:
                    getAllStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepPrintingMenu = false;
                    break;
                default:
                    unknownCommand();
            }
        }
       exitMessage();}
        catch(ClassRosterPersistenceException e){
            view.displayErrorMessage(e.getMessage());
        }
    }



    //PRIVATE CONTROLLER  METHODS THAT HANDLE THE REQUESTS FORM USER INTERACTION WITH VIEW
    private int getMenuSelection(){
        //call to print menu on view member
        return view.printMenuAndGetSelection();
    }

//    private void createStudent() throws ClassRosterPersistenceException {
//        view.displayCreateStudentBanner();//display student banner
//        //collect user information and return new student object
//        //createNewStudentInfo returns student object
//        Student newStudent = view.createNewStudentInfo();
//        //store/add new student with id and inputted student object values
//        dao.addStudent(newStudent.getStudentId(), newStudent);
//        service.createStudent();
//        view.displayCreateSuccessBanner();//display success
//    }
    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student currentStudent = view.createNewStudentInfo();
            try {
                service.createStudent(currentStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }




    private void getAllStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        //implement new list with getAllStudents which returns
        //(Arraylist from daoIMPL) with template literals
        List<Student> studentList = service.getAllStudents();
        //display student list
        view.displayStudentList(studentList);
    }

    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = service.getStudent(studentId);;
        view.displaySingleStudent(student);
    }

    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = service.removeStudent(studentId);
        view.removeStudent(removedStudent);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    private void exitMessage() {
        view.displayExitBanner();
    }


}



