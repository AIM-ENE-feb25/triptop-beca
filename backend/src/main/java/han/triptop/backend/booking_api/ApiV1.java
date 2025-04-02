package han.triptop.backend.booking_api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ApiV1 implements ApiInterface {

    @Override
    public JSONObject getFlights(String from, String to, String date) throws UnirestException {
        try {
            String apiUrl = String.format(
                    "https://booking-com15.p.rapidapi.com/api/v1/flights/searchFlights?fromId=%s.AIRPORT&toId=%s.AIRPORT&departDate=%s&pageNo=1&adults=1&children=0%%2C17&sort=BEST&cabinClass=ECONOMY&currency_code=EUR",
                    from, to, date);

            System.out.println("Requesting URL: " + apiUrl);

            HttpResponse<JsonNode> response = Unirest.get(apiUrl)
                    .header("x-rapidapi-key", "bce5053868msh3f7de38b3e4c52bp137140jsn93248ea6b459")
                    .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                    .header("Accept", "application/json")
                    .asJson();

            return response.getBody().getObject();

//            JSONObject responseBody = response.getBody().getObject();
//            JSONObject flightData = responseBody.getJSONObject("data")
//                    .getJSONArray("flightOffers")
//                    .getJSONObject(0)
//                    .getJSONArray("segments")
//                    .getJSONObject(0);
//
//            JSONObject priceBreakdown = responseBody.getJSONObject("data")
//                    .getJSONArray("flightOffers")
//                    .getJSONObject(0)
//                    .getJSONObject("priceBreakdown");
//
//            JSONObject departureAirport = flightData.getJSONObject("departureAirport");
//            JSONObject arrivalAirport = flightData.getJSONObject("arrivalAirport");
//
//            JSONObject flightInfo = new JSONObject();
//            flightInfo.put("departureCode", departureAirport.getString("code"));
//            flightInfo.put("departureName", departureAirport.getString("name"));
//            flightInfo.put("departureCity", departureAirport.getString("cityName"));
//            flightInfo.put("departureCountry", departureAirport.getString("countryName"));
//
//            flightInfo.put("arrivalCode", arrivalAirport.getString("code"));
//            flightInfo.put("arrivalName", arrivalAirport.getString("name"));
//            flightInfo.put("arrivalCity", arrivalAirport.getString("cityName"));
//            flightInfo.put("arrivalCountry", arrivalAirport.getString("countryName"));
//
//            flightInfo.put("departureTime", flightData.getString("departureTime"));
//            flightInfo.put("arrivalTime", flightData.getString("arrivalTime"));
//
//            flightInfo.put("currency", priceBreakdown.getJSONObject("total").getString("currencyCode"));
//            flightInfo.put("price", priceBreakdown.getJSONObject("total").getInt("units"));

//            return flightInfo;
        } catch (Exception e) {
            System.out.println("Error fetching flight data: " + e.getMessage());
        }
        return null;
    }
}
