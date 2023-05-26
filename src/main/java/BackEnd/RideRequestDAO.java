package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class RideRequestDAO {

    // Database credentials
    private static final String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
    private static final String user = "IntelliJ";
    private static final String dbPassword = "vsc.DAI23";

    public static boolean insertRideRequest(String username, Date rideDate, int eventID, int requestedSeats, boolean isAccepted, String pickupLocation) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql = "INSERT INTO RideRequests (username, rideDate, EventID, requestedSeats, isAccepted, pickupLocation) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setDate(2, new java.sql.Date (rideDate.getTime()));
            stmt.setInt(3, eventID);
            stmt.setInt(4, requestedSeats);
            stmt.setBoolean(5, isAccepted);
            stmt.setString(6, pickupLocation);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            close(conn, stmt, null);
        }
    }

    public static List<RideRequest> getAllRideRequests() {
        List<RideRequest> rideRequests = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql = "SELECT * FROM RideRequests";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int requestID = rs.getInt("requestID");
                String username = rs.getString("username");
                Date rideDate = rs.getDate("rideDate");
                int eventID = rs.getInt("EventID");
                int requestedSeats = rs.getInt("requestedSeats");
                boolean isAccepted = rs.getBoolean("isAccepted");
                String pickupLocation = rs.getString("pickupLocation");
                RideRequest rideRequest = new RideRequest(requestID, username, rideDate, eventID, requestedSeats, isAccepted, pickupLocation);
                rideRequests.add(rideRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, stmt, rs);
        }

        return rideRequests;
    }

    public static List<RideRequest> getUnacceptedRideRequestsByEvent(int eventID) {
        List<RideRequest> rideRequests = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql = "SELECT * FROM RideRequests WHERE isAccepted = 0 AND EventID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, eventID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int requestID = rs.getInt("requestID");
                String username = rs.getString("username");
                Date rideDate = rs.getDate("rideDate");
                int requestedSeats = rs.getInt("requestedSeats");
                boolean isAccepted = rs.getBoolean("isAccepted");
                String pickupLocation = rs.getString("pickupLocation");
                RideRequest rideRequest = new RideRequest(requestID, username, rideDate, eventID, requestedSeats, isAccepted, pickupLocation);
                rideRequests.add(rideRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, stmt, rs);
        }

        return rideRequests;
    }


    public static boolean deleteRideRequestById(int requestID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql = "DELETE FROM RideRequests WHERE requestID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, requestID);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            close(conn, stmt, null);
        }
    }


    public static List<RideRequest> getUnacceptedRideRequests() {
        List<RideRequest> rideRequests = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql = "SELECT * FROM RideRequests WHERE isAccepted = 0";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int requestID = rs.getInt("requestID");
                String username = rs.getString("username");
                Date rideDate = rs.getDate("rideDate");
                int eventID = rs.getInt("EventID");
                int requestedSeats = rs.getInt("requestedSeats");
                boolean isAccepted = rs.getBoolean("isAccepted");
                String pickupLocation = rs.getString("pickupLocation");
                RideRequest rideRequest = new RideRequest(requestID, username, rideDate, eventID, requestedSeats, isAccepted, pickupLocation);
                rideRequests.add(rideRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, stmt, rs);
        }

        return rideRequests;
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
