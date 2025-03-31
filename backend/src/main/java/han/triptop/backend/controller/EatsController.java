package han.triptop.backend.controller;

import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.RestaurantDTO;
import han.triptop.backend.service.EatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eats")
public class EatsController {

    private final EatsService eatsService;

    @Autowired
    public EatsController(EatsService eatsService) {
        this.eatsService = eatsService;
    }

    @GetMapping("")
    @Cacheable(value = "restaurants")
    public List<Restaurant> getAllRestaurants() {
        return eatsService.findAllRestaurants();
    }

    @PostMapping("/api")
    @CachePut(value = "restaurants", key = "#restaurant.uuid")
    public void getAndSaveAPIResults(@RequestBody RestaurantDTO restaurantDTO) {
        eatsService.retrieveData(restaurantDTO.getMaxRows(), restaurantDTO.getQuery(), restaurantDTO.getAddress(), restaurantDTO.getPages());
    }

}
