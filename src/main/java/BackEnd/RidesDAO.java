package BackEnd;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class RidesDAO {

    // Insere um novo registro na tabela Rides
    public static boolean insertRide(Date rideDate, String eventID, int availableSeats, String username, boolean rideStatus) {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            String sql = "INSERT INTO [dbo].[Rides] ([RideDate], [EventID], [AvailableSeats], [Username], [RideStatus]) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(rideDate.getTime()));
            stmt.setString(2, eventID);
            stmt.setInt(3, availableSeats);
            stmt.setString(4, username);
            stmt.setBoolean(5, rideStatus);

            rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // Remove uma boleia pelo rideID
    public static boolean deleteRideByRideID(int rideID) {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            String sql = "DELETE FROM Rides WHERE RideID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, rideID);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    /*
    // Recupera todas as boleias
    public static List<Ride> getAllRides() {
        List<Ride> rides = new ArrayList<>();

        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            String sql = "SELECT RideID, RideDate, EventID, AvailableSeats, Username, RideStatus FROM Rides";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int rideID = rs.getInt("RideID");
                Date rideDate = rs.getDate("RideDate");
                String eventID = rs.getString("EventID");
                int availableSeats = rs.getInt("AvailableSeats");
                String username = rs.getString("Username");
                boolean rideStatus = rs.getBoolean("RideStatus");

                Ride ride = new Ride(rideDate, eventID, availableSeats, username, rideStatus);
                ride.setRideID(rideID);
                rides.add(ride);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return rides;
    }
*/

    // Lista as boleias para um determinado evento
    public static List<Ride> getRidesForEvent(String eventID) {
        List<Ride> rides = new ArrayList<>();

        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            String sql = "SELECT RideID, RideDate, EventID, AvailableSeats, Username, RideStatus FROM Rides WHERE EventID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, eventID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int rideID = rs.getInt("RideID");
                Date rideDate = rs.getDate("RideDate");
                String event_ID = rs.getString("EventID");
                int availableSeats = rs.getInt("AvailableSeats");
                String username = rs.getString("Username");
                boolean rideStatus = rs.getBoolean("RideStatus");

                Ride ride = new Ride(rideDate, event_ID, availableSeats, username, rideStatus);
                ride.setRideID(rideID);
                rides.add(ride);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return rides;
    }



    public static List<Ride> getAvailableRidesForEvent(String eventID) {
        List<Ride> rides = new ArrayList<>();

        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            String sql = "SELECT RideID, RideDate, EventID, AvailableSeats, Username, RideStatus FROM Rides WHERE AvailableSeats > 0 AND EventID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, eventID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int rideID = rs.getInt("RideID");
                Date rideDate = rs.getDate("RideDate");
                String event_ID = rs.getString("EventID");
                int availableSeats = rs.getInt("AvailableSeats");
                String username = rs.getString("Username");
                boolean rideStatus = rs.getBoolean("RideStatus");

                Ride ride = new Ride(rideDate, event_ID, availableSeats, username, rideStatus);
                ride.setRideID(rideID);
                rides.add(ride);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return rides;
    }





    // Pedir uma boleia (ou seja, aceitar a boleia)
    public static boolean takeRide(int rideID, String username) {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            String sql = "UPDATE Rides SET AvailableSeats = AvailableSeats - 1 WHERE RideID = ? AND AvailableSeats > 0";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, rideID);

            rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                stmt.close(); // Feche o primeiro PreparedStatement

                sql = "INSERT INTO UserRides (RideID, Username) VALUES (?, ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, rideID);
                stmt.setString(2, username);

                rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
