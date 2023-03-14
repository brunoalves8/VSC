package BackEnd;

public class Player extends User {
    private String name;
    private int age;
    private int height; //Em cm
    private double weight; //Em kg
    private String position; //No futuro, mudar o tipo, pois não faz sentido ser String
    private int shirtNumber;

    public Player() {
    }

    public Player(String username, String password, String email) {
        super(username, password, email);
    }

    public Player(String username, String password, String email, String name, int age, int height, double weight, String position, int shirtNumber) {
        super(username, password, email);
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.shirtNumber = shirtNumber;
    }
}
