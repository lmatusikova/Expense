package sk.matusikoval.expense.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoleNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1728178468025314115L;

	public RoleNotFoundException(String exception) {
		super(exception);
	}
}
