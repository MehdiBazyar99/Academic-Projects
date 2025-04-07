package sample;

public class Hotel {
    private int HotelID;
    private String HotelName;
    private String HotelCN;
    private String HotelEA;
    private String HotelWS;
    private String HotelDESC;
    private int HotelRCapacity;
    private String HotelALine;
    private String HotelCity;
    private String HotelState;
    private String HotelCountry;
    private String HotelZipCode;


    public Hotel(int hotelID, String hotelName, String hotelCN, String hotelEA, String hotelWS, String hotelDESC, int hotelRCapacity, String hotelALine, String hotelCity, String hotelState, String hotelCountry, String hotelZipCode) {
        HotelID = hotelID;
        HotelName = hotelName;
        HotelCN = hotelCN;
        HotelEA = hotelEA;
        HotelWS = hotelWS;
        HotelDESC = hotelDESC;
        HotelRCapacity = hotelRCapacity;
        HotelALine = hotelALine;
        HotelCity = hotelCity;
        HotelState = hotelState;
        HotelCountry = hotelCountry;
        HotelZipCode = hotelZipCode;
    }

    public int getHotelID() {
        return HotelID;
    }

    public String getHotelName() {
        return HotelName;
    }

    public String getHotelCN() {
        return HotelCN;
    }

    public String getHotelEA() {
        return HotelEA;
    }

    public String getHotelWS() {
        return HotelWS;
    }

    public String getHotelDESC() {
        return HotelDESC;
    }

    public int getHotelRCapacity() {
        return HotelRCapacity;
    }

    public String getHotelALine() {
        return HotelALine;
    }

    public String getHotelCity() {
        return HotelCity;
    }

    public String getHotelState() {
        return HotelState;
    }

    public String getHotelCountry() {
        return HotelCountry;
    }

    public String getHotelZipCode() {
        return HotelZipCode;
    }
}
