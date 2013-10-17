package model;
/**
*Exception that's thrown when trying to 
*access a non-existent card in a hand/deck.
 */

public class NoSuchCardException extends RuntimeException {

	private static final long serialVersionUID = 4175426871183562467L;
	
	public NoSuchCardException() {

	}

	public NoSuchCardException(String message) {
		super(message);
	}

	public NoSuchCardException(Throwable cause) {
		super(cause);
	}

	public NoSuchCardException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchCardException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
