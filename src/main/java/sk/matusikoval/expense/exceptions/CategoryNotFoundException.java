package sk.matusikoval.expense.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5776302598709084499L;

	public CategoryNotFoundException(String exception) {
		super(exception);
	}
}
