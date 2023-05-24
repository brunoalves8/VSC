package BackEnd;

import java.sql.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class RegisterGame {
    private String team1;
    private String team2;
    private Collection<Appearances> playersTeam1 = new HashSet<>();
    private Collection<Appearances> playersTeam2 = new HashSet<>();


    public RegisterGame(String team1, String team2, Collection<Appearances> playersTeam1, Collection<Appearances> playersTeam2) {
        this.team1 = team1;
        this.team2 = team2;
        this.playersTeam1 = playersTeam1;
        this.playersTeam2 = playersTeam2;
    }

    public RegisterGame() {

    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public Collection<Appearances> getPlayersTeam1() {
        return playersTeam1;
    }

    public Collection<Appearances> getPlayersTeam2() {
        return playersTeam2;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setPlayersTeam1(Collection<Appearances> playersTeam1) {
        this.playersTeam1 = playersTeam1;
    }

    public void setPlayersTeam2(Collection<Appearances> playersTeam2) {
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


    public static boolean registerGame(String team1, String team2, Collection<Appearances> playersTeam1, Collection<Appearances> playersTeam2) {
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        LocalDate todayDate = LocalDate.now();

        int rowsAffected = 0;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            String sql3 = "SELECT pavilion FROM [dbo].[Teams] WHERE team_id = ?";
                stmt = conn.prepareStatement(sql3);
                stmt.setString(1, team1);
                rs = stmt.executeQuery();
            String pavilion = null;
            if(rs.next()) {
                    pavilion = rs.getString("pavilion");
                }

            // Inserir Equipas
            String sql2 = "INSERT INTO [dbo].[Game] ([home_team_id],[away_team_id],[pavilion],[game_date]) VALUES (?,?,?,?)";
                stmt = conn.prepareStatement(sql2);
                stmt.setString(1, team1);
                stmt.setString(2, team2);
                stmt.setString(3, pavilion );
                stmt.setDate(4, java.sql.Date.valueOf(todayDate));
                rowsAffected += stmt.executeUpdate();


            String sql4 = "SELECT code_match FROM [dbo].[Game] WHERE home_team_id = ? AND away_team_id = ? AND CAST([game_date] AS date) = ?";
            stmt = conn.prepareStatement(sql4);
            stmt.setString(1, team1);
            stmt.setString(2, team2);
            stmt.setDate(3,java.sql.Date.valueOf(todayDate));
            rs1 = stmt.executeQuery();
            int code_match = 0;
            if(rs1.next()) {
                code_match = rs1.getInt("code_match");
            }


            // Inserir Jogadores Da Team1
            String sql = "INSERT INTO [dbo].[Appearances] ([name],[teamID],[shirt],[match_id]) VALUES (?, ?, ?, ?)";
            for(Appearances player: playersTeam1 ) {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, player.getName());
                stmt.setString(2, team1);
                stmt.setInt(3, player.getShirt());
                stmt.setInt(4, code_match);
                rowsAffected += stmt.executeUpdate();
            }
            // Inserir Jogadores Da Team2
            for(Appearances player: playersTeam2 ) {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, player.getName());
                stmt.setString(2, team2);
                stmt.setInt(3, player.getShirt());
                stmt.setInt(4, code_match);
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
