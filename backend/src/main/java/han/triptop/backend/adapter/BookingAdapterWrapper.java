package han.triptop.backend.adapter;

import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.domain.HotelBookingResponse;
import han.triptop.backend.domain.FlightBookingResponse;
import han.triptop.backend.domain.CarRentalResponse;
import han.triptop.backend.exception.BookingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingAdapterWrapper {
    private final BookingAdapter bookingAdapter;

    @Autowired
    public BookingAdapterWrapper(BookingAdapter bookingAdapter) {
        this.bookingAdapter = bookingAdapter;
    }

    public boolean checkAvailability(BookingRequest request) throws BookingException {
        return bookingAdapter.checkAvailability(request);
    }

    public HotelBookingResponse bookHotel(BookingRequest request) throws BookingException {
        return bookingAdapter.bookHotel(request);
    }

    public FlightBookingResponse bookFlight(BookingRequest request) throws BookingException {
        return bookingAdapter.bookFlight(request);
    }

    public CarRentalResponse bookCar(BookingRequest request) throws BookingException {
        return bookingAdapter.bookCar(request);
    }
}
