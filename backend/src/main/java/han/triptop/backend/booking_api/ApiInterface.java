package han.triptop.backend.booking_api;

import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.domain.Flight;
import han.triptop.backend.state.ApiState;

public interface ApiInterface extends ApiState {
    Flight getFlights(String from, String to, String date) throws UnirestException;
}
