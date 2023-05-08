package BackEnd;
import java.sql.*;
public class AuthenticateUser {
    public static boolean authenticate(String username, String password){
        // Conectar ao banco de dados
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Verificar se o username existe na primeira tabela
            String sql1 = "SELECT username FROM Players WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql1);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }

            // Verificar se o username existe na segunda tabela
            String sql2 = "SELECT username FROM Coach WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql2);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }

            // Verificar se o username existe na terceira tabela
            String sql3 = "SELECT username FROM Scouter WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql3);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }

            // Verificar se o username existe na quarta tabela
            String sql4 = "SELECT username FROM Director WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql4);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
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
