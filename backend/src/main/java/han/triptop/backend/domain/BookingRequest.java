package han.triptop.backend.domain;

public class BookingRequest {

    // Voor hotel
    private String hotelId;
    private String currency;
    private String location;
    private String destId;
    private int adults;

    // Voor vlucht
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

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDestId() {
        return destId;
    }

    public void setDestId(String destId) {
        this.destId = destId;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public double getPickUpLatitude() {
        return pickUpLatitude;
    }

    public void setPickUpLatitude(double pickUpLatitude) {
        this.pickUpLatitude = pickUpLatitude;
    }

    public double getPickUpLongitude() {
        return pickUpLongitude;
    }

    public void setPickUpLongitude(double pickUpLongitude) {
        this.pickUpLongitude = pickUpLongitude;
    }

    public double getDropOffLatitude() {
        return dropOffLatitude;
    }

    public void setDropOffLatitude(double dropOffLatitude) {
        this.dropOffLatitude = dropOffLatitude;
    }

    public double getDropOffLongitude() {
        return dropOffLongitude;
    }

    public void setDropOffLongitude(double dropOffLongitude) {
        this.dropOffLongitude = dropOffLongitude;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(String dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }

}
