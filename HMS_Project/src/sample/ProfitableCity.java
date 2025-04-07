package sample;

import java.sql.Date;

public class ProfitableCity {

    private String ProfitableCityName;
    private int ProfitableCityTimes;
    private Date ProfitableCityFromDate;
    private Date ProfitableCityToDate;


    public ProfitableCity(String profitableCityName, int profitableCityTimes, Date profitableCityFromDate, Date profitableCityToDate) {
        ProfitableCityName = profitableCityName;
        ProfitableCityTimes = profitableCityTimes;
        ProfitableCityFromDate = profitableCityFromDate;
        ProfitableCityToDate = profitableCityToDate;
    }


    public String getProfitableCityName() {
        return ProfitableCityName;
    }

    public int getProfitableCityTimes() {
        return ProfitableCityTimes;
    }

    public Date getProfitableCityFromDate() {
        return ProfitableCityFromDate;
    }

    public Date getProfitableCityToDate() {
        return ProfitableCityToDate;
    }
}
