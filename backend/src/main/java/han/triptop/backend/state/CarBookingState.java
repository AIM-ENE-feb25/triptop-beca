package han.triptop.backend.state;

import han.triptop.backend.adapter.BookingAdapterWrapper;
import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.domain.CarRentalResponse;
import han.triptop.backend.service.BookingService;
import han.triptop.backend.exception.BookingException;

public class CarBookingState implements BookingState {
    @Override
    public void handleRequest(BookingService service, BookingRequest request, BookingAdapterWrapper adapterWrapper) throws BookingException {
        CarRentalResponse response = adapterWrapper.bookCar(request);
        if (!response.isSuccess()) {
            throw new BookingException("Car rental booking failed: " + response.getMessage());
        }

        System.out.println("Car booked successfully.");
        service.setState(new InitialState());
    }
}
