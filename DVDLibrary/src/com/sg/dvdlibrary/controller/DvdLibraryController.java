package com.sg.dvdlibrary.controller;


import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dto.DvdRecord;
import com.sg.dvdlibrary.ui.DvdLibraryView;

import java.util.List;

/**
 * Brains of Operation, Knows what needs to be done and when
 *
 * Functions:
 * 1- Display Menu
 * 2- Get the Users menu choice
 * 3- Call Methods to perform action based on menu choice
 *
 * */

public class DvdLibraryController {



    private DvdLibraryView view;
    private DvdLibraryDao dao;


    //constructor for controller(used in main when instantiating specific dao & view )
    public DvdLibraryController (DvdLibraryDao dao, DvdLibraryView view){
        this.dao = dao;
        this.view = view;
    }

    //run method to kickstart program
    public void run(){
        boolean keepPrintingMenu = true;//key for while loop
        int menuSelection = 0;//initialise menu selection to random int


        try{
            while(keepPrintingMenu){

                //call get menu selection method(instance of view)
                menuSelection = getMenuSelection();

                //switch actions based on user selection
                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        viewDvdRecord();
                        break;
                    case 3:
                        createDvdRecord();
                        break;
                    case 4:
                        editDvdRecord();
                        break;
                    case 5:
                        searchDvdByTitle();
                        break;
                    case 6:
                        removeDvdRecord();
                        break;
                    case 7:
                        keepPrintingMenu = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            //save function
            exitMessage();
        }
        catch(DvdLibraryDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    /**
     * CONTROLLER  METHODS THAT HANDLE THE REQUESTS FORM USER INTERACTION WITH VIEW
     *
     *     method(){
     *        view method to interact with user
     *        dao method to handle logic of user input
     *        view method to prompt user about status/ move to next/exit
     *     }
     *
     * Here we are defining the functions in the while loop view and dao methods based on user choice
     *
     * */


    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    private void listDvds () throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DvdRecord> dvds = dao.getAllDvdRecords();
        view.displayDVDList(dvds);
    }

    private void viewDvdRecord () throws DvdLibraryDaoException{
        view.displayDisplayDvdBanner();
        String currentId  = view.getDvdIdChoice();
        DvdRecord currentRecord = dao.getDvdById(currentId);
        view.displaySingleDvd(currentRecord);
    }

    private void createDvdRecord () throws DvdLibraryDaoException{
        view.displayCreateDvdBanner();
        DvdRecord currentDvdRecord = view.createNewDvdRecord();//prompt user to create Dvd
        dao.addDvdRecord(currentDvdRecord.getDvdId(), currentDvdRecord);
        view.displayCreateSuccessBanner();
    }


    private void editDvdRecord () throws DvdLibraryDaoException {
        view.displayEditDvdBanner();
        String editedDvdId = view.getDvdIdChoice();
        DvdRecord currentRecordToEdit = dao.getDvdById(editedDvdId);
        view.editDvd(currentRecordToEdit);

        //ask calvin for better version of this
        //can I put this in main while loop
        if (currentRecordToEdit != null) {
            int menuSelection = view.getFieldMenuSelection();
            String input = view.collectUserInput();
            dao.editDvdRecord(editedDvdId, menuSelection, input);
            view.displayEditSuccessBanner();
        }
    }

    private void removeDvdRecord() throws DvdLibraryDaoException{
        view.displayRemoveDvdBanner();
        String dvdId = view.getDvdIdChoice();
        DvdRecord removedDvd = dao.removeDvdRecord(dvdId);
        view.removeDvd(removedDvd);
    }

    private void searchDvdByTitle () throws DvdLibraryDaoException{
        view.displaySearchDvdBanner();
        String queryString  = view.getDvdTitleChoice();
       List<DvdRecord> currentSearch = dao.getDvdByTitle(queryString);
        view.displayDVDList(currentSearch);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    private void exitMessage() {
        view.displayExitBanner();
    }


}
