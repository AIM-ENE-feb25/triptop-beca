package han.triptop.backend.booking_api;

import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.domain.Flight;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ApiV2 implements ApiInterface {

    @Override
    public Flight getFlights(String from, String to, String date) throws UnirestException {
        // TODO: Implement this method
        return null;
    }
}