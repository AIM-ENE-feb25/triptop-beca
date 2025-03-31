package han.triptop.backend.adapter;

import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.domain.HotelBookingResponse;
import han.triptop.backend.domain.FlightBookingResponse;
import han.triptop.backend.domain.CarRentalResponse;
import han.triptop.backend.exception.BookingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BookingAdapter implements IAdapter {

    @Value("${booking.api.key}")
    private String apiKey;

    @Value("${booking.api.host}")
    private String apiHost;

    @Override
    public boolean checkAvailability(BookingRequest request) throws BookingException {
        try {
            String url = "https://booking-com15.p.rapidapi.com/api/v1/hotels/getAvailability" +
                    "?hotel_id=" + request.getHotelId() +
                    "&currency_code=" + request.getCurrency() +
                    "&location=" + request.getLocation();
            // Voorbeeld test URL:
            // GET https://booking-com15.p.rapidapi.com/api/v1/hotels/getAvailability?hotel_id=5218600&currency_code=USD&location=US

            HttpResponse<JsonNode> response = Unirest.get(url)
                    .header("x-rapidapi-key", apiKey)
                    .header("x-rapidapi-host", apiHost)
                    .asJson();

            if (response.getStatus() == 200) {
                boolean available = response.getBody().getObject().optBoolean("available", true);
                return available;
            } else {
                throw new BookingException("Failed to check availability, status: " + response.getStatus());
            }
        } catch (Exception e) {
            throw new BookingException("Error checking availability: " + e.getMessage());
        }
    }

    @Override
    public HotelBookingResponse bookHotel(BookingRequest request) throws BookingException {
        try {
            String url = "https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotels" +
                    "?dest_id=" + request.getDestId() +
                    "&search_type=CITY&adults=" + request.getAdults() +
                    "&children_age=0,17&room_qty=1&page_number=1&units=metric" +
                    "&temperature_unit=c&languagecode=en-us&currency_code=" + request.getCurrency() +
                    "&location=" + request.getLocation();
            // Voorbeeld test URL:
            // GET https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotels?dest_id=-2092174&search_type=CITY&adults=1&children_age=0,17&room_qty=1&page_number=1&units=metric&temperature_unit=c&languagecode=en-us&currency_code=AED&location=US

            HttpResponse<JsonNode> response = Unirest.get(url)
                    .header("x-rapidapi-key", apiKey)
                    .header("x-rapidapi-host", apiHost)
                    .asJson();

            if (response.getStatus() == 200) {
                return new HotelBookingResponse(true, "Hotel booked.");
            } else {
                return new HotelBookingResponse(false, "Hotel booking failed, status: " + response.getStatus());
            }
        } catch (Exception e) {
            throw new BookingException("Error booking hotel: " + e.getMessage());
        }
    }

    @Override
    public FlightBookingResponse bookFlight(BookingRequest request) throws BookingException {
        try {
            String url = "https://booking-com15.p.rapidapi.com/api/v1/flights/searchFlights" +
                    "?fromId=" + request.getFromId() +
                    "&toId=" + request.getToId() +
                    "&pageNo=1&adults=" + request.getAdults() +
                    "&children=0,17&sort=BEST&cabinClass=ECONOMY&currency_code=" + request.getCurrency();
            // Voorbeeld test URL:
            // GET https://booking-com15.p.rapidapi.com/api/v1/flights/searchFlights?fromId=BOM.AIRPORT&toId=DEL.AIRPORT&pageNo=1&adults=1&children=0,17&sort=BEST&cabinClass=ECONOMY&currency_code=AED

            HttpResponse<JsonNode> response = Unirest.get(url)
                    .header("x-rapidapi-key", apiKey)
                    .header("x-rapidapi-host", apiHost)
                    .asJson();

            if (response.getStatus() == 200) {
                return new FlightBookingResponse(true, "Flight booked.");
            } else {
                return new FlightBookingResponse(false, "Flight booking failed, status: " + response.getStatus());
            }
        } catch (Exception e) {
            throw new BookingException("Error booking flight: " + e.getMessage());
        }
    }

    @Override
    public CarRentalResponse bookCar(BookingRequest request) throws BookingException {
        try {
            String url = "https://booking-com15.p.rapidapi.com/api/v1/cars/searchCarRentals" +
                    "?pick_up_latitude=" + request.getPickUpLatitude() +
                    "&pick_up_longitude=" + request.getPickUpLongitude() +
                    "&drop_off_latitude=" + request.getDropOffLatitude() +
                    "&drop_off_longitude=" + request.getDropOffLongitude() +
                    "&pick_up_time=" + request.getPickUpTime() +
                    "&drop_off_time=" + request.getDropOffTime() +
                    "&driver_age=" + request.getDriverAge() +
                    "&currency_code=" + request.getCurrency();
            // Voorbeeld test URL:
            // GET https://booking-com15.p.rapidapi.com/api/v1/cars/searchCarRentals?pick_up_latitude=40.6397&pick_up_longitude=-73.7792&drop_off_latitude=40.6397&drop_off_longitude=-73.7792&pick_up_time=10:00&drop_off_time=10:00&driver_age=30&currency_code=USD

            HttpResponse<JsonNode> response = Unirest.get(url)
                    .header("x-rapidapi-key", apiKey)
                    .header("x-rapidapi-host", apiHost)
                    .asJson();

            if (response.getStatus() == 200) {
                return new CarRentalResponse(true, "Car rental booked.");
            } else {
                return new CarRentalResponse(false, "Car rental booking failed, status: " + response.getStatus());
            }
        } catch (Exception e) {
            throw new BookingException("Error booking car: " + e.getMessage());
        }
    }
}
