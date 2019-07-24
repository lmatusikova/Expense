package sk.matusikoval.expense.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExpenseNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -3580141028908733824L;

	public ExpenseNotFoundException(String exception) {
		super(exception);
	}
}
