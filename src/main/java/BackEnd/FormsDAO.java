package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;



public class FormsDAO {

    // Insere um novo registro na tabela forms
    public static boolean insertForm(String link, String name, java.util.Date endDate) {
        // Conectar ao banco de dados
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Preparar a instrução SQL para inserir um novo registro
            String sql = "INSERT INTO [dbo].[Forms] ([link], [name], [end_date]) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, link);
            stmt.setString(2, name);
            stmt.setDate(3, new java.sql.Date (endDate.getTime()));

            // Executar a instrução SQL para inserir o registro
            rowsAffected = stmt.executeUpdate();

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

    public static boolean deleteFormByLink(String link) {
        // Conectar ao banco de dados
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Preparar a instrução SQL para excluir um registro pelo link
            String sql = "DELETE FROM forms WHERE link = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, link);

            // Executar a instrução SQL para excluir o registro
            int rowsAffected = stmt.executeUpdate();

            // Verificar se a exclusão foi bem sucedida
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
        // Lista de todos os forms - Para o treinador

    public static List<Form> getAllForms() {
        List<Form> forms = new ArrayList<>();

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
            String sql = "SELECT link, name, end_date FROM forms";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Ler os resultados da consulta e criar objetos Form correspondentes
            while (rs.next()) {
                String link = rs.getString("link");
                String name = rs.getString("name");
                Date endDate = rs.getDate("end_date");
                Form form = new Form(link, name, endDate);
                forms.add(form);
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

        return forms;
    }

        // Para os jogadores- Mostra apenas os forms que ainda estão disponíveis

    public static List<Form> getCurrentForms()
    {
        List<Form> forms = new ArrayList<>();

        // Conectar ao banco de dados
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String user = "IntelliJ";
        String dbPassword = "vsc.DAI23";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);

            // Fazer uma consulta ao banco de dados para obter os forms com data futura
            String sql = "SELECT * FROM forms WHERE end_date >= ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            rs = stmt.executeQuery();

            // Adicionar cada form à lista de forms
            while (rs.next()) {
                String link = rs.getString("link");
                String name = rs.getString("name");
                Date endDate = rs.getDate("end_date");
                Form form = new Form(link, name, endDate);
                forms.add(form);
            }
        } catch (Exception e) {
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

        return forms;
    }



}
