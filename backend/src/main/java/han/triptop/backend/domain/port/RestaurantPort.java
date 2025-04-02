package han.triptop.backend.domain.port;

import han.triptop.backend.domain.Restaurant;

import java.util.List;


public interface RestaurantPort {

    public List<Restaurant> getRestaurants(String query, String address);
}
