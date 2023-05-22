package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class RemoveEvent {

    public static boolean removeEvent(Event evento){
        String name = evento.getName();
        LocalTime start = evento.getStart();
        LocalTime finish = evento.getFinish();
        LocalDate date = evento.getDate();

        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;

        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Fazer uma consulta ao banco de dados para verificar se as credenciais do usuário
            String sql = "DELETE FROM [dbo].[Events] WHERE [nameOfEvent] = ? AND CAST([dayOfEvent] AS date) = ? ";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setDate(2, java.sql.Date.valueOf(date));


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
