package han.triptop.backend.adapter.out;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.adapter.APICaller;
import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.port.RestaurantPort;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UberEatsScraperAdapter extends APICaller implements RestaurantPort {

    public UberEatsScraperAdapter(@Value("${ubereats.API.key}") String APIKey, @Value("${ubereats.API.url}") String APIURL) {
        this.APIURL = APIURL;
        this.APIKey = APIKey;
    }

    @Override
    public void login() {
        System.out.println("login bij de externe Uber Eats API");
    }

    @Override
    public void checkToken() {
        this.token = null;
        // uitleggen in SGB/comment dat deze leeg is en later geimplementeerd moet worden
    }

    @Override
    public String callAPI(Map<String, String> parameters) {

        int maxRows = 15;
        int pages = 1;
        JSONObject scraper = new JSONObject();
        scraper.put("maxRows", maxRows);
        scraper.put("query", parameters.getOrDefault("query", ""));
        scraper.put("address", parameters.getOrDefault("address", ""));
        scraper.put("locale", "nl-NL");
        scraper.put("page", pages);


        JSONObject bodyJson = new JSONObject();
        bodyJson.put("scraper", scraper);
        String body = bodyJson.toString();

        try {
            HttpResponse<JsonNode> response = Unirest.post(APIURL)
                    .header("x-rapidapi-key", APIKey)
                    .header("x-rapidapi-host", "uber-eats-scraper-api.p.rapidapi.com")
                    .header("Content-Type", "application/json")
                    .body(body)
                    .asJson();


            return response.getBody().toString();
            // json direct teruggeven of als string?
            // beetje omslachtig om json -> string -> json te doen maar hierdoor wel uniforme methode voor APICaller.
            // to do: check of nieuwe feature ook json teruggeeft (neem aan dat dat ook met JsonNode wordt)
            // dan aanpassen naar Json methode ipv String!
        } catch (UnirestException ue) {
            throw new RuntimeException("Er ging iets mis bij het ophalen van de data van Uber Eats.", ue);
        }
    }

    @Override
    public List<Restaurant> getRestaurants(String query, String address) {
        Map<String, String> parameters = Map.of("query", query, "address", address);
        String response = executeAPICall(parameters);

        List<Restaurant> restaurantList = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(response);
        JSONObject returnValue = jsonObject.optJSONObject("returnvalue");
        JSONArray restaurants = returnValue.optJSONArray("data");

        if (restaurants == null || restaurants.length() == 0) {
            throw new RuntimeException("Er zijn geen restaurants gevonden.");
        }

        for (int i = 0; i < restaurants.length(); i++) {
            JSONObject restaurant = restaurants.getJSONObject(i);

            JSONObject location = restaurant.getJSONObject("location");
            Restaurant restaurantObject = new Restaurant(restaurant.getString("uuid"),
                    restaurant.getString("title"), location.getString("address"));
            restaurantList.add(restaurantObject);
        }
        System.out.println(restaurantList);
        return restaurantList;
    }
}
