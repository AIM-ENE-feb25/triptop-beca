package han.triptop.backend.service;

import han.triptop.backend.adapter.BookingAdapter;
import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.domain.BookingResponse;
import han.triptop.backend.exception.BookingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingAdapter bookingAdapter;
    private final BookingVolgorde bookingVolgorde;

    @Autowired
    public BookingService(BookingAdapter bookingAdapter, BookingVolgorde bookingVolgorde) {
        this.bookingAdapter = bookingAdapter;
        this.bookingVolgorde = bookingVolgorde;
    }

    public BookingResponse processBooking(BookingRequest request) throws BookingException {
        boolean available = bookingAdapter.checkAvailability(request);
        if (!available) {
            throw new BookingException("No availability found.");
        }

        return bookingVolgorde.processBooking(request);
    }
}
