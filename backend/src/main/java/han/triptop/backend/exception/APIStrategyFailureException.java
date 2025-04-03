package han.triptop.backend.exception;

public class APIStrategyFailureException extends RuntimeException {
    public APIStrategyFailureException(String message) {
        super(message);
    }
}
