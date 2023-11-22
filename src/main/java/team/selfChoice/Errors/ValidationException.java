package team.selfChoice.Errors;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}