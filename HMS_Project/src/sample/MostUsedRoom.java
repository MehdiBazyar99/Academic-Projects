package sample;

import java.sql.Date;

public class MostUsedRoom {
    private int MostUsedRoomID;
    private int MostUsedTimesUsed;
    private Date MostUsedRoomFromDate;
    private Date MostUsedRoomToDate;


    public MostUsedRoom(int mostUsedRoomID, int mostUsedTimesUsed, Date mostUsedRoomFromDate, Date mostUsedRoomToDate) {
        MostUsedRoomID = mostUsedRoomID;
        MostUsedTimesUsed = mostUsedTimesUsed;
        MostUsedRoomFromDate = mostUsedRoomFromDate;
        MostUsedRoomToDate = mostUsedRoomToDate;
    }


    public int getMostUsedRoomID() {
        return MostUsedRoomID;
    }

    public int getMostUsedTimesUsed() {
        return MostUsedTimesUsed;
    }

    public Date getMostUsedRoomFromDate() {
        return MostUsedRoomFromDate;
    }

    public Date getMostUsedRoomToDate() {
        return MostUsedRoomToDate;
    }
}
