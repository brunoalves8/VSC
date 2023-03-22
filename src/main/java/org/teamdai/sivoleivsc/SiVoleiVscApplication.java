package org.teamdai.sivoleivsc;

import BackEnd.ListOfUsers;
import BackEnd.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;


@SpringBootApplication
public class SiVoleiVscApplication {

    public static void main(String[] args) {

        SpringApplication.run(SiVoleiVscApplication.class, args);

       // Defina os detalhes da conexão com o banco de dados
        String url = "vsc23.database.windows.net";
        String username = "InteliiJ";
        String password = "vsc.DAI23";

        // Crie a conexão com o banco de dados
        try (Connection conexao = DriverManager.getConnection(url, username, password)) {

            // Crie uma instrução SQL para inserir dados na tabela "minha_tabela"
            String sql = "INSERT INTO Users (usernames, passwords,email) VALUES ('bruno', 'bruno','ba578731@gmail.com')";

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
