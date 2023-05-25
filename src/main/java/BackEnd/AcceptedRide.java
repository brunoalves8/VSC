package BackEnd;
public class AcceptedRide {
    private int rideID;
    private String requesterUsername;
    private String accepterUsername;
    private int eventID;

    public AcceptedRide(int rideID, String requesterUsername, String accepterUsername, int eventID) {
        this.rideID = rideID;
        this.requesterUsername = requesterUsername;
        this.accepterUsername = accepterUsername;
        this.eventID = eventID;
    }

    // getters
    public int getRideID() { return this.rideID; }
    public String getRequesterUsername() { return this.requesterUsername; }
    public String getAccepterUsername() { return this.accepterUsername; }

    public int geteventID() { return this.eventID; }

    // setters
    public void setRideID(int rideID) { this.rideID = rideID; }
    public void setRequesterUsername(String requesterUsername) { this.requesterUsername = requesterUsername; }
    public void setAccepterUsername(String accepterUsername) { this.accepterUsername = accepterUsername; }

    public void seteventID(int rideID) { this.eventID = eventID; }
}