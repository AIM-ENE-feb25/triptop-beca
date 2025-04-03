package han.triptop.backend.state;

import han.triptop.backend.adapter.BookingAdapterWrapper;
import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.service.BookingService;
import han.triptop.backend.exception.BookingException;

public class InitialState implements BookingState {
    @Override
    public void handleRequest(BookingService service, BookingRequest request, BookingAdapterWrapper adapterWrapper) throws BookingException {
        System.out.println("Booking started");
        service.setState(new HotelBookingState());
        service.getCurrentState().handleRequest(service, request, adapterWrapper);
    }
}
