package han.triptop.backend.adapter;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EatsAdapterPortImpl implements EatsAdapterPort {

    private static final String URL = "https://uber-eats-scraper-api.p.rapidapi.com/api/job";
    private final String apiKey;

    @Autowired
    public EatsAdapterPortImpl(@Value("${API_KEY}") String apiKey) {
        this.apiKey = apiKey;
    }

    public JSONObject getRestaurantsNearUser(String query, String address) {

        int maxRows = 15;
        int pages = 1;
        JSONObject scraper = new JSONObject();
        scraper.put("maxRows", maxRows);
        scraper.put("query", query);
        scraper.put("address", address);
        scraper.put("locale", "nl-NL");
        scraper.put("page", pages);

        JSONObject bodyJson = new JSONObject();
        bodyJson.put("scraper", scraper);

        String body = bodyJson.toString();

        try {
            HttpResponse<JsonNode> response = Unirest.post(URL)
                    .header("Content-Type", "application/json")
                    .header("x-rapidapi-host", "uber-eats-scraper-api.p.rapidapi.com")
                    .header("x-rapidapi-key", apiKey)
                    .body(body)
                    .asJson();

            return response.getBody().getObject();
        } catch (UnirestException e) {
            throw new RuntimeException("Error while making API request", e);
        }
    }
}
