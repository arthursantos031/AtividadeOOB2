package Exceptions;

public class DomainException extends RuntimeException {
    private final DomainErrorType errorType;

    public DomainException(String message, DomainErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

    public DomainErrorType getErrorType() {
        return errorType;
    }

    @Override
    public String toString() {
        return "Error: " + getMessage() + " | Type: " + errorType;
    }
}