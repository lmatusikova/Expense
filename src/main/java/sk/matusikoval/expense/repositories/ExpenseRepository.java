package sk.matusikoval.expense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sk.matusikoval.expense.entities.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	List<Expense> findByUserUsername(String username);
	List<Expense> findByAmountGreaterThan(int amount);
}
