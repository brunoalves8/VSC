package BackEnd;

import java.time.LocalDate;
import java.util.Collection;

public class Match {
    private int codeMatch;
    private LocalDate gameDate;
    private Team homeTeam;
    private Team awayTeam;
    //Coloquei pavilion mas não faz sentido porque através da homeTeam já se sabe o pavilhão
    private String pavilion;
    private Collection<Set> sets;
}
