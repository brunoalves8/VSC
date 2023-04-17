package BackEnd;

import java.util.Collection;
import java.util.HashMap;


public class ListOfUsers {

    private static HashMap<String, User> listUsers;


    public ListOfUsers() {
        listUsers = new HashMap<>();
    }

    public static String verifyIfUserExists(String username) {
        for (User u : listUsers.values()) {
            if (u.getUsername().equals(username)) {
                return "Encontrou";
            }
        }
        return "Não encontrou";
    }

    public static void addUser(User user){
        listUsers.put(user.getUsername(), user);
    }
    public void removeUser(String username) {
        listUsers.remove(username);
    }

   /* public static String authenticateUsername(String username) {
        for (User u : listUsers.values()) {
            if (username.equals(u.getUsername())) {
                return u.getUsername();
            }
        }
        return "a";
    }*/


   /* public String registerUser(String username, String password, String email) {

        if (listUsers.containsKey(username)) {

            return "Já existe um usuário com esse username";

        } else if (userDao.isValidEmail(email) == false) {

            return "Não existe nenhum email atribuido com esse nome";

        }
        User newUser = new User(username, password, email);
        listUsers.put(username, newUser);
        return "";
    }
// no frontend temos que criar uma instancia tipo utilizador logado, depois o que passa por referencia para o metodo
    // é o username desse mesmo utilizador
/*
    public String showUserProfile(String username) {
        for (User u : listUsers.values()) {
            if (username.getClass() instanceof Coach) {
                íf(u.getUsername().equals(username)) {
                    .
                }
            }
            if ()
        }


    }

    */
}









