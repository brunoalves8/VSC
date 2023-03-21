package BackEnd;

import java.util.Collection;
import java.util.HashMap;
import BackEnd.UserDao;

public class ListOfUsers {

    private final HashMap<String, User> listUsers;
    private UserDao userDao;

    public ListOfUsers(){
        listUsers= new HashMap<String, User>();

    }

    public boolean verifyuserexists(String username) {
        for (User u : listUsers.values()) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    public void removeUser(String username){
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

    public void registerUser(String username, String password, String email) {

        if (listUsers.containsKey(username)) { // containskey é boolean
            // usuário já existe
            System.exit(0); // só para testar
        }

        User newUser = new User(username, password, email);
        listUsers.put(username, newUser);
    }



}













