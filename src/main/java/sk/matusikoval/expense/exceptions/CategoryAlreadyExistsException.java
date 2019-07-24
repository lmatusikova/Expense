package sk.matusikoval.expense.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CategoryAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 881677272423298479L;
	
	public CategoryAlreadyExistsException(String exception) {
		super(exception);
	}
}
