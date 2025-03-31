package han.triptop.backend.service;

import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.repository.EatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetrieveFromCacheStrategy implements RetrieveDataStrategy {

    private final EatsRepository eatsRepository;

    @Autowired
    public RetrieveFromCacheStrategy(EatsRepository eatsRepository) {
        this.eatsRepository = eatsRepository;
    }

    // Kleine test of strategy pattern werkt, werkt maar moet wel specifiekere data oppakken, nu pak ik alles.

    @Override
    public void retrieveData(int maxRows, String query, String address, int pages) {
        try {
            List<Restaurant> restaurants = eatsRepository.findAll();
            System.out.println(restaurants);
        } catch(Exception e) {
            System.out.println("Geen cached results gevonden! - " + e.getMessage());
        }
    }

}
