package han.triptop.backend.booking_api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.domain.Flight;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ApiV1 implements ApiInterface {

    @Override
    public Flight getFlights(String from, String to, String date) throws UnirestException {
        return null;
    }
}