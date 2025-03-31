package han.triptop.backend.service;

import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.port.RestaurantPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantPort restaurantPort;
//    hoe zorg ik dat hij restaurantPort bean kan vinden?
    public RestaurantService(RestaurantPort restaurantPort) {
        this.restaurantPort = restaurantPort;
    }

    public List<Restaurant> getRestaurants() {
        return restaurantPort.getRestaurants();
    }
}
