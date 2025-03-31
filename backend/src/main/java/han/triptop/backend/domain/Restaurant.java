package han.triptop.backend.domain;

public class Restaurant {
    private String name;
    private String phonenumber;
    private String city;

    public Restaurant(String name, String phonenumber, String city) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getCity() {
        return city;
    }
}
