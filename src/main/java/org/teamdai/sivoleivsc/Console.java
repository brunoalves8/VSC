package org.teamdai.sivoleivsc;

import org.springframework.boot.SpringApplication;

import java.sql.*;
import java.util.Scanner;

public class Console {

    private final Scanner scan = new Scanner(System.in);


    public void insertIntoDirector(String us, String pass, String em, String team ){
        // Defina os detalhes da conexão com o banco de dados
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String username = "IntelliJ";
        String password = "vsc.DAI23";



        // Crie a conexão com o banco de dados
        try (Connection conexao = DriverManager.getConnection(url, username, password)) {

            // Crie uma instrução SQL para inserir dados na tabela "minha_tabela"

            String sql = "INSERT INTO Director (username, password,email,team_id) VALUES (?,?,?,?)";
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, us);
            pst.setString(2, pass);
            pst.setString(3, em);
            pst.setString(4, team);

            pst.executeUpdate();
            // Crie um objeto Statement para executar a instrução SQL
            try (Statement stmt = conexao.createStatement()) {

                // Execute a instrução SQL
                stmt.executeUpdate(sql);

                // Exiba uma mensagem informando que os dados foram inseridos com sucesso
                System.out.println("Os dados foram inseridos com sucesso na tabela.");

            } catch (SQLException ex) {
                // Trate a exceção
                ex.printStackTrace();
            }

        } catch (SQLException ex) {
            // Trate a exceção
            ex.printStackTrace();
        }
    }

    /*public static void lerDadosTabela() {

        // Defina os detalhes da conexão com o banco de dados
        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String username = "IntelliJ";
        String password = "vsc.DAI23";

        // Crie a conexão com o banco de dados
        try (Connection conexao = DriverManager.getConnection(url, username, password)) {

            // Crie uma instrução SQL para selecionar todos os dados da tabela "Director"
            String sql = "SELECT * FROM Director";

            // Crie um objeto Statement para executar a instrução SQL
            try (Statement stmt = conexao.createStatement()) {

                // Execute a instrução SQL e obtenha um ResultSet com os resultados
                ResultSet rs = stmt.executeQuery(sql);

                // Itere sobre o ResultSet e imprima os dados
                while (rs.next()) {
                    String usernames = rs.getString("username");
                    String passwords = rs.getString("password");
                    String emails = rs.getString("email");
                    String

                    System.out.println("Username: " + username + ", Password: " + password + ", Email: " + email);
                }

                // Feche o ResultSet
                rs.close();

            } catch (SQLException ex) {
                // Trate a exceção
                ex.printStackTrace();
            }

        } catch (SQLException ex) {
            // Trate a exceção
            ex.printStackTrace();
        }
    }*/

}
