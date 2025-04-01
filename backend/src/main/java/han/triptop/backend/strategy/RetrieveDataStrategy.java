package han.triptop.backend.strategy;

import han.triptop.backend.domain.RestaurantResponse;

public interface RetrieveDataStrategy {

    RestaurantResponse retrieveData(String query, String address);

}
