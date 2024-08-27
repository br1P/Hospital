package Hospital.Exceptions;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException(String date) {
        super("Invalid date format or out of range: " + date);
    }
}