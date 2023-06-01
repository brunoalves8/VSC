package BackEnd;
import java.sql.*;

public class RegisterPlayer {

    public String username;

    public String password;
    public String email;

    public String name;
    public int phoneNumber;


    public static Boolean verifyIfUserExists(String username) {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Verificar se o username existe na primeira tabela
            String sql1 = "SELECT username FROM Players WHERE username = ?";
            stmt = conn.prepareStatement(sql1);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }

            // Verificar se o username existe na segunda tabela
            String sql2 = "SELECT username FROM Coach WHERE username = ?";
            stmt = conn.prepareStatement(sql2);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }

            // Verificar se o username existe na terceira tabela
            String sql3 = "SELECT username FROM Scouter WHERE username = ?";
            stmt = conn.prepareStatement(sql3);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }

            // Verificar se o username existe na quarta tabela
            String sql4 = "SELECT username FROM Director WHERE username = ?";
            stmt = conn.prepareStatement(sql4);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return true;

        }finally {
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

    public static boolean registerPlayer(String name, String username, String email, int phoneNumber, String password) {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Fazer uma consulta ao banco de dados para verificar se as credenciais do usuário
            String sql = "INSERT INTO [dbo].[Players] ([name],[username], [password], [team_id],[phone_number],[email]) " +
                    "VALUES ( ? , ? , ? , ? , ? , ? )";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, "VSC");
            stmt.setInt(5, phoneNumber);
            stmt.setString(6, email);
            rowsAffected = stmt.executeUpdate();

            if(rowsAffected > 0){
                //Se a inserção dos dados for bem sucedida devolve true
                return true;
            }else{
                //se a inserção dos dados nao for bem sucedida devolve false
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            // Fechar o Statement e a Connection

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
