package BackEnd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RemoveAndListUser {

    public static boolean removeUser(String username) {
        // Conectar ao banco de dados
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            int rowsAffected = 0;

            String sql1 = "DELETE FROM Players WHERE username = ?";
            stmt = conn.prepareStatement(sql1);
            stmt.setString(1, username);
            rowsAffected += stmt.executeUpdate();

            String sql2 = "DELETE FROM Coach WHERE username = ?";
            stmt = conn.prepareStatement(sql2);
            stmt.setString(1, username);
            rowsAffected += stmt.executeUpdate();

            String sql3 = "DELETE FROM Scouter WHERE username = ?";
            stmt = conn.prepareStatement(sql3);
            stmt.setString(1, username);
            rowsAffected += stmt.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // Fechar o ResultSet, o Statement e a Connection
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

    public static List<User> listAllUsers() {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();

            String sql1 = "SELECT username, password, email FROM Players";
            rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                User userObj = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"));
                users.add(userObj);
            }

            String sql2 = "SELECT username, password, email FROM Coach";
            rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                User userObj = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"));
                users.add(userObj);
            }

            String sql3 = "SELECT username, password, email FROM Scouter";
            rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                User userObj = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"));
                users.add(userObj);
            }

            return users;

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

    public static List<Player> listAllPlayers() {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Player> players = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();

            String sql1 = "SELECT username,name, shirt_number FROM Players";
            rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                Player userObj = new Player(rs.getString("username"), rs.getInt("shirt_number"),rs.getString("name"));
                players.add(userObj);
            }



            return players;

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
}
