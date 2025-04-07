package sample;

import java.sql.Date;

public class ProfitableGuest {
    private int ProfitableGuestID;
    private String ProfitableGuestFName;
    private String ProfitableGuestLName;
    private int ProfitableGuestTotalSpending;
    private Date ProfitableGuestFromDate;
    private Date ProfitableGuestToDate;


    public ProfitableGuest(int profitableGuestID, String profitableGuestFName,
                           String profitableGuestLName,
                           int profitableGuestTotalSpending,
                           Date profitableGuestFromDate, Date profitableGuestToDate) {
        ProfitableGuestID = profitableGuestID;
        ProfitableGuestFName = profitableGuestFName;
        ProfitableGuestLName = profitableGuestLName;
        ProfitableGuestTotalSpending = profitableGuestTotalSpending;
        ProfitableGuestFromDate = profitableGuestFromDate;
        ProfitableGuestToDate = profitableGuestToDate;
    }


    public int getProfitableGuestID() {
        return ProfitableGuestID;
    }

    public String getProfitableGuestFName() {
        return ProfitableGuestFName;
    }

    public String getProfitableGuestLName() {
        return ProfitableGuestLName;
    }

    public int getProfitableGuestTotalSpending() {
        return ProfitableGuestTotalSpending;
    }

    public Date getProfitableGuestFromDate() {
        return ProfitableGuestFromDate;
    }

    public Date getProfitableGuestToDate() {
        return ProfitableGuestToDate;
    }
}
