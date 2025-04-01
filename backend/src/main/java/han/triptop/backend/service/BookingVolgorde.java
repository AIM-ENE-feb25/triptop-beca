package han.triptop.backend.service;

import han.triptop.backend.adapter.BookingAdapterWrapper;
import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.domain.BookingResponse;
import han.triptop.backend.exception.BookingException;
import han.triptop.backend.state.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingVolgorde {

    @Autowired
    private BookingAdapterWrapper adapterWrapper;

    public BookingResponse processBooking(BookingRequest request) throws BookingException {

        new HotelBookingState().handleRequest(request, adapterWrapper);

        new FlightBookingState().handleRequest(request, adapterWrapper);

        new CarBookingState().handleRequest(request, adapterWrapper);

        return new BookingResponse("Booking completed successfully.", true);
    }
}
