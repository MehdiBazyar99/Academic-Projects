package sample;

import java.sql.Date;

public class MostUsedHotel {
    private int MostUsedHotelID;
    private int MostUsedTimesUsed;
    private Date MostUsedHotelFromDate;
    private Date MostUsedHotelToDate;


    public MostUsedHotel(int mostUsedHotelID, int mostUsedTimesUsed, Date mostUsedHotelFromDate, Date mostUsedHotelToDate) {
        MostUsedHotelID = mostUsedHotelID;
        MostUsedTimesUsed = mostUsedTimesUsed;
        MostUsedHotelFromDate = mostUsedHotelFromDate;
        MostUsedHotelToDate = mostUsedHotelToDate;
    }


    public int getMostUsedHotelID() {
        return MostUsedHotelID;
    }

    public int getMostUsedTimesUsed() {
        return MostUsedTimesUsed;
    }

    public Date getMostUsedHotelFromDate() {
        return MostUsedHotelFromDate;
    }

    public Date getMostUsedHotelToDate() {
        return MostUsedHotelToDate;
    }
}
