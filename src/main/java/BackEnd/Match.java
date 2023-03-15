package BackEnd;

import java.time.LocalDate;
import java.util.Collection;

public class Match {
    private int codeMatch;
    private LocalDate gameDate;
    private Team homeTeam;
    private Team awayTeam;
    private String pavilion;
    private Collection<Set> sets;
    private Collection<Play> plays;
    private Collection<Player> draftedPlayers;

    public Match(int codeMatch, LocalDate gameDate, Team homeTeam, Team awayTeam, String pavilion, Collection<Set> sets,
                 Collection<Play> plays, Collection<Player> draftedPlayers) {
        this.codeMatch = codeMatch;
        this.gameDate = gameDate;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.pavilion = pavilion;
        this.sets = sets;
        this.plays = plays;
        this.draftedPlayers = draftedPlayers;
    }

    public int getCodeMatch() {
        return codeMatch;
    }

    public void setCodeMatch(int codeMatch) {
        this.codeMatch = codeMatch;
    }

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getPavilion() {
        return pavilion;
    }

    public void setPavilion(String pavilion) {
        this.pavilion = pavilion;
    }

    public Collection<Set> getSets() {
        return sets;
    }

    public void setSets(Collection<Set> sets) {
        this.sets = sets;
    }

    public Collection<Play> getPlays() {
        return plays;
    }

    public void setPlays(Collection<Play> plays) {
        this.plays = plays;
    }

    public Collection<Player> getDraftedPlayers() {
        return draftedPlayers;
    }

    public void setDraftedPlayers(Collection<Player> draftedPlayers) {
        this.draftedPlayers = draftedPlayers;
    }

    // Methods

    public void addSetToMatch(Set set){
        sets.add(set);
    }







































}
