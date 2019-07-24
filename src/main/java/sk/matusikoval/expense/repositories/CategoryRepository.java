package sk.matusikoval.expense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sk.matusikoval.expense.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findByName(String name);
}
