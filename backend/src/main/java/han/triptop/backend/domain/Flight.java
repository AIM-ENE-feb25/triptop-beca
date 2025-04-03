package han.triptop.backend.domain;

public class Flight {
    private final String departureCode;
    private final String departureName;
    private final String departureCityName;
    private final String departureCountryName;
    private final String arrivalCode;
    private final String arrivalName;
    private final String arrivalCityName;
    private final String arrivalCountryName;
    private final String departureTime;
    private final String arrivalTime;
    private final String currency;
    private final int price;

    public Flight(String departureCode, String departureName, String departureCityName, String departureCountryName,
                  String arrivalCode, String arrivalName, String arrivalCityName, String arrivalCountryName,
                  String departureTime, String arrivalTime, String currency, int price) {
        this.departureCode = departureCode;
        this.departureName = departureName;
        this.departureCityName = departureCityName;
        this.departureCountryName = departureCountryName;
        this.arrivalCode = arrivalCode;
        this.arrivalName = arrivalName;
        this.arrivalCityName = arrivalCityName;
        this.arrivalCountryName = arrivalCountryName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.currency = currency;
        this.price = price;
    }

    public String getDepartureCode() {
        return departureCode;
    }

    public String getDepartureName() {
        return departureName;
    }

    public String getDepartureCityName() {
        return departureCityName;
    }

    public String getDepartureCountryName() {
        return departureCountryName;
    }

    public String getArrivalCode() {
        return arrivalCode;
    }

    public String getArrivalName() {
        return arrivalName;
    }

    public String getArrivalCityName() {
        return arrivalCityName;
    }

    public String getArrivalCountryName() {
        return arrivalCountryName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getCurrency() {
        return currency;
    }

    public int getPrice() {
        return price;
    }
}