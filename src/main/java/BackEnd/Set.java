package BackEnd;

import java.util.Collection;

public class Set {
    private int numSet;
    private Collection<Point> awayTeamPoints;
    private Collection<Point> homeTeamPoints;

    public Set() {
    }
    public Set(int numSet, Collection<Point> awayTeamPoints, Collection<Point> homeTeamPoints) {
        this.numSet = numSet;
        this.awayTeamPoints = awayTeamPoints;
        this.homeTeamPoints = homeTeamPoints;
    }

    public int getNumSet() {
        return numSet;
    }

    public void setNumSet(int numSet) {
        this.numSet = numSet;
    }

    public Collection<Point> getAwayTeamPoints() {
        return awayTeamPoints;
    }

    public void setAwayTeamPoints(Collection<Point> awayTeamPoints) {
        this.awayTeamPoints = awayTeamPoints;
    }

    public Collection<Point> getHomeTeamPoints() {
        return homeTeamPoints;
    }

    public void setHomeTeamPoints(Collection<Point> homeTeamPoints) {
        this.homeTeamPoints = homeTeamPoints;
    }
}
