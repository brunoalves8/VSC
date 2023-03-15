package BackEnd;

import java.util.Collection;
import java.util.HashMap;

public class ListOfUsers {

    private HashMap<String, User> listUsers;

    public ListOfUsers(){
        listUsers = new HashMap<>();
    }

    public void addUser(User user){
        listUsers.put(user.getUsername(), user);
    }

    public void removeUser(String username){
        listUsers.remove(username);
    }




}
