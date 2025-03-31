package han.triptop.backend.service;

import com.mashape.unirest.http.JsonNode;
import han.triptop.backend.adapter.EatsAdapter;
import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.exception.RestaurantNotFoundException;
import han.triptop.backend.repository.EatsRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

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
    public void retrieveData(int maxRows, String query, String address, int pages) {
        try {
            // DOEN ALSOF DE API NIET WERKT OM NAAR DE VOLGENDE STRATEGIE TE GAAN

            JsonNode apiResponse = new JsonNode("");
            JSONObject responseJson = apiResponse.getObject();
            JSONObject returnValue = responseJson.optJSONObject("returnvalue");
            JSONArray restaurants = returnValue.optJSONArray("data");

            if (restaurants == null || restaurants.length() == 0) {
                throw new RestaurantNotFoundException("Restaurant not found.");
            }

            saveRestaurants(restaurants);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve data from API.", e);
        }
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
