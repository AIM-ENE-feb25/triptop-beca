package han.triptop.backend.strategy;

import com.mashape.unirest.http.JsonNode;
import han.triptop.backend.adapter.EatsAdapter;
import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.RestaurantResponse;
import han.triptop.backend.exception.APIStrategyFailureException;
import han.triptop.backend.exception.RestaurantNotFoundException;
import han.triptop.backend.repository.EatsRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RetrieveFromAPIStrategy implements RetrieveDataStrategy {

    private final EatsAdapter eatsAdapter;
    private final EatsRepository eatsRepository;

    @Autowired
    public RetrieveFromAPIStrategy(EatsAdapter eatsAdapter, EatsRepository eatsRepository) {
        this.eatsAdapter = eatsAdapter;
        this.eatsRepository = eatsRepository;
    }

    @Override
    public RestaurantResponse retrieveData(String query, String address) {
        try {
            // DOEN ALSOF DE API NIET WERKT OM NAAR DE VOLGENDE STRATEGIE TE GAAN
            JsonNode apiResponse = new JsonNode("");

            //JsonNode apiResponse = eatsAdapter.getRestaurantsNearUser(query, address);
            JSONObject responseJson = apiResponse.getObject();
            JSONObject returnValue = responseJson.optJSONObject("returnvalue");
            JSONArray restaurants = returnValue.optJSONArray("data");

            if (restaurants == null || restaurants.length() == 0) {
                throw new RestaurantNotFoundException("Restaurant niet gevonden.");
            }

            saveRestaurants(restaurants);
            List<Restaurant> prettyRestaurants = prettyRestaurantsList(restaurants);
            return new RestaurantResponse(prettyRestaurants, false);

        } catch (Exception e) {
            throw new APIStrategyFailureException("Failed to retrieve data from API, going to Cache Strategy.");
        }
    }

    private List<Restaurant> prettyRestaurantsList(JSONArray restaurants) {
        List<Restaurant> restaurantList = new ArrayList<>();
        for (int i = 0; i < restaurants.length(); i++) {
            JSONObject restaurant = restaurants.getJSONObject(i);

            JSONObject location = restaurant.getJSONObject("location");
            Restaurant restaurantObject = new Restaurant(restaurant.getString("uuid"),
                    restaurant.getString("title"), location.getString("address"));
            restaurantList.add(restaurantObject);
        }
        return restaurantList;
    }

    private void saveRestaurants(JSONArray restaurants) {
        for (int i = 0; i < restaurants.length(); i++) {
            JSONObject restaurant = restaurants.getJSONObject(i);

            String title = restaurant.getString("title");
            String uuid = restaurant.getString("uuid");
            JSONObject location = restaurant.getJSONObject("location");
            String address = location.getString("address");
            saveRestaurant(new Restaurant(uuid, title, address));
        }
    }

    @CachePut(value = "restaurants", key = "#restaurant.uuid")
    public void saveRestaurant(Restaurant restaurant) {
        eatsRepository.save(restaurant);
    }
}
