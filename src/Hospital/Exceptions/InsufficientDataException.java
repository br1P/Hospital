package Hospital.Exceptions;

public class InsufficientDataException extends RuntimeException {
    public InsufficientDataException(String message) {
        super("Insufficient data provided: " + message);
    }
}
