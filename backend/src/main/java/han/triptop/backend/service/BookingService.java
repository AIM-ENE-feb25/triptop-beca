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
    private BookingState currentState;

    @Autowired
    public BookingService(BookingAdapterWrapper adapterWrapper) {
        this.adapterWrapper = adapterWrapper;
        this.currentState = new InitialState();
    }

    public void setState(BookingState state) {
        this.currentState = state;
    }

    public BookingState getCurrentState() {
        return currentState;
    }

    public BookingResponse processBooking(BookingRequest request) throws BookingException {
        currentState.handleRequest(this, request, adapterWrapper);
        return new BookingResponse("Booking completed successfully.", true);
    }
}
