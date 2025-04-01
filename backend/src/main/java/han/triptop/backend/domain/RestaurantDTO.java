package han.triptop.backend.domain;

public class RestaurantDTO {
    private String query;
    private String address;

    public RestaurantDTO(String query, String address) {
        this.query = query;
        this.address = address;
    }

    public String getQuery() {
        return query;
    }

    public String getAddress() {
        return address;
    }
}
