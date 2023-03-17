package org.teamdai.sivoleivsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



@SpringBootApplication
public class SiVoleiVscApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiVoleiVscApplication.class, args);

        try {

            String username = "admin";
            String password = "admin";
            String email = "jadmin@gmail.com";

            Connection conn = DriverManager.getConnection(username, password, email);

            // ... continue com as operações no banco de dados

            conn.close();
        } catch (SQLException e) {
            // trate a exceção
            e.printStackTrace();
        }
        System.out.println("Hello");
    }

}
