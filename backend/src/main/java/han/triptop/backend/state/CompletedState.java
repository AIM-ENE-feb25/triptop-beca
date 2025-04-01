package han.triptop.backend.state;


import han.triptop.backend.adapter.BookingAdapterWrapper;
import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.exception.BookingException;

public class CompletedState implements BookingState {
    @Override
    public void handleRequest(BookingRequest request, BookingAdapterWrapper adapterWrapper) throws BookingException {
        System.out.println("Booking process completed. Saving booking...");
    }
}
