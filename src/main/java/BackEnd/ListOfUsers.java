package BackEnd;

import java.util.Collection;
import java.util.HashMap;


public class ListOfUsers {

    private static HashMap<String, User> listUsers;
    private UserDao userDao;

    public ListOfUsers() {
        listUsers = new HashMap<String, User>();

    }

    public static String verifyIfUserExists(String username) {
        for (User u : listUsers.values()) {
            if (u.getUsername().equals(username)) {
                return "Encontrou";
            }
        }
        return "Não encontrou";
    }

    public void removeUser(String username) {
        listUsers.remove(username);
    }

    public boolean authenticate(String username, String passwd) {  // está a percorrer a hashmap , temos que relacionar com a BD//
        for (User u : listUsers.values()) {
            if (username.equals(u.getUsername()) && passwd.equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public String registerUser(String username, String password, String email) {

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

    public String showUserProfile(String username) {
        for (User u : listUsers.values()) {
            if (username.getClass() instanceof Coach) {
                íf(u.getUsername().equals(username)) {

                }
            }
            if ()
        }


    }
}









