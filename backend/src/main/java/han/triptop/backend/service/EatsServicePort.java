package han.triptop.backend.service;


import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.RestaurantResponse;

import java.util.List;

public interface EatsServicePort {

    List<Restaurant> findAllRestaurants();

    RestaurantResponse retrieveData(String query, String address);
}
