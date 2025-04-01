package han.triptop.backend.strategy;

import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.RestaurantResponse;
import han.triptop.backend.exception.RestaurantNotFoundException;
import han.triptop.backend.repository.EatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RetrieveFromCacheStrategy implements RetrieveDataStrategy {

    private final EatsRepository eatsRepository;

    @Autowired
    public RetrieveFromCacheStrategy(EatsRepository eatsRepository) {
        this.eatsRepository = eatsRepository;
    }

    @Override
    public RestaurantResponse retrieveData(String query, String address) {
        List<Restaurant> filteredRestaurants = eatsRepository.findAll()
                .stream()
                .filter(restaurant ->
                        restaurant.getName().trim().equalsIgnoreCase(query.trim()) ||
                                restaurant.getAddress().trim().equalsIgnoreCase(address.trim())
                )
                .collect(Collectors.toList());

        if (filteredRestaurants.isEmpty()) {
            throw new RestaurantNotFoundException("Geen restauranten gevonden.");
        }
        return new RestaurantResponse(filteredRestaurants, true);
    }
}
