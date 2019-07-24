package sk.matusikoval.expense.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.matusikoval.expense.entities.Category;
import sk.matusikoval.expense.exceptions.CategoryAlreadyExistsException;
import sk.matusikoval.expense.exceptions.CategoryNotFoundException;
import sk.matusikoval.expense.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category getCategoryById(Long categoryId) throws CategoryNotFoundException {	
		if(!categoryRepository.existsById(categoryId))
			throw new CategoryNotFoundException("Category with ID = " + categoryId + " not found.");
		return categoryRepository.findById(categoryId).get();
	}	

	public List<Category> getAllCategories() {
		List<Category> list = new ArrayList<>();
		categoryRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	public void addCategory(Category category) throws CategoryAlreadyExistsException {
	        List<Category> list = categoryRepository.findByName(category.getName()); 	
                if (list.size() > 0)
                	 throw new CategoryAlreadyExistsException("Category called " + category.getName() + " already exists.");
                else
                	categoryRepository.save(category);           
	}

	public void updateCategory(Long categoryId, Category category) throws CategoryNotFoundException {
		Category c = categoryRepository.findById(categoryId).orElseThrow(() ->
			new CategoryNotFoundException("Update category with ID = " + categoryId + " failed. || Category not found."));
		c.setIdC(category.getIdC());
		c.setName(category.getName());
		c.setDescription(category.getDescription());
		c.setExpenses(category.getExpenses());
		c.setUser(category.getUser());
		categoryRepository.save(c);
	}

	public void deleteCategory(Long categoryId) {
		Category c = categoryRepository.findById(categoryId).orElseThrow(() ->
				new CategoryNotFoundException("Update category with ID = " + categoryId + " failed. || Category not found."));
		categoryRepository.delete(c);
	}
}
