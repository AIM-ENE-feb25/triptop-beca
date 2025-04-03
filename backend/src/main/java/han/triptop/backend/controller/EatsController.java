package han.triptop.backend.controller;

import han.triptop.backend.domain.Restaurant;
import han.triptop.backend.domain.RestaurantDTO;
import han.triptop.backend.domain.RestaurantResponse;
import han.triptop.backend.service.EatsServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants-van-atakan")
public class EatsController {

    private final EatsServicePort eatsServicePort;

    @Autowired
    public EatsController(EatsServicePort eatsServicePort) {
        this.eatsServicePort = eatsServicePort;
    }

    @GetMapping("")
    public List<Restaurant> getAllRestaurants() {
        return eatsServicePort.findAllRestaurants();
    }

    @PostMapping("")
    public RestaurantResponse getAndSaveAPIResults(@RequestBody RestaurantDTO restaurantDTO) {
        return eatsServicePort.retrieveData(restaurantDTO.getQuery(), restaurantDTO.getAddress());
    }

}
