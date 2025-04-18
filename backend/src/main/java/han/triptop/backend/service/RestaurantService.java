package han.triptop.backend.service;

import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.port.RestaurantPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantPort restaurantPort;

    @Autowired
    public RestaurantService(RestaurantPort restaurantPort) {
        this.restaurantPort = restaurantPort;
    }

    public List<Restaurant> getRestaurants(String query, String address) {
        return restaurantPort.getRestaurants(query, address);
    }
}
