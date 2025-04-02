package han.triptop.backend.adapter;


import han.triptop.backend.domain.Restaurant;

import java.util.List;
import java.util.Map;

public abstract class APICaller {

    protected String token;
    protected String APIKey;
    protected String APIURL;

    public String executeAPICall() {
        return executeAPICall(Map.of());
    }

    public String executeAPICall(Map<String, String> parameters) {
        if (token == null || token.isEmpty()) {
            login();
        }
        return callAPI(parameters); 
    }

    public abstract void login();

    public abstract void checkToken();

    public abstract String callAPI(Map<String, String> parameters);

    public static interface RestaurantPort {

        public List<Restaurant> getRestaurants(String query, String address);
    }
}
