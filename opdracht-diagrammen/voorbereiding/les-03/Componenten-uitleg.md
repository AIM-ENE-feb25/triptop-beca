# Componenten

## Verantwoordelijkheid

| Component | Verantwoordelijkheid  |
|-----------|-----------------------|
|Reservatie Controller |Verstuurt boekingsaanvragen en ontvangt de API-calls vanuit de frontend.|
|Volgorde Checker  |Zorgt ervoor dat de aanroepen in de correcte volgorde gebeuren en dat er geen inconsistenties zijn.|
|Booking Adapter |Handelt communicatie met Booking.com af en vertaalt hun API-data naar het interne systeem.|
|Trip Repository       |Slaat de boekingsdata op in de database. |

## Interfaces

> ReservationController Interface

@RequestMapping("/api/reservations")

public interface ReservationController {
@PostMapping("/book")

ResponseEntity<BookingResponse> bookTrip(@RequestBody BookingRequest request); }

> BookingAdapter Interface

public interface BookingService {

boolean checkAvailability(BookingRequest request);
HotelBookingResponse bookHotel(BookingRequest request);
FlightBookingResponse bookFlight(BookingRequest request);
CarRentalResponse bookCar(BookingRequest request);
}

> TripRepository Interface

public interface DatabaseService {

void saveBooking(BookingEntity booking);
}
