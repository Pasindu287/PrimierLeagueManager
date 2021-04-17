package Core;

public class UniversityFootballClub extends  SportClub {
    private String uniName;
    private String uniftballclbName;
    private String uniftballclbColour;
    private String uniftballclbCouach;
    private int uniftballclbId;

    public UniversityFootballClub(String uniName, String uniftballclbName,
                                  String uniftballclbColour, String uniftballclbCouach, int uniftballclbId){
        this.uniName  = uniName;
        this.uniftballclbName  = uniftballclbName;
        this.uniftballclbColour = uniftballclbColour;
        this.uniftballclbCouach = uniftballclbCouach;
        this.uniftballclbId = uniftballclbId;
    }

    public String getUniftballclbName() {
        return uniftballclbName;
    }

    public String getUniftballclbColour() {
        return uniftballclbColour;
    }

    public String getUniftballclbCouach() {
        return uniftballclbCouach;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public void setUniftballclbName(String uniftballclbName) {
        this.uniftballclbName = uniftballclbName;
    }

    public void setUniftballclbColour(String uniftballclbColour) {
        this.uniftballclbColour = uniftballclbColour;
    }

    public void setUniftballclbCouach(String uniftballclbCouach) {
        this.uniftballclbCouach = uniftballclbCouach;
    }

    public void setUniftballclbId(int uniftballclbId) {
        this.uniftballclbId = uniftballclbId;
    }

    public int getUniftballclbId() {
        return uniftballclbId;
    }
}
