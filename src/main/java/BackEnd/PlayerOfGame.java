package BackEnd;

public class PlayerOfGame {

    private String name;
    private int shirt;
    private String timeID;

    public PlayerOfGame(String name, int shirt, String timeID) {
        this.name = name;
        this.shirt = shirt;
        this.timeID = timeID;
    }

    public String getName() {
        return name;
    }

    public int getShirt() {
        return shirt;
    }

    public String getTimeID() {
        return timeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShirt(int shirt) {
        this.shirt = shirt;
    }

    public void setTimeID(String timeID) {
        this.timeID = timeID;
    }
}
