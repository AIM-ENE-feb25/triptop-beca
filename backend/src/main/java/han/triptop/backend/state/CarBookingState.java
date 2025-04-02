package han.triptop.backend.state;

import han.triptop.backend.adapter.BookingAdapterWrapper;
import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.domain.CarRentalResponse;
import han.triptop.backend.exception.BookingException;

public class CarBookingState implements BookingState {
    @Override
    public BookingState handleRequest(BookingRequest request, BookingAdapterWrapper adapterWrapper) throws BookingException {
        CarRentalResponse response = adapterWrapper.bookCar(request);
        if (!response.isSuccess()) {
            throw new BookingException("Car rental booking failed: " + response.getMessage());
        }
        return new InitialState();
    }
}
