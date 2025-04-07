package sample;

import java.sql.Date;

public class NotUsedHotel {

    private int NotUsedHotelGuestID;
    private String NotUsedHotelCityName;
    private int NotUsedHotelID;
    private Date NotUsedHotelFromDate;
    private Date NotUsedHotelToDate;

    public NotUsedHotel(int notUsedHotelGuestID, String notUsedHotelCityName, int notUsedHotelID, Date notUsedHotelFromDate, Date notUsedHotelToDate) {
        NotUsedHotelGuestID = notUsedHotelGuestID;
        NotUsedHotelCityName = notUsedHotelCityName;
        NotUsedHotelID = notUsedHotelID;
        NotUsedHotelFromDate = notUsedHotelFromDate;
        NotUsedHotelToDate = notUsedHotelToDate;
    }


    public int getNotUsedHotelGuestID() {
        return NotUsedHotelGuestID;
    }

    public String getNotUsedHotelCityName() {
        return NotUsedHotelCityName;
    }

    public int getNotUsedHotelID() {
        return NotUsedHotelID;
    }

    public Date getNotUsedHotelFromDate() {
        return NotUsedHotelFromDate;
    }

    public Date getNotUsedHotelToDate() {
        return NotUsedHotelToDate;
    }
}
