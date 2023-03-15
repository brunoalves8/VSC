package BackEnd;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Team {
    private String name;
    private Collection<Player> players = new HashSet<>();

    private Collection<Match> playedMatches = new HashSet<>();
    private String pavilion;
    private int num_players;



    public Team() {
    }
    public Team(String name, Collection<Player> players,String pavilion, int num_players) {
        this.name = name;
        this.pavilion = pavilion;
        this.num_players = num_players;
        this.players = players;
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

    public Collection<Match> getPlayedMatches() {
        return playedMatches;
    }

    public void setPlayedMatches(Collection<Match> playedMatches) {
        this.playedMatches = playedMatches;
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


    //Methods

    public void addPlayedMatch(Match match){
        playedMatches.add(match);
    }

}
