package han.triptop.backend.domain;

public class BookingResponse {
    private String message;
    private boolean success;

    public BookingResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }
    public boolean isSuccess() {
        return success;
    }
}
