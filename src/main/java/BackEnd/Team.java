package BackEnd;


import java.util.Collection;

public class Team {
    private String name;
    private Collection<Player> players;
    private String pavilion;
    private int num_players;

    public Team() {
    }
    public Team(String name, Collection<Player> players, String pavilion, int num_players) {
        this.name = name;
        this.players = players;
        this.pavilion = pavilion;
        this.num_players = num_players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    public String getPavilion() {
        return pavilion;
    }

    public void setPavilion(String pavilion) {
        this.pavilion = pavilion;
    }

    public int getNum_players() {
        return num_players;
    }

    public void setNum_players(int num_players) {
        this.num_players = num_players;
    }
}
