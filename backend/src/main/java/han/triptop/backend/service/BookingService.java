package han.triptop.backend.service;

import han.triptop.backend.adapter.BookingAdapterWrapper;
import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.domain.BookingResponse;
import han.triptop.backend.exception.BookingException;
import han.triptop.backend.state.BookingState;
import han.triptop.backend.state.InitialState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingAdapterWrapper adapterWrapper;

    @Autowired
    public BookingService(BookingAdapterWrapper adapterWrapper) {
        this.adapterWrapper = adapterWrapper;
    }

    public BookingResponse processBooking(BookingRequest request) throws BookingException {
        BookingState currentState = new InitialState();


        currentState = currentState.handleRequest(request, adapterWrapper);
        currentState = currentState.handleRequest(request, adapterWrapper);
        currentState = currentState.handleRequest(request, adapterWrapper);
        currentState = currentState.handleRequest(request, adapterWrapper);

        return new BookingResponse("Booking completed successfully.", true);
    }
}