package han.triptop.backend.service;

import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.repository.EatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EatsService {

    private final List<RetrieveDataStrategy> retrieveDataStrategies;
    private final EatsRepository eatsRepository;

    @Autowired
    public EatsService(List<RetrieveDataStrategy> retrieveDataStrategies, EatsRepository eatsRepository) {
        this.retrieveDataStrategies = retrieveDataStrategies;
        this.eatsRepository = eatsRepository;
    }

    public List<Restaurant> findAllRestaurants() {
        return eatsRepository.findAll();
    }

    public void retrieveData(int maxRows, String query, String address, int pages) {
        for (RetrieveDataStrategy strategy : retrieveDataStrategies) {
            try {
                strategy.retrieveData(maxRows, query, address, pages);
                return;
            } catch (Exception e) {
                System.out.println("Eentje werkt niet, VOLGENDE! - " + e.getMessage());
            }
        }
        throw new RuntimeException("Niks gevonden...");
    }


}
