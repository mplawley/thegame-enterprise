package gameCore.login;

public class EmailExistsException extends Exception {
    public EmailExistsException() {}

    public EmailExistsException(String message)
    {
        super(message);
    }

    public EmailExistsException (Throwable cause) {
        super(cause);
    }

    public EmailExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
