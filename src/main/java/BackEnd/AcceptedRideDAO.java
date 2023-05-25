package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;


public class AcceptedRideDAO {
    // Database credentials
    private static final String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
    private static final String user = "IntelliJ";
    private static final String dbPassword = "vsc.DAI23";

    public static List<AcceptedRide> getAllAcceptedRides() {
        List<AcceptedRide> acceptedRides = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql = "SELECT * FROM AcceptedRides";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int rideID = rs.getInt("rideID");
                String requesterUsername = rs.getString("requesterUsername");
                String accepterUsername = rs.getString("accepterUsername");
                int eventID = rs.getInt("EventID");
                AcceptedRide acceptedRide = new AcceptedRide(rideID, requesterUsername, accepterUsername, eventID);
                acceptedRides.add(acceptedRide);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, stmt, rs);
        }

        return acceptedRides;
    }

    public static List<RideRequest> getUnacceptedRideRequestsByEvent(int eventID) {
        List<RideRequest> rideRequests = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql = "SELECT username, pickupLocation FROM RideRequests WHERE EventID = ? AND isAccepted = 0";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, eventID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String pickupLocation = rs.getString("pickupLocation");
                RideRequest rideRequest = new RideRequest(0, username, null, eventID, 0, false, pickupLocation);
                rideRequests.add(rideRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, stmt, rs);
        }

        return rideRequests;
    }


    public static boolean deleteAcceptedRideById(int rideID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql = "DELETE FROM AcceptedRides WHERE rideID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, rideID);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            close(conn, stmt, null);
        }
    }

    private static void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
