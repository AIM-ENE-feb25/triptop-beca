package han.triptop.backend.booking_api;

import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.domain.Flight;
import org.json.JSONObject;

public interface ApiInterface {
    Flight getFlights(String from, String to, String date) throws UnirestException;
}
