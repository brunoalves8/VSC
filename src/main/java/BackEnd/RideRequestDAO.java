package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

public class RideRequestDAO {

    // Database credentials
    private static final String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
    private static final String user = "IntelliJ";
    private static final String dbPassword = "vsc.DAI23";

    public static int insertRideRequest(String username, int eventID, boolean isAccepted, String pickupLocation) throws SQLException {
        String sql = "INSERT INTO RideRequests (username, EventID, isAccepted, pickupLocation) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, username);
            stmt.setInt(2, eventID);
            stmt.setBoolean(3, isAccepted);
            stmt.setString(4, pickupLocation);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating ride request failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);  // retorna o ID gerado
                } else {
                    throw new SQLException("Creating ride request failed, no ID obtained.");
                }
            }
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
                int eventID = rs.getInt("EventID");
                boolean isAccepted = rs.getBoolean("isAccepted");
                String pickupLocation = rs.getString("pickupLocation");
                RideRequest rideRequest = new RideRequest(requestID, username, eventID, isAccepted, pickupLocation);
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
                int requestedSeats = rs.getInt("requestedSeats");
                boolean isAccepted = rs.getBoolean("isAccepted");
                String pickupLocation = rs.getString("pickupLocation");
                RideRequest rideRequest = new RideRequest(requestID, username, requestedSeats, isAccepted, pickupLocation);
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
