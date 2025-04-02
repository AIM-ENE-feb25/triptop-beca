package han.triptop.backend.service;

import han.triptop.backend.adapter.APICaller;
import han.triptop.backend.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final APICaller.RestaurantPort restaurantPort;

    @Autowired
    public RestaurantService(APICaller.RestaurantPort restaurantPort) {
        this.restaurantPort = restaurantPort;
    }

    public List<Restaurant> getRestaurants(String query, String address) {
        return restaurantPort.getRestaurants(query, address);
    }
}
