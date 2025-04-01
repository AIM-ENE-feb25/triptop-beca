package han.triptop.backend.service;

import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.repository.EatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EatsServiceImpl implements EatsService {

    private final List<RetrieveDataStrategy> retrieveDataStrategies;
    private final EatsRepository eatsRepository;

    @Autowired
    public EatsServiceImpl(List<RetrieveDataStrategy> retrieveDataStrategies, EatsRepository eatsRepository) {
        this.retrieveDataStrategies = retrieveDataStrategies;
        this.eatsRepository = eatsRepository;
    }

    public List<Restaurant> findAllRestaurants() {
        return eatsRepository.findAll();
    }

    public List<Restaurant> retrieveData(String query, String address) {
        for (RetrieveDataStrategy strategy : retrieveDataStrategies) {
            try {
                return strategy.retrieveData(query, address);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }


}
