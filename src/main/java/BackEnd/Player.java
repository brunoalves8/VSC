package BackEnd;

public class Player extends User{
    private String name;
    private int age;
    private int height; //Em cm
    private double weight; //Em kg
    private String position;
    private int shirtNumber;
    private boolean injured;
    private Team team;

    public Player(String username, String password, String email, String name, int age, int height, double weight,
                  String position, int shirtNumber, boolean injured, Team team) {
        super(username, password, email);
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.injured = injured;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
}
