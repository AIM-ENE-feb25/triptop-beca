package han.triptop.backend.domain.port;

import han.triptop.backend.domain.Hotel;

import java.util.List;

public interface HotelPort {
    List<Hotel> getHotels(String dest_id, String search_type, String arrival_date, String departure_date);
}
