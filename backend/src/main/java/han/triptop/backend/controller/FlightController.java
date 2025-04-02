package han.triptop.backend.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.booking_api.ApiInterface;
import han.triptop.backend.booking_api.ApiV1;
import han.triptop.backend.booking_api.ApiV2;
import han.triptop.backend.domain.Flight;
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

        Flight flight = ((ApiInterface) apiV1).getFlights(from, to, date);

        return ResponseEntity.ok(flight);
    }
}
