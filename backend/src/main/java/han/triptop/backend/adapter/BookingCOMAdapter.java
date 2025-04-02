package han.triptop.backend.adapter;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.domain.Hotel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class BookingCOMAdapter extends APICaller implements HotelPort {

    public BookingCOMAdapter(@Value("${bookingCOM.API.key}") String APIKey, @Value("${bookingCOM.API.url}") String APIURL) {
        this.APIURL = APIURL;
        this.APIKey = APIKey;
    }

    @Override
    public void login() {
        System.out.println("login bij de externe Booking.COM API");
    }

    @Override
    public void checkToken() {
        this.token = null;
    }

    @Override
    public String callAPI(Map<String, String> parameters) {
        String requestURL = APIURL + "dest_id=" + parameters.get("dest_id") + "&search_type=" + parameters.get("search_type") + "&arrival_date=" + parameters.get("arrival_date")  + "&departure_date=" + parameters.get("departure_date");

        try {
            HttpResponse<JsonNode> response = Unirest.get(requestURL)
                    .header("x-rapidapi-key", APIKey)
                    .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                    .header("Content-Type", "application/json")
                    .asJson();

            return response.getBody().toString();
        } catch (UnirestException ue) {
            throw new RuntimeException("Er ging iets mis bij het ophalen van de data van Booking.COM.", ue);
        }
    }

    @Override
    public List<Hotel> getHotels(String dest_id, String search_type, String arrival_date, String departure_date) {
        Map<String, String> parameters = Map.of("dest_id", dest_id, "search_type", search_type, "arrival_date", arrival_date, "departure_date", departure_date);

        String response = executeAPICall(parameters);

        List<Hotel> hotelList = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(response);
        JSONObject data = jsonObject.optJSONObject("data");
        JSONArray hotels = data.optJSONArray("hotels");

        if (hotels == null || hotels.length() == 0) {
            throw new RuntimeException("Er zijn geen hotels gevonden.");
        }

        for (int i = 0; i < hotels.length(); i++) {
            JSONObject hotel = hotels.getJSONObject(i);

            JSONObject property = hotel.getJSONObject("property");
            Hotel hotelObject = new Hotel(hotel.getInt("hotel_id"),
                    property.getString("name"));
            hotelList.add(hotelObject);
        }
        System.out.println(hotelList);
        return hotelList;
    }
}