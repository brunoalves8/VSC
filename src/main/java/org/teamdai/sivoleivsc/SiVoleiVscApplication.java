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
        final Console console = new Console();

        console.insertIntoDirector("Kiko5", "nuno","kiko3@gmail.com","1234");




    }


}
