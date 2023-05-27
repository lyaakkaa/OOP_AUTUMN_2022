package exceptions;

@SuppressWarnings("serial")
public class WrongOperationException extends Exception{
	public WrongOperationException(String message) {
        super(message);
    }
}
