package sample;

import java.sql.Date;

public class MostUsedService {
    private String MostUsedServiceName;
    private int MostUsedServiceTimes;
    private Date MostUsedServiceFromDate;
    private Date MostUsedServiceToDate;


    public MostUsedService(String mostUsedServiceName, int mostUsedServiceTimes, Date mostUsedServiceFromDate, Date mostUsedServiceToDate) {
        MostUsedServiceName = mostUsedServiceName;
        MostUsedServiceTimes = mostUsedServiceTimes;
        MostUsedServiceFromDate = mostUsedServiceFromDate;
        MostUsedServiceToDate = mostUsedServiceToDate;
    }

    public String getMostUsedServiceName() {
        return MostUsedServiceName;
    }

    public int getMostUsedServiceTimes() {
        return MostUsedServiceTimes;
    }

    public Date getMostUsedServiceFromDate() {
        return MostUsedServiceFromDate;
    }

    public Date getMostUsedServiceToDate() {
        return MostUsedServiceToDate;
    }
}
