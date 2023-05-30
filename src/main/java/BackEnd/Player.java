package BackEnd;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class Player extends User{
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private int height; //Em cm
    private double weight; //Em kg
    private String position;
    private int shirtNumber;
    private boolean injured;
    private Team team;
    private int phoneNumber;

    public Player(){

    }

    public Player(String username, int shirtNumber,String name) {
        this.name = name;
        this.shirtNumber = shirtNumber;
        this.setUsername(username);
    }

    public Player(String username) {
        super(username);
    }

    public Player(String username, String password, String email, String name, Date birth, int height, double weight,
                  String position, int shirtNumber, boolean injured, Team team, int phoneNumber) {
        super(username, password, email);
        this.name = name;

        this.birthDate = birth;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.injured = injured;
        this.team = team;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birth) {
        this.birthDate = birth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public boolean isInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
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

    public static double calculateBMI(double weight, double height) {
        double heightMeters = height / 100; // converter para metros
        double bmi = weight / (heightMeters * heightMeters);
        return bmi;
    }

    public String getUser(){
        String user= super.getUsername();
        return user;
    }
}
