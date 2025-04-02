package han.triptop.backend.booking_api;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public interface ApiInterface {
    JSONObject getFlights(String from, String to, String date) throws UnirestException;
}
