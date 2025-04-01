package han.triptop.backend.controller;

import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.RestaurantDTO;
import han.triptop.backend.domain.RestaurantResponse;
import han.triptop.backend.service.EatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public RestaurantResponse getAndSaveAPIResults(@RequestBody RestaurantDTO restaurantDTO) {
        return eatsService.retrieveData(restaurantDTO.getQuery(), restaurantDTO.getAddress());
    }

}
