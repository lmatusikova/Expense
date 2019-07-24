package sk.matusikoval.expense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sk.matusikoval.expense.entities.Expense;
import sk.matusikoval.expense.exceptions.ExpenseNotFoundException;
import sk.matusikoval.expense.exceptions.UserNotFoundException;
import sk.matusikoval.expense.services.ExpenseService;

@RestController
@RequestMapping("expense")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
    @GetMapping("/{id}")
    public @ResponseBody Expense getExpenseById(@PathVariable("id") Long id) throws ExpenseNotFoundException {  
        return expenseService.getExpenseById(id);
    }
	
	@GetMapping
	public @ResponseBody List<Expense> getAllExpenses() {
		List<Expense> expenses = expenseService.getAllExpenses();
		return expenses;
	}
	
    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
    	return ResponseEntity.ok(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteExpense(@PathVariable("id") Long id) throws ExpenseNotFoundException {
    	expenseService.deleteExpense(id);
    	return ResponseEntity.ok(id);
    }
    
    @PutMapping
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") Long id, @RequestBody Expense expense) throws ExpenseNotFoundException {
    	expenseService.updateExpense(id, expense);
    	return ResponseEntity.ok(expense);
    }
    
	@GetMapping("/getbyusername/{username}")
	public @ResponseBody List<Expense> getExpenseByUser(@PathVariable("username") String username) throws UserNotFoundException {
		List<Expense> expenses = expenseService.getExpenseByUser(username);
		return expenses;
	}
	
	@GetMapping("/getbyamount/{amount}") 
	public @ResponseBody List<Expense> getExpenseByAmount(@PathVariable("amount") int amount) {
		List<Expense> expenses = expenseService.getExpenseByAmount(amount);
		return expenses;
	}
}
