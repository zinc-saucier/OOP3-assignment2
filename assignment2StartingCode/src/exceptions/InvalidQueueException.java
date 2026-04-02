package exceptions;

public class InvalidQueueException extends Exception{
	
	public InvalidQueueException() {
		
	}
	
	public InvalidQueueException(String message) {
		super(message);
	}

}
