package han.triptop.backend.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.booking_api.ApiInterface;
import han.triptop.backend.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final ApiInterface apiV1;
    private final ApiInterface apiV2;

    @Autowired
    public FlightService(ApiInterface apiV1, ApiInterface apiV2) {
        this.apiV1 = apiV1;
        this.apiV2 = apiV2;
    }

    public Flight getFlights(String from, String to, String date, String version) throws UnirestException {
        if ("v2".equalsIgnoreCase(version)) {
            return apiV2.getFlights(from, to, date);
        } else {
            return apiV1.getFlights(from, to, date);
        }
    }
}