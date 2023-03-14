package BackEnd;

import java.time.LocalDate;

public class Coach extends User {

    private String name;
    private LocalDate birthDate;
    private Team team;

    //Constructores
    public Coach() {
    }

    public Coach(String username, String password, String email) {
        super(username, password, email);
    }

    public Coach(String name, LocalDate birthDate, Team team) {
        this.name = name;
        this.birthDate = birthDate;
        this.team = team;
    }

    public Coach(String username, String password, String email, String name, LocalDate birthDate, Team team) {
        super(username, password, email);
        this.name = name;
        this.birthDate = birthDate;
        this.team = team;
    }

    //Methods
}
