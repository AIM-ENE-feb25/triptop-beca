package han.triptop.backend.adapter;

import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.domain.HotelBookingResponse;
import han.triptop.backend.domain.FlightBookingResponse;
import han.triptop.backend.domain.CarRentalResponse;
import han.triptop.backend.exception.BookingException;

public interface IAdapter {
    HotelBookingResponse bookHotel(BookingRequest request) throws BookingException;
    FlightBookingResponse bookFlight(BookingRequest request) throws BookingException;
    CarRentalResponse bookCar(BookingRequest request) throws BookingException;
}
