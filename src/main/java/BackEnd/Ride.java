package BackEnd;

import java.util.Date;

public class Ride {
    private int rideID;
    private Date rideDate;
    private String eventID;
    private int availableSeats;
    private String username;
    private boolean rideStatus;

    public Ride() {
    }

    public Ride(Date rideDate, String eventID, int availableSeats, String username, boolean rideStatus)
    {
        this.rideDate = rideDate;
        this.eventID = eventID;
        this.availableSeats = availableSeats;
        this.username = username;
        this.rideStatus = rideStatus;
    }

    public int getRideID() {
        return rideID;
    }

    public void setRideID(int rideID) {
        this.rideID = rideID;
    }

    public Date getRideDate() {
        return rideDate;
    }

    public void setRideDate(Date rideDate) {
        this.rideDate = rideDate;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(boolean rideStatus) {
        this.rideStatus = rideStatus;
    }
}
