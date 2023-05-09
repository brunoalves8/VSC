package BackEnd;

public class Director extends User{

    //Constructors
    public Director() {
    }
    public Director(String username, String password, String email) {
        super(username, password, email);
    }


    public Director(String username) {
        super(username);
    }
}
