public class HouseGPS {

    private double longitude;
    private double latitude;

    public HouseGPS (double longitude, double latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public double getLatitude(){
        return latitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public String getCoordinates (){
        return ("long: " + latitude + "lat: " + longitude);
    }
}
