package han.triptop.backend.state;

import han.triptop.backend.adapter.BookingAdapterWrapper;
import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.service.BookingService;
import han.triptop.backend.exception.BookingException;

public interface BookingState {
    void handleRequest(BookingService service, BookingRequest request, BookingAdapterWrapper adapterWrapper) throws BookingException;
}
