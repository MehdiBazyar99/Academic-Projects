package sample;

public class ServiceUsed {

    private int ServiceUsedID;
    private int ServiceUsedServiceID;
    private int ServiceUsedBookingID;


    public ServiceUsed(int serviceUsedID, int serviceUsedServiceID, int serviceUsedBookingID) {
        ServiceUsedID = serviceUsedID;
        ServiceUsedServiceID = serviceUsedServiceID;
        ServiceUsedBookingID = serviceUsedBookingID;
    }


    public int getServiceUsedID() {
        return ServiceUsedID;
    }

    public int getServiceUsedServiceID() {
        return ServiceUsedServiceID;
    }

    public int getServiceUsedBookingID() {
        return ServiceUsedBookingID;
    }
}
