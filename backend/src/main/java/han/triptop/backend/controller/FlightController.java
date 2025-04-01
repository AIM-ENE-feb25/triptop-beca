package han.triptop.backend.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class FlightController {

    public void getFlights() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("https://booking-com15.p.rapidapi.com/api/v1/flights/searchFlights?fromId=AMS.AIRPORT&toId=BCN.AIRPORT&departDate=2025-05-03&pageNo=1&adults=1&children=0%2C17&sort=BEST&cabinClass=ECONOMY&currency_code=EUR")
                .header("x-rapidapi-key", "bce5053868msh3f7de38b3e4c52bp137140jsn93248ea6b459")
                .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                .asJson();

        JSONObject responseBody = response.getBody().getObject();
        JSONObject flightData = responseBody.getJSONObject("data")
                .getJSONArray("flightOffers")
                .getJSONObject(0)
                .getJSONArray("segments")
                .getJSONObject(0);

        JSONObject priceBreakdown = responseBody.getJSONObject("data")
                .getJSONArray("flightOffers")
                .getJSONObject(0)
                .getJSONObject("priceBreakdown");

        JSONObject departureAirport = flightData.getJSONObject("departureAirport");
        JSONObject arrivalAirport = flightData.getJSONObject("arrivalAirport");

        String departureCode = departureAirport.getString("code");
        String departureName = departureAirport.getString("name");
        String departureCity = departureAirport.getString("cityName");
        String departureCountry = departureAirport.getString("countryName");

        String arrivalCode = arrivalAirport.getString("code");
        String arrivalName = arrivalAirport.getString("name");
        String arrivalCity = arrivalAirport.getString("cityName");
        String arrivalCountry = arrivalAirport.getString("countryName");

        String departureTime = flightData.getString("departureTime");
        String arrivalTime = flightData.getString("arrivalTime");

        String currency = priceBreakdown.getJSONObject("total").getString("currencyCode");
        int price = priceBreakdown.getJSONObject("total").getInt("units");

        // Printing the flight data
        System.out.println("Flight Information:");
        System.out.println("Departure Airport: " + departureName + " (" + departureCode + ")");
        System.out.println("City: " + departureCity + ", " + departureCountry);
        System.out.println("Arrival Airport: " + arrivalName + " (" + arrivalCode + ")");
        System.out.println("City: " + arrivalCity + ", " + arrivalCountry);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Arrival Time: " + arrivalTime);

        System.out.println("Price: " + price + " " + currency);
    }
}
