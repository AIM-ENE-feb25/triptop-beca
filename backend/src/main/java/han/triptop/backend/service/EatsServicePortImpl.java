package han.triptop.backend.service;

import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.RestaurantResponse;
import han.triptop.backend.exception.RestaurantNotFoundException;
import han.triptop.backend.repository.EatsRepository;
import han.triptop.backend.strategy.RetrieveDataStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EatsServicePortImpl implements EatsServicePort {

    private final List<RetrieveDataStrategy> retrieveDataStrategies;
    private final EatsRepository eatsRepository;

    @Autowired
    public EatsServicePortImpl(List<RetrieveDataStrategy> retrieveDataStrategies, EatsRepository eatsRepository) {
        this.retrieveDataStrategies = retrieveDataStrategies;
        this.eatsRepository = eatsRepository;
    }

    @Cacheable(value = "restaurants")
    public List<Restaurant> findAllRestaurants() {
        List<Restaurant> restaurants = eatsRepository.findAll();

        if (restaurants.isEmpty()) {
            throw new RestaurantNotFoundException("Geen restauranten gevonden.");
        }

        return restaurants;
    }

    @Cacheable(value = "restaurants", key = "#query + #address")
    public RestaurantResponse retrieveData(String query, String address) {
        for (RetrieveDataStrategy strategy : retrieveDataStrategies) {
            try {
                return strategy.retrieveData(query, address);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        throw new RestaurantNotFoundException("Geen restauranten gevonden vanuit zowel API als Cache.");
    }
}
