package sk.matusikoval.expense.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = -6413850864976402204L;

	public UserAlreadyExistsException(String exception) {
		super(exception);
	}
}
