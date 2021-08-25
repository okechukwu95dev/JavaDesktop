package com.sg.classroster.dao;

//this extends exception and throws error
public class ClassRosterPersistenceException extends Exception{

    //Constructor used for errors in  not caused by another exception
    //e.g. validation rules for student data input does pass
    public ClassRosterPersistenceException(String message) {
        super(message);//thrown with message describing problem
    }

    //Constructor used for errors caused by another exception
    //e.g fileNotFound exception
    //we use this in the catch blocks of the specific implementation
    //We use throwable to capture as many exceptions as possible. Exception extends throwable
    public ClassRosterPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
