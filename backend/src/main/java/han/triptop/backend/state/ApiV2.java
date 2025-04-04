package han.triptop.backend.state;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.adapter.ApiInterface;
import han.triptop.backend.domain.Flight;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ApiV2 implements ApiState {

    @Override
    public Flight getFlights(String from, String to, String date) throws UnirestException {
        try {
            String apiUrl = String.format(
                    "https://booking-com15.p.rapidapi.com/api/v1/flights/searchFlights?fromId=%s.AIRPORT&toId=%s.AIRPORT&departDate=%s&pageNo=1&adults=1&children=0%%2C17&sort=BEST&cabinClass=ECONOMY&currency_code=EUR",
                    from, to, date);

            HttpResponse<JsonNode> response = Unirest.get(apiUrl)
                    .header("x-rapidapi-key", "bce5053868msh3f7de38b3e4c52bp137140jsn93248ea6b459")
                    .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                    .header("Accept", "application/json")
                    .asJson();

            JSONObject responseBody = response.getBody().getObject();
            JSONObject flightData = responseBody.getJSONObject("data")
                    .getJSONArray("flightOffers")
                    .getJSONObject(0)
                    .getJSONArray("segments")
                    .getJSONObject(0);

            JSONObject priceBreakdown = responseBody.getJSONObject("data")
                    .getJSONArray("flightOffers")
                    .getJSONObject(0)
                    .getJSONObject("priceBreakdown");

            JSONObject departureAirport = flightData.getJSONObject("departureAirport");
            JSONObject arrivalAirport = flightData.getJSONObject("arrivalAirport");

            String departureTime = flightData.getString("departureTime");
            String arrivalTime = flightData.getString("arrivalTime");
            String currency = priceBreakdown.getJSONObject("total").getString("currencyCode");
            int price = priceBreakdown.getJSONObject("total").getInt("units");

            Flight flight = new Flight(departureAirport.getString("code"),
                    departureAirport.getString("name"),
                    departureAirport.getString("cityName"),
                    departureAirport.getString("countryName"),
                    arrivalAirport.getString("code"),
                    arrivalAirport.getString("name"),
                    arrivalAirport.getString("cityName"),
                    arrivalAirport.getString("countryName"),
                    departureTime, arrivalTime, currency, price);

            return flight;
        } catch (Exception e) {
            System.out.println("Error fetching flight data: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void setNextState(ApiState nextState) {
        // No-op: ApiV2 is the final state
    }
}