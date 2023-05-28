package BackEnd;

import org.springframework.http.ResponseEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RideRequest {
    private int requestID;
    private String username;
    private String driverUsername;
    private String nameEvent;
    private Date rideDate;
    private int eventID;
    private int requestedSeats;
    private boolean isAccepted;
    private String pickupLocation;

    public RideRequest(int i, String username, int eventID, boolean isAccepted, String pickupLocation) {
    }

    public RideRequest(int requestID, String username, String driverUsername, int eventID, boolean isAccepted, String pickupLocation) {
        this.requestID = requestID;
        this.username = username;
        this.driverUsername = driverUsername;
        this.eventID = eventID;
        this.isAccepted = isAccepted;
        this.pickupLocation = pickupLocation;
    }

    public RideRequest(String username, String driverUsername, int eventID, boolean isAccepted, String pickupLocation) {
        this.username = username;
        this.driverUsername = driverUsername;
        this.eventID = eventID;
        this.isAccepted = isAccepted;
        this.pickupLocation = pickupLocation;
    }


    public RideRequest(int requestID, String username, String driverUsername, Date rideDate, int eventID, int requestedSeats, boolean isAccepted, String pickupLocation) {
        this.requestID = requestID;
        this.username = username;
        this.driverUsername = driverUsername;
        this.rideDate = rideDate;
        this.eventID = eventID;
        this.requestedSeats = requestedSeats;
        this.isAccepted = isAccepted;
        this.pickupLocation = pickupLocation;
    }

    public RideRequest(String username, int eventID, boolean b, String pickupLocation) {
    }

    public RideRequest() {

    }

    public void setDriverUsername(String driverUsername) {
        this.driverUsername = driverUsername;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
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

    public String getDriverUsername() {
        return driverUsername;
    }

    public void setRiderUsername(String driverUsername) {
        this.driverUsername = driverUsername;
    }

    private static final String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
    private static final String user = "IntelliJ";
    private static final String dbPassword = "vsc.DAI23";

    public static int insertRideRequest(String username,String driverUsername, int eventID, boolean isAccepted, String pickupLocation) throws SQLException {
        String sql = "INSERT INTO RideRequests (username,driverUsername,Username, EventID, isAccepted, pickupLocation) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, username);
            stmt.setString(2, driverUsername);
            stmt.setInt(3, eventID);
            stmt.setBoolean(4, isAccepted);
            stmt.setString(5, pickupLocation);

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
                String driverUsername = rs.getString("driverUsername");
                int eventID = rs.getInt("EventID");
                boolean isAccepted = rs.getBoolean("isAccepted");
                String pickupLocation = rs.getString("pickupLocation");
                RideRequest rideRequest = new RideRequest(requestID, username,driverUsername, eventID, isAccepted, pickupLocation);
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
                String driverUsername = rs.getString("driverUsername");
                int requestedSeats = rs.getInt("requestedSeats");
                boolean isAccepted = rs.getBoolean("isAccepted");
                String pickupLocation = rs.getString("pickupLocation");
                RideRequest rideRequest = new RideRequest(requestID, username,driverUsername, requestedSeats, isAccepted, pickupLocation);
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

    public static List<Event> listAllEventsToAskRide() {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Event> eventsToAskRide = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();

            String sql1 = "SELECT nameOfEvent FROM Events";
            rs = stmt.executeQuery(sql1);

            while (rs.next()) {
                Event eventObj = new Event(rs.getString("nameOfEvent"));
                eventsToAskRide.add(eventObj);
            }

            return eventsToAskRide;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // Close the ResultSet, the Statement and the Connection
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
    }

    public boolean insertDataOfRequest(int EventID, String username, String pickupLocation, String nameEvent){
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Inserir os dados na tabela RideRequest
            String insertQuery = "INSERT INTO RideRequests (EventID, pickupLocation, username, nameEvent) VALUES (?, ?, ?,?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, EventID);
            pstmt.setString(2, pickupLocation);
            pstmt.setString(3, username);
            pstmt.setString(4, nameEvent);
            pstmt.executeUpdate();

            // Exibir uma mensagem de sucesso ou redirecionar para outra página, se necessário
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            // Exibir uma mensagem de erro ou redirecionar para uma página de erro, se necessário
            return false;
        } finally {
            // Fechar a conexão com o banco de dados
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<RideRequest> findUsernameRideRequest(String username){
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<RideRequest> rideRequests = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Consultar a tabela RideRequest
            String selectQuery = "SELECT * FROM RideRequests WHERE  username=?";
            pstmt = conn.prepareStatement(selectQuery);
            pstmt.setString(1, username);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                RideRequest rideRequest = new RideRequest();
                rideRequest.setRequestID(rs.getInt("requestID"));
                rideRequest.setUsername(rs.getString("username"));
                rideRequest.setEventID(rs.getInt("eventID"));
                rideRequest.setPickupLocation(rs.getString("pickupLocation"));
                rideRequest.setIsAccepted(rs.getBoolean("isAccepted"));

                // Adicionar à lista
                rideRequests.add(rideRequest);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechar a conexão com o banco de dados
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Retornar a lista de RideRequests
        return rideRequests;
    }


    public void acceptRideRequest(int requestID, String driverUsername){
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Atualizar os campos isAccepted e driverUsername na tabela RideRequests
            String updateQuery = "UPDATE RideRequests SET isAccepted = 1, driverUsername = ? WHERE requestID = ?";
            pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, driverUsername);
            pstmt.setInt(2, requestID);
            pstmt.executeUpdate();

            System.out.println("Pedido de boleia aceito com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Não foi possível aceitar o pedido de boleia.");
        } finally {
            // Fechar a conexão com o banco de dados
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
