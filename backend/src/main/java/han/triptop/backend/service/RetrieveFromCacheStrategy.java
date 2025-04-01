package han.triptop.backend.service;

import han.triptop.backend.domain.Restaurant;
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
    public List<Restaurant> retrieveData(String query, String address) {
        try {
            return eatsRepository.findAll().
                    stream().
                    filter(restaurant -> (restaurant.getName().trim().equalsIgnoreCase(query.trim()) ||
                            (restaurant.getAddress()).trim().equalsIgnoreCase(address.trim()))).
                    collect(Collectors.toList());
        } catch (RestaurantNotFoundException e) {
            System.out.println("Geen cached results gevonden! - " + e.getMessage());
        }
        return null;
    }
}
