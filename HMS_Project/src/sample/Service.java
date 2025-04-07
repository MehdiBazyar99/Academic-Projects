package sample;

public class Service {

    private  int ServiceID;
    private  String ServiceName;
    private  String ServiceDESC;
    private  int ServiceCost;
    private  int ServiceHotelID;


    public Service(int serviceID, String serviceName, String serviceDESC, int serviceCost, int serviceHotelID) {
        ServiceID = serviceID;
        ServiceName = serviceName;
        ServiceDESC = serviceDESC;
        ServiceCost = serviceCost;
        ServiceHotelID = serviceHotelID;
    }


    public int getServiceID() {
        return ServiceID;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public String getServiceDESC() {
        return ServiceDESC;
    }

    public int getServiceCost() {
        return ServiceCost;
    }

    public int getServiceHotelID() {
        return ServiceHotelID;
    }
}
