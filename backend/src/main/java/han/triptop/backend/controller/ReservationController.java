package han.triptop.backend.controller;

import han.triptop.backend.domain.BookingRequest;
import han.triptop.backend.domain.BookingResponse;
import han.triptop.backend.exception.BookingException;
import han.triptop.backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReservationController {

    private final BookingService bookingService;

    @Autowired
    public ReservationController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookTrip")
    public ResponseEntity<BookingResponse> bookTrip(@RequestBody BookingRequest request) {
        try {
            BookingResponse response = bookingService.processBooking(request);
            return ResponseEntity.ok(response);
        } catch (BookingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new BookingResponse(e.getMessage(), false));
        }
    }
}
