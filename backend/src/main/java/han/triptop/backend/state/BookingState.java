package han.triptop.backend.state;

import han.triptop.backend.adapter.BookingAdapterWrapper;
import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.exception.BookingException;

public interface BookingState {
    void handleRequest(BookingRequest request, BookingAdapterWrapper adapterWrapper) throws BookingException;
}