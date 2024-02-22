package resortInfo;

public class LiftPasses {

private int liftPassID;
    private String clientLiftPassFullName="";
    private String liftPassType="";
    private String liftPassValidity="";

    public int getLiftPassID() {
        return liftPassID;
    }

    public void setLiftPassID(int liftPassID) {
        this.liftPassID = liftPassID;
    }

    public String getClientLiftPassFullName() {
        return clientLiftPassFullName;
    }

    public void setClientLiftPassFullName(String clientLiftPassFullName) {
        this.clientLiftPassFullName = clientLiftPassFullName;
    }

    public String getLiftPassType() {
        return liftPassType;
    }

    public void setLiftPassType(String liftPassType) {
        this.liftPassType = liftPassType;
    }

    public String getLiftPassValidity() {
        return liftPassValidity;
    }

    public void setLiftPassValidity(String liftPassValidity) {
        this.liftPassValidity = liftPassValidity;
    }
}
