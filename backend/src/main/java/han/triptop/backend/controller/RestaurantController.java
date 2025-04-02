package han.triptop.backend.controller;

import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.RestaurantDTO;
import han.triptop.backend.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public List<Restaurant> getRestaurants(@RequestBody RestaurantDTO restaurantDTO) {
        return restaurantService.getRestaurants(restaurantDTO.getQuery(), restaurantDTO.getAddress());
    }
}
