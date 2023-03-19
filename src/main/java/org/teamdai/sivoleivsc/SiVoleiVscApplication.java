package org.teamdai.sivoleivsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;


@SpringBootApplication
public class SiVoleiVscApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiVoleiVscApplication.class, args);

       // Defina os detalhes da conexão com o banco de dados
        String url = "jdbc:mysql://192.168.1.154:3306/vsc";
        String username = "root";
        String password = "password";

        // Crie a conexão com o banco de dados
        try (Connection conexao = DriverManager.getConnection(url, username, password)) {

            // Crie uma instrução SQL para inserir dados na tabela "minha_tabela"
            String sql = "INSERT INTO users (username, password,email) VALUES ('admin2', 'admin2','admin2@gmail.com')";

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


}
