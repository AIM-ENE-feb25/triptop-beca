package han.triptop.backend.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.booking_api.ApiInterface;
import han.triptop.backend.booking_api.ApiV1;
import han.triptop.backend.booking_api.ApiV2;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final ApiV1 apiV1;
    private final ApiV2 apiV2;

    public FlightController(ApiV1 apiV1, ApiV2 apiV2) {
        this.apiV1 = apiV1;
        this.apiV2 = apiV2;
    }

    @GetMapping
    public ResponseEntity<Flight> getFlights(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date,
            @RequestParam(defaultValue = "v1") String version
    ) throws UnirestException {

        JSONObject responseBody = ((ApiInterface) apiV1).getFlights(from, to, date);
        JSONObject flightData = responseBody.getJSONObject("data")
                .getJSONArray("flightOffers")
                .getJSONObject(0)
                .getJSONArray("segments")
                .getJSONObject(0);
        JSONObject departureAirport = flightData.getJSONObject("departureAirport");
        JSONObject arrivalAirport = flightData.getJSONObject("arrivalAirport");

        Flight flight = new Flight(departureAirport.getString("code"),
                departureAirport.getString("name"),
                departureAirport.getString("cityName"),
                departureAirport.getString("countryName"),
                arrivalAirport.getString("code"),
                arrivalAirport.getString("name"),
                arrivalAirport.getString("cityName"),
                arrivalAirport.getString("countryName"));
        return ResponseEntity.ok(flight);
    }
}
