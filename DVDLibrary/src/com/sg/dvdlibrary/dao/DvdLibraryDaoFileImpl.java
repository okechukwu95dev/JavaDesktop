package com.sg.dvdlibrary.dao;
import com.sg.dvdlibrary.dto.DvdRecord;

import java.io.*;
import java.util.*;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    //DECLARE MEMBER VARIABLES
    private Map<String, DvdRecord> dvdRecords = new HashMap<>();
    public static final String ROSTER_FILE = "dvd-library.txt";
    public static final String DELIMITER = "::";

    @Override
    //create dvd object based on id
    public DvdRecord addDvdRecord(String dvdId, DvdRecord dvdRecord) throws DvdLibraryDaoException {
        loadRoster();
        DvdRecord newDvd = dvdRecords.put(dvdId,dvdRecord);
        writeRoster();
        return newDvd;
    }

    //should send dvd object with all fields updated
    //use hash map specific field
    @Override
    public DvdRecord editDvdRecord(String dvdId, int fieldToBeEdited, String newInput) throws DvdLibraryDaoException {
        loadRoster();
        DvdRecord recordToBeEdited = dvdRecords.get(dvdId);
        DvdRecord newRecord = this.setFields (fieldToBeEdited,recordToBeEdited,newInput);
        writeRoster();
        return newRecord;

    }

    @Override
    //gets all dvd objects out of dvd map as a collection by calling values method
    //Array list takes collection of dvd objects(dvdRecords.values()) as param
    //We can return ArrayList here because it implements List interface
    public List<DvdRecord> getAllDvdRecords() throws DvdLibraryDaoException {
        loadRoster();
        return new ArrayList<DvdRecord>(dvdRecords.values());
    }

    @Override
    public List<DvdRecord> getDvdByTitle(String dvdTitle) throws DvdLibraryDaoException {
        loadRoster();
        List<DvdRecord> searchResults = new ArrayList<DvdRecord>();
        for (DvdRecord record : dvdRecords.values()) {
            if (record.getTitle().contains(dvdTitle)) {
                searchResults.add(record);
            };
        }
        return searchResults;
    }

    @Override
    public DvdRecord getDvdById(String dvdId) throws DvdLibraryDaoException {
        loadRoster();
        return dvdRecords.get(dvdId);
    }

    @Override
    public DvdRecord removeDvdRecord(String dvdId) throws DvdLibraryDaoException {
        loadRoster();
        DvdRecord recordToBeRemoved = dvdRecords.remove(dvdId);
        writeRoster();
        return  recordToBeRemoved;
    }

    private DvdRecord setFields (int fieldToBeEdited, DvdRecord recordToBeEdited, String newInput ){
        switch (fieldToBeEdited){
            case 1:
                recordToBeEdited.setTitle(newInput);
                break;
            case 2:
                recordToBeEdited.setReleaseDate(newInput);
                break;
            case 3:
                recordToBeEdited.setOfficialRating(newInput);
                break;
            case 4:
                recordToBeEdited.setDirectorName(newInput);
                break;
            case 5:
                recordToBeEdited.setStudio(newInput);
                break;
            case 6:
                recordToBeEdited.setUserRating(newInput);
                break;
        }

        return recordToBeEdited;
    }


//-------------------Data persistence METHODS FOR READING AND WRITING TO FILE----------------------------//

    //method that can translate a line of text into a dvd object.
    private DvdRecord unmarshallDvd (String dvdAsText){

        // Expected input: 1234::Ada::30-20-2015::18+::Ada Director::Studio1::Great Movie.
        //<id>::<title>::<releaseDate>::<OfficialRating>::<director>::<studio>::<userRating>
        String[] dvdTokens = dvdAsText.split(DELIMITER);//Array of split line

        // Given the pattern above, the dvd Id is in index 0 of the array.
        String dvdId = dvdTokens[0];

        // Which we can then use to create a new dvdRecord object to satisfy
        // the requirements of the dvdRecord constructor.
        DvdRecord dvdRecordFromFile = new DvdRecord(dvdId);

        //Manually set remaining fields
        dvdRecordFromFile.setTitle(dvdTokens[1]);//Title Index 1
        dvdRecordFromFile.setReleaseDate(dvdTokens[2]);//Releasedate Index 2
        dvdRecordFromFile.setOfficialRating(dvdTokens[3]);//OfficialRate Index3
        dvdRecordFromFile.setDirectorName(dvdTokens[4]);//director Index 4
        dvdRecordFromFile.setStudio(dvdTokens[5]);//studio Index 5
        dvdRecordFromFile.setUserRating(dvdTokens[6]);//user rate Index 6

        return dvdRecordFromFile;
    }

    //method that reads the roster file into memory.
    private void loadRoster() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        }
        //WE ARE TRANSLATING FILENOTFOUND TO OUR DAO EXCEPTION
        catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException (
                    "-_- Could not load DVD roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        DvdRecord currentDvd;
        // currentDVD holds the most recent dvdRecord unmarshalled

        // Go through ROSTER_FILE line by line, decoding each line into a
        // DvdRecord object by calling the unmarshallDvd method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a DvdRecord Object
            currentDvd = unmarshallDvd((currentLine)); //call unmarshall method to translate line
            // We are going to use the dvd id as the map key for our dvd object.
            // Put currentDvd into the map using DVD id as the key
            dvdRecords.put(currentDvd.getDvdId(), currentDvd);
        }
        // close scanner
        scanner.close();
    }

    //method that organizes the DVD information from in memory object to line of text
    //to write to file
    private String marshallDvd(DvdRecord aDvdRecord){
        //Target Output:
        //<id>::<title>::<releaseDate>::<OfficialRating>::<director>::<studio>::<userRating>

        // We will concatenate each property individually to our DELIMITER
        // Start with the DVD ID which is at first index.
        String dvdAsText = aDvdRecord.getDvdId() + DELIMITER;
        //Add remaining variables
        dvdAsText+=aDvdRecord.getTitle() + DELIMITER;
        dvdAsText+=aDvdRecord.getReleaseDate() + DELIMITER;
        dvdAsText+=aDvdRecord.getOfficialRating() + DELIMITER;
        dvdAsText+=aDvdRecord.getDirectorName() + DELIMITER;
        dvdAsText+=aDvdRecord.getStudio() + DELIMITER;
        dvdAsText+=aDvdRecord.getUserRating();//no delimiter herr
        // We have now turned a dvdrecord to text! Return it!
        return dvdAsText;
    }

    //method that writes the dvd information from memory to a file.
    private void writeRoster() throws DvdLibraryDaoException {
        //DvdLibExceptipon calling code handles io exception, we are only throwing it here

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {//we arent handling IO exception here
            throw new DvdLibraryDaoException(
                    "Could not save Dvd data.", e);
        }

        //here we will use this classes get all dvd method from dvdrecords.values()
        String dvdAsText;
        List<DvdRecord> dvdRecordList = this.getAllDvdRecords();
        for ( DvdRecord currentDvd : dvdRecordList) {
            // turn a dvd information  into a String
            dvdAsText = marshallDvd(currentDvd);
            // write the DVD object to the file
            out.println(dvdAsText);
            // force PrintWriter to doublecheck write line to the file
            out.flush();

        }
        // Clean up
        out.close();//close to avoid record leaks
    }


}


