package Core;

public class FootballClub extends SportClub {
   private String ftballclbName;
    private String ftballclbColour;
    private String ftballclbCouach;
    private int ftballclbId;



    public FootballClub(String ftballclbName, String ftballclbColour, String ftballclbCouach, int ftballclbId){
        this.ftballclbName  = ftballclbName;//clubname
        this.ftballclbColour = ftballclbColour;
        this.ftballclbCouach = ftballclbCouach;//couach name
        this.ftballclbId = ftballclbId;//club id
    }

    public String getFtballclbName() {
        return ftballclbName;
    }

    public String getFtballclbColour() {
        return ftballclbColour;
    }

    public String getFtballclbCouach() {
        return ftballclbCouach;
    }

    public void setFtballclbName(String ftballclbName) {
        this.ftballclbName = ftballclbName;
    }

    public void setFtballclbColour(String ftballclbColour) {
        this.ftballclbColour = ftballclbColour;
    }

    public void setFtballclbCouach(String ftballclbCouach) {
        this.ftballclbCouach = ftballclbCouach;
    }

    public void setFtballclbId(int ftballclbId) {
        this.ftballclbId = ftballclbId;
    }

    public int getFtballclbId() {
        return ftballclbId;
    }
}
