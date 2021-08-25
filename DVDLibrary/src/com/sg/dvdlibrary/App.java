package com.sg.dvdlibrary;
import com.sg.dvdlibrary.controller.DvdLibraryController;
import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sg.dvdlibrary.ui.DvdLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * In App, we will :
 * Declare a UserIO variable and initialize it with a UserIOConsoleImpl reference.
 * Declare and instantiate a DvdLibraryView object, passing the UserIO  into the constructor.
 * Declare a DvdLibraryDao variable and initialize it with a DvdLibraryDaoFileImpl reference.
 * Instantiate a DvdLibraryController, passing the DvdLibraryDao and DvdLibraryView object into the constructor.
 * Call the run method on the controller to kick things off.
 *
 * REMEMBER: for dependency injection in this case, we are crr
 *
 * */


public class App {
    /**
     * main method in this case configures,instantiates and assembles the MVC classes
     * */


//    These are injected only at run time ??? Ask calvin fidd b/W run and compile time
        public static void main(String[] args) {
            UserIO myIo = new UserIOConsoleImpl(); //new i/o instance initialised with reference of specific implementation
            DvdLibraryView myView = new DvdLibraryView(myIo);//view instance with user io variable in constructor
            DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();//dao instance
            DvdLibraryController controller =
                    new DvdLibraryController(myDao, myView);//controller instance
            controller.run();
        }


}
