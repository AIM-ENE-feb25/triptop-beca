package han.triptop.backend.adapter.out;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.adapter.APICaller;
import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.port.RestaurantPort;

import java.util.ArrayList;
import java.util.List;

public class UberEatsScraperAdapter extends APICaller implements RestaurantPort {

    @Override
    public void login() {
        this.token = "token"; // vervangen voor token (hardcoded of application.properties?)
        // is het duidelijker om dit ipv token key te noemen?
    }

    @Override
    public void checkToken() {
        // uitleggen in SGB/comment dat deze leeg is en later geimplementeerd moet worden
    }

    @Override
    public String callAPI() {
        try {
            HttpResponse<String> response = Unirest.get("url met params") // url invullen
                    .header("x-rapidapi-key", token)
                    .header("x-rapidapi-host", "uber-eats-scraper-api.p.rapidapi.com")
                    .asString();

            return response.getBody();
        } catch (UnirestException ue) {
            throw new RuntimeException("Er ging iets mis bij het ophalen van de data van Uber Eats.", ue);
        }
    }

    @Override
    public List<Restaurant> getRestaurants() {
        String response = executeAPICall();
        List<Restaurant> restaurants = new ArrayList<>();

//        response mappen naar restaurant lijst

        return restaurants;
    }
}
