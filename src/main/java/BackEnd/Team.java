package BackEnd;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Team {
    private String timeID;
    private String name;
    private String pavilion;
    private Collection<Player> players = new HashSet<>();
    private Collection<Match> playedMatches = new HashSet<>();





    public Team() {
    }
    public Team(String name, Collection<Player> players,String pavilion) {
        this.name = name;
        this.pavilion = pavilion;
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


    //Methods

    public void addPlayedMatch(Match match){
        playedMatches.add(match);
    }

}
