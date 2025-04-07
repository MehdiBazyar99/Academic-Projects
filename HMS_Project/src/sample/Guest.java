package sample;

public class Guest {

    private int guestID;
    private String guestNC;
    private String guestFName;
    private String guestLName;
    private String guestCN;
    private int guestTBH;
    private String guestEA;
    private String guestALine;
    private String guestCity;
    private String guestState;
    private String guestCountry;
    private String guestZipCode;


    public Guest(int guestID, String guestNC, String guestFName, String guestLName,
                 String guestCN, int guestTBH, String guestEA, String guestALine,
                 String guestCity, String guestState, String guestCountry, String guestZipCode) {
        this.guestID = guestID;
        this.guestNC = guestNC;
        this.guestFName = guestFName;
        this.guestLName = guestLName;
        this.guestCN = guestCN;
        this.guestTBH = guestTBH;
        this.guestEA = guestEA;
        this.guestALine = guestALine;
        this.guestCity = guestCity;
        this.guestState = guestState;
        this.guestCountry = guestCountry;
        this.guestZipCode = guestZipCode;
    }

    public int getGuestID() {
        return guestID;
    }

    public String getGuestNC() {
        return guestNC;
    }

    public String getGuestFName() {
        return guestFName;
    }

    public String getGuestLName() {
        return guestLName;
    }

    public String getGuestCN() {
        return guestCN;
    }

    public int getGuestTBH() {
        return guestTBH;
    }

    public String getGuestEA() {
        return guestEA;
    }

    public String getGuestALine() {
        return guestALine;
    }

    public String getGuestCity() {
        return guestCity;
    }

    public String getGuestState() {
        return guestState;
    }

    public String getGuestCountry() {
        return guestCountry;
    }

    public String getGuestZipCode() {
        return guestZipCode;
    }
}
