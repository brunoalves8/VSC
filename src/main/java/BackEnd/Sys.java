package BackEnd;

import java.io.Serializable;
import java.sql.*;

public class Sys implements Serializable {



    public boolean verifyIfExistDirector(String user, String pwd) {
        String query = "SELECT * FROM Director WHERE username=? AND password = ?";

        String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
        String username = "IntelliJ";
        String password = "vsc.DAI23";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pwd);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }

        return false;
    }

  /* public String consultDataOfDirector(String user, String pwd) {
       String query = "SELECT * FROM your_table WHERE username = ? AND password = ?";
       String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
       String username = "IntelliJ";
       String password = "vsc.DAI23";
       try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

           preparedStatement.setString(1, user);
           preparedStatement.setString(2, pwd);

           try (ResultSet resultSet = preparedStatement.executeQuery()) {
               while (resultSet.next()) {
                   // Substitua 'column1', 'column2', etc., pelos nomes das colunas da sua tabela
                   String column1 = resultSet.getString("username");
                   String column2 = resultSet.getString("password");
                   String column3 = resultSet.getString("email");
                   String column4 = resultSet.getString("team_id");
                   // ... adicione mais colunas conforme necessário

                   // Imprima os valores das colunas para cada linha retornada
                   System.out.printf("Username: %s\n Password: %s\n Email: %s\n Team ID: %s\n ", column1, column2);
               }
           }

       } catch (SQLException e) {
           System.out.println("Error connecting to the database: " + e.getMessage());
       }
       return ;
   }

   */

   }



