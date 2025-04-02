package han.triptop.backend.service;

import han.triptop.backend.domain.Hotel;
import han.triptop.backend.adapter.HotelPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelPort hotelPort;

    @Autowired
    public HotelService(HotelPort hotelPort) {
        this.hotelPort = hotelPort;
    }

    public List<Hotel> getHotels(String dest_id, String search_type, String arrival_date, String departure_date) {
        return hotelPort.getHotels(dest_id, search_type, arrival_date, departure_date);
    }
}
