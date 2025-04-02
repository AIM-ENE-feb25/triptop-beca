package han.triptop.backend.controller;

public class Flight {
    private final String code;
    private final String name;
    private final String cityName;
    private final String countryName;
    private final String code1;
    private final String name1;
    private final String cityName1;
    private final String countryName1;

    public Flight(String code, String name, String cityName, String countryName, String code1, String name1, String cityName1, String countryName1) {
        this.code = code;
        this.name = name;
        this.cityName = cityName;
        this.countryName = countryName;
        this.code1 = code1;
        this.name1 = name1;
        this.cityName1 = cityName1;
        this.countryName1 = countryName1;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCode1() {
        return code1;
    }

    public String getName1() {
        return name1;
    }

    public String getCityName1() {
        return cityName1;
    }

    public String getCountryName1() {
        return countryName1;
    }
}
