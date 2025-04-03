package han.triptop.backend.domain;

public class CarRentalResponse {
    private boolean success;
    private String message;

    public CarRentalResponse(boolean success, String message) {
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
