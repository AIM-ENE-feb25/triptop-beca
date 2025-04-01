package han.triptop.backend.state;

import han.triptop.backend.adapter.BookingAdapterWrapper;
import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.domain.HotelBookingResponse;
import han.triptop.backend.exception.BookingException;


public class HotelBookingState implements BookingState {
    @Override
    public void handleRequest(BookingRequest request, BookingAdapterWrapper adapterWrapper) throws BookingException {
        HotelBookingResponse response = adapterWrapper.bookHotel(request);
        if (!response.isSuccess()) {
            throw new BookingException("Hotel booking failed: " + response.getMessage());
        }
        System.out.println("Hotel booking successful.");
    }
}
