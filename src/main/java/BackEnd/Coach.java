package BackEnd;

import java.time.LocalDate;

public class Coach extends User {

    private String name;
    private LocalDate birthDate;
    private String type;
    private Team team;

    private int phoneNumber;

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

    public Coach(String username) {
        super(username);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
