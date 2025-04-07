package sample;

public class Room {
    private int roomID;
    private int roomNumber;
    private int roomType;
    private int roomHotelID;


    public Room(int roomID, int roomNumber, int roomType, int roomHotelID) {
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomHotelID = roomHotelID;
    }

    public int getRoomID() {
        return roomID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getRoomType() {
        return roomType;
    }

    public int getRoomHotelID() {
        return roomHotelID;
    }
}
