package BackEnd;

public class RideRequest {
    private int requestID;
    private String username;
    private int eventID;
    private boolean isAccepted;
    private String pickupLocation;

    public RideRequest() {
    }

    public RideRequest(String username, int eventID, boolean isAccepted, String pickupLocation) {
        this.username = username;
        this.eventID = eventID;
        this.isAccepted = isAccepted;
        this.pickupLocation = pickupLocation;
    }

    public RideRequest(int requestID, String username, int eventID, boolean isAccepted, String pickupLocation) {
        this.requestID = requestID;
        this.username = username;
        this.eventID = eventID;
        this.isAccepted = isAccepted;
        this.pickupLocation = pickupLocation;
    }

    public int getRequestID() {
        return this.requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEventID() {
        return this.eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public boolean getIsAccepted() {
        return this.isAccepted;
    }

    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public String getPickupLocation() {
        return this.pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
}
