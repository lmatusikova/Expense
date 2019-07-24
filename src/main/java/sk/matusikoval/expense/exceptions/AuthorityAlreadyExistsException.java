package sk.matusikoval.expense.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AuthorityAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -5258107794646628810L;

	public AuthorityAlreadyExistsException(String exception) {
		super(exception);
	}
}
