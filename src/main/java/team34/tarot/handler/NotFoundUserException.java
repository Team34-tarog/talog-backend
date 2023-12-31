package team34.tarot.handler;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException() {
        super();
    }

    public NotFoundUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundUserException(String message) {
        super(message);
    }

    public NotFoundUserException(Throwable cause) {
        super(cause);
    }
}
