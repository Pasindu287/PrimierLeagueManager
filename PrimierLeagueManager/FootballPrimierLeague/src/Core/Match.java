package Core;

import java.io.Serializable;
import java.util.Date;

public class Match implements Serializable {
    private String club1Name;
    private int club1Score;
    private String club2Name;
    private int club2Score;
    private Date date;
    private String result;
    private boolean duplicate;

    public Match (String club1Name, int club1Score, String club2Name, int club2Score, Date date, boolean duplicate) {
        this.club1Name = club1Name;
        this.club1Score = club1Score;
        this.club2Name = club2Name;
        this.club2Score = club2Score;
        this.date = date;
        if (club1Score > club2Score)//get result
            result = "WIN";
        else if (club1Score < club2Score)
            result = "LOSE";
        else
            result = "DRAW";
        this.duplicate = duplicate;//boolen value help get win or lose or draw
    }

    public String getClub1Name() {
        return club1Name;
    }

    public void setClub1Name(String club1Name) {
        this.club1Name = club1Name;
    }

    public int getClub1Score() {
        return club1Score;
    }

    public void setClub1Score(int club1Score) {
        this.club1Score = club1Score;
    }

    public String getClub2Name() {
        return club2Name;
    }

    public void setClub2Name(String club2Name) {
        this.club2Name = club2Name;
    }

    public int getClub2Score() {
        return club2Score;
    }

    public void setClub2Score(int club2Score) {
        this.club2Score = club2Score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }
}
