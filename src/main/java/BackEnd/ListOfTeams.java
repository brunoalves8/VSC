package BackEnd;

import java.util.Collection;
import java.util.HashSet;

public class ListOfTeams {

    private Collection<Team> listTeams;

    public ListOfTeams(){
        listTeams = new HashSet<>();
    }

    public void addTeam(Team team){
        listTeams.add(team);
    }

}
