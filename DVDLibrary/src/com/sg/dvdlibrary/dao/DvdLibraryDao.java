package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DvdRecord;

import java.util.List;

//This dao composes

public interface DvdLibraryDao {
    /**
     * Adds the given DVD title  to the roster and associates it with the given
     * DVDid. If there is already a DVD associated with the given
     * DVDid it will return that DVDRecord object, otherwise it will
     * return null.
     */
    DvdRecord addDvdRecord(String dvdId, DvdRecord record)throws DvdLibraryDaoException;

    /**
     * Returns a List of all DVD's  on the library.
     * @return Dvd List containing all DVDs on the roster.
     * @thros DvdLibraryDaoException
     */
    List<DvdRecord> getAllDvdRecords() throws DvdLibraryDaoException;

    /**
     * Returns the DVD object associated with the given  dvdId.
     * Returns null if no such DVD exists
     */
    DvdRecord getDvdById (String dvdId) throws DvdLibraryDaoException;

    /**
     * Returns the DVD object associated with the given tilte.
     * Returns null if no such DVD exists
     * @return
     */
    List<DvdRecord> getDvdByTitle (String dvdTitle) throws DvdLibraryDaoException;


    /**
     * Removes from the library the dvd associated with the given id.
     * Returns the dvdRecord object that is being removed or null if
     * there is no dvd associated with the given id
     *
     */
    DvdRecord removeDvdRecord(String dvdId) throws DvdLibraryDaoException;

    /**
     * Edits the selected field of the dvd associated with the given id.
     * Returns the dvdRecord object that has been edited or null if
     * there is no dvd associated with the given id
     *
     */
    DvdRecord editDvdRecord(String dvdId, int fieldToBeEdited, String newInput ) throws DvdLibraryDaoException;
}
