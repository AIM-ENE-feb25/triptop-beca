package han.triptop.backend.strategy;

import han.triptop.backend.domain.Restaurant;

import java.util.List;

public interface RetrieveDataStrategy {

    List<Restaurant> retrieveData(String query, String address);

}
