package exceptions;


@SuppressWarnings("serial")
public class FailedLogInException extends Exception {
    public FailedLogInException(String message) {
        super(message);
    }
}