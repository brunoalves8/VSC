package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FormsDAO {

    // Insere um novo registro na tabela forms
    public static boolean insertForm(String link, String name, String endDate) {
        // Conectar ao banco de dados
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Preparar a instrução SQL para inserir um novo registro
            String sql = "INSERT INTO forms (link, name, end_date) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, link);
            stmt.setString(2, name);
            stmt.setString(3, endDate);

            // Executar a instrução SQL para inserir o registro
            int rowsAffected = stmt.executeUpdate();

            // Verificar se a inserção foi bem sucedida
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
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
