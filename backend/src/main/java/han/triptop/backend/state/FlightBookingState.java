package han.triptop.backend.state;

import han.triptop.backend.adapter.BookingAdapterWrapper;
import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.domain.FlightBookingResponse;
import han.triptop.backend.service.BookingService;
import han.triptop.backend.exception.BookingException;

public class FlightBookingState implements BookingState {
    @Override
    public void handleRequest(BookingService service, BookingRequest request, BookingAdapterWrapper adapterWrapper) throws BookingException {
        FlightBookingResponse response = adapterWrapper.bookFlight(request);
        if (!response.isSuccess()) {
            throw new BookingException("Flight booking failed: " + response.getMessage());
        }

        System.out.println("Flight booked successfully.");
        service.setState(new CarBookingState());
        service.getCurrentState().handleRequest(service, request, adapterWrapper);
    }
}
