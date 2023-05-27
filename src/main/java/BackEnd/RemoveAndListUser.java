package BackEnd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RemoveAndListUser {

    public static boolean removeUser(String username){
        // Conectar ao banco de dados
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            String sql1 = "DELETE FROM Players WHERE username = ?";
            stmt = conn.prepareStatement(sql1);
            stmt.setString(1, username);
            int rowsAffectedPlayers = stmt.executeUpdate();
            if (rowsAffectedPlayers > 0) {
                return true;
            }

            String sql2 = "DELETE FROM Coach WHERE username = ?";
            stmt = conn.prepareStatement(sql2);
            stmt.setString(1, username);
            int rowsAffectedCoach = stmt.executeUpdate();
            if (rowsAffectedCoach > 0) {
                return true;
            }

            String sql3 = "DELETE FROM Scouter WHERE username = ?";
            stmt = conn.prepareStatement(sql3);
            stmt.setString(1, username);
            int rowsAffectedScouter = stmt.executeUpdate();
            if (rowsAffectedScouter > 0) {
                return true;
            }

            return false;

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

    public static List<String> listAllUsers(){
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<String> users = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();

            String sql1 = "SELECT username FROM Players";
            rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                users.add(rs.getString("username"));
            }

            String sql2 = "SELECT username FROM Coach";
            rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                users.add(rs.getString("username"));
            }

            String sql3 = "SELECT username FROM Scouter";
            rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                users.add(rs.getString("username"));
            }

            return users;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
}
