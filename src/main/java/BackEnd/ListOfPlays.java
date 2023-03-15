package BackEnd;

import java.util.Collection;
import java.util.HashSet;

public class ListOfPlays {

    private Collection<Play> plays;

    public ListOfPlays() {
        plays = new HashSet<>();
    }

    public void addPlay(Play play){
        plays.add(play);
    }

    public void clearList(){
        for(Play play : plays){
            plays.remove(play);
        }
    }

}
