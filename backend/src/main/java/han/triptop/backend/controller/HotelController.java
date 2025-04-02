package han.triptop.backend.controller;

import han.triptop.backend.domain.Hotel;
import han.triptop.backend.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getHotels(@RequestParam String dest_id, @RequestParam String search_type, @RequestParam String arrival_date, @RequestParam String departure_date) { //
        return hotelService.getHotels(dest_id, search_type, arrival_date, departure_date); //
    }
}
