package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterAuditDaoFileImpl;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.service.ClassRosterServiceLayerImpl;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;
/**
 *
 * In App, we will :
 * Declare a UserIO variable and initialize it with a UserIOConsoleImpl reference.
 * Declare and instantiate a ClassRosterView object, passing the UserIO  into the constructor.
 * Declare a ClassRosterDao variable and initialize it with a ClassRosterDaoFileImpl reference.
 * Instantiate a ClassRosterController, passing the ClassRosterDao and ClassRosterView object into the constructor.
 * Call the run method on the controller to kick things off.
 *
 * */

public class App {
    /**
     * main method configures,instantiates and assembles the MVC classes
     * */
//    public static void main(String[] args) {
//        UserIO myIo = new UserIOConsoleImpl();
//        ClassRosterView myView = new ClassRosterView(myIo);
//        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
//        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao,);
//
//        ClassRosterController controller =
//                new ClassRosterController(myView,myService);
//        controller.run();
//    }

    public static void main(String[] args) {
        // Instantiate the UserIO implementation
        UserIO myIo = new UserIOConsoleImpl();
        // Instantiate the View and wire the UserIO implementation into it
        ClassRosterView myView = new ClassRosterView(myIo);
        // Instantiate the DAO
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        // Instantiate the Audit DAO
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        // Instantiate the Controller and wire the Service Layer into it
        ClassRosterController controller = new ClassRosterController(myView, myService);
        // Kick off the Controller
        controller.run();
    }
}
