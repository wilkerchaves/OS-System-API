package OS.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError{

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	public void addError(String fieldName, String msg) {
		this.errors.add(new FieldMessage(fieldName, msg));
	}
	
	
	
	

}
