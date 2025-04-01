package han.triptop.backend.service;


import han.triptop.backend.domain.Restaurant;

import java.util.List;

public interface EatsService {

    List<Restaurant> findAllRestaurants();

    List<Restaurant> retrieveData(String query, String address);
}
