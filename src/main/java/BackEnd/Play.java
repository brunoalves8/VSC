package BackEnd;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Play {

    private String tipoJogada;
    private String equipe;
    private String jogador;
    private int numeroJogadora;
    private int set;
    private String time;
    private String code;

    public static int match_code;

    public Play() {
    }

    public String getTipoJogada() {
        return tipoJogada;
    }
    public void setTipoJogada(String tipoJogada) {
        this.tipoJogada = tipoJogada;
    }
    public String getEquipe() {
        return equipe;
    }
    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
    public String getJogador() {
        return jogador;
    }
    public void setJogador(String jogador) {
        this.jogador = jogador;
    }
    public int getNumeroJogadora() {
        return numeroJogadora;
    }
    public void setNumeroJogadora(int numeroJogadora) {
        this.numeroJogadora = numeroJogadora;
    }
    public int getSet() {
        return set;
    }
    public void setSet(int set) {
        this.set = set;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public static int getMatch_code() {
        return match_code;
    }
    public static void setMatch_code(int match_code) {
        Play.match_code = match_code;
    }

    public static boolean insertPlay(Play play) {
        String typeOfPlay = play.getTipoJogada();
        String code = play.getCode();
        String team = play.getEquipe();
        String player = play.getJogador();
        int shirtNumber = play.getNumeroJogadora();
        int set = play.getSet();
        String time = play.getTime();
        int match_code = RegisterGame.match_code;

        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Fazer uma consulta ao banco de dados para verificar se as credenciais do usuário
            String sql = "INSERT INTO [dbo].[Plays] ([type_of_play],[code],[team_id], [player], [player_shirt_number]," +
                    " [set_id], [time_Of_Play], [match_code]) VALUES ( ? , ? , ? , ? , ? , ?, ? , ? )";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, typeOfPlay);
            stmt.setString(2, code);
            stmt.setString(3, team);
            stmt.setString(4, player);
            stmt.setInt(5, shirtNumber);
            stmt.setInt(6, set);
            stmt.setString(7, time);
            stmt.setInt(8, match_code);


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

    /*public static Iterable<Play> getPlays() {

        List<Play> plays = new ArrayList<>();
        int match_code = RegisterGame.match_code;

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
            String sql = "SELECT nameOfEvent, hourOfStart, hourOfFinish, dayOfEvent FROM Events";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Ler os resultados da consulta e criar objetos Form correspondentes
            while (rs.next()) {
                String name = rs.getString("nameOfEvent");
                LocalTime start = rs.getTime("hourOfStart").toLocalTime();
                LocalTime finish = rs.getTime("hourOfFinish").toLocalTime();
                LocalDate date = rs.getDate("dayOfEvent").toLocalDate();
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

    }*/


}
