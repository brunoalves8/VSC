package BackEnd;

import java.util.Date;

public class RideRequest {
    private int requestID;
    private String username;
    private Date rideDate;
    private int eventID;
    private int requestedSeats;
    private boolean isAccepted;
    private String pickupLocation;

    public RideRequest() {
    }

    public RideRequest(int requestID, String username, Date rideDate, int eventID, int requestedSeats, boolean isAccepted, String pickupLocation) {
        this.requestID = requestID;
        this.username = username;
        this.rideDate = rideDate;
        this.eventID = eventID;
        this.requestedSeats = requestedSeats;
        this.isAccepted = isAccepted;
        this.pickupLocation = pickupLocation;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRideDate() {
        return rideDate;
    }

    public void setRideDate(Date rideDate) {
        this.rideDate = rideDate;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getRequestedSeats() {
        return requestedSeats;
    }

    public void setRequestedSeats(int requestedSeats) {
        this.requestedSeats = requestedSeats;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }
}
