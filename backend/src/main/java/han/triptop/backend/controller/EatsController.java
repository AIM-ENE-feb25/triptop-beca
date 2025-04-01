package han.triptop.backend.controller;

import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.RestaurantDTO;
import han.triptop.backend.exception.RestaurantNotFoundException;
import han.triptop.backend.service.EatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class EatsController {


    private final EatsService eatsService;

    @Autowired
    public EatsController(EatsService eatsService) {
        this.eatsService = eatsService;
    }

    @GetMapping("")
    public List<Restaurant> getAllRestaurants() {
        return eatsService.findAllRestaurants();
    }

    @PostMapping("")
    @CachePut(value = "restaurants", key = "#restaurant.uuid")
    public List<Restaurant> getAndSaveAPIResults(@RequestBody RestaurantDTO restaurantDTO) {
        try {
            return eatsService.retrieveData(restaurantDTO.getQuery(), restaurantDTO.getAddress());
        } catch (RestaurantNotFoundException e) {
            throw new RestaurantNotFoundException("Geen restauranten gevonden.");
        }
    }

}
