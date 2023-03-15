package BackEnd;

import java.util.Collection;
import java.util.HashSet;

public class ListOfMatches {

    private Collection<Match> listMatches;

    public ListOfMatches(){
        listMatches = new HashSet<>();
    }

    public void addMatch(Match match){
        listMatches.add(match);
    }

    public void addMatchToTeam(Team team){
        for (Match match: listMatches){
            if(match.getHomeTeam().equals(team) || match.getAwayTeam().equals(team)){
                team.addPlayedMatch(match);
            }
        }
    }

}
