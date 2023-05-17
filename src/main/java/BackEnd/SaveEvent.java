package BackEnd;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class SaveEvent {

    public static boolean insertEvent(Event evento){
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
            String sql = "INSERT INTO [dbo].[Events] ([name],[start_hour], [finish_hour], [date]) " +
                    "VALUES ( ? , ? , ? , ? )";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setTime(2, java.sql.Time.valueOf(start));
            stmt.setTime(3, java.sql.Time.valueOf(finish));
            stmt.setObject(4, java.sql.Date.valueOf(date));


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

    public static List<Event> getAllEvents(){

        List<Event> events = new ArrayList<>();

        // Conectar ao banco de dados
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Fazer uma consulta ao banco de dados para buscar todos os registros
            String sql = "SELECT name, start_hour, finish_hour, date FROM Events";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Ler os resultados da consulta e criar objetos Form correspondentes
            while (rs.next()) {
                String name = rs.getString("name");
                LocalTime start = rs.getTime("start_hour").toLocalTime();
                LocalTime finish = rs.getTime("finish_hour").toLocalTime();
                LocalDate date = rs.getDate("date").toLocalDate();
                Event evento = new Event(name, start, finish, date);

                events.add(evento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        return events;

    }


}
