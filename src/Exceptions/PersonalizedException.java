package Exceptions;

public class PersonalizedException extends RuntimeException {
    private final ErrorType errorType;

    public PersonalizedException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    @Override
    public String toString() {
        return "Error: " + getMessage() + " | Type: " + errorType;
    }
}