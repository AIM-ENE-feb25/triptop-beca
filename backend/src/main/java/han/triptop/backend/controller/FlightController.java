package han.triptop.backend.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.domain.Flight;
import han.triptop.backend.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<Flight> getFlights(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date,
            @RequestParam(defaultValue = "v1") String version
    ) throws UnirestException {

        Flight flight = flightService.getFlights(from, to, date, version);

        return ResponseEntity.ok(flight);
    }
}