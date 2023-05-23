package BackEnd;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;

public class RegisterInfoGameVideo {
    private String team1;
    private String team2;
    private Collection<PlayerOfGame> playersTeam1 = new HashSet<>();
    private Collection<PlayerOfGame> playersTeam2 = new HashSet<>();


    public RegisterInfoGameVideo(String team1, String team2, Collection<PlayerOfGame> playersTeam1, Collection<PlayerOfGame> playersTeam2) {
        this.team1 = team1;
        this.team2 = team2;
        this.playersTeam1 = playersTeam1;
        this.playersTeam2 = playersTeam2;
    }

    public RegisterInfoGameVideo() {

    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public Collection<PlayerOfGame> getPlayersTeam1() {
        return playersTeam1;
    }

    public Collection<PlayerOfGame> getPlayersTeam2() {
        return playersTeam2;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setPlayersTeam1(Collection<PlayerOfGame> playersTeam1) {
        this.playersTeam1 = playersTeam1;
    }

    public void setPlayersTeam2(Collection<PlayerOfGame> playersTeam2) {
        this.playersTeam2 = playersTeam2;
    }


    public static Boolean verifyIfTeamExists(String teamID) {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Verificar se a equipa existe
            String sql1 = "SELECT team_id FROM Teams WHERE team_id = ?";
            stmt = conn.prepareStatement(sql1);
            stmt.setString(1, teamID);
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

    public static boolean registerInfoGameVideo(String team1, String team2, Collection<PlayerOfGame> playersTeam1, Collection<PlayerOfGame> playersTeam2) {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Inserir Equipas
            String sql2 = "INSERT INTO [dbo].[InfoGameVideo] ([team1],[team2]) VALUES (?, ?)";
                stmt = conn.prepareStatement(sql2);
                stmt.setString(1, team1);
                stmt.setString(2, team2);
                rowsAffected += stmt.executeUpdate();



            // Inserir Jogadores Da Team1
            String sql = "INSERT INTO [dbo].[PlayersOfGame] ([name],[teamID],[shirt]) VALUES (?, ?, ?)";
            for(PlayerOfGame player: playersTeam1 ) {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, player.getName());
                stmt.setString(2, team1);
                stmt.setInt(3, player.getShirt());
                rowsAffected += stmt.executeUpdate();
            }
            // Inserir Jogadores Da Team2
            for(PlayerOfGame player: playersTeam2 ) {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, player.getName());
                stmt.setString(2, team2);
                stmt.setInt(3, player.getShirt());
                rowsAffected += stmt.executeUpdate();
            }

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
