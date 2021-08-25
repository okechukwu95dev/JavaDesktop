package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DvdRecord;

import java.util.List;

/**
 *
 * DvdLibraryView only knows that it is interacting with user
 * it doesn't know that it is reading and writing to console
 * or to file
 *
 * The specific implementation of the I/O in this case is for the concole
 * (User IO)
 *
 *
 * EVERYTHING THAT HAS TO DO WITH INPUT/OUTPUT RESIDES IN OUR VIEW
 *
 * */

public class DvdLibraryView {

    //allows for loose coupling(dependency injection)
    private UserIO io;

    //io member field constructor
    public DvdLibraryView(UserIO io){
        this.io = io;
    }

    //public method that returns selection from menu
    public int printMenuAndGetSelection() {
        //Print Menu
        io.print("Main Menu");
        io.print("1. List all DVDs");
        io.print("2. View single DVD Record(by ID search)");
        io.print("3. Create New DVD Record");
        io.print("4. Edit a DVD Record");
        io.print("5. Search for DVD by Title");
        io.print("6. Remove a DVD Record");
        io.print("7. Exit");
        //Get Selection
        return io.readInt("Please pick one from the choices above", 1, 7);
    }

    public int getFieldMenuSelection(){
        //Print Menu

        io.print("Select Field to Edit");
        io.print("1. Title");
        io.print("2. Release Date");
        io.print("3. Official Rating");
        io.print("4. Director Name");
        io.print("5. Studio");
        io.print("6. User Rating");
        io.print("7. Exit");
        //Get Selection
        return io.readInt("Please pick one from the choices above", 1, 7);
    }

    //view method to gather user information and create new dvdRecord object
    public DvdRecord createNewDvdRecord(){
        //ask user for each field and set to variables
        String dvdId = io.readString("Please enter dvdID ");
        DvdRecord currentDvd = new DvdRecord(dvdId);//create new record object

        String title = io.readString("Please enter Title");
        currentDvd.setTitle(title);

        String releaseDate = io.readString("Please enter Release Date");
        currentDvd.setReleaseDate(releaseDate);

        String officialRating = io.readString("Please enter Official Rating");
        currentDvd.setOfficialRating(officialRating);

        String directorName = io.readString("Please enter Director Name");
        currentDvd.setDirectorName(directorName);

        String studio = io.readString("Please enter Studio Name");
        currentDvd.setStudio(studio);

        String userRating = io.readString("Please enter User Rating/Comments");
        currentDvd.setUserRating(userRating);

        return currentDvd;
    }
    public void displayCreateDvdBanner() {
        io.print("=== Create DVD RECORD ===");
    }
    public void displayCreateSuccessBanner() { io.readString("RECORD successfully created.  Please hit enter to continue"); }
    //------------------------------------------------------------------------------------



    //view method that takes in list of dvdObjects objects from dvdRecords.values() collection
    //displays each item as string with template literal
    public void displayDVDList ( List<DvdRecord> dvdRecordList){
        for (DvdRecord currentDvd : dvdRecordList){
            //string literals
            String dvdInfo = String.format("#%s : TITLE: %s STUDIO: %s ",
                    currentDvd.getDvdId(),
                    currentDvd.getTitle(),
                    currentDvd.getStudio());
            io.print(dvdInfo);//print template with values
        }
        io.readString("Press enter to continue");
    }
    public void displayDisplayAllBanner() { io.print("=== Display All DVDs ==="); }
    //------------------------------------------------------------------------------------


    //view method to edit dvd
    public void editDvd (DvdRecord dvd){

        if(dvd != null) {
            io.print("DVD to be edited is: ");
            io.print(dvd.getTitle());

        }else{
            io.print("No such DVD");
        }
        io.readString("Please hit enter to continue");
    }
    public String collectUserInput (){
        return io.readString("Please enter new Value");
    }
    public void displayEditDvdBanner(){io.print("=== Edit Dvd ===");}
    public void displayEditSuccessBanner() { io.readString("RECORD successfully edited.  Please hit enter to continue"); }

    //------------------------------------------------------------------------------------


    //view method to search by title, takes in list of dvd objects and returns only
    //where the title matches the user input
    public void searchDvdByTitle( List<DvdRecord> dvdRecordList){
    }
    public String getDvdTitleChoice() { return io.readString("Please enter the dvd Title."); }
    public void displaySearchDvdBanner () {
        io.print("=== DVD SEARCH ===");
    }
    //------------------------------------------------------------------------------------


    //view methods to display single DVD
    public void displaySingleDvd(DvdRecord dvd){
        if(dvd!=null){
            io.print(dvd.getDvdId());
            io.print(dvd.getTitle());
            io.print(dvd.getStudio());
            io.print(dvd.getDirectorName());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getOfficialRating());
            io.print(dvd.getUserRating());
            io.print("");
        }
        else{
            io.print("Dvd does not exist");
        }
        io.readString("Please hit enter to continue");
    }
    public String getDvdIdChoice() { return io.readString("Please enter the dvd ID."); }
    public void displayDisplayDvdBanner () {
        io.print("=== DvD search By ID ===");
    }
    //------------------------------------------------------------------------------------


    //view methods to remove DVD by dvd id key
    public void removeDvd (DvdRecord dvd){
        if(dvd != null) {
            io.print("DVD successfully removed");
        }else{
            io.print("No such DVD");
        }
        io.readString("Please hit enter to continue");
    }
    public void displayRemoveDvdBanner(){io.print("=== Remove Dvd ===");}
    //------------------------------------------------------------------------------------


    //view methods for exiting, unknown commands and errors
    public void displayExitBanner() { io.print("Good Bye!!!"); }
    public void displayUnknownCommandBanner() {io.print("Unknown Command!!!"); }
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
