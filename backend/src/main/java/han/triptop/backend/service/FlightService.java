package han.triptop.backend.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.domain.Flight;
import han.triptop.backend.state.ApiState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private ApiState currentState;
    private final ApiState apiV1;
    private final ApiState apiV2;

    @Autowired
    public FlightService(ApiState apiV1, ApiState apiV2) {
        this.apiV1 = apiV1;
        this.apiV2 = apiV2;
        this.currentState = apiV1;
    }

    public Flight getFlights(String from, String to, String date) throws UnirestException {
        Flight flight = currentState.getFlights(from, to, date);
        if (flight == null && currentState == apiV1) {
            currentState = apiV2;
            flight = currentState.getFlights(from, to, date);
        }
        return flight;
    }
}