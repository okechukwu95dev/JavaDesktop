package com.sg.dvdlibrary.dto;

/**
 * DvdRecord class with get and set methods for data transfer
 * Holds all DVD information
 * */

public class DvdRecord {

    //MEMBER VARIABLES/ FIELDS
    private String title;
    private String dvdId;//use this value to keep track
    private String releaseDate;
    private String officialRating;//MPAA
    private String directorName;
    private String studio;
    private String userRating;

    /**
     *
     * dvdId is a read only field
     * There is no setter, only a get method
     * It is passed in as a param to constructor
     * All other fields are set manually
     *
     * */

    //CONSTRUCTOR
    public DvdRecord (String dvdId ){
        this.dvdId = dvdId;
    }

    public String getDvdId() {
        return dvdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOfficialRating() {
        return officialRating;
    }

    public void setOfficialRating(String officialRating) {
        this.officialRating = officialRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
}
