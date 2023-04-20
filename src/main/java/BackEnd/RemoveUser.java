package BackEnd;

import java.sql.*;

public class RemoveUser {

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




}
