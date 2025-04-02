package han.triptop.backend.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.domain.Flight;
import han.triptop.backend.state.ApiState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private ApiState currentState;

    @Autowired
    public FlightService(ApiState apiV1) {
        this.currentState = apiV1;
    }

    public Flight getFlights(String from, String to, String date) throws UnirestException {
        return currentState.getFlights(from, to, date);
    }
}
