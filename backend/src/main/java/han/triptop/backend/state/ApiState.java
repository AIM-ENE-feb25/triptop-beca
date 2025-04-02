package han.triptop.backend.state;

import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.domain.Flight;

public interface ApiState {
    Flight getFlights(String from, String to, String date) throws UnirestException;
}