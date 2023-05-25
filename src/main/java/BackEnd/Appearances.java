package BackEnd;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Appearances {
    @JsonProperty("name")
    private String name;
    @JsonProperty("shirt")
    private int shirt;
    @JsonProperty("teamID")
    private String teamID;
    private int match_id;

    public Appearances(String name, int shirt, String teamID) {
        this.name = name;
        this.shirt = shirt;
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }

    public int getShirt() {
        return shirt;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShirt(int shirt) {
        this.shirt = shirt;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public int getMatch_id() {
        return match_id;
    }
    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }
}
