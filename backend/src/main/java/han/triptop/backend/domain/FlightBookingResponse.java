package han.triptop.backend.domain;

public class FlightBookingResponse {
    private boolean success;
    private String message;

    public FlightBookingResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }
    public String getMessage() {
        return message;
    }
}