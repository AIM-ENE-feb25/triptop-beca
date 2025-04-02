package han.triptop.backend.state;

import han.triptop.backend.adapter.BookingAdapterWrapper;
import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.exception.BookingException;

public class InitialState implements BookingState {

    @Override
    public BookingState handleRequest(BookingRequest request, BookingAdapterWrapper adapterWrapper) throws BookingException {
        return new HotelBookingState();
    }
}
