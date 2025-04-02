package han.triptop.backend.repository;

import han.triptop.backend.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EatsRepository extends CrudRepository<Restaurant, String> {

    List<Restaurant> findAll();

}
