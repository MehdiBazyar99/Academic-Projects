package sample;
import java.sql.Date;

public class Bookings {
    private int bookingsID;
    private Date bookingsDate;
    private int bookingsDOFS;
    private int bookingsGuestID;
    private String bookingsFName;
    private String bookingsLName;
    private Date bookingsCheckINDate;
    private Date bookingsCheckOUTDate;
    private String bookingsHotelName;
    private int bookingsHotelID;
    private int bookingsRoomID;
    private int bookingsTotalPayment;
    private int bookingsCheckedOut;


    public Bookings(int bookingsID, Date bookingsDate, int bookingsDOFS, int bookingsGuestID, String bookingsFName, String bookingsLName, Date bookingsCheckINDate, Date bookingsCheckOUTDate, String bookingsHotelName, int bookingsHotelID, int bookingsRoomID, int bookingsTotalPayment, int bookingsCheckedOut) {
        this.bookingsID = bookingsID;
        this.bookingsDate = bookingsDate;
        this.bookingsDOFS = bookingsDOFS;
        this.bookingsGuestID = bookingsGuestID;
        this.bookingsFName = bookingsFName;
        this.bookingsLName = bookingsLName;
        this.bookingsCheckINDate = bookingsCheckINDate;
        this.bookingsCheckOUTDate = bookingsCheckOUTDate;
        this.bookingsHotelName = bookingsHotelName;
        this.bookingsHotelID = bookingsHotelID;
        this.bookingsRoomID = bookingsRoomID;
        this.bookingsTotalPayment = bookingsTotalPayment;
        this.bookingsCheckedOut = bookingsCheckedOut;
    }


    public int getBookingsID() {
        return bookingsID;
    }

    public Date getBookingsDate() {
        return bookingsDate;
    }

    public int getBookingsDOFS() {
        return bookingsDOFS;
    }

    public int getBookingsGuestID() {
        return bookingsGuestID;
    }

    public String getBookingsFName() {
        return bookingsFName;
    }

    public String getBookingsLName() {
        return bookingsLName;
    }

    public Date getBookingsCheckINDate() {
        return bookingsCheckINDate;
    }

    public Date getBookingsCheckOUTDate() {
        return bookingsCheckOUTDate;
    }

    public String getBookingsHotelName() {
        return bookingsHotelName;
    }

    public int getBookingsHotelID() {
        return bookingsHotelID;
    }

    public int getBookingsRoomID() {
        return bookingsRoomID;
    }

    public int getBookingsTotalPayment() {
        return bookingsTotalPayment;
    }

    public int getBookingsCheckedOut() {
        return bookingsCheckedOut;
    }
}
