package han.triptop.backend.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class FlightController {

    public void getFlights() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("https://booking-com15.p.rapidapi.com/api/v1/flights/searchFlights?fromId=BOM.AIRPORT&toId=DEL.AIRPORT&departDate=2025-04-05&returnDate=2025-04-12&pageNo=1&adults=1&children=0%2C17&sort=BEST&cabinClass=ECONOMY&currency_code=AED")
                .header("x-rapidapi-key", "bce5053868msh3f7de38b3e4c52bp137140jsn93248ea6b459")
                .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                .asJson();
        System.out.println(response.getBody());
    }
}
