package OS.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityViolationException(String msg, Throwable t) {
		super(msg,t);
	}
	
	public DataIntegrityViolationException(String msg) {
		super(msg);
	}

}
