package han.triptop.backend.domain.port;

import han.triptop.backend.domain.Restaurant;

import java.util.List;


public interface RestaurantPort {

    public List<Restaurant> getRestaurants();
    // lat en long meegeven? of hardcoded stad toevoegen aan url params in callAPI()?
}
