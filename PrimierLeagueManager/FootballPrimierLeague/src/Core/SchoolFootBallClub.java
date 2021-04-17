package Core;

public class SchoolFootBallClub extends SportClub {
    private String sclName;
    private String sclftballclbName;
    private String sclftballclbColour;
    private  String sclftballclbCouach;
    private int sclftballclbId;

    public SchoolFootBallClub( String sclName, String sclftballclbName, String sclftballclbColour,String sclftballclbCouach ,int sclftballclbId){
        this.sclName = sclName;
        this.sclftballclbName  = sclftballclbName;
        this.sclftballclbColour = sclftballclbColour;
        this.sclftballclbCouach = sclftballclbCouach;
        this.sclftballclbId = sclftballclbId;

    }

    public String getSclName() { return sclName; }

    public String getSclftballclbName() {
        return sclftballclbName;
    }

    public String getSclftballclbColour() {
        return sclftballclbColour;
    }

    public String getSclftballclbCouach() {
        return sclftballclbCouach;
    }

    public void setSclName(String sclName) {
        this.sclName = sclName;
    }

    public void setSclftballclbName(String sclftballclbName) {
        this.sclftballclbName = sclftballclbName;
    }

    public void setSclftballclbColour(String sclftballclbColour) {
        this.sclftballclbColour = sclftballclbColour;
    }

    public void setSclftballclbCouach(String sclftballclbCouach) {
        this.sclftballclbCouach = sclftballclbCouach;
    }

    public void setSclftballclbId(int sclftballclbId) {
        this.sclftballclbId = sclftballclbId;
    }

    public int getSclftballclbId() {
        return sclftballclbId;
    }
}
