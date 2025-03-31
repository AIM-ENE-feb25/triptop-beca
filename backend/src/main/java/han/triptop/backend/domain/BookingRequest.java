package han.triptop.backend.domain;

public class BookingRequest {

    // Voor hotel
    private String hotelId;
    private String currency;
    private String location;
    private String destId;
    private int adults;

    // Voor vluct
    private String fromId;
    private String toId;

    // Voor auto
    private double pickUpLatitude;
    private double pickUpLongitude;
    private double dropOffLatitude;
    private double dropOffLongitude;
    private String pickUpTime;
    private String dropOffTime;
    private int driverAge;

}
