package Core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class SportClub implements Serializable {
   private int Won;
   private int Draw;
   private int Lost;
   private int played;
   private List<Match> matches = new ArrayList<>();//matches arry list
   private int points = 0;
   private int goals = 0;

    protected SportClub() {
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals += goals;
    }

    public SportClub(int Won, int Draw, int Lost, int played){

        this.Won = Won;
        this.Draw = Draw;
        this.Lost =  Lost;
        this.played = played;


    }

    public void setWon() {
        Won++;
        setPoints(3);
    }

    public void setDraw() {
        Draw++;
        setPoints(1);
    }

    public void setLost() {
        Lost++;
    }

    public void setPlayed() {
        played++;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getWon() {
        return Won;
    }

    public int getDraw() {
        return Draw;
    }

    public int getLost() {
        return Lost;
    }

    public int getPlayed() {
        return played;
    }

    public void addMatch(Match match) {
        matches.add(match);
    }



}