package sk.matusikoval.expense.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.matusikoval.expense.entities.Expense;
import sk.matusikoval.expense.entities.User;
import sk.matusikoval.expense.exceptions.ExpenseNotFoundException;
import sk.matusikoval.expense.exceptions.UserNotFoundException;
import sk.matusikoval.expense.repositories.ExpenseRepository;
import sk.matusikoval.expense.repositories.UserRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Expense getExpenseById(Long expenseId) throws ExpenseNotFoundException {
		if(!expenseRepository.existsById(expenseId))
			throw new ExpenseNotFoundException("Expense with ID = " + expenseId + " not found.");
		return expenseRepository.findById(expenseId).get();
	}	

	public List<Expense> getAllExpenses() {
		List<Expense> list = new ArrayList<>();
		expenseRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	public void addExpense(Expense expense) {
        expenseRepository.save(expense);
	}

	public void updateExpense(Long expenseId, Expense expense) throws ExpenseNotFoundException {
        Expense e = expenseRepository.findById(expenseId).orElseThrow(() -> 
    	new ExpenseNotFoundException("Expense user with ID = " + expenseId + " failed. || Expense not found."));
	e.setIdE(expenseId);
    e.setDescription(expense.getDescription());
    e.setAmount(expense.getAmount());
    e.setCategories(expense.getCategories());
    e.setUser(expense.getUser());
	expenseRepository.save(e);
	}

	public void deleteExpense(Long expenseId) throws ExpenseNotFoundException {
		Expense e = expenseRepository.findById(expenseId).orElseThrow(() -> 
			new ExpenseNotFoundException("Delete expense with ID = " + expenseId + " failed || Expense not found."));
		expenseRepository.delete(e);
	}
	
	public List<Expense> getExpenseByUser(String username) throws UserNotFoundException {
		User u = userRepository.findByUsername(username);
		if(u == null)
			throw new UserNotFoundException("User " + username + "not found.");
		List<Expense> expenses = expenseRepository.findByUserUsername(username);
		return expenses;
	}
	
	public List<Expense> getExpenseByAmount(int amount) {
		List<Expense> expenses = expenseRepository.findByAmountGreaterThan(amount);
		return expenses;
	}

}
