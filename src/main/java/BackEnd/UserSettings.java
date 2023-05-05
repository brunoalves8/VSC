package BackEnd;

import java.sql.*;
import java.util.Date;

public class UserSettings {

    public static Boolean verifyIfPlayerExists(String username) {
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

    public static boolean addInfoPlayer(String position, int height, int weight, int shirtNumber, Date birthDate) {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Fazer uma consulta ao banco de dados para verificar se as credenciais do usuário
            String sql = "INSERT INTO [dbo].[Players] ([position],[height], [weight],[shirtNumber],[birthDate]) " +
                    "VALUES ( ? , ? , ? , ? , ? , ? )";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, position);
            stmt.setInt(2, height);
            stmt.setInt(3, weight);
            stmt.setInt(4, shirtNumber);
            stmt.setDate(5, (java.sql.Date) birthDate);
            rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                //Se a inserção dos dados for bem sucedida devolve true
                return true;
            } else {
                //se a inserção dos dados nao for bem sucedida devolve false
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
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

    public static boolean changePassword(String position, int height, int weight, int shirtNumber, Date birthDate) {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Fazer uma consulta ao banco de dados para verificar se as credenciais do usuário
            String sql = "INSERT INTO [dbo].[Players] ([position],[height], [weight],[shirtNumber],[birthDate]) " +
                    "VALUES ( ? , ? , ? , ? , ? , ? )";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, position);
            stmt.setInt(2, height);
            stmt.setInt(3, weight);
            stmt.setInt(4, shirtNumber);
            stmt.setDate(5, (java.sql.Date) birthDate);
            rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                //Se a inserção dos dados for bem sucedida devolve true
                return true;
            } else {
                //se a inserção dos dados nao for bem sucedida devolve false
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
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
